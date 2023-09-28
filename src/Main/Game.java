package Main;

import Location.Location;
import Location.Cave;
import Location.SafeHouse;
import Location.ToolStore;
import java.util.Scanner;
import Location.Forest;
import Location.River;

public class Game {
    public Scanner scan = new Scanner(System.in);
    String playerName;

    public void start(){

        System.out.println("Macera oyununa hoşgeldiniz!");
        System.out.print("Lütfen bir isim giriniz: ");
        playerName = scan.next();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " oyuna hoşgeldiniz...");
        System.out.println("Lütfen bir karakter seçiniz!");
        player.selectChar();

        Location location = null;
        while (true){
            player.printPlayerInfo();
            System.out.println();
            System.out.println("----------Bölgeler----------");
            System.out.println();
            System.out.println("1 - Güvenli Ev ---> Düşman yoktur, eviniz gibi hissedin!");
            System.out.println("2 - Mağaza ---> Silah veya zırh satın alabileceğiniz bir mağaza!");
            System.out.println("3 - Mağara ---> Mağaraya gir ve yemek ödülünü al, dikkatli ol zombi çıkabilir!");
            System.out.println("4 - Orman ---> Ormana gir ve odun ödülünü al, dikkatli ol vampir çıkabilir!");
            System.out.println("5 - Nehir ---> Nehre gir ve su ödülünü al, dikkatli ol ayı çıkabilir!");
            System.out.println("0 - Çıkış yap ---> Oyunu sonlandır!");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = scan.nextInt();

            switch (selectLoc){
                case 0:
                    System.out.println("Tekrar görüşmek üzere! Sistem kapatılıyor!");
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz!");
            }

            if (location == null){
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }
    }
}
