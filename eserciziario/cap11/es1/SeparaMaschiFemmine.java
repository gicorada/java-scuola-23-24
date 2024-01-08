package eserciziario.cap11.es1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SeparaMaschiFemmine {
    public static void main(String[] args) {
        final String PATH = "./perCasa/eserciziario/cap11/es1/";
        try(Scanner s = new Scanner(new File(PATH + "babynames.txt"));
                PrintWriter maschi = new PrintWriter(PATH + "boynames.txt");
                PrintWriter femmine = new PrintWriter(PATH + "girlnames.txt")) {
            while (s.hasNextLine()) {
                String line = s.nextLine();
                Scanner data = new Scanner(line);
                int rank = data.nextInt();
                String name;
                int count;
                double percent;

                name = data.next();
                count = data.nextInt();
                percent = data.nextDouble();
                maschi.println(rank + " " + name + " " + count + " " + percent);

                name = data.next();
                count = data.nextInt();
                percent = data.nextDouble();
                femmine.println(rank + " " + name + " " + count + " " + percent);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
