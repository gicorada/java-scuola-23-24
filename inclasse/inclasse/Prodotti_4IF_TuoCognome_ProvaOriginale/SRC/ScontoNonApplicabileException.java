package inclasse.Prodotti_4IF_TuoCognome_ProvaOriginale.SRC;

/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* DI QUESTA CLASSE CONOSCI SOLO IL NOME! 
   DEVI COMPLETARLA SAPENDO CHE POTRA' ISTANZIARE UNA ECCEZIONE PERSONALIZZATA CHE GIUSTIFICA IL MOTIVO PER CUI 
   NON SARA' POSSIBILE APPLICARE LO SCONTO SU UN PRODOTTO SCONTABILE
*/
public class ScontoNonApplicabileException extends IllegalArgumentException {
   public ScontoNonApplicabileException(String msg) {
      super(msg);
   }
}
