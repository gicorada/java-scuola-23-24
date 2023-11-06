package libro.cap11.es11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) throws FileNotFoundException {
        String path = args[0];

        ArrayList<String> righe = new ArrayList<>();

        try(Scanner s = new Scanner(new File(path))) {
            while (s.hasNextLine()) {
                righe.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }

        try (PrintWriter out = new PrintWriter(path)) {
            for(String riga : righe) {
                String inversa = "";
                for(int i = riga.length() - 1; i >= 0; i--) {
                    inversa += riga.charAt(i);
                }
                out.println(inversa);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }
    }
}
