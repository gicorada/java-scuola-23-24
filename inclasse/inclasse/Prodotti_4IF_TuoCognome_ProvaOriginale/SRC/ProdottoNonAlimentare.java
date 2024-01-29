package inclasse.Prodotti_4IF_TuoCognome_ProvaOriginale.SRC;

/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* DI QUESTA CLASSE CONOSCI SOLO IL NOME! 
   DEVI COMPLETARLA SULLA BASE DEL DIAGRAMMA UML FORNITO*/
public class ProdottoNonAlimentare extends Prodotto {
   private String ingombro;

   public ProdottoNonAlimentare(String descrizione, double prezzo, String ingombro) {
      super(descrizione, prezzo);
      this.ingombro = ingombro;
   }
   

   @Override
   public String toString() {
      return super.toString() + "\n\tIngombro: " + ingombro;
   }
}
