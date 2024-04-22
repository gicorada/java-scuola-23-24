package inclasse.complessita;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class AlgoritmiOrdinamentoGen {
	public static void selectionSort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int pos_min = i;
			Comparable currentMin = a[i];

			for(int j = i+1; j < a.length; j++) {
				Comparable maybeMin = a[j];
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


	public static void substitutionSort(Comparable[] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				Comparable orig = a[i];
				Comparable other = a[j];
				if (orig.compareTo(other) > 0) {
					a[i] = other;
					a[j] = orig;
				}
			}
		}
	}


	public static void bubbleSort(Comparable[] a) {
		boolean scambio = true;
		int last = a.length-1;

		while (scambio) {
			scambio = false;

			for (int i = 0; i < last; i++) {
				Comparable orig = a[i];
				Comparable other = a[i+1];
				if (orig.compareTo(other) > 0) {
					a[i] = other;
					a[i+1] = orig;

					scambio = true;
				}
			}

			last--;
		}
	}


	public static void insertionSort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			Comparable e = a[i];
			int j = i;

			while (j > 0 && a[j-1].compareTo(e) > 0) {
				a[j] = a[j-1];
				j--;
			}

			a[j] = e;
		}
	}


	public static void mergeSort(Comparable[] a) {
		if(a.length == 1) return;

		Comparable[] sx = new Comparable[a.length/2];
		Comparable[] dx = new Comparable[a.length - sx.length];

		for (int i = 0; i < sx.length; i++) {
			sx[i] = a[i];
		}
		for (int i = 0; i < dx.length; i++) {
			dx[i] = a[sx.length + i];
		}

		mergeSort(sx);
		mergeSort(dx);

		int isx = 0, idx = 0, j = 0;
		Comparable esx = sx[0], edx = dx[0];
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


	public static void quickSort(Comparable[] a) {
		quickSort(a, 0, a.length-1);
	}
	private static void quickSort(Comparable[] a, int from, int to) {
		if(from >= to) return;
		int p = quickSortPartition(a, from, to);
		quickSort(a, from, p);
		quickSort(a, p+1, to);
	}
	private static int quickSortPartition(Comparable[] a, int from, int to) {
		Comparable pivot = a[from];
		int i = from - 1;
		int j = to + 1;

		while(i < j) {
			i++;
			while(a[i].compareTo(pivot) < 0) i++;
			j--;
			while(a[j].compareTo(pivot) > 0) j--;
			if(i < j) {
				Comparable tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}

		return j;
	}





	public static void main(String[] args) {
		try(PrintWriter pw = new PrintWriter(".\\inclasse\\inclasse\\complessita\\datiOrdinamentoComparable.csv")){
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
		Comparable[] values = new Comparable[cap];

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

		Comparable[] aSelection = values.clone();
		long tSelectionStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoGen.selectionSort(aSelection);
		long tSelectionEnd = System.currentTimeMillis();
		long tSelection = tSelectionEnd - tSelectionStart;
		if(!isOrdered(aSelection)) {
			throw new Exception("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Selection");
		}


		Comparable[] aSostituzione = values.clone();
		long tSostituzioneStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoGen.substitutionSort(aSostituzione);
		long tSostituzioneEnd = System.currentTimeMillis();
		long tSostituzione = tSostituzioneEnd - tSostituzioneStart;
		if(!isOrdered(aSostituzione)) {
			throw new Exception("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Sostituzione");
		}


		Comparable[] aBubble = values.clone();
		long tBubbleStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoGen.bubbleSort(aBubble);
		long tBubbleEnd = System.currentTimeMillis();
		long tBubble = tBubbleEnd - tBubbleStart;
		if(!isOrdered(aBubble)) {
			throw new Exception("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Bubble");
		}


		Comparable[] aInsertion = values.clone();
		long tInsertionStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoGen.insertionSort(aInsertion);
		long tInsertionEnd = System.currentTimeMillis();
		long tInsertion = tInsertionEnd - tInsertionStart;
		if(!isOrdered(aInsertion)) {
			throw new Exception("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Insertion");
		}


		Comparable[] aMerge = values.clone();
		long tMergeStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoGen.mergeSort(aMerge);
		long tMergeEnd = System.currentTimeMillis();
		long tMerge = tMergeEnd - tMergeStart;
		if(!isOrdered(aMerge)) {
			throw new Exception("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Merge");
		}


		Comparable[] aQuick = values.clone();
		long tQuickStart = System.currentTimeMillis();
			AlgoritmiOrdinamentoGen.quickSort(aQuick);
		long tQuickEnd = System.currentTimeMillis();
		long tQuick = tQuickEnd - tQuickStart;
		if(!isOrdered(aQuick)) {
			throw new Exception("L'array non è stato ordinato correttamente all'iterazione " + cap + " dell'ordinamento Quick");
		}




		System.out.println(cap + "," + tSelection + "," + tSostituzione + "," + tBubble + "," + tInsertion + "," + tMerge + "," + tQuick);
		pw.println(cap + "," + tSelection + "," + tSostituzione + "," + tBubble + "," + tInsertion + "," + tMerge + "," + tQuick);
	}




	private static boolean isOrdered(Comparable[] a) {
		boolean isOrdered = true;

		for (int i = 1; i < a.length && isOrdered; i++) {
			if(a[i].compareTo(a[i-1]) < 0) isOrdered = false;
		}

		return isOrdered;
	}
}