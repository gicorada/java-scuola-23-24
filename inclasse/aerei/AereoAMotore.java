/**
 * Classe che rappresenta un aereo a motore con una potenza in cavalli
 */
public class AereoAMotore extends Aeromobile {
	private double cv;

	/**
	 * Costruttore
	 * @param sigla Nome dell'aereo a motore
	 * @param cv Potenza del motore in cavalli
	 */
	public AereoAMotore(String sigla, double cv) {
		super(sigla);
		this.cv = cv;
	}
	
	/**
	 * Getter della potenza
	 * @return Potenza del motore in cavalli
	 */
	public double getCv() {
		return cv;
	}

	@Override
	public String getTipoAeromobile() {
		return "Aereo a motore";
	}

	@Override
	public boolean piuPotenteDi(Aeromobile o) {
		if(o.getClass() != getClass()) throw new IllegalArgumentException("Un aereo a motore non può essere confrontato con un " + o.getTipoAeromobile());
		AereoAMotore a = (AereoAMotore) o;
		return cv > a.cv;
	}

	@Override
	public String toString() {
		return super.toString() + ", Cavalli " + cv;
	}
}
