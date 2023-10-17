package libro.cap9.es12;

public class Person {
    private String nome;
    private int nascita;

    public Person(String nome, int nascita) {
        this.nome = nome;
        this.nascita = nascita;
    }

    @Override
    public String toString() {
        return "Nome=" + nome + ", Anno di nascita=" + nascita;
    }
}
