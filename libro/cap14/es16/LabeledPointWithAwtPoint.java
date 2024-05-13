package libro.cap14.es16;

import java.awt.Point;

public class LabeledPointWithAwtPoint {
    private Point point;
    private String label;

    public LabeledPointWithAwtPoint(int x, int y, String label) {
        point = new Point(x, y);
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabeledPointWithAwtPoint lp = (LabeledPointWithAwtPoint) o;
        return point.equals(lp.point) && label.equals(lp.label);
    }

    public int hashCode() {
        final int HASH_MULTIPLIER = 31;

        int h = 0;
        h = HASH_MULTIPLIER * h + point.hashCode();
        h = HASH_MULTIPLIER * h + label.hashCode();

        return h;
    }
}
