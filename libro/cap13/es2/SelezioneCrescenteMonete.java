package libro.cap13.es2;

import java.util.Arrays;

public class SelezioneCrescenteMonete {
    public static void main(String[] args) {
        Moneta[] a = { new Moneta(5), new Moneta(2), new Moneta(7), new Moneta(3), new Moneta(9), new Moneta(1),
                new Moneta(6), new Moneta(4), new Moneta(8) };

        for (int i = 0; i < a.length - 1; i++) {
            int posMin = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[posMin]) < 0) {
                    posMin = j;
                }
            }
            Moneta temp = a[i];
            a[i] = a[posMin];
            a[posMin] = temp;
        }

        System.out.println(Arrays.toString(a));
    }
}
