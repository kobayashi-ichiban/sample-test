public class Main {
    public static void main(String[] args) {
        Hero h = new Hero("K");
        // h.name = "K";
        // h.hp = 100;
        System.out.println(h.hp);
        System.out.println(h.name);
        System.out.println(h.name + "が生まれました。");

        Hero.money = 100;
        Hero.setRandomMoney();
        System.out.println(Hero.money);
        System.out.println(h.money);

        Hero h2 = new Hero();
        // h2 = h;
        // h2.name = "A";
        // h2.hp = 200;
        // System.out.println(h.hp);
        System.out.println(h2.hp);
        System.out.println(h2.name);

        h.money = 300;
        System.out.println(h2.money);

        Matango m1 = new Matango();
        m1.hp = 50;
        m1.suffix = 'A';

        Matango m2 = new Matango();
        m2.hp = 48;
        m2.suffix = 'B';

        // 9-4
        Sword s = new Sword();
        s.name = "魔法の剣";
        s.damage = 10;
        h.sword = s;
        System.out.println("現在の武器は" + h.sword.name);

        Wizard w = new Wizard();
        w.name = "S";
        w.hp = 50;
        w.heal(h);
        w.heal(h2);
        w.heal(h2);

        h.sit(5);
        h.slip();
        h.sit(25);
        h.run();
    }
}
