public class Wizard {
    int hp;
    int mp;
    String name;
    Wand wand;
    
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    void heal(Hero h) {
        int basePoint = 10;
        int recoverPoint = (int) (basePoint * this.wand.getPower());

        h.setHp(h.getHp() + recoverPoint);
        System.out.println(h.getName() + "を" + recoverPoint + "回復した。");
    }
}
