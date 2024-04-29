package inclasse.complessita;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class AlgoritmiRicercaPersona {
	public static int ricercaLineare(Persona[] a, Persona c) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == c) return i;
		}
		return -1;
	}


	public static int ricercaBinaria(Persona[] a, Persona c) {
		return ricercaBinaria(a, c, 0, a.length-1);
	}
	private static int ricercaBinaria(Persona[] a, Persona c, int low, int high) {
		if(low <= high) {
			int mid = (low + high)/2;
			if(a[mid].equals(c)) return mid;
			else if(a[mid].equals(c)) return ricercaBinaria(a, c, low, mid-1);
			else return ricercaBinaria(a, c, mid+1, high);
		}
		else return -1;
	}


	public static void main(String[] args) {
		try(PrintWriter pw = new PrintWriter(".\\inclasse\\inclasse\\complessita\\datiRicercaPersona.csv")) {
			pw.println("Lineare,SoloRicercaBinaria,OrdEBinariaConArraysSort");
			int start = Integer.parseInt(args[0]);
			int end = Integer.parseInt(args[1]);
			int diff = Integer.parseInt(args[2]);
			
			for (int i = start; i < end; i = i + diff) {
				tester(pw, i);
			}
		} catch(FileNotFoundException e) {
			System.out.println("File non trovato");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


	private static void tester(PrintWriter pw, int cap) throws Exception {
		Persona[] values = new Persona[cap];

		Random r = new Random();

		for (int i = 0; i < cap; i++) {
			String nome = "";
			for(int j = 0; j < r.nextInt(20); j++) {
				nome += (char) ('a' + (int) (r.nextFloat() * ('z' - 'a' + 1)));
			}
			String cognome = "";
			for(int j = 0; j < r.nextInt(20); j++) {
				nome += (char) ('a' + (int) (r.nextFloat() * ('z' - 'a' + 1)));
			}

			values[i] = new Persona(nome,cognome,r.nextInt(100));
		}

		Persona c = values[r.nextInt(cap)];

		Persona[] aLineare = values.clone();
		long tLineareStart = System.currentTimeMillis();
		int iLineare = AlgoritmiRicercaPersona.ricercaLineare(aLineare, c);
		long tLineareEnd = System.currentTimeMillis();
		long tLineare = tLineareEnd - tLineareStart;
		if(iLineare != -1 && aLineare[iLineare] != c) {
			throw new Exception("Errore nella ricerca all'iterazione " + cap + " della ricerca Lineare");
		}


		Persona[] aBinaria = values.clone();
		long tOrdEBinariaStart = System.currentTimeMillis();
		Arrays.sort(aBinaria);
		long tSoloRicercaBinariaStart = System.currentTimeMillis();
		int iBinaria = AlgoritmiRicercaPersona.ricercaBinaria(aBinaria, c);
		long tSoloRicercaBinariaEnd = System.currentTimeMillis();
		long tSoloRicercaBinaria = tSoloRicercaBinariaEnd - tSoloRicercaBinariaStart;
		long tOrdEBinaria = tSoloRicercaBinariaEnd - tOrdEBinariaStart;
		if(iBinaria != -1 && aBinaria[iBinaria] != c) {
			throw new Exception("Errore nella ricerca all'iterazione " + cap + " della ricerca Binary");
		}


		System.out.println(cap + "," + tLineare + "," + tSoloRicercaBinaria + "," + tOrdEBinaria);
		pw.println(cap + "," + tLineare + "," + tSoloRicercaBinaria + "," + tOrdEBinaria);
	}
}
