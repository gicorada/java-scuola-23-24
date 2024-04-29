package inclasse.complessita;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class AlgoritmiOrdinamento {
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int pos_min = i;
			int currentMin = a[i];

			for(int j = i+1; j < a.length; j++) {
				int maybeMin = a[j];
				if(maybeMin < currentMin) {
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


	public static void substitutionSort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				int orig = a[i];
				int other = a[j];
				if (orig>other) {
					a[i] = other;
					a[j] = orig;
				}
			}
		}
	}


	public static void bubbleSort(int[] a) {
		boolean scambio = true;
		int last = a.length-1;

		while (scambio) {
			scambio = false;

			for (int i = 0; i < last; i++) {
				int orig = a[i];
				int other = a[i+1];
				if (orig>other) {
					a[i] = other;
					a[i+1] = orig;

					scambio = true;
				}
			}

			last--;
		}
	}


	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int e = a[i];
			int j = i;

			while (j > 0 && a[j-1] > e) {
				a[j] = a[j-1];
				j--;
			}

			a[j] = e;
		}
	}


	public static void mergeSort(int[] a) {
		if(a.length == 1) return;

		int[] sx = new int[a.length/2];
		int[] dx = new int[a.length - sx.length];

		for (int i = 0; i < sx.length; i++) {
			sx[i] = a[i];
		}
		for (int i = 0; i < dx.length; i++) {
			dx[i] = a[sx.length + i];
		}

		mergeSort(sx);
		mergeSort(dx);

		int isx = 0, idx = 0, j = 0;
		int esx = sx[0], edx = dx[0];
		while(isx < sx.length && idx < dx.length) {
			if(esx < edx) {
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


	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length-1);
	}
	private static void quickSort(int[] a, int from, int to) {
		if(from >= to) return;
		int p = quickSortPartition(a, from, to);
		quickSort(a, from, p);
		quickSort(a, p+1, to);
	}
	private static int quickSortPartition(int[] a, int from, int to) {
		int pivot = a[from];
		int i = from - 1;
		int j = to + 1;

		while(i < j) {
			i++;
			while(a[i] < pivot) i++;
			j--;
			while(a[j] > pivot) j--;
			if(i < j) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}

		return j;
	}





	public static void main(String[] args) {
		try(PrintWriter pw = new PrintWriter(".\\inclasse\\inclasse\\complessita\\datiOrdinamento.csv")) {
			pw.println("NumElementi,Selection,Sostituzione,Bubble,Insertion,Merge,Quick");
			int start = Integer.parseInt(args[0]);
			int end = Integer.parseInt(args[1]);
			int diff = Integer.parseInt(args[2]);

			for (int i = start; i < end; i = i + diff) {
				tester(pw, i);
			}
		} catch(FileNotFoundException e) {
			System.out.println("File non trovato");
		}
	}


	private static void tester(PrintWriter pw, int cap) {
		int[] values = new int[cap];

		Random r = new Random();

		for (int i = 0; i < cap; i++) {
			values[i] = r.nextInt(cap);
		}

		int[] aSelection = values.clone();
		long tSelectionStart = System.currentTimeMillis();
		AlgoritmiOrdinamento.selectionSort(aSelection);
		long tSelectionEnd = System.currentTimeMillis();
		long tSelection = tSelectionEnd - tSelectionStart;
		if(!isOrdered(aSelection)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Selection");
		}


		int[] aSostituzione = values.clone();
		long tSostituzioneStart = System.currentTimeMillis();
		AlgoritmiOrdinamento.substitutionSort(aSostituzione);
		long tSostituzioneEnd = System.currentTimeMillis();
		long tSostituzione = tSostituzioneEnd - tSostituzioneStart;
		if(!isOrdered(aSostituzione)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Sostituzione");
		}


		int[] aBubble = values.clone();
		long tBubbleStart = System.currentTimeMillis();
		AlgoritmiOrdinamento.bubbleSort(aBubble);
		long tBubbleEnd = System.currentTimeMillis();
		long tBubble = tBubbleEnd - tBubbleStart;
		if(!isOrdered(aBubble)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Bubble");
		}


		int[] aInsertion = values.clone();
		long tInsertionStart = System.currentTimeMillis();
		AlgoritmiOrdinamento.insertionSort(aInsertion);
		long tInsertionEnd = System.currentTimeMillis();
		long tInsertion = tInsertionEnd - tInsertionStart;
		if(!isOrdered(aInsertion)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Insertion");
		}


		int[] aMerge = values.clone();
		long tMergeStart = System.currentTimeMillis();
		AlgoritmiOrdinamento.mergeSort(aMerge);
		long tMergeEnd = System.currentTimeMillis();
		long tMerge = tMergeEnd - tMergeStart;
		if(!isOrdered(aMerge)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Merge");
		}


		int[] aQuick = values.clone();
		long tQuickStart = System.currentTimeMillis();
		AlgoritmiOrdinamento.quickSort(aQuick);
		long tQuickEnd = System.currentTimeMillis();
		long tQuick = tQuickEnd - tQuickStart;
		if(!isOrdered(aQuick)) {
			System.out.println("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Quick");
		}




		System.out.println(cap + "," + tSelection + "," + tSostituzione + "," + tBubble + "," + tInsertion + "," + tMerge + "," + tQuick);
		pw.println(cap + "," + tSelection + "," + tSostituzione + "," + tBubble + "," + tInsertion + "," + tMerge + "," + tQuick);
	}




	private static boolean isOrdered(int[] a) {
		boolean isOrdered = true;

		for (int i = 1; i < a.length && isOrdered; i++) {
			if(a[i] < a[i-1]) isOrdered = false;
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
		AlgoritmiOrdinamento.selectionSort(aSelection);
		long tSelectionSortEnd = System.currentTimeMillis();
		long tSelection = tSelectionSortEnd - tSelectionSortStart;

		ArrayList<Comparable> aSostituzione = (ArrayList<Comparable>) coins.clone();;
		long tSostituzioneStart = System.currentTimeMillis();
		AlgoritmiOrdinamento.sostituzioneSort(aSostituzione);
		long tSostituzioneEnd = System.currentTimeMillis();
		long tSostituzione = tSostituzioneEnd - tSostituzioneStart;

		ArrayList<Comparable> aBubble = (ArrayList<Comparable>) coins.clone();;
		long tBubbleStart = System.currentTimeMillis();
		AlgoritmiOrdinamento.bubbleSort(aBubble);
		long tBubbleEnd = System.currentTimeMillis();
		long tBubble = tBubbleEnd - tBubbleStart;
		System.out.println(tSelection + "," + tSostituzione + "," + tBubble);
*/