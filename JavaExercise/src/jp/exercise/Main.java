package jp.exercise;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Sample sample = () -> System.out.println("Hello!!");
        sample.greeting();

        method(() -> {System.out.println("Hello Lambda!");});

        Function<Integer, String> asterisker = (i) -> { return "*" + i; };
        String result = asterisker.apply(10);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> adder = (a, b) -> { return a + b; };
        int resultBi = adder.apply(1,2);
        System.out.println(resultBi);
    }

    public static void method(Runnable r) {
        r.run();
    }
}
