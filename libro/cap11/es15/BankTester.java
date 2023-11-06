package libro.cap11.es15;

public class BankTester {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            // Lancia un'eccezione
            BankAccount account2 = new BankAccount(-1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.deposit(500);
            // Lancia un'eccezione
            account.withdraw(2000);
            System.out.println("Saldo: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Lancia un'eccezione
            account.deposit(-500);
            account.withdraw(2000);
            System.out.println("Saldo: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.deposit(500);
            // Lancia un'eccezione
            account.withdraw(-2000);
            System.out.println("Saldo: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
