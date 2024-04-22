package inclasse.complessita;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class AlgoritmiOrdinamentoString {
	public static void selectionSort(String[] a) {
		for (int i = 0; i < a.length; i++) {
			int pos_min = i;
			String currentMin = a[i];

			for(int j = i+1; j < a.length; j++) {
				String maybeMin = a[j];
				if(maybeMin.compareTo(currentMin) < 0) {
					pos_min = j;
					currentMin = maybeMin;
				}
			}

			if(pos_min != i) {
				a[pos_min] = a[i];
				a[i] = currentMin;
			}
		}
	}


	public static void substitutionSort(String[] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				String orig = a[i];
				String other = a[j];
				if (orig.compareTo(other) > 0) {
					a[i] = other;
					a[j] = orig;
				}
			}
		}
	}


	public static void bubbleSort(String[] a) {
		boolean scambio = true;
		int last = a.length-1;

		while (scambio) {
			scambio = false;

			for (int i = 0; i < last; i++) {
				String orig = a[i];
				String other = a[i+1];
				if (orig.compareTo(other) > 0) {
					a[i] = other;
					a[i+1] = orig;

					scambio = true;
				}
			}

			last--;
		}
	}


	public static void insertionSort(String[] a) {
		for (int i = 1; i < a.length; i++) {
			String e = a[i];
			int j = i;

			while (j > 0 && a[j-1].compareTo(e) > 0) {
				a[j] = a[j-1];
				j--;
			}

			a[j] = e;
		}
	}


	public static void mergeSort(String[] a) {
		if(a.length == 1) return;

		String[] sx = new String[a.length/2];
		String[] dx = new String[a.length - sx.length];

		for (int i = 0; i < sx.length; i++) {
			sx[i] = a[i];
		}
		for (int i = 0; i < dx.length; i++) {
			dx[i] = a[sx.length + i];
		}

		mergeSort(sx);
		mergeSort(dx);

		int isx = 0, idx = 0, j = 0;
		String esx = sx[0], edx = dx[0];
		while(isx < sx.length && idx < dx.length) {
			if(esx.compareTo(edx) < 0) {
				a[j] = esx;
				isx++;
				if(isx < sx.length) esx = sx[isx];
			} else {
				a[j] = edx;
				idx++;
				if(idx < dx.length) edx = dx[idx];
			} 
			j++;
		}
		while (isx < sx.length) {
			a[j++] = sx[isx++];
		}
		while (idx < dx.length) {
			a[j++] = dx[idx++];
		}
	}


	public static void quickSort(String[] a) {
		quickSort(a, 0, a.length-1);
	}
	private static void quickSort(String[] a, int from, int to) {
		if(from >= to) return;
		int p = quickSortPartition(a, from, to);
		quickSort(a, from, p);
		quickSort(a, p+1, to);
	}
	private static int quickSortPartition(String[] a, int from, int to) {
		String pivot = a[from];
		int i = from - 1;
		int j = to + 1;

		while(i < j) {
			i++;
			while(a[i].compareTo(pivot) < 0) i++;
			j--;
			while(a[j].compareTo(pivot) > 0) j--;
			if(i < j) {
				String tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}

		return j;
	}





	public static void main(String[] args) {

		try(PrintWriter pw = new PrintWriter(".\\inclasse\\inclasse\\complessita\\datiOrdinamentoString.csv")) {
			pw.println("NumElementi,Selection,Sostituzione,Bubble,Insertion,Merge,Quick");
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
		String[] values = new String[cap];

		Random r = new Random();

		for (int i = 0; i < cap; i++) {
			String s = "";
			for(int j = 0; j < r.nextInt(20); j++) {
				s += (char) ('a' + (int) (r.nextFloat() * ('z' - 'a' + 1)));
			}
			values[i] = s;
		}

		String[] aSelection = values.clone();
		long tSelectionStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoString.selectionSort(aSelection);
		long tSelectionEnd = System.currentTimeMillis();
		long tSelection = tSelectionEnd - tSelectionStart;
		if(!isOrdered(aSelection)) {
			throw new Exception("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Selection");
		}


		String[] aSostituzione = values.clone();
		long tSostituzioneStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoString.substitutionSort(aSostituzione);
		long tSostituzioneEnd = System.currentTimeMillis();
		long tSostituzione = tSostituzioneEnd - tSostituzioneStart;
		if(!isOrdered(aSostituzione)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Sostituzione");
		}


		String[] aBubble = values.clone();
		long tBubbleStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoString.bubbleSort(aBubble);
		long tBubbleEnd = System.currentTimeMillis();
		long tBubble = tBubbleEnd - tBubbleStart;
		if(!isOrdered(aBubble)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Bubble");
		}


		String[] aInsertion = values.clone();
		long tInsertionStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoString.insertionSort(aInsertion);
		long tInsertionEnd = System.currentTimeMillis();
		long tInsertion = tInsertionEnd - tInsertionStart;
		if(!isOrdered(aInsertion)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Insertion");
		}


		String[] aMerge = values.clone();
		long tMergeStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoString.mergeSort(aMerge);
		long tMergeEnd = System.currentTimeMillis();
		long tMerge = tMergeEnd - tMergeStart;
		if(!isOrdered(aMerge)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Merge");
		}


		String[] aQuick = values.clone();
		long tQuickStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoString.quickSort(aQuick);
		long tQuickEnd = System.currentTimeMillis();
		long tQuick = tQuickEnd - tQuickStart;
		if(!isOrdered(aQuick)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Quick");
		}




		System.out.println(cap + "," + tSelection + "," + tSostituzione + "," + tBubble + "," + tInsertion + "," + tMerge + "," + tQuick);
		pw.println(cap + "," + tSelection + "," + tSostituzione + "," + tBubble + "," + tInsertion + "," + tMerge + "," + tQuick);
	}




	private static boolean isOrdered(String[] a) {
		boolean isOrdered = true;

		for (int i = 1; i < a.length && isOrdered; i++) {
			if(a[i].compareTo(a[i-1]) < 0) isOrdered = false;
		}

		return isOrdered;
	}
}
















/*
		int cap = 8000;
		ArrayList<Coin> coins = new ArrayList<>(cap);
		Random r = new Random();
		for (int i = 0; i < cap; i++) {
			coins.add(new Coin(r.nextDouble()*5));
		}
		ArrayList<Comparable> aSelection = (ArrayList<Comparable>) coins.clone();
		long tSelectionSortStart = System.currentTimeMillis();
		AlgoritmiOrdinamentoString.selectionSort(aSelection);
		long tSelectionSortEnd = System.currentTimeMillis();
		long tSelection = tSelectionSortEnd - tSelectionSortStart;

		ArrayList<Comparable> aSostituzione = (ArrayList<Comparable>) coins.clone();;
		long tSostituzioneStart = System.currentTimeMillis();
		AlgoritmiOrdinamentoString.sostituzioneSort(aSostituzione);
		long tSostituzioneEnd = System.currentTimeMillis();
		long tSostituzione = tSostituzioneEnd - tSostituzioneStart;

		ArrayList<Comparable> aBubble = (ArrayList<Comparable>) coins.clone();;
		long tBubbleStart = System.currentTimeMillis();
		AlgoritmiOrdinamentoString.bubbleSort(aBubble);
		long tBubbleEnd = System.currentTimeMillis();
		long tBubble = tBubbleEnd - tBubbleStart;
		System.out.println(tSelection + "," + tSostituzione + "," + tBubble);
*/