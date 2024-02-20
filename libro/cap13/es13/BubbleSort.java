package libro.cap13.es13;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void bubbleSort(int[] a) {
        boolean scambio = true;
        int last = a.length-1;

        while (scambio) {
            scambio = false;

            for (int i = 0; i < last; i++) {
                int orig = a[i];
                int other = a[i+1];
                if (orig>other) {
                    a[i] = other;
                    a[i+1] = orig;

                    scambio = true;
                }
            }

            last--;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[50];

        Random r = new Random();
        for(int i = 0; i < 50; i++) {
            a[i] = r.nextInt();
        }

        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));


    }
}
