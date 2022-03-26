package jp.exercise;

import java.util.ArrayList;
import java.util.List;

public class EnumLesson {
    public static void main(String[] args) {
        List<String> printList = new ArrayList<>();
        if (StringValue.STRING_ONE.toString().equals("ONE")) {
            printList.add("TRUE");
        }
        if (StringValue.STRING_TWO.toString().equals("ONE")) {
            printList.add("FALSE");
        }
        System.out.println(printList.size());
    }

    public enum StringValue {
        STRING_ONE("ONE"),
        STRING_TWO("TWO");

        private final String text;

        StringValue(String text) {
            this.text = text;
        }

        public String toString() {
            return text;
        }
    }

}
