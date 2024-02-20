package libro.cap13.es2;

public class Moneta implements Comparable<Moneta> {
    private double valore;

    public Moneta(int valore) {
        this.valore = valore;
    }

    public double getValore() {
        return valore;
    }
    @Override
    public int compareTo(Moneta o) {
        return Double.compare(valore, o.valore);
    }

    @Override
    public String toString() {
        return String.valueOf(valore);
    }

}
