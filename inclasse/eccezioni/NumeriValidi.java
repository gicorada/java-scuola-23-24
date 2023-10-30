package eccezioni;

import java.util.Scanner;

public class NumeriValidi {
	public static int leggiIntero(String msg) {
		Scanner in = new Scanner(System.in);
		boolean isOk = false;
		int n = 0;
		do {
			try {
				System.out.print(msg);
				n = Integer.parseInt(in.nextLine());
				isOk = true;
			} catch (NumberFormatException e) {
				System.out.println("Devi inserire un NUMERO INTERO senza altri caratteri!");
			}
		} while(!isOk);

		return n;
	}

	public static int leggiInteroNonNegativo(String msg) {
		boolean isOk = false;
		int n = -1;

		do {
			n = leggiIntero(msg);
			
			if(n < 0) {
				System.out.println("Devi inserire un numero NON NEGATIVO (>= 0)");
				continue;
			}
			isOk = true;
		} while (!isOk);

		return n;
	}

	public static int leggiInteroPositivo(String msg) {
		boolean isOk = false;
		int n = -1;

		do {
			n = leggiIntero(msg);
			
			if(n <= 0) {
				System.out.println("Devi inserire un numero POSITIVO (> 0)");
				continue;
			}
			isOk = true;
		} while (!isOk);

		return n;
	}
}
