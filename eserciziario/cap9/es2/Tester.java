package eserciziario.cap9.es2;

public class Tester {
    public static void main(String[] args) {
        Clock clock = new Clock();
        WorldClock worldClock = new WorldClock(2);
        System.out.println("Ora locale: " + clock.getTime());
        System.out.println("Ora in un fuso orario +2: " + worldClock.getTime());
    }
}
