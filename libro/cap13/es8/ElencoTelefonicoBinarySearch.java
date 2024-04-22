package libro.cap13.es8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ElencoTelefonicoBinarySearch {


    public static void main(String[] args) throws FileNotFoundException {
        ElencoTelefonico et = new ElencoTelefonico();

        try (Scanner s = new Scanner(new File("./perCasa/libro/cap13/es8/elenco.txt"));) {
            s.useDelimiter(",");
            while(s.hasNextLine()) {
                String nome = s.next();
                System.out.println(nome);
                String numero = s.next();
                et.aggiungi(nome, numero);
            }

            System.out.println(et.cerca("Michael"));
            System.out.println(et.cerca("Geordie"));
            System.out.println(et.cerca("Conrado"));
        }
    }

    private static class ElencoTelefonico {
        private final String[] nomi;
        private final String[] numeri;
        private int i = 0;

        public ElencoTelefonico() {
            nomi = new String[1000];
            numeri = new String[1000];
        }

        public void aggiungi(String nome, String numero) {
            if(i < nomi.length) {
                nomi[i] = nome;
                numeri[i] = numero;
                i++;
            }
        }

        public String cerca(String nome) {
            String[] nomiCopy = Arrays.copyOfRange(nomi, 0, i);
            int pos = BinarySearch.search(nomiCopy, nome);
            if(pos >= 0) {
                return numeri[pos];
            } else {
                return null;
            }
        }
    }
}
