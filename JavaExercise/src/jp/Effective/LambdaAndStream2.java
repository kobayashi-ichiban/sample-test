package jp.Effective;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LambdaAndStream2 {
    public static void main(String[] args) throws IOException {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }
        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + " : " + group);
            }
        }
    }

    private static String alphabetize(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
