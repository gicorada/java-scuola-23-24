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
      if(!inScadenza()) throw new ScontoNonApplicabileException("Il prodotto " + getDescrizione() + " non può essere scontato perché NON E' ANCORA IN SCADENZA");
      if(scaduto()) throw new ScontoNonApplicabileException("Il prodotto " + getDescrizione() + " non può essere scontato perché INVENDIBILE (SCADUTO)");
      
      if(giaScontato() && !scontatoScadenzaImminente) {
         setPrezzo(getPrezzo() - getPrezzo() * 0.5);
         setScontato(true);
         scontatoScadenzaImminente = true;
         return;
      }

      if(!giaScontato() && scontatoScadenzaImminente) {
         setPrezzo(getPrezzo() - getPrezzo() * percentuale / 100);
         setScontato(true);
         scontatoScadenzaImminente = true;
         return;
      }
      
      if(!giaScontato() && !scontatoScadenzaImminente) {
         setPrezzo(getPrezzo() - getPrezzo() * percentuale / 100);
         setPrezzo(getPrezzo() - getPrezzo() * 0.5);
         setScontato(true);
         scontatoScadenzaImminente = true;
         return;
      }
      
      throw new ScontoNonApplicabileException("Il prodotto " + getDescrizione() + " è già stato scontato");
   }
}
