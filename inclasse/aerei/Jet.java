public class Jet extends AereoAMotore {
	private int motori;

	public Jet(String sigla, double cv, int motori) {
		super(sigla, cv);
		this.motori = motori;
	}
	
	@Override
	public String getTipoAeromobile() {
		return "Jet";
	}

	@Override
	public boolean piuPotenteDi(Aeromobile o) {
		if(o.getClass() != getClass()) return false;
		Jet a = (Jet) o;
		return motori > a.motori;
	}

	public int getMotori() {
		return motori;
	}

	@Override
	public String toString() {
		return super.toString() + ", Numero motori " + getMotori();
	}
}
