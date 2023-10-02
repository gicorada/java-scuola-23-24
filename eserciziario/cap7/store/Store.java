package eserciziario.cap7.store;

import java.util.ArrayList;

public class Store {
	private ArrayList<Customer> customers;

	public Store() {
		customers = new ArrayList<Customer>();
	}

	public void addSale(String customerName, double amount) {
		Customer customer;
		for (Customer c : customers) {
			if (c.getName().equals(customerName)) {
				c.addSale(amount);
				return;
			}
		}

		customer = new Customer(customerName);
		customer.addSale(amount);
		
		customers.add(customer);
	}

	public String nameOfBestCustomer() {
		Customer bestCustomer = null;
		for (Customer c : customers) {
			if (bestCustomer == null || c.getTotal() > bestCustomer.getTotal()) {
				bestCustomer = c;
			}
		}

		if (bestCustomer != null) return bestCustomer.getName();
		else return null;
	}
}