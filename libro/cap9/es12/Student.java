package libro.cap9.es12;

public class Student extends Person {
    private String disciplina;

    public Student(String nome, int nascita, String disciplina) {
        super(nome, nascita);
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return super.toString() + ", Disciplina=" + disciplina;
    }
}
