package eserciziario.cap9.es2;

public class Clock {
    public int getHours() {
        return java.time.LocalTime.now().getHour();
    }

    public int getMinutes() {
        return java.time.LocalTime.now().getMinute();
    }

    public String getTime() {
        return getHours() + ":" + String.format("%02d", getMinutes());
    }

}
