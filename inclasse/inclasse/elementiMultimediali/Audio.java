package inclasse.elementiMultimediali;

/**
 * Classe che rappresenta un elemento multimediale di tipo audio
 */
public class Audio extends ElementoMultimediale implements Riproducibile {
	private int durata;
	private int volume;

	/**
	 * Costruttore
	 * @param titolo Titolo dell'elemento audio
	 * @param durata Durata dell'elemento audio
	 */
	public Audio(String titolo, int durata) {
		super(titolo);
		this.durata = durata;
		volume = 5;
	}

	@Override
	public int getDurata() {
		return durata;
	}

	@Override
	public void play() {
		String v = " ";
		for(int i = 0; i < volume; i++) { v += "v"; }
		for(int i = 0; i < durata; i++) { System.out.println(getTitolo() + v); }
	}

	@Override
	public void weaker() {
		volume--;
	}

	@Override
	public void louder() {
		volume++;
	}

	@Override
	public void esegui() {
		play();
	}
}