package jp.Effective;

public class EnumAndAnnotation {
    // int enumパターン - 不完全
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;
    
    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;

    // うまいオレンジ風味のアップルソース
    int i = (APPLE_FUJI - ORANGE_TEMPLE) / APPLE_PIPPIN;

    public enum Apple { FUJI, PIPPIN, GRANNY_SMITH }
    public enum Orange { NAVEL, TEMPLE, BLOOD }

    // データと振る舞いを持つenum型
    public enum Planet {
        MERCURY(3.302e+23, 2.439e6),
        VENUS(4.869e+24, 6.052e6),
        EARTH(5.975e+24, 6.378e6),
        MARS(6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN(5.685e+26, 6.027e7),
        URANUS(8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7);

        private final double mass; // 単位：kg
        private final double radius; // 単位：m
        private final double surfaceGravity; // 単位：m/s^2

        // 万有引力定数 単位：m^3/kg s^2
        private final double G = 6.67300E-11;

        // コンストラクタ
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        public double mass() {
            return mass;
        }

        public double radius() {
            return radius;
        }

        public double surfaceGravity() {
            return surfaceGravity;
        }
        
        public double surfaceWeight(double mass) {
            return mass * surfaceGravity; // F = ma
        }
    }

    // 値によって切り替えるenum型(問題が多い)
    public enum OperationBad {
        PLUS, MINUS, TIMES, DIVIDE;

        // 定数で表される算術操作を行う
        public double apply(double x,double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
            }
            throw new AssertionError("Unknown op:" + this);
        }
    }

    // 定数固有メソッド実装を持つenum型
    public enum Operation1 {
        PLUS {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES {
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE {
            public double apply(double x, double y) {
                return x / y;
            }
        };
        public abstract double apply(double x, double y);
    }

    // 定数固有クラス本体と定数固有データを持つenum型
    public enum Operation2 {
        PLUS("+") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES("*") {
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            public double apply(double x, double y) {
                return x / y;
            }
        };

        private final String symbol;

        Operation2(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public abstract double apply(double x, double y);
    }



}
