package inclasse.aerei;

/**
 * Classe che rappresenta un aeromobile astratto, identificabile con una sigla
 */
public abstract class Aeromobile implements Aeromodello, Cloneable, Comparable<Aeromobile> {
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

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj.getClass() != getClass())) return false;
		Aeromobile a = (Aeromobile) obj;
		
		return sigla.equals(a.sigla);
	}

	@Override
	public int hashCode() {
		return sigla.hashCode();
	}
}
