package inclasse.elementiMultimediali;

public interface Riproducibile {
	/**
	 * Getter della durata dell'elemento riproducibile
	 * @return Durata dell'elemento
	 */
	int getDurata();

	/**
	 * Metodo per riprodurre l'elemento
	 */
	void play();

	/**
	 * Metodo per diminuire il volume dell'elemento
	 */
	void weaker();

	/**
	 * Metodo per aumentare il volume dell'elemento
	 */
	void louder();
}