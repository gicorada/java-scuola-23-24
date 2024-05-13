package inclasse.struttureDati.esercizioFileDiTesto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnalyzerString {
	public static void main(String[] args) {
		
	}
	
	public static void analizzaFile() {
		try (Scanner s = new Scanner(new File(".//inclasse//inclasse//struttureDati//esercizioFileDiTesto//tempi.csv"))) {
			s.useDelimiter(",");

			while (s.hasNextLine()) {
				int tTree = s.nextInt();
				int tHash = s.nextInt();

				if(tTree <= tHash) {
					System.out.println("TreeSet ha impiegato meno tempo di HashSet");
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
