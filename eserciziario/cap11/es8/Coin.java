package eserciziario.cap11.es8;

import java.util.Scanner;
import java.io.FileNotFoundException;

public class Coin {
    private String name;
    private double value;

    public Coin(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public void read(Scanner in) throws FileNotFoundException {
        if (in.hasNextLine()) {
            String line = in.nextLine();
            String[] parti = line.split(" ");
            if (parti.length != 2) {
                throw new IllegalArgumentException("Formato non valido");
            }
            this.name = parti[0];
            this.value = Double.parseDouble(parti[1]);
        } else {
            throw new FileNotFoundException("Righe esaurite");
        }
    }
}