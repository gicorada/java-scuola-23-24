package inclasse.complessita;

public class Persona implements Comparable<Persona> {
	private String nome;
	private String cognome;
	private int eta;

	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	@Override
	public int compareTo(Persona p) {
		if(p == null) throw new IllegalArgumentException();
		if(eta > p.eta) return 1;
		else if(eta < p.eta) return -1;
		else return nome.compareTo(p.nome);
	}

	public boolean equals(Object o) {
		if(o == null) throw new IllegalArgumentException();
		if(o.getClass() == this.getClass()) return false;
		Persona p = (Persona) o;
		return (nome.equals(p.nome) && cognome.equals(p.cognome) && eta == p.eta);
	}
}
