/**
 * Classe che rappresenta un elemento multimediale di tipo immagine
 */
public class Immagine extends ElementoMultimediale implements Illuminabile {
	private int luminosita;

	/**
	 * Costruttore
	 * @param titolo Titolo dell'immagine
	 */
	public Immagine(String titolo) {
		super(titolo);
		luminosita = 5;
	}

	/**
	 * Metodo per mostrare l'elemento
	 */
	public void show() {
		String l = " ";
		for(int i = 0; i < luminosita; i++) { l += "l"; }
		System.out.println(getTitolo() + l);
	}

	public void brighter() {
		luminosita++;
	}

	public void darker() {
		luminosita--;
	}

	@Override
	public void esegui() {
		show();
	}
}