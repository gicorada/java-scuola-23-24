package libro.cap11.es2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RimuoviRigheVuoteFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "perCasa/libro/cap11/es2/file.txt";

        File f = new File(path);
        Scanner s = new Scanner(f);
        ArrayList<String> righe = new ArrayList<>();

        while (s.hasNextLine()) {
            String riga = s.nextLine();
            if (!riga.isEmpty()) {
                righe.add(riga);
            }
        }

        s.close();

        PrintWriter w = new PrintWriter(path);
        for(String riga : righe) {
            w.println(riga);
        }

        w.close();

    }
}
