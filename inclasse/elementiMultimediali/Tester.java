package inclasse.elementiMultimediali;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		ArrayList<ElementoMultimediale> multimediali = new ArrayList<>();

		//Utilizzo questi per testare, il codice per l'inserimento dall'utente è sotto commentato
		multimediali.add(new Immagine("Immagine, numero 1"));
		multimediali.add(new Audio("Audio, numero 2", 7));
		multimediali.add(new Filmato("Filmato, numero 3", 2));
		multimediali.add(new Audio("Audio secondo, numero 4", 3));
		multimediali.add(new Immagine("Immagine seconda, numero 5"));
		
		Scanner in = new Scanner(System.in);

		/*
		do {
			System.out.println("Inserisci il tipo di elemento (i, a, f): ");
			char tipo = in.next().charAt(0);
			switch(tipo) {
				case 'i':
					System.out.print("Inserisci il titolo dell'immagine (senza spazi): ");
					multimediali.add(new Immagine(in.next()));
					break;
				case 'a':
					System.out.print("Inserisci il titolo dell'audio: ");
					String titoloA = in.next();
					System.out.print("Inserisci la durata dell'audio: ");
					multimediali.add(new Audio(titoloA, in.nextInt()));
					break;
				case 'f':
					System.out.print("Inserisci il titolo del filmato: ");
					String titoloF = in.next();
					System.out.print("Inserisci la durata del filmato: ");
					multimediali.add(new Audio(titoloF, in.nextInt()));
			}
		} while(multimediali.size() < 5);
		*/


		while(true) {
			System.out.print("Inserisci il numero dell'elemento multimediale da visualizzare (0 per uscire): ");
			int n = in.nextInt();

			if(n==0) break;
			if(n-- > multimediali.size()) {
				System.out.println("NUMERO NON VALIDO: Il numero deve essere contenuto tra 1 e " + multimediali.size());
				continue;
			}

			multimediali.get(n).esegui();

			boolean i = multimediali.get(n) instanceof Illuminabile;
			boolean r = multimediali.get(n) instanceof Riproducibile;

			while(true) {
				System.out.println("Vuoi cambiare qualche parametro? " + (i ? "l -> luminosita', " : "") + (r ? "v -> volume, " : "") + "qualsiasi altro carattere per uscire");

				char param = in.next().charAt(0);

				switch(param) {
					case 'l':
						if(!(multimediali.get(n) instanceof Illuminabile)) {
							System.out.println("Non puoi cambiare la luminosita' ad un oggetto che non implementa la classe Illuminabile");
							continue;
						}
						System.out.println("Vuoi aumentare o diminuire la luminosita'? + o -");
						char lum = in.next().charAt(0);
						if(lum == '+') { ((Illuminabile)multimediali.get(n)).brighter(); }
						else if(lum == '-') { ((Illuminabile)multimediali.get(n)).darker(); }
						continue;
					case 'v':
						if(!(multimediali.get(n) instanceof Riproducibile)) {
							System.out.println("Non puoi cambiare il volume ad un oggetto che non implementa la classe Riproducibile");
							continue;
						}
						System.out.println("Vuoi aumentare o diminuire il volume? + o -");
						char vol = in.next().charAt(0);
						if(vol == '+') { ((Riproducibile)multimediali.get(n)).louder(); }
						else if(vol == '-') { ((Riproducibile)multimediali.get(n)).weaker(); }
						continue;
				}

				break;
			}
		}
	}
}
