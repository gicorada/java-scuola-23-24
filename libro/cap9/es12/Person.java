package libro.cap9.es12;

public class Person implements Cloneable {
    private String nome;
    private int nascita;

    public Person(String nome, int nascita) {
        this.nome = nome;
        this.nascita = nascita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return nome.equals(person.nome) && nascita == person.nascita;
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
    public String toString() {
        return "Nome=" + nome + ", Anno di nascita=" + nascita;
    }
}
