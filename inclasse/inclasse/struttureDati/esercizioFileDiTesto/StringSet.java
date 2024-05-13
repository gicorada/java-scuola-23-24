package inclasse.struttureDati.esercizioFileDiTesto;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class StringSet {
	public static void main(String[] args) {
		TreeSet<String> tree = new TreeSet<>();
		HashSet<String> hash = new HashSet<>();
		
		String[] inputStringGenerator = {"true"};
		StringGenerator.main(inputStringGenerator);

		try (Scanner in = new Scanner(new File(".//inclasse//inclasse//struttureDati//esercizioFileDiTesto//Stringhe.txt"));
				PrintWriter pw = new PrintWriter(".//inclasse//inclasse//struttureDati//esercizioFileDiTesto//tempi.csv")) {
			long sommaTree = 0;
			long sommaHash = 0;
			for (int i = 0; i < 5000; i++) {
				if(i%500 == 0) System.out.println("Elemento " + i);
				String s = in.next();

				long tTreeStart = System.nanoTime();
				tree.add(s);
				long tTreeEnd = System.nanoTime();
				long tTree = tTreeEnd - tTreeStart;


				long tHashStart = System.nanoTime();
				hash.add(s);
				long tHashEnd = System.nanoTime();
				long tHash = tHashEnd - tHashStart;

				sommaTree += tTree;
				sommaHash += tHash;

			}
			
			System.out.println("Terminato");
			
			System.out.println(sommaTree + "," + sommaHash);
			pw.print(sommaTree + "," + sommaHash);
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		AnalyzerString.analizzaFile();
	}
}
