package setUse;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        System.out.println(set.add("apple"));
        System.out.println(set.add("peach"));
        System.out.println(set.add("banana"));
        System.out.println(set.add("orange"));

        System.out.println(set.size());
        System.out.println(set);

        System.out.println(set.add("apple"));
        System.out.println(set.contains("watermelon"));
        System.out.println(set.contains("apple"));

        System.out.println(set.remove("wa"));
        System.out.println(set.remove("apple"));

        set.clear();
        System.out.println(set.isEmpty());
        System.out.println(set.size());
    }
}
