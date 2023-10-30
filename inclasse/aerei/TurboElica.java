package inclasse.aerei;

/**
 * Classe che rappresenta un aereo a motore turboelica
 */
public class TurboElica extends AereoAMotore {
	private int rpm;

	/**
	 * Costruttore
	 * @param sigla Nome del turboelica
	 * @param cv Potenza del motore in cavalli
	 * @param rpm Giri per minuto delle eliche
	 */
	public TurboElica(String sigla, double cv, int rpm) {
		super(sigla, cv);
		this.rpm = rpm;
	}

	/**
	 * Getter del numero di giri del motore
	 * @return Numero di giri del motore per minuto
	 */
	public int getRpm() {
		return rpm;
	}

	@Override
	public String getTipoAeromobile() {
		return "Turbo-elica";
	}
	
	@Override
	public boolean piuPotenteDi(Aeromobile o) {
		if(o.getClass() != getClass()) throw new IllegalArgumentException("Un turboelica non può essere confrontato con un " + o.getTipoAeromobile());
		TurboElica a = (TurboElica) o;
		return rpm > a.rpm;
	}

	@Override
	public String toString() {
		return super.toString() + ", Giri per minuto "+ rpm;
	}
}
