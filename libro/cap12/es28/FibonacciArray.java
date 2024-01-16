package libro.cap12.es28;

import java.util.ArrayList;

public class FibonacciArray {
    private ArrayList<Integer> nfib;

    public FibonacciArray() {
        this.nfib = new ArrayList<Integer>();
        this.nfib.add(0);
        this.nfib.add(1);
    }

    public int get(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n deve essere >= 0");
        }
        if (n < this.nfib.size()) {
            return this.nfib.get(n);
        } else {
            int fib = this.get(n - 1) + this.get(n - 2);
            this.nfib.add(fib);
            return fib;
        }
    }

    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n deve essere >= 0");
        }
        for (int i = 0; i <= n; i++) {
            get(i);
        }

        return nfib.get(n);
    }


    public static void main(String[] args) {
        FibonacciArray fib = new FibonacciArray();
        System.out.println(fib.fib(5));
    }
}
