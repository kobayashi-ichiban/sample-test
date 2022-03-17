package jp.exercise;

public class EnumLesson {
    public static void main(String[] args) {
        System.out.println(StringValue.STRING_ONE.toString().equals("ONE"));
        System.out.println(StringValue.STRING_TWO.toString().equals("ONE"));
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
