package inclasse.aerei;

/**
 * Classe che rappresenta un aliante con una efficienza
 */
public class Aliante extends Aeromobile {
	private int efficienza;

	/**
	 * Costruttore
	 * @param sigla Nome dell'aliante
	 * @param efficienza Numero intero che rappresenta l'efficienza dell'aliante
	 */
	public Aliante(String sigla, int efficienza) {
		super(sigla);
		this.efficienza = efficienza;
	}

	/**
	 * Getter dell'efficienza dell'aliante
	 * @return
	 */
	public int getEfficienza() {
		return efficienza;
	}

	@Override
	public String getTipoAeromobile() {
		return "Aliante";
	}

	@Override
	public boolean piuPotenteDi(Aeromobile o) {
		if(o.getClass() != getClass()) throw new IllegalArgumentException("Un aliante non può essere confrontato con un " + o.getTipoAeromobile());
		Aliante a = (Aliante) o;
		return efficienza > a.efficienza;
	}

	@Override
	public String toString() {
		return super.toString() + ", Efficienza " + getEfficienza();
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;

		Aliante a = (Aliante) obj;
		
		return efficienza == a.efficienza;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + (int) efficienza;
	}

	@Override
	public int compareTo(Aeromobile o) {
		if(o.getClass() != getClass()) throw new ClassCastException();

		Aliante a = (Aliante) o;

		return efficienza - a.efficienza;
	}
}
