package inclasse.struttureDati;

import java.util.ArrayList;

/**
 * Classe che implementa una coda generica semplice, con estremo iniziale fisso
 * attraverso un ArrayList
 * @author radaelli11353
 */
public class QueueArrayList<T> {
	private ArrayList<T> coda;


	/**
	 * Costruttore parametrico
	 * @param cap Capienza iniziale della coda
	 */
	public QueueArrayList(int cap) {
		coda = new ArrayList<>(cap);
	}

	/**
	 * Costruttore di base
	 * Imposta la capienza iniziale a 10
	 */
	public QueueArrayList() {
		this(10);
	}


	/**
	 * Inserisce l'elemento nell'ultima posizione della coda
	 * @param el Elemento da inserire
	 */
	public void enqueue(T el) {
		coda.add(el);
	}

	/**
	 * Ispeziona il primo elemento della coda
	 * @throws IllegalStateException Se la coda è vuota
	 * @return Primo elemento della coda
	 */
	public T getFirst() {
		if(!isEmpty()) {
			return coda.get(0);
		} else throw new IllegalStateException("La coda è vuota");
	}

	/**
	 * Rimuove e restituisce il primo elemento della coda
	 * @throws IllegalStateException Se la coda è vuota
	 * @return Primo elemento della coda
	 */
	public T dequeue() {
		if(!isEmpty()) {
			return coda.remove(0);
		} else throw new IllegalStateException("La coda è vuota");
	}


	/**
	 * Restituisce la grandezza della coda
	 * @return Grandezza della coda
	 */
	public int size() {
		return coda.size();
	}

	/**
	 * Verifica se la coda ha elementi al suo interno
	 * @return True se la coda è vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return coda.isEmpty();
	}

	@Override
	public String toString() {
		return coda.toString();
	}
}
