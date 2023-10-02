import java.util.ArrayList;

public class Gara {
    private String nomeGara;
    private boolean inCorso;
    private ArrayList<Pilota> piloti;

    public Gara(String nome) {
        nomeGara = nome;
        piloti = new ArrayList<>();
    }

    public void aggiungiPilota(Pilota p) {
        piloti.add(p);
    }

    public void grigliaDiPartenza(String[] nomi, String[] scuderie, int[] punti) {
        for(int i = 0; i < nomi.length; i++) {
            aggiungiPilota(new Pilota(nomi[i], scuderie[i], punti[i]));
        }
    }

    public String classifica() {
        String cl = "";

        for (int i = 0; i < piloti.size(); i++) {
            cl += (i+1) + "° " + piloti.get(i) + "\n"; 
        }

        return cl;
    }

    public void start() {
        inCorso = true;
    }

    private int posCorrente(String nomeP) {
        for (int i = 0; i < piloti.size(); i++) {
            if(piloti.get(i).getNome().equals(nomeP)) return i;
        }

        return -1;
    }

    public void fuoriGara(String n) {
        piloti.remove(posCorrente(n));
    }

    public void effettuaSorpasso(String n) {
        int pos = posCorrente(n);
        if(pos > 0) {
            piloti.add(pos - 1, piloti.get(pos));
            piloti.remove(pos + 1);
        }
    }

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
