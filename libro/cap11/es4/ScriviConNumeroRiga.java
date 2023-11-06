package libro.cap11.es4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScriviConNumeroRiga {
    public static void main(String[] args) throws FileNotFoundException {
        String pathIn, pathOut;

        Scanner in = new Scanner(System.in);
        ArrayList<String> righe = new ArrayList<>();

        System.out.print("Inserisci il path del file di input (dalla radice del progetto): ");
        pathIn = in.nextLine();
        System.out.print("Inserisci il path del file di output (dalla radice del progetto): ");
        pathOut = in.nextLine();

        File f = new File(pathIn);
        Scanner s = new Scanner(f);

        while(s.hasNextLine()) {
            righe.add(s.nextLine());
        }

        s.close();

        PrintWriter w = new PrintWriter(pathOut);
        for(int i = 0; i < righe.size(); i++) {
            w.println("/* " + (i+1) + " */ " + righe.get(i));
        }

        w.close();

    }
}
