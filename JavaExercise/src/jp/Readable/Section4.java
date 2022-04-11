package jp.Readable;

import java.util.List;

public class Section4 {
    public static void main(String[] args) {
        System.out.println("Start");

    }

    class StatsKeeper {
        public void add(double d) {
            d = d + 1.0;
        }
        double Average() {
            return 4.0 / 1.5;
        }

        private List<Double> past_items;
        int count;

        double minimum;
        double maximum;
    }
}
