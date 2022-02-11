public class Hero {
    private String name;
    private int hp;
    Sword sword;

    public static int money;

    Hero() {
        this("dummy");
    }

    Hero(String name) {
        this.hp = 100;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 1 || name.length() >= 8) {
            throw new IllegalArgumentException("この名前は設定できません。");
        }
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        if (hp <= 0) {
            throw new IllegalArgumentException("この値は設定できません。");
        }
        this.hp = hp;
    }

    public Sword getSword() {
        return sword;
    }
    
    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public static void setMoney(int money) {
        Hero.money = money;
    }

    public static int getMoney() {
        return money;
    }

    void run() {
        System.out.println(this.name + "は逃げた。");
        System.out.println("最終HP: " + this.hp);
    }

    void sit(int sec) {
        this.hp += sec;
        System.out.println(this.name + "は座った。");
        System.out.println("HPが" + sec + "ポイント回復");
    }

    void slip() {
        this.hp -= 5;
        System.out.println(this.name + "は転んだ。");
        System.out.println("5 ダメージを受けた");
    }

    void bye() {
        System.out.println("勇者は別れを宣言した。");
    }

    private void die() {
        System.out.println("勇者は死んでしまった・・・ -GAMEOVER-");
    }

    void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠り、回復した");
    }

    public void attack(Matango m, Sword s) {
        System.out.println(this.name + "の攻撃");
        m.hp -= s.damage;
        System.out.println("マタンゴ" + m.suffix + "の反撃");
        this.hp -= 2;
        if (this.hp <= 0) {
            this.die();
        }
    }

    static void setRandomMoney() {
        Hero.money = (int) (Math.random() * 1000);
    }
}
