public class Hero {
    String name;
    int hp;

    void attack() {

    }

    void run() {
        System.out.println(this.name + "は逃げた。");
        System.out.println("最終HP: "+ this.hp);
    }

    void sit(int sec) {
        this.hp += sec;
        System.out.println(this.name + "は座った。");
        System.out.println("HPが"+ sec + "ポイント回復");
    }

    void slip() {
        this.hp -= 5;
        System.out.println(this.name + "は転んだ。");
        System.out.println("5 ダメージを受けた");
    }

    void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠り、回復した");
    }
}
