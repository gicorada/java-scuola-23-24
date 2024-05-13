package libro.cap14.es3;

import java.util.TreeSet;

public class Crivello {
    public static TreeSet<Integer> crivello(int n) {
        TreeSet<Integer> numeriPrimi = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            numeriPrimi.add(i);
        }

        for (int i = 2; i < n/2; i++) {
            if (numeriPrimi.contains(i)) {
                for (int j = i + i; j < n; j += i) {
                    numeriPrimi.remove(j);
                }
            }
        }

        return numeriPrimi;
    }

    public static void main(String[] args) {
        System.out.println(crivello(100));
    }
}
