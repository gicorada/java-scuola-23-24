package libro.cap9.es12;

public class Student extends Person implements Cloneable {
    private String disciplina;

    public Student(String nome, int nascita, String disciplina) {
        super(nome, nascita);
        this.disciplina = disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if(super.equals(o)) return true;
        Student s = (Student) o;
        return disciplina.equals(s.disciplina);
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + ", Disciplina=" + disciplina;
    }
}
