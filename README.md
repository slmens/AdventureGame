# AdventureGame
Patika+ assignment

Değerlendirme yapacak arkadaşlarımın daha kolay değerlendirebilmesi için önemli noktaları buraya yazdım.

------- İlk Ödev: Ödülleri toplayınca oyunun bitmesi ve bir lokasyondaki ödülü alınca bir daha o lokasyona giremememek -------

Her lokasyondaki ödüller bu şekilde kazanılıyor: combat metodu true gelirse o lokasyondaki herkesi ölmeden öldürebilmişiz demektir. True dönünce hangi lokasyonda olduğumuza göre doğru ödülü veren bir switch case tanımladım. 

![RewardlarNasılKazanılıyor](https://github.com/slmens/AdventureGame/assets/99343829/a7745a53-e499-4eaa-8809-e0e6d34973f9)                                                                                

Ana menüye döndüğümüzde bütün ödülleri topladık mı diye bir kontrol sağlıyorum. Eğer topladıysak oyunu kazanmış oluyoruz. 

![GameMetodundakiKazanmaKoşulu](https://github.com/slmens/AdventureGame/assets/99343829/e8132df9-7ab0-4151-b04e-2f8493a4a966)

Ayrıca eğer bir lokasyondaki ödülü kazandıysak aşağıdaki kontrol sayesinde o lokasyona bir daha giremiyoruz.

![ÖdülleriKazandıkChecki](https://github.com/slmens/AdventureGame/assets/99343829/68f02383-fe20-4844-8702-e017a4e7d84c)


------- İkinci Ödev: İlk kimin saldıracağını %50 ihtimalle belirlemek -------

Aşağıdaki gibi firstEncounter diye bir değişken belirledim. Yani eğer 3 zombi varsa ilk zombiyle ilk karşılaşmamızda firstEncounter true oluyor ama bir kere isFirstHitMonster() metodu çağrılınca artık false oluyor ki o zombi ölene kadar her seferinde şans faktörü devreye girmesin.
Ancak bir sonraki zombi geldiğinde ilk karşılaşmamız olacağı için firstEncounterı metodu çağrışımızdan hemen sonra true yapıyoruz ki yeni zombimiz geldiğinde o bu if koşulunu sağlasın ve %50 ihtimalle ilk o vurabilsin.

![İlkKiminVuracağıNasılHesaplanıyorİfKoşulu](https://github.com/slmens/AdventureGame/assets/99343829/1f8a9dfb-d57e-458e-805e-32452df74e9f)

Bu da metodun kendisi. Çok basit bir metot, 0 - 100 arası bir sayı seçiyor ve 50 den küçükse true dönüyor yani zombimiz bizimle ilk defa karşılaşıyorsa ve bu metot true dönerse o saldıracak demektir.

![İlkKiminVuracağıMetot](https://github.com/slmens/AdventureGame/assets/99343829/ce621ca7-0329-4daa-ab07-44354e1ff718)


------- Üçüncü Ödev: Yeni bir harita ve yeni bir canavar eklemek -------

Bu yılan canavarımızın sınıfı. Tek bir metodu var o da yeni bir yılan nesnesi yaratıldığında rastgele 3 ila 6 arası bir damage almasını sağlıyor.
![YılanClassı](https://github.com/slmens/AdventureGame/assets/99343829/8216a242-45b2-40a5-b631-6b6b01e949ae)

Bu da BattleLocation'daki combat metodumuzda her for loopta yeni bir yılan nesnesi üreterek her yılanın farklı bir hasarı olmasını sağlamamız gerektiği anlamına geliyor. Eğer location zindansa yeni bir yılan yaratıyoruz.
![SnakeObjeÜretimiHerLoopta](https://github.com/slmens/AdventureGame/assets/99343829/82d9b7db-e930-4703-bf0f-ca5745ae5e95)

Combat metodumuzda bir yılan öldürdüğümüzde, BattleLocation sınıfımızın rewardFromSnake metodunu çağırıyor.

![EğerZindansaHerSnakeÖlünceNeYapılıyor](https://github.com/slmens/AdventureGame/assets/99343829/a4ffba81-22dd-48d2-9bb5-915ee78da667)

Bu metot ise önce Dungeon sınıfındaki whichGonnaGet metodunu yani o yılandan hangi ihtimalle ne kazanacağımızı hesaplayan metodu çağırıyor. Bu metot bize kazandığımız nesneyi String olarak döndürüyor.

![DungeonClassı](https://github.com/slmens/AdventureGame/assets/99343829/5a96639b-8078-4b08-bdbf-dfd978af5f40)

BattleLocation sınıfımızda rewardFromSnake metodunda ise bu whichGonnaGet metodundan dönen String ile oyuncumuzun değerlerini güncelliyoruz.

![RewardSnakeMetotu](https://github.com/slmens/AdventureGame/assets/99343829/074d36a2-81ca-464a-88d7-365acbab963f)

Bu kadar.

