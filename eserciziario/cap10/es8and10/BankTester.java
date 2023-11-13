package eserciziario.cap10.es8and10;

public class BankTester {
    public static void main(String[] args) {
        BankAccount[] cc = {new BankAccount(1000), new BankAccount(2000), new BankAccount(3000), new BankAccount(100), new BankAccount(200), new BankAccount(300)};

        double a = Data.average(cc, new Measurer() {
            public double measure(Object anObject) {
                return ((BankAccount) anObject).getBalance();
            }
        }, new Filter() {
            public boolean accept(Object x) {
                return ((BankAccount) x).getBalance() >= 1000;
            }
        });

        System.out.printf("La media è: %.2f\n", a);
    }
}
