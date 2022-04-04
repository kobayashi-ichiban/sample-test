package jp.Effective;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        // 関数オブジェクトとしてのラムダ式(無名関数置き換え)
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }
}
