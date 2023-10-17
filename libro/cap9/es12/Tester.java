package libro.cap9.es12;

public class Tester {
    public static void main(String[] args) {
        Person[] persone = new Person[5];
        persone[0] = new Person("TestP", 1990);
        persone[1] = new Student("TestS1", 1990, "Informatica");
        persone[2] = new Student("TestS2", 1991, "Matematica");
        persone[3] = new Instructor("TestI1", 1980, 1000);
        persone[4] = new Instructor("TestI2", 1970, 2000);

        for (Person p : persone) {
            System.out.println(p);
        }
    }
}
