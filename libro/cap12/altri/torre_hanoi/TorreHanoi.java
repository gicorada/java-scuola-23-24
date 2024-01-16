package libro.cap12.altri.torre_hanoi;

public class TorreHanoi {
    public static void torreHanoi(int d, int from, int to) {
        if(d>0) {
            int other = 6 - from - to;
            torreHanoi(d-1, from, other);
            System.out.println("Muovi disco da " + from + " a " + to);
            torreHanoi(d-1, other, to);
        }
    }

    public static void main(String[] args) {
        torreHanoi(3, 1, 3);
    }
}
