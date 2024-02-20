package libro.cap13.es1;

import java.util.Arrays;

public class SelezioneDecrescente {
    public static void main(String[] args) {
        int[] a = { 5, 2, 7, 3, 9, 1, 6, 4, 8 };

        for (int i = 0; i < a.length - 1; i++) {
            int posMin = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[posMin]) {
                    posMin = j;
                }
            }
            int temp = a[i];
            a[i] = a[posMin];
            a[posMin] = temp;
        }

        System.out.println(Arrays.toString(a));
    }
}
