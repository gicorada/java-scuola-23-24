public class Aliante extends Aeromobile {
	private int efficienza;

	public Aliante(String sigla, int efficienza) {
		super(sigla);
		this.efficienza = efficienza;
	}

	@Override
	public String getTipoAeromobile() {
		return "Aliante";
	}

	@Override
	public boolean piuPotenteDi(Aeromobile o) {
		if(o.getClass() != getClass()) return false;
		Aliante a = (Aliante) o;
		return efficienza > a.efficienza;
	}

	public int getEfficienza() {
		return efficienza;
	}

	@Override
	public String toString() {
		return super.toString() + ", Efficienza " + getEfficienza();
	}
}
