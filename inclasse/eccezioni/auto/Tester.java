package eccezioni.auto;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		boolean fileLetto = false;

		System.out.println("Inserisci il percorso del file: ");

		do {
			try {
				String path = s.nextLine();
				
				GestoreAuto ges = new GestoreAuto(path);
				ges.leggiDatiDaFile();
				System.out.println("Il file è stato letto correttamente");

				ges.interpretaDati();
				System.out.println(ges.toString());
				fileLetto = true;
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println("Inserisci nuovamente il percorso del file: ");
			}
		} while (!fileLetto);
		
	}
}
