package libro.cap14.es4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VotiMappa {
    public static void main(String[] args) {
        Map<String, String> voti = new TreeMap<>();

        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Inserisci la scelta stampa/inserisci/rimuovi/modifica/stop: ");
            String scelta = in.next();
            if(scelta.equals("stop")) {
                break;
            }
            switch (scelta) {
                case "stampa":
                    for (String nome : voti.keySet()) {
                        System.out.println(nome + ": " + voti.get(nome));
                    }
                    break;
                case "rimuovi": {
                    System.out.print("Inserisci il nome dello studente da rimuovere: ");
                    String nome = in.next();
                    if(!voti.containsKey(nome)) {
                        System.out.println("Studente non trovato");
                        break;
                    }
                    voti.remove(nome);
                    break;
                }
                case "inserisci": {
                    System.out.print("Inserisci il nome dello studente da inserire: ");
                    String nome = in.next();
                    System.out.print("Inserisci il voto di " + nome + ": ");
                    String voto = in.next();
                    voti.put(nome, voto);
                    break;
                }
                case "modifica": {
                    System.out.print("Inserisci il nome dello studente da modificare: ");
                    String nome = in.next();
                    if(!voti.containsKey(nome)) {
                        System.out.println("Studente non trovato");
                        break;
                    }
                    System.out.print("Inserisci il nuovo voto di " + nome + ": ");
                    String voto = in.next();
                    voti.put(nome, voto);
                    break;
                }
                default:
                    System.out.println("Scelta non valida");
            }
        } while (true);
    }
}
