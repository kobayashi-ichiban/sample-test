package jp.Effective;

import java.util.*;

public class LambdaAndStream {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("ABC");
        words.add("MBS");
        words.add("YTV");
        words.add("NHK");

        // 無名インスタンスはもう使われない
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });

        words.add("ETV");
        // 関数オブジェクトとしてのラムダ式(無名関数置き換え)
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        words.add("QVC");
        Collections.sort(words, Comparator.comparingInt(String::length));

        words.add("SUN");
        words.sort(Comparator.comparingInt(String::length));

        // Map map = new HashMap();
        // map.merge(key, 1, (count, incr) -> count + incr);
    }
    // 定数固有クラス本体とデータを持つ
    public enum Operation {
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
        Operation(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public abstract double apply(double x, double y);
    }

    public enum Operation2 {
        PLUS("+", (x, y)  -> x + y),
        MINUS("-", (x, y)  -> x - y),
        TIMES("*", (x, y)  -> x * y),
        DIVIDE("/", (x, y)  -> x / y);

        private final String symbol;
        private final DoubleBinaryOperator op;

        Operation2(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        @Override
        public String toString() {
            return symbol;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }
}
