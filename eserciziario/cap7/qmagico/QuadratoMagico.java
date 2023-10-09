package eserciziario.cap7.qmagico;

import java.util.Scanner;

public class QuadratoMagico {
    public static void main(String[] args) {
        int[][] quadrato = new int[4][4];

        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci i numeri da 1 a 16 per formare un quadrato magico. \n Inseriscili riga per riga, separati da uno spazio. \n Ad esempio: 1 2 3 4");
        for (int i = 0; i < quadrato.length; i++) {
            String riga = in.nextLine();
            String[] numeri = riga.split(" ");
            for (int j = 0; j < quadrato.length; j++) {
                quadrato[i][j] = Integer.parseInt(numeri[j]);
            }
        }

        // Nei dati inseriti dall’utente sono presenti tutti i numeri 1, 2, ..., 16?
        boolean[] presenti = new boolean[16];
        for (int[] riga : quadrato) {
            for (int n : riga) {
                presenti[n - 1] = true;
            }
        }

        for (boolean b : presenti) {
            if (!b) {
                System.out.println("Non tutti i numeri da 1 a 16 sono presenti");
                return;
            }
        }

        // Quando i numeri vengono disposti in un quadrato, la somma degli elementi di ogni riga, di
        // ogni colonna e delle due diagonali ha lo stesso valore?

        for(int i = 0; i < quadrato.length; i++) {
            int sommaRiga = 0;
            int sommaColonna = 0;
            int sommaDiagonale1 = 0;
            int sommaDiagonale2 = 0;
            for(int j = 0; j < quadrato.length; j++) {
                sommaRiga += quadrato[i][j];
                sommaColonna += quadrato[j][i];
                sommaDiagonale1 += quadrato[j][j];
                sommaDiagonale2 += quadrato[j][quadrato.length - j - 1];
            }

            if (sommaRiga != 34 || sommaColonna != 34 || sommaDiagonale1 != 34 || sommaDiagonale2 != 34) {
                System.out.println("Non tutte le righe, le colonne e le diagonali hanno somma 34");
                return;
            }
        }
        System.out.println("Il quadrato è magico");
    }
}
