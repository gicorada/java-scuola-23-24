package eserciziario.cap7.store;

public class Customer {
    private String name;
    private double total;

    public Customer(String name) {
        this.name = name;
        this.total = 0;
    }

    public void addSale(double amount) {
        total += amount;
    }

    public String getName() {
        return name;
    }

    public double getTotal() {
        return total;
    }
}