package eserciziario.cap10.es6;

public class Data {
    public static double average(Object[] objects, Measurer meas, Filter filter) {
        double sum = 0;
        double count = 0;
        for (Object obj : objects) {
            if(filter.accept(obj)) {
                sum = sum + meas.measure(obj);
                count++;
            }
        }
        if(count > 0) return sum / count;
        else return 0;
    }
}
