package libro.cap11.es3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RimuoviRigheVuoteInizioFineFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "perCasa/libro/cap11/es3/file.txt";

        File f = new File(path);
        Scanner s = new Scanner(f);
        Scanner in = new Scanner(System.in);
        ArrayList<String> righe = new ArrayList<>();

        // Rimuovo le righe vuote all'inizio del file e alla fine del file
        boolean inizioFile = true;
        while(s.hasNextLine()) {
            String riga = s.nextLine();
            if(!riga.isEmpty()) {
                righe.add(riga);
                inizioFile = false;
            } else if(inizioFile) {
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
