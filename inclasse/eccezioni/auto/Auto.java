package eccezioni.auto;

public class Auto {
	private String nome;
	private int km;
	private int litri;

	/**
	 * Costruttore
	 * @param nome Nome dell'auto
	 * @param km Km percorsi dall'auto
	 * @param litri Litri consumati dall'auto nel percorso
	 */
	public Auto(String nome, int km, int litri) throws IllegalArgumentException {
		if(km < 0) throw new IllegalArgumentException("I km percorsi non possono essere negativi");
		if(litri < 0) throw new IllegalArgumentException("I litri consumati non possono essere negativi");
		if(litri == 0 && km > 0) throw new IllegalArgumentException("I litri consumati devono essere maggiori di zero se i km percorsi non sono 0");
		
		this.nome = nome;
		this.km = km;
		this.litri = litri;
		
	}

	/*
	 * Calcola la resa dell'auto, in base ai km percorsi e ai litri consumati forniti
	 */
	public double resa() {
		return km/(double)litri;
	}

	/*
	 * Getter del nome dell'auto
	 */
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "L'auto " + nome + " ha percorso " + km + " km usando " + litri + " litri";
	}
}
