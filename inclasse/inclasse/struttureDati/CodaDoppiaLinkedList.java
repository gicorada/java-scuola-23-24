package inclasse.struttureDati;

import java.util.LinkedList;

/**
 * Classe che implementa una coda doppia generica attraverso una LinkedList
 * @author radaelli11353
 */
public class CodaDoppiaLinkedList<T> {
	private LinkedList<T> coda;
	
	/**
	 * Costruttore di base
	 * Imposta la capienza iniziale a 10
	 */
	public CodaDoppiaLinkedList() {
		coda = new LinkedList<>();
	}


	// Coda da dx a sx
	/**
	 * Aggiunge l'elemento in coda alla coda che scorre da destra a sinistra
	 * @param el Elemento da aggiungere in coda
	 */
	public void addLast(T el) {
		coda.addLast(el);
	}

	/**
	 * Ispeziona il primo elemento della coda che scorre da destra a sinistra
	 * @throws IllegalStateException Se la coda è vuota
	 * @return Elemento nella prima posizione a sinistra
	 */
	public T getFirst() {
		if(coda.isEmpty()) throw new IllegalStateException();
		return coda.getFirst();
	}

	/**
	 * Ispeziona e rimuove il primo elemento della coda che scorre da destra a
	 * sinistra
	 * @throws IllegalStateException Se la coda è vuota
	 * @return Elemento nella prima posizione a sinistra
	 */
	public T removeFirst() {
		if(coda.isEmpty()) throw new IllegalStateException();
		return coda.removeFirst();
	}



	// Coda da sx a dx
	/**
	 * Aggiunge l'elemento in coda alla coda che scorre da sinistra a destra
	 * @param el Elemento da aggiungere in coda
	 */
	public void addFirst(T el) {
		coda.addFirst(el);
	}

	/**
	 * Ispeziona il primo elemento della coda che scorre da sinistra a destra
	 * @throws IllegalStateException Se la coda è vuota
	 * @return Elemento nella prima posizione a destra
	 */
	public T getLast() {
		if(coda.isEmpty()) throw new IllegalStateException();
		return coda.getLast();
	}

	/**
	 * Ispeziona il primo elemento della coda che scorre da sinistra a destra
	 * @throws IllegalStateException Se la coda è vuota
	 * @return Elemento nella prima posizione a destra
	 */
	public T removeLast() {
		if(coda.isEmpty()) throw new IllegalStateException();
		return coda.removeLast();
	}


	
	/**
	 * Restituisce la grandezza della coda doppia
	 * @return Grandezza della coda doppia
	 */
	public int size() {
		return coda.size();
	}

	/**
	 * Verifica se la coda doppia ha elementi al suo interno
	 * @return True se la coda doppia è vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return coda.isEmpty();
	}

}
