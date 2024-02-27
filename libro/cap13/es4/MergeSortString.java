package libro.cap13.es4;

public class MergeSortString {
    public static void sort(String[] a) {
        if(a.length <= 1) return;
        String[] first = new String[a.length/2];
        String[] second = new String[a.length - a.length/2];

        for(int i = 0; i < first.length; i++) {
            first[i] = a[i];
        }

        for(int i = 0; i < second.length; i++) {
            second[i] = a[i + a.length/2];
        }

        sort(first);
        sort(second);
        merge(a, first, second);
    }

    private static void merge(String[] result, String[] first, String[] second) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while(iFirst < first.length && iSecond < second.length) {
            if(first[iFirst].compareTo(second[iSecond]) < 0) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        while(iFirst < first.length) {
            result[j] = first[iFirst];
            iFirst++;
            j++;
        }

        while(iSecond < second.length) {
            result[j] = second[iSecond];
            iSecond++;
            j++;
        }
    }

    public static void main(String[] args) {
        String[] a = {"c", "a", "b", "e", "d"};
        sort(a);
        for(String s : a) {
            System.out.println(s);
        }
    }
}
