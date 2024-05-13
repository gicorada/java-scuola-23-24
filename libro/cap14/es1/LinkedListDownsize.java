package libro.cap14.es1;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDownsize {
    public static void downsize(LinkedList<String> employeeNames, int n) {
        if (n <= 0) {
            return;
        }

        int i = 0;
        Iterator<String> it = employeeNames.iterator();
        while (it.hasNext()) {
            it.next();
            i++;
            if (i % n == 0) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> employeeNames = new LinkedList<>();
        employeeNames.add("John");
        employeeNames.add("Paul");
        employeeNames.add("George");
        employeeNames.add("Ringo");
        employeeNames.add("Pete");
        employeeNames.add("Stuart");
        employeeNames.add("Brian");
        employeeNames.add("Bill");
        employeeNames.add("Charlie");
        employeeNames.add("Mick");
        employeeNames.add("Keith");
        employeeNames.add("Ronnie");
        employeeNames.add("Charlie");
        employeeNames.add("Roger");
        employeeNames.add("Pete");
        System.out.println(employeeNames);
        downsize(employeeNames, 3);
        System.out.println(employeeNames);
    }
}
