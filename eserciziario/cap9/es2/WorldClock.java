package eserciziario.cap9.es2;

public class WorldClock extends Clock {
    private final int timeDifference;

    public WorldClock(int timeDifference) {
        this.timeDifference = timeDifference;
    }

    @Override
    public int getHours() {
        return (super.getHours() + timeDifference) % 24;
    }
}
