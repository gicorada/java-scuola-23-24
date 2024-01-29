package inclasse.aerei;

/**
 * Classe che rappresenta un Jet con un numero di motori
 */
public class Jet extends AereoAMotore {
	private int motori;

	/**
	 * Costruttore
	 * @param sigla Nome del jet
	 * @param cv Potenza del motore in cavalli
	 * @param motori Numero di motori che il jet usa
	 */
	public Jet(String sigla, double cv, int motori) {
		super(sigla, cv);
		this.motori = motori;
	}
	
	/**
	 * Getter del numero di motori
	 * @return Numero di motori utilizzati dal jet
	 */
	public int getMotori() {
		return motori;
	}
	
	@Override
	public String getTipoAeromobile() {
		return "Jet";
	}

	@Override
	public boolean piuPotenteDi(Aeromobile o) {
		if(o.getClass() != getClass()) throw new IllegalArgumentException("Un Jet non può essere confrontato con un " + o.getTipoAeromobile());
		Jet a = (Jet) o;
		return motori > a.motori;
	}

	@Override
	public String toString() {
		return super.toString() + ", Numero motori " + getMotori();
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;

		Jet a = (Jet) obj;
		
		return motori == a.motori;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + (int) motori;
	}

	@Override
	public int compareTo(Aeromobile o) {
		if(o.getClass() != getClass()) throw new ClassCastException();

		Jet a = (Jet) o;

		return motori - a.motori;
	}
}
