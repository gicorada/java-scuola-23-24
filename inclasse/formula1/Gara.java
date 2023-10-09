package inclasse.formula1;

import java.util.ArrayList;

public class Gara {
    private String nomeGara;
    private boolean inCorso;
    private ArrayList<Pilota> piloti;

    public Gara(String nome) {
        nomeGara = nome;
		inCorso = false;
        piloti = new ArrayList<>();
    }

	/**
	 * Metodo per aggiungere un signolo pilota alla gara
	 * @param p Pilota da inserire
	 */
    public void aggiungiPilota(Pilota p) {
        piloti.add(p);
    }

	/**
	 * Metodo per aggiungere una lista di piloti alla gara
	 * @param nomi Array contenente i nomi dei piloti
	 * @param scuderie Array contenente le scuderie a cui appartengono i rispettivi piloti
	 * @param punti Array contenente i punti dei rispettivi piloti
	 */
    public void grigliaDiPartenza(String[] nomi, String[] scuderie, int[] punti) {
        for(int i = 0; i < nomi.length; i++) {
            aggiungiPilota(new Pilota(nomi[i], scuderie[i], punti[i]));
        }
    }

	/**
	 * Metodo che restituisce una stringa formattata contenente la classifica
	 * @return Stringa contenente la classifica
	 */
    public String classifica() {
        String cl = "";

        for (int i = 0; i < piloti.size(); i++) {
            cl += (i+1) + "° " + piloti.get(i) + "\n"; 
        }

        return cl;
    }

	/**
	 * Metodo che fa partire la gara
	 */
    public void start() {
        inCorso = true;
    }

	/**
	 * Metodo privato che restituisce la posizione corrente del pilota di cui è fornito il nome
	 * @param nomeP Nome del pilota da ricercare
	 * @return Posizione del pilota
	 */
    private int posCorrente(String nomeP) {
        for (int i = 0; i < piloti.size(); i++) {
            if(piloti.get(i).getNome().equals(nomeP)) return i;
        }

        return -1;
    }

	/**
	 * Metodo per mandare fuori gara un pilota
	 * @param n Nome del pilota da espellere
	 */
    public void fuoriGara(String n) {
		int pos = posCorrente(n);
        if(pos >= 0) piloti.remove(posCorrente(n));
    }

	/**
	 * Metodo per far effettuare un sorpasso ad un pilota
	 * @param n Nome del pilota da far avanzare
	 */
    public void effettuaSorpasso(String n) {
        int pos = posCorrente(n);
        if(pos > 0) {
            piloti.add(pos - 1, piloti.get(pos));
            piloti.remove(pos + 1);
        }
    }

	/**
	 * Metodo per far fermare al pit stop un pilota
	 * @param n Nome del pilota da far fermare al pit stop
	 */
    public void pitStop(String n) {
        int pos = posCorrente(n);
        if(pos <= piloti.size() - 4) {
            piloti.add(pos + 3, piloti.get(pos));
        } else {
            piloti.add(piloti.get(pos));
        }

        piloti.remove(pos);
    }

    public String stop() {
        inCorso = false;
        
        String cl = "";

        cl += "VINCITORE: " + vincitore() + "\n";
        cl += "ULTIMO: " + piloti.get(piloti.size() - 1) + "\n";
        cl += classifica();

        return cl;
    }

    public Pilota vincitore() {
        if(!inCorso) return piloti.get(0);
        return null;
    }
}
