package jp.Sukkiri;

import java.util.Random;

public class Cleric {
    static final int MAX_HP = 50;
    static final int MAX_MP = 10;
 
    String name;
    int hp = 50;
    int mp = 10;

    Cleric(String name) {
        this(name, Cleric.MAX_HP);
    }

    Cleric(String name, int hp) {
        this(name,hp, Cleric.MAX_MP);
    }

    Cleric(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    void selfAid(){
        System.out.println("呪文: セルフエイド");
        this.hp = MAX_HP;
        mp -= 5;
        System.out.println("体力が最大まで回復");
    }

    int pray(int sec) {
        System.out.println(this.name + "は"+ sec + "秒願った");

        int recover = new Random().nextInt(3) + sec;
        int recoverActual = Math.min(this.MAX_MP - this.mp, recover);

        this.mp += recoverActual;
        System.out.println("MP回復: " + recoverActual);
        return recoverActual;
    }
}
