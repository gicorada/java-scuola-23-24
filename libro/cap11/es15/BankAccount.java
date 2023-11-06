package libro.cap11.es15;

public class BankAccount {
    private double balance;

    public BankAccount(double balance) throws IllegalArgumentException {
        if(balance < 0) throw new IllegalArgumentException("Il saldo iniziale non può essere negativo");
        this.balance = balance;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if(amount < 0) throw new IllegalArgumentException("L'importo del versamento non può essere negativo");
        balance += amount;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if(amount < 0) throw new IllegalArgumentException("L'importo del prelievo non può essere negativo");
        if(amount > balance) throw new IllegalArgumentException("Saldo insufficiente");
        balance -= amount;
    }

    public double getBalance() { return balance; }
}
