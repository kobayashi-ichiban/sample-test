package jp.exercise;

import java.util.Arrays;
import java.util.EnumSet;

public class EnumSetExercise {
    static boolean useSake = true;
    static boolean useButa = false;
    static boolean useNimono = false;
    static boolean isBigSize = true;

    public static void main(String[] args) {
        EnumSet<Menu> flag = EnumSet.noneOf(Menu.class);
        if (useSake) {
            flag.add(Menu.SAKE);
        }
        if (useButa) {
            flag.add(Menu.BUTA);
        }
        if (useNimono) {
            flag.add(Menu.NIMONO);
        }
        if (isBigSize) {
            flag.add(Menu.BIGSIZE);
        }
        MenuSet menu = MenuSet.getByFlag(flag);
        System.out.println(menu);
    }

    enum Menu {
        SAKE,
        BUTA,
        NIMONO,
        BIGSIZE;
    }

    enum MenuSet {
        RICE("ご飯", EnumSet.noneOf(Menu.class)),
        SAKE("鮭定食", EnumSet.of(Menu.SAKE)),
        BUTA("焼豚定食", EnumSet.of(Menu.BUTA)),
        NIMONO("煮物定食", EnumSet.of(Menu.NIMONO)),
        RICE_BIG("ご飯大盛り", EnumSet.of(Menu.BIGSIZE)),
        SAKE_BIG("鮭定食大盛り", EnumSet.of(Menu.SAKE, Menu.BIGSIZE)),
        BUTA_BIG("焼豚定食大盛り", EnumSet.of(Menu.BUTA, Menu.BIGSIZE)),
        NIMONO_BIG("煮物定食大盛り", EnumSet.of(Menu.NIMONO, Menu.BIGSIZE));

        private final String name;

        private final EnumSet<Menu> flag;

        private MenuSet(String name, EnumSet<Menu> flag) {
            this.name = name;
            this.flag = flag;
        }

        public String getName() {
            return name;
        }

        public EnumSet<Menu> getFlag() {
            return flag;
        }

        public static MenuSet getByFlag(EnumSet<Menu> flag) {
            return Arrays.stream(values())
                    .filter(s -> s.getFlag().equals(flag))
                    .findFirst()
                    .orElse(MenuSet.RICE);
        }
    }
}
