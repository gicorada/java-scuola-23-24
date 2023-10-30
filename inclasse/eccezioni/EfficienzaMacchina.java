package inclasse.eccezioni;

import java.util.Scanner;

public class EfficienzaMacchina {
	public static void main(String[] args) {
		int distanza = 0;
		int litri = 0;
		boolean isOk = false;

		Scanner in = new Scanner(System.in);

		distanza = NumeriValidi.leggiInteroNonNegativo("Inserisci la DISTANZA in km: ");
		litri = NumeriValidi.leggiInteroPositivo("Inserisci i LITRI che hai consumato: ");

		try {
			int efficienza = distanza / litri;
			System.out.println("Per " + distanza + "km hai usato " + litri + "L");
			System.out.println("L'efficienza (IN INT) della tua automobile è " + efficienza + "km/L");
		} catch (ArithmeticException e) {
			System.out.println("Impossibile calcolare l'efficienza: i litri devono essere diversi da zero");
		}
	}
}
