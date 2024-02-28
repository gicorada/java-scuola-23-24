package libro.cap13.es17;

import java.util.Arrays;

public class MergeSortIterativo {
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) return;

        int n = a.length;
        int[] temp = new int[n];

        for (int size = 1; size < n; size *= 2) {
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * size) {
                int mid = Math.min(leftStart + size - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);
                merge(a, temp, leftStart, mid, rightEnd);
            }
        }
    }

    private static void merge(int[] result, int[] temp, int leftStart, int mid, int rightEnd) {
        int leftEnd = mid;
        int rightStart = mid + 1;
        int index = leftStart;

        int left = leftStart;
        int right = rightStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (result[left] <= result[right]) {
                temp[index++] = result[left++];
            } else {
                temp[index++] = result[right++];
            }
        }

        while (left <= leftEnd) {
            temp[index++] = result[left++];
        }

        while (right <= rightEnd) {
            temp[index++] = result[right++];
        }

        for (int i = leftStart; i <= rightEnd; i++) {
            result[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 17, 80, 7, 1, 7, 8, 8};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
