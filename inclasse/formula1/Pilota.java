package inclasse.formula1;

public class Pilota {
    private String nome;
    private String scuderia;
    private int punti;

    public Pilota(String nome, String scuderia, int punti) {
        this.nome = nome;
        this.scuderia = scuderia;
        this.punti = punti;
    }

    public String getNome() {
        return nome;
    }

    public String getScuderia() {
        return scuderia;
    }

    public int getPunti() {
        return punti;
    }

    public void vittoria() {
        punti += 10;
    }

    @Override
    public String toString() {
        return nome + " (" + punti + ") " + scuderia;
    }
}
