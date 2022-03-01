package jp.Effective;

import jp.Effective.EnumAndAnnotation.Planet;

public class WeightTable {
    public static void main(String[] args) {
        double eathWeight = Double.parseDouble("185");
        double mass= eathWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p,  p.surfaceWeight(mass));
        }
    }
}
