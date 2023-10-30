package inclasse.aerei;

public interface Aeromodello {
	/**
	 * Getter della tipologia di aeromobile
	 * @return Tipologia di aeromobile
	 */
	String getTipoAeromobile();

	/**
	 * Metodo che confronta la potenza di due aeromobili dello stesso tipo
	 * @param o Altro aeromobile
	 * @return True se l'aeromobile su cui viene invocato il metodo è più potente dell'altro, false altrimenti
	 * @throws IllegalArgumentException Viene lanciata se i due aeromobili non sono dello stesso tipo
	 */
	boolean piuPotenteDi(Aeromobile o) throws IllegalArgumentException;
}