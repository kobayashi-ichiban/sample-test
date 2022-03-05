package jp.Effective;

import jp.Effective.EnumAndAnnotation.Planet;

public class WeightTable {
    public static void main(String[] args) {
        double eathWeight = Double.parseDouble("185");
        double mass= eathWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p,  p.surfaceWeight(mass));
        }

        double x = Double.parseDouble("2");
        double y = Double.parseDouble("4");
        for (EnumAndAnnotation.Operation2 op : EnumAndAnnotation.Operation2.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
