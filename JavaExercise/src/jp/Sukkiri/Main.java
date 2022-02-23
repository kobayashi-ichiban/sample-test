public class Main {
    public static void main(String[] args) {
        Hero h = new Hero("K");
        System.out.println(h.getName() + "が生まれました。");

        Hero.money = 100;
        Hero.setRandomMoney();
        System.out.println(Hero.money);

        Matango m1 = new Matango('A');
        m1.hp = 50;

        Matango m2 = new Matango('B');
        m2.hp = 48;

        // 9-4
        Sword s = new Sword();
        s.name = "魔法の剣";
        s.damage = 10;
        h.sword = s;
        System.out.println("現在の武器は" + h.sword.name);

        Wizard w = new Wizard();
        w.setName("Swiz");
        w.setHp(50);
        // w.heal(h);

        h.sit(5);
        h.slip();
        h.sit(25);
        h.run();

        SuperHero sh = new SuperHero();
        sh.fly();
        sh.run();

    }
}
