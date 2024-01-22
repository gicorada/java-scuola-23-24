package ricorsione;

import java.util.Arrays;

public class Esercizi {
	public static void main(String[] args) {
		int indiceFibo = 9;
		System.out.println("Il numero all'indice " + indiceFibo + " della sequenza di Fibonacci è " + fibo(indiceFibo));
	
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("L'array " + Arrays.toString(a) + (ordineCrescente(a) ? " " : " non " ) + "è in ordine crescente");
	
	
		String stringaPalindroma = "anna";
		System.out.println("La stringa '"+ stringaPalindroma + "' " + (isPalindroma(stringaPalindroma) ? "" : "non") + "è palindroma");
	
	
		int aPot = 2, bPot = 3;
		System.out.println("La potenza (" + aPot + ")^(" + bPot + ") ha come risultato " + potenza(aPot, bPot));
	
	
		int aMol = 5, bMol = -3;
		System.out.println("La moltiplicazione (" + aMol + ")*(" + bMol + ") ha come risultato " + moltiplica(aMol, bMol));
	}



	/**
	 * Calcola il n° numero della sequenza di fibonacci
	 * @param n Indice del numero nella sequenza
	 * @return Numero corrispondente all'indice n nella sequenza di fibonacci
	 */
	public static int fibo(int n) {
		if(n < 0) throw new IllegalArgumentException("L'indice richiesto deve essere non negativo");
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		return fibo(n-1) + fibo(n-2);
	}
	
	//------------------------------------------
	
	/**
	 * Verifica se l'array fornito è in ordine crescente
	 * Restituisce true anche se due elementi consecutivi sono uguali (ad es 1, 2, 2, 3, 4)
	 * @param a Array da verificare
	 * @return True se l'array è in ordine crescente, false altrimenti
	 */
	public static boolean ordineCrescente(int[] a) {
		if(a.length <= 0) throw new IllegalArgumentException("L'array non può essere vuoto");
		return ordineCrescente(a, a.length - 1);
	}

	private static boolean ordineCrescente(int[] a, int pos) {
		if(pos == 0) return true;

		return a[pos] >= a[pos - 1] && ordineCrescente(a, pos - 1);
	}

	//------------------------------------------

	/**
	 * Verifica se una stringa è palindroma
	 * Per definizione, le stringhe da 0 o 1 caratteri sono palindrome
	 * @param s Stringa da verificare
	 * @return True se la stringa è palindroma, false altrimenti
	 */
	public static boolean isPalindroma(String s) {
		return isPalindroma(s, 0);
	}

	private static boolean isPalindroma(String s, int pos) {
		if(s.length() / 2 == pos) return true;

		return s.charAt(pos) == s.charAt(s.length() - pos - 1) && isPalindroma(s, pos + 1);
	}

	//------------------------------------------

	/**
	 * Calcola la potenza di un numero senza utilizzare funzioni di libreria, utilizzando ricorsivamente la moltiplicazione
	 * @param a Base della potenza
	 * @param b Esponente della potenza, maggiore o uguale a 0
	 * @return a^b
	 */
	public static int potenza(int a, int b) {
		if(b < 0) throw new IllegalArgumentException("L'esponente non può essere negativo, utilizzando questo metodo");
		if(b == 0) return 1;

		return a*potenza(a, b-1);
	}

	//------------------------------------------

	/**
	 * Calcola la moltiplicazione di due numeri utilizzando ricorsivamente la somma
	 * Posso utilizzare numeri negativi
	 * @param a Moltiplicando
	 * @param b Moltiplicatore
	 * @return a*b
	 */
	public static int moltiplica(int a, int b) {
		if(b < 0) {
			a = -a;
			b = -b;
		}
		if(b == 0) return 0;

		return a + moltiplica(a, b-1);
	}


 
}