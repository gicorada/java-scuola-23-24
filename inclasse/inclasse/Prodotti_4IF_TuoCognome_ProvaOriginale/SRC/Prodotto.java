package inclasse.Prodotti_4IF_TuoCognome_ProvaOriginale.SRC;

/* QUESTA CLASSE NON DEVE ESSERE MODIFICATA */
public class Prodotto {
    private String descrizione;
    private double prezzo;

    public Prodotto(String descrizione, double prezzo) {
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double nuovoPrezzo) {
        prezzo = nuovoPrezzo;
    }
    
    @Override
    public String toString() {
        return "Prodotto "+this.getClass().getSimpleName()+"\n\tDescrizione: " + descrizione + "\n\tPrezzo: " + prezzo + " euro";
    }  
}
