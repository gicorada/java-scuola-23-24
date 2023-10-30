package inclasse.elementiMultimediali;

/**
 * Classe astratta che rappresenta un generico elemento multimediale
 */
public abstract class ElementoMultimediale {
	private String titolo;

	/**
	 * Costruttore
	 * @param titolo Titolo dell'elemento
	 */
	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Getter del titolo
	 * @return
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * Metodo per riprodurre l'elemento
	 */
	public abstract void esegui();
}