/**
 * Classe che rappresenta un elemento multimediale di tipo filmato
 */
public class Filmato extends ElementoMultimediale implements Illuminabile, Riproducibile{
	private int durata;
	private int luminosita;
	private int volume;
	
	/**
	 * Costruttore
	 * @param titolo Titolo del filmato
	 * @param durata Durata del filmato
	 */
	public Filmato(String titolo, int durata) {
		super(titolo);
		this.durata = durata;
	}

	@Override
	public int getDurata() {
		return durata;
	}

	@Override
	public void play() {
		String v = " ";
		String l = " ";
		for(int i = 0; i < volume; i++) { v += "v"; }
		for(int i = 0; i < luminosita; i++) { l += "l"; }
		
		for (int i = 0; i < durata; i++) {
			System.out.println(getTitolo() + v + l);
		}
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
	public void brighter() {
		luminosita++;
	}

	@Override
	public void darker() {
		luminosita--;
	}

	@Override
	public void esegui() {
		play();
	}
	
}
