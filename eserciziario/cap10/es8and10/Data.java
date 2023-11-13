package eserciziario.cap10.es8and10;

public class Data {
    public static double average(Object[] objects, Measurer meas, Filter filter) {
        double sum = 0;
        int count = Filter.count(objects, filter);
        for (Object obj : objects) {
            if(filter.accept(obj)) {
                sum = sum + meas.measure(obj);
            }
        }
        if(count > 0) return sum / count;
        else return 0;
    }
}
