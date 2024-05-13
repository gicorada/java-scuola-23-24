package inclasse.struttureDati;

import java.util.ArrayList;

/**
 * Classe che implementa una pila generica attraverso un ArrayList
 * @author radaelli11353
 */
public class StackArrayList<T> {
	private ArrayList<T> pila;

	/**
	 * Costruttore parametrico
	 * @param cap Capienza iniziale della pila
	 */
	public StackArrayList(int cap) {
		pila = new ArrayList<>(cap);
	}

	/**
	 * Costruttore di base
	 * Imposta la capienza iniziale a 10
	 */
	public StackArrayList() {
		this(10);
	}

	/**
	 * Inserisce un elemento alla parte superiore della pila
	 * @param el Elemento da inserire
	 */
	public void push(T el) {
		pila.add(el);
	}

	/**
	 * Ispeziona l'elemento nella parte superiore della pila
	 * @throws IllegalStateException Se la pila è vuota
	 * @return Elemento nella parte superiore della pila
	 */
	public T top() {
		if(!isEmpty()) {
			return pila.get(pila.size() - 1);
		} else throw new IllegalStateException("La pila è vuota");
	}

	/**
	 * Rimuove e restituisce l'elemento nella parte superiore della pila
	 * @throws IllegalStateException Se la pila è vuota
	 * @return Elemento nella parte superiore della pila
	 */
	public T pop() {
		if(!isEmpty()) {
			return pila.remove(pila.size() - 1);
		} else throw new IllegalStateException("La pila è vuota");
	}


	/**
	 * Restituisce la grandezza della pila
	 * @return Grandezza della pila
	 */
	public int size() {
		return pila.size();
	}

	/**
	 * Verifica se la pila ha elementi al suo interno
	 * @return True se la pila è vuota, false altrimenti
	 */
	public boolean isEmpty() {
		return pila.isEmpty();
	}
	
	@Override
	public String toString() {
		return pila.toString();
	}
}
