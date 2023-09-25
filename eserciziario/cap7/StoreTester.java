package eserciziario.cap7;

import java.util.Scanner;

public class StoreTester {
    public static void main(String[] args) {
        Store store = new Store();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci il nome del cliente: ");
            String customerName = scanner.next();

            System.out.print("Inserisci l'importo della vendita (0 per uscire): ");
            double amount = scanner.nextDouble();
			if (amount == 0) {
                break;
            }

            store.addSale(customerName, amount);
        }

        String bestCustomer = store.nameOfBestCustomer();
        if (bestCustomer != null) {
            System.out.println("Miglior cliente: " + bestCustomer);
        } else {
            System.out.println("Nessuna vendita registrata");
        }
    }
}
