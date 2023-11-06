package libro.cap11.es12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReverseFile {
    public static void main(String[] args) {
        String pathIn = args[0];
        String pathOut = args[1];

        System.out.println(pathIn);
        System.out.println(pathOut);

        ArrayList<String> righe = new ArrayList<>();

        try(Scanner s = new Scanner(new File(pathIn))) {
            while (s.hasNextLine()) {
                righe.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }

        Collections.reverse(righe);

        try (PrintWriter out = new PrintWriter(pathOut)) {
            for(String riga : righe) {
                out.println(riga);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }
    }
}
