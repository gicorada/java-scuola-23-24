package eserciziario.cap11.es8;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DescrizioniMonete {
    public static void main(String[] args) {
        while (true) {
            try(Scanner in = new Scanner(System.in)) {
                System.out.print("Inserisci il percorso del file: ");
                String filename = in.nextLine();
                ArrayList<Coin> coins = readFile(filename);
                double totalValue = 0;
                for (Coin coin : coins) {
                    totalValue += coin.getValue();
                }
                System.out.println("Valore totale: " + totalValue);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File non trovato. Inserisci un altro percorso.");
            } catch (IllegalArgumentException e) {
                System.out.println("Formato non valido in almeno una riga: " + e.getMessage());
            }
        }
    }

    public static ArrayList<Coin> readFile(String filename) throws FileNotFoundException {
        ArrayList<Coin> coins = new ArrayList<>();
        File file = new File(filename);
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            Coin coin = new Coin("", 0);
            coin.read(in);
            coins.add(coin);
        }
        in.close();
        return coins;
    }
}