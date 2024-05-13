package inclasse.struttureDati;

import java.util.ArrayList;

/**
 * Classe che implementa una coda circolare generica, con lunghezza fissa e
 * estremi mobili attraverso un ArrayList
 * @author radaelli11353
 */
public class CodaCircolareArrayList<T> {
	private ArrayList<T> coda;
	private int cap;
	private int num;
	private int first;
	private int last;

	/**
	 * Costruttore parametrico
	 * @param cap Capienza massima della coda
	 */
	public CodaCircolareArrayList(int cap) {
		coda = new ArrayList<>(cap);
		for (int i = 0; i < cap; i++) {
			coda.add(null);
		}
		first = 0;
		last = -1;
		num = 0;
		this.cap = cap;
	}

	/**
	 * Costruttore di base
	 * Imposta la capienza massima a 10
	 */
	public CodaCircolareArrayList() {
		this(10);
	}


	/**
	 * Inserisce l'elemento nell'ultima posizione della coda
	 * @throws IllegalStateException Se la coda è piena
	 * @param el Elemento da inserire
	 */
	public void enqueue(T el) {
		if(num == cap) throw new IllegalStateException("La coda è piena");

		int index = (last + 1) % cap;
		coda.set(index, el);
		num++;
		last = index;
	}

	/**
	 * Ispeziona il primo elemento della coda
	 * @throws IllegalStateException Se la coda è piena
	 * @return Primo elemento della coda
	 */
	public T getFirst() {
		if(num == 0) throw new IllegalStateException("Non ci sono elementi");

		return  coda.get(first);
	}

	/**
	 * Rimuove e restituisce il primo elemento della coda
	 * @throws IllegalStateException Se la coda è piena
	 * @return Primo elemento della coda
	 */
	public T dequeue() {
		if(num == 0) throw new IllegalStateException("Non ci sono elementi");

		T el = coda.get(first++);
		num--;
		return el;
	}


	/**
	 * Restituisce il numero di elementi presenti nella coda
	 * Non restituisce la dimensione effettiva
	 * @return Numero di elementi presenti nella coda
	 */
	public int size() {
		return num;
	}

	/**
	 * Restituisce la dimensione massima della coda
	 * @return Dimensione massima della coda
	 */
	public int maxSize() {
		return cap;
	}

	/**
	 * Verifica se la coda ha elementi al suo interno
	 * @return True se la coda è vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return num == 0;
	}

	@Override
	public String toString() {
		return coda.toString();
	}
}
