package jp.exercise;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        System.out.println("インスタンスカウント:" + s1.getCount());
        s1.increment();
        System.out.println("インスタンスカウント:" + s1.getCount());
        s1.increment();
        System.out.println("インスタンスカウント:" + s1.getCount());

        Singleton s2 = Singleton.getInstance();
        System.out.println("インスタンスカウント:" + s2.getCount());

        /* インスタンスが複製されていないことの確認 */
        if (s1 == s2) {
            System.out.println("s1_instanceとs2_instanceは同一です。");
        }
    }
}
