public class Main {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "K";
        h.hp = 100;
        System.out.println(h.name + "が生まれました。");

        Matango m1 = new Matango();
        m1.hp =50;
        m1.suffix = 'A';

        Matango m2 = new Matango();
        m2.hp = 48;
        m2.suffix = 'B';
        
        h.sit(5);
        h.slip();
        h.sit(25);
        h.run();
    }
}
