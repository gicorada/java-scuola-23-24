package inclasse.Prodotti_4IF_TuoCognome_ProvaOriginale.SRC;

/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* DI QUESTA CLASSE CONOSCI SOLO IL NOME! 
   DEVI COMPLETARLA SULLA BASE DEL DIAGRAMMA UML FORNITO*/
public class ProdottoAlimentare extends Prodotto implements Scontabile {
   private int giorniAllaScadenza;
   private boolean scontato;

   public ProdottoAlimentare(String descrizione, double prezzo, int giorniAllaScadenza) {
      super(descrizione, prezzo);
      this.giorniAllaScadenza = giorniAllaScadenza;
      scontato = false;
   }

   public int getGiorniAllaScadenza() {
      return giorniAllaScadenza;
   }
   
   public boolean giaScontato() {
      return scontato;
   }
   public void setScontato(boolean s) {
      scontato = s;
   }

   public double getPrezzo() {
      if(scaduto()) setPrezzo(0);
      return super.getPrezzo();
   }
   
   @Override
   public void applicaSconto(int percentuale) throws ScontoNonApplicabileException {
      if(scaduto()) throw new ScontoNonApplicabileException("Il prodotto " + getDescrizione() + " non può essere scontato perché INVENDIBILE (SCADUTO)");
      if(!inScadenza()) throw new ScontoNonApplicabileException("Il prodotto " + getDescrizione() + " non può essere scontato perché NON E' ANCORA IN SCADENZA");
      if(scontato == true) throw new ScontoNonApplicabileException("Il prodotto è già stato scontato");
      setPrezzo(getPrezzo() - getPrezzo() * percentuale / 100);
      scontato = true;
   }
   
   @Override
   public boolean inScadenza() {
      return giorniAllaScadenza <= 10 && giorniAllaScadenza > 0;
   }
   
   @Override
   public boolean scaduto() {
      return giorniAllaScadenza <= 0;
   }   


   @Override
   public String toString() {
      return super.toString() + "\n\tGiorni alla scadenza: " + giorniAllaScadenza;
   }
}
