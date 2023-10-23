package libro.cap9.es12;

public class Instructor extends Person {
    private double salario;

    public Instructor(String nome, int nascita, double salario) {
        super(nome, nascita);
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if(super.equals(o)) return true;
        Instructor s = (Instructor) o;
        return salario == s.salario;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + ", Salario=" + salario;
    }
}
