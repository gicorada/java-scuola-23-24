package libro.cap11.es5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScriviNumeroConRigaTerminale {
    public static void main(String[] args) throws FileNotFoundException {
        String pathIn;
        String pathOut;

        try {
            pathIn = args[0];
        } catch(ArrayIndexOutOfBoundsException e) {
            pathIn = new Scanner(System.in).next();
        }

        try {
            pathOut = args[1];
        } catch(ArrayIndexOutOfBoundsException e) {
            pathOut = new Scanner(System.in).next();
        }

        ArrayList<String> righe = new ArrayList<>();

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
