package libro.cap11.es9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Find {
    public static void main(String[] args) {
        String[] files = new String[args.length - 1];
        if(args.length < 2) {
            System.out.println("Uso: java Find <stringa> <file/s>");
            return;
        }

        String word = args[0];
        for(int i = 1; i < args.length; i++) {
            String fileName = args[i];
            files[i - 1] = fileName;
        }

        for(String fileName : files) {
            try(Scanner s = new Scanner(new File(fileName))) {
                while (s.hasNextLine()) {
                    String line = s.nextLine();
                    if(line.contains(word)) {
                        System.out.println(fileName + ": " + line);
                    }
                }
            } catch(FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
