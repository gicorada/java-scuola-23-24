package inclasse.complessita.altriEsercizi;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Random;

/*
 * Implementate il seguente algoritmo di ordinamento: si suddivide l’array dato,
 * a, in segmenti non decrescenti e decrescenti (cioè segmenti tali che a[i] ≤
 * a[i+1] ≤ ... ≤ a[i+k] oppure a[j] > a[j+1] > ... > a[j+m]), dopodiché si
 * invertono tutti i segmenti decrescenti, in modo che l’array risulti suddiviso
 * in segmenti non decrescenti; a questo punto, si fondono i primi due segmenti,
 * poi i due segmenti successivi, e così via, in modo che ciascuna coppia di
 * segmenti consecutivi dia luogo a un segmento non decrescente, ripetendo la
 * procedura finché non siano stati fusi tutti i segmenti.
 */
public class OrdinamentoClassroom1604 {
	public static void ordinamentoSegmenti(int[] a) {
		ArrayDeque<Sequenza> sequenze = new ArrayDeque<>();
		
		int start = 0;
		int end = 0;
		boolean inSequence = false;
		for (int i = 0; i < a.length - 1; i++) {
			if(a[i] > a[i+1]) {
				if(inSequence) end++;
				else {
					start = i;
					end = i + 1;
					inSequence = true;
				}
			} else {
				Sequenza lastSeq = new Sequenza(start, end);
				if(sequenze.isEmpty()) sequenze.add(lastSeq);
				else if(!sequenze.getLast().equals(lastSeq) && end-start != 0) {
					sequenze.add(lastSeq);
				}
				inSequence = false;
			}
		}
		System.out.println(sequenze.toString());

		// Reverse

		for (Sequenza s : sequenze) {
			
		}

	}

	private static void reverse(int[] a, int l, int r) {
		
	}

	private static void fusione(int[] a, int l1, int r1, int l2, int r2) {

	}

	private static class Sequenza {
		private int first, last;

		public Sequenza(int first, int last) {
			this.first = first;
			this.last = last;
		}

		public int getFirst() {
			return first;
		}
		public int getLast() {
			return last;
		}

		@Override
		public String toString() {
			return first + "-" + last;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == null) throw new IllegalArgumentException();
			if(obj.getClass() != this.getClass()) return false;
			Sequenza s = (Sequenza) obj;

			return first == s.first && last == s.last;
		}
	}


	public static void main(String[] args) {
		int[] array = {3, 43, 13, 25, 44, 32, 41, 23, 35, 46, 24, 43, 14, 43, 12, 39, 4, 35, 2, 44};
/*
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(50);
		}
*/
		System.out.println(Arrays.toString(array));
		
		ordinamentoSegmenti(array);
		
		System.out.println(Arrays.toString(array));
	}
}
