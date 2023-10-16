/**
 * Classe che rappresenta un aeromobile astratto, identificabile con una sigla
 */
public abstract class Aeromobile implements Aeromodello {
	private String sigla;

	/**
	 * Costruttore
	 * @param sigla Nome dell'aeromobile
	 */
	public Aeromobile(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * Getter della sigla dell'aeromobile
	 * @return Nome dell'aeromobile
	 */
	public String getSigla() {
		return sigla;
	}

	@Override
	public String toString() {
		return getTipoAeromobile() + " \"" + getSigla() + "\"";
	}
}
