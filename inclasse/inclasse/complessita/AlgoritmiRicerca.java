package inclasse.complessita;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class AlgoritmiRicerca {
	public static int ricercaLineare(int[] a, int c) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == c) return i;
		}
		return -1;
	}


	public static int ricercaBinaria(int[] a, int c) {
		return ricercaBinaria(a, c, 0, a.length-1);
	}
	private static int ricercaBinaria(int[] a, int c, int low, int high) {
		if(low <= high) {
			int mid = (low + high)/2;
			if(a[mid] == c) return mid;
			else if(a[mid] > c) return ricercaBinaria(a, c, low, mid-1);
			else return ricercaBinaria(a, c, mid+1, high);
		}
		else return -1;
	}


	public static void main(String[] args) {

		try(PrintWriter pw = new PrintWriter(".\\inclasse\\inclasse\\complessita\\datiRicerca.csv")) {
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
		int[] values = new int[cap];

		Random r = new Random();

		for (int i = 0; i < cap; i++) {
			values[i] = r.nextInt(cap);
		}

		int c = values[r.nextInt(cap)];

		int[] aLineare = values.clone();
		long tLineareStart = System.currentTimeMillis();
		int iLineare = AlgoritmiRicerca.ricercaLineare(aLineare, c);
		long tLineareEnd = System.currentTimeMillis();
		long tLineare = tLineareEnd - tLineareStart;
		if(iLineare != -1 && aLineare[iLineare] != c) {
			throw new Exception("Errore nella ricerca all'iterazione " + cap + " della ricerca Lineare");
		}


		int[] aBinaria = values.clone();
		long tOrdEBinariaStart = System.currentTimeMillis();
		Arrays.sort(aBinaria);
		long tBinariaStart = System.currentTimeMillis();
		int iBinaria = AlgoritmiRicerca.ricercaBinaria(aBinaria, c);
		long tBinariaEnd = System.currentTimeMillis();
		long tBinaria = tBinariaEnd - tBinariaStart;
		long tOrdEBinaria = tBinariaEnd - tOrdEBinariaStart;
		if(iBinaria != -1 && aBinaria[iBinaria] != c) {
			throw new Exception("Errore nella ricerca all'iterazione " + cap + " della ricerca Binary");
		}


		System.out.println(cap + "," + tLineare + "," + tBinaria + "," + tOrdEBinaria);
		pw.println(cap + "," + tLineare + "," + tBinaria + "," + tOrdEBinaria);
	}
}
