public class TurboElica extends AereoAMotore {
	private int rpm;

	public TurboElica(String sigla, double cv, int rpm) {
		super(sigla, cv);
		this.rpm = rpm;
	}

	@Override
	public String getTipoAeromobile() {
		return "Turbo-elica";
	}
	
	@Override
	public boolean piuPotenteDi(Aeromobile o) {
		if(o.getClass() != getClass()) return false;
		TurboElica a = (TurboElica) o;
		return rpm > a.rpm;
	}

	public int getRpm() {
		return rpm;
	}

	@Override
	public String toString() {
		return super.toString() + ", Giri per minuto "+ rpm;
	}
}
