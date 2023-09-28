package Location;

import Main.Player;

import java.util.Random;

public abstract class BattleLocation extends Location{
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name,Monster monster, String award,int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int randomMonsterNumber = this.randomMonster();

        System.out.println("Şuan buradasınız: " + this.getName());
        System.out.println("Dikkatli ol! Burada " + randomMonsterNumber + " tane " + this.getMonster().getName() + " yaşıyor olabilir!");
        System.out.print("<S>avaş veya <Kaç> : ");
        String selectedBehaviour = scan.next().toUpperCase();

        if (selectedBehaviour.equals("S")){
            if (combat(randomMonsterNumber)){
                System.out.println(this.getName() + "daki" + " tüm düşmanları yendiniz!");
                return true;
            }
        }

        if (this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz!");
            return false;
        }

        return true;
    }

    public boolean combat(int monsterNumber){
        for (int i = 1; i<= monsterNumber; i++){
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            playerStats();
            monsterStats(i);

            while (this.getPlayer().getHealth() > 0 &&  this.getMonster().getHealth() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = scan.next().toUpperCase();

                if (selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz!");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();

                    if (this.getMonster().getHealth() > 0){
                        System.out.println();
                        System.out.println("Canavar size vurdu!");
                        int takenDamage =this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (takenDamage < 0){
                            takenDamage = 0;
                        }
                        int newHealth = this.getPlayer().getHealth() - takenDamage;
                        this.getPlayer().setHealth(newHealth);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }

            if (this.monster.getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı Yendiniz!");
                System.out.println(this.monster.getPrize() + " para kazandınız!");
                int newMoney = this.getPlayer().getMoney() + this.getMonster().getPrize();
                this.getPlayer().setMoney(newMoney);
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
            }else {
                return false;
            }
        }

        return true ;
    }

    public void afterHit(){
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println("Canavarın canı: " + monster.getHealth());
    }

    public void playerStats(){
        System.out.println("Oyuncu değerleri: ");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Blok: " + this.getPlayer().getInventory().getArmor().getBlock());
    }

    public void monsterStats(int i){
        System.out.println(i + "." + " Düşmanın değerleri: ");
        System.out.println("Sağlık: " + this.getMonster().getHealth());
        System.out.println("Hasar: " + this.getMonster().getDamage());
        System.out.println("Ödül: " + this.getMonster().getPrize());
    }

    public int randomMonster(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }


    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
