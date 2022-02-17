public class SuperHero extends Hero {
    private boolean flying;
    
    public void fly() {
        this.flying = true;
        System.out.println("勇者はとんだ");
    }

    public void land(){
        this.flying = false;
        System.out.println("勇者は着地した");
    }

    public void run() {
        System.out.println("撤退します。");
    }

    public void attack(Matango m) {
        super.attack(m);
        if(this.flying) {
            super.attack(m);
        }
    }
}
