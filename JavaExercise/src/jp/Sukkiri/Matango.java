package jp.Sukkiri;

public class Matango {
    int hp = 50;
    final int level = 10;
    private char suffix;

    public Matango(char suffix) {
        this.suffix = suffix;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getLevel() {
        return level;
    }

    public char getSuffix() {
        return suffix;
    }

    public void setSuffix(char suffix) {
        this.suffix = suffix;
    }

    void run() {
        System.out.println("マタンゴは逃げた");
    }

    public void attack(Hero h) {
        System.out.println("マタンゴ" + getSuffix() + "の攻撃");
        System.out.println("10のダメージ");
        h.setHp(h.getHp() - 10);
    }
}
