package libro.cap13.es16;

public class BinarySearchConPos {
    public static int search(int[] a, int low, int high, int value) {
        if(low <= high) {
            int mid = (low+high)/2;

            if(a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                return search(a, mid+1, high, value);
            } else {
                return search(a, low, mid - 1, value);
            }
        } else return -((low+high)/2)-1;
    }

    public static int search(int[] a, int value) {
        return search(a, 0, a.length-1, value);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 6, 7, 8, 9};

        System.out.println(search(a, 4));
    }
}
