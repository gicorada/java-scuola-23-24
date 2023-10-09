public class AereoAMotore extends Aeromobile {
	private double cv;

	public AereoAMotore(String sigla, double cv) {
		super(sigla);
		this.cv = cv;
	}
	
	@Override
	public String getTipoAeromobile() {
		return "Aereo a motore";
	}

	@Override
	public boolean piuPotenteDi(Aeromobile o) {
		if(o.getClass() != getClass()) return false;
		AereoAMotore a = (AereoAMotore) o;
		return cv > a.cv;
	}

	public double getCv() {
		return cv;
	}

	@Override
	public String toString() {
		return super.toString() + ", Cavalli " + cv;
	}

	
}
