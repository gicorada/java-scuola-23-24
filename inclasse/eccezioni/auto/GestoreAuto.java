package eccezioni.auto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GestoreAuto {
	private ArrayList<String> linee;
	private ArrayList<Auto> auto;
	private File f;

	public GestoreAuto (String filePath) {
		linee = new ArrayList<>();
		auto = new ArrayList<>();
		f = new File(filePath);
	}

	public void leggiDatiDaFile() throws FileNotFoundException {
		linee.clear();
		try(Scanner s = new Scanner(f)) {
			while (s.hasNextLine()) {
				linee.add(s.nextLine());
			}
		}
	}

	public void interpretaDati() {
		for(String riga : linee) {
			String[] dati = riga.split("[\s]+");
			try {
				auto.add(new Auto(dati[0], Integer.parseInt(dati[1]), Integer.parseInt(dati[2])));
			} catch (NoSuchElementException | IllegalArgumentException e) {
				System.out.println("L'AUTO NON VIENE AGGIUNTA: " + e.getMessage());
			}
		}
	}


	public String toString() {
		String s = "";

		s += "\nResa delle auto:\n";
		// Soluzione 1
		/*/
		for (Auto a : auto) {
			try {
				s += String.format("%s. La resa è di %.2f km/l\n", a.toString(), a.resa());
			} catch (ArithmeticException e) {
				System.out.println("Auto " + a.getNome() + ": " + e.getMessage());
			}
		}
		*/
		
		// Soluzione 2
		
		for (Auto a : auto) {
			s += String.format("%s. La resa è di %.2f km/l\n", a.toString(), a.resa());
		}
		
		return s;
	}
}
