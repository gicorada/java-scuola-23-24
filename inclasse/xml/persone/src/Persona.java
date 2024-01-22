public class Persona {
    private String nome;
    private String cognome;
    private char sesso;
    private int eta;
    private boolean over65;

    public Persona(String nome, String cognome, char sesso, int eta) {
        if(!nome.isEmpty()) this.nome = nome;
        else this.nome = "Unknown";
        
        if(!cognome.isEmpty()) this.cognome = cognome;
        else this.cognome = "Unknown";
        
        this.sesso = sesso;
        this.eta = eta;
        this.over65 = (eta >= 65);
    }

    @Override
    public String toString() {
        return "Persona{" + "nome=" + nome + ", cognome=" + cognome +
                ", sesso="+ sesso + ", eta=" + eta + (over65 ? " (over 65)" : "") +'}';
    }
}
