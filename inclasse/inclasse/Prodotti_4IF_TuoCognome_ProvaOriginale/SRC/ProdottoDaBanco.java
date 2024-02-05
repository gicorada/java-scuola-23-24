package inclasse.Prodotti_4IF_TuoCognome_ProvaOriginale.SRC;

/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* DI QUESTA CLASSE CONOSCI SOLO IL NOME! 
   DEVI COMPLETARLA SULLA BASE DEL DIAGRAMMA UML FORNITO*/
public class ProdottoDaBanco extends ProdottoAlimentare {
   private boolean scontatoScadenzaImminente;

   public ProdottoDaBanco(String descrizione, double prezzo, int giorniAllaScadenza) {
      super(descrizione, prezzo, giorniAllaScadenza);
      scontatoScadenzaImminente = false;
   }

   public boolean scadenzaImminente() {
      return getGiorniAllaScadenza() <= 5 && getGiorniAllaScadenza() > 0;
   }

   @Override
   public void applicaSconto(int percentuale) throws ScontoNonApplicabileException {
      if(scaduto()) {
         setPrezzo(0);
         throw new ScontoNonApplicabileException("Il prodotto " + getDescrizione() + " non può essere scontato perché INVENDIBILE (SCADUTO)");
      }
      if(!inScadenza()) throw new ScontoNonApplicabileException("Il prodotto " + getDescrizione() + " non può essere scontato perché NON E' ANCORA IN SCADENZA");

      if(!giaScontato()) {
         setPrezzo(getPrezzo() - getPrezzo() * percentuale / 100);
         setScontato(true);
      }
      
      if(!scontatoScadenzaImminente && scadenzaImminente()) {
         setPrezzo(getPrezzo() - getPrezzo() * 0.5);
         setScontato(true);
         scontatoScadenzaImminente = true;
      }
      
      throw new ScontoNonApplicabileException("Il prodotto " + getDescrizione() + " è già stato scontato");
   }
}
