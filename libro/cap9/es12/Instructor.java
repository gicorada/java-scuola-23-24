package libro.cap9.es12;

public class Instructor extends Person {
    private double salario;

    public Instructor(String nome, int nascita, double salario) {
        super(nome, nascita);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salario=" + salario;
    }
}
