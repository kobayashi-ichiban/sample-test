package jp.exercise;

public enum Singleton {
    INSTANCE;

    private int count= -1;

    public static Singleton getInstance() {
        if (INSTANCE.count == -1) {
            INSTANCE.count =0;
        }
        return INSTANCE;
    }

    public void increment() {
        INSTANCE.count++;
    }

    public int getCount() {
        return INSTANCE.count;
    }
}
