public class PoisonMatango extends Matango {
    private int poisonCount = 5;

    public PoisonMatango(char suffix) {
        super(suffix);
    }

    @Override
    public void attack(Hero h) {
        super.attack(h);
        if (this.poisonCount > 0) {
            System.out.println("毒の胞子を播いた");
            int damage = h.getHp() / 5;
            h.setHp(h.getHp() - damage);
            System.out.println(damage + "ポイントのダメージを与えた");
            this.poisonCount--;
        }
    }
}
