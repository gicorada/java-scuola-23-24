package libro.cap13.es8;

public class BinarySearch {
    public static int search(String[] a, String value) {
        return search(a, 0, a.length-1, value);
    }

    private static int search(String[] a, int low, int high, String value) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].compareTo(value) == 0) {
                return mid;
            } else if (a[mid].compareTo(value) < 0) {
                return search(a, mid + 1, high, value);
            } else {
                return search(a, low, mid - 1, value);
            }
        } else return -1;
    }
}
