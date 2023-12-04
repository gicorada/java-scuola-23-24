package libro.cap12.r6;

import java.util.Arrays;

public class OrdinaNumeriRicorsivo {
    public static void main(String[] args) {
        int[] a = { 5, 3, 2, 4, 1 };
        ordina(a, 0);
        System.out.println(Arrays.toString(a));
    }

    public static void ordina(int[] a, int pos) {
        if (pos >= a.length - 1) {
            return;
        }

        int minIndex = pos;
        for (int i = pos + 1; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }

        int temp = a[pos];
        a[pos] = a[minIndex];
        a[minIndex] = temp;

        ordina(a, pos + 1);
    }
}
