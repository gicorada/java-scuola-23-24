package inclasse.struttureDati.esercizioFileDiTesto;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class StringGenerator {
	/**
	 * Metodo main. Se riceve true, scrive 5000 elementi diversi,
	 * altrimenti ne scrive 5000 in blocchi uguali da 1000
	 * @param args Elementi in ingresso (accettato solo un boolean)
	 */
	public static void main(String[] args) {
		if(args.length != 1) throw new IllegalArgumentException("Devi fornire un boolean in input");
		try(PrintWriter pw = new PrintWriter(".//inclasse//inclasse//struttureDati//esercizioFileDiTesto//Stringhe.txt")) {
			Random r = new Random();
			
			if(Boolean.parseBoolean(args[0])) { //Genera tutti diversi
				for (int i = 0; i < 5000; i++) {
					pw.println(generateString(r, 5));
				}
			} else { //Genera i primi 1000 e poi li copia per raggiungere 5000
				ArrayList<String> prime1000stringhe = new ArrayList<>();
				for (int i = 0; i < 1000; i++) {
					prime1000stringhe.add(generateString(r, 5));
				}
	
				for (int i = 0; i < 5000; i++) {
					pw.println(prime1000stringhe.get(i%1000));
				}
			}

			System.out.println("Stampa completata");
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static String generateString(Random r, int len) {

		String s = "";
		for (int j = 0; j < len; j++) {
			s += (char)(r.nextInt(26) + 'a');
		}

		return s;
	}
}
