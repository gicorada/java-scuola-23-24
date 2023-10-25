package libro.cap11.es1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HelloWorldToFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "perCasa/libro/cap11/es1/hello.txt";
        File f = new File(path);

        PrintWriter w = new PrintWriter(path);
        w.println("Hello, World!");
        w.close();

        Scanner s = new Scanner(f);
        String messaggio = s.nextLine();
        System.out.println(messaggio);
        s.close();
    }
}
