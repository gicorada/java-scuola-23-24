public abstract class Aeromobile implements Aeromodello {
	private String sigla;

	public Aeromobile(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	@Override
	public String toString() {
		return getTipoAeromobile() + " \"" + getSigla() + "\"";
	}
}
