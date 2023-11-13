package eserciziario.cap10.es8and10;

public interface Filter {
    boolean accept(Object x);

    /* P10.8 */
    static int count(Object[] values, Filter condition) {
        int count = 0;
        for (Object value : values) {
            if (condition.accept(value)) {
                count++;
            }
        }
        return count;
    }

    /* P10.10 */
    default boolean reject(Object x) {
        return !accept(x);
    }
}
