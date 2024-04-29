package libro.cap14.es15;

public class LabeledPoint {
    private int x;
    private int y;
    private String label;

    public LabeledPoint(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabeledPoint lp = (LabeledPoint) o;
        return x == lp.x && y == lp.y && label.equals(lp.label);
    }

    public int hashCode() {
        final int HASH_MULTIPLIER = 31;

        int h = 0;
        h = HASH_MULTIPLIER * h + x;
        h = HASH_MULTIPLIER * h + y;
        h = HASH_MULTIPLIER * h + label.hashCode();

        return h;
    }
}
