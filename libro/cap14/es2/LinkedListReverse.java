package libro.cap14.es2;

import java.util.LinkedList;

public class LinkedListReverse {
    public static void reverse(LinkedList<String> strings) {
        if (strings.size() <= 1) {
            return;
        }

        int size = strings.size();
        for (int i = 0; i < size / 2; i++) {
            String temp = strings.get(i);
            strings.set(i, strings.get(size - 1 - i));
            strings.set(size - 1 - i, temp);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<String>();
        strings.add("Ciao");
        strings.add("Mondo");
        strings.add("!");
        reverse(strings);
        System.out.println(strings);
    }
}
