package inclasse.Prodotti_4IF_TuoCognome_ProvaOriginale.SRC;

import java.util.ArrayList;

/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* QUESTA CLASSE DEVE ESSERE COMPLETATA NELLE PARTI IN CUI APPARE LA STRINGA "CANCELLAMI E COMPLETA"
   LE PARTI GIA' SCRITTE NON POSSONO ESSERE MODIFICATE!! */

public class ProdottiTester {
    public static void main(String[] args){
        ArrayList <Prodotto> prodottiInVendita = new ArrayList<>();
        GestoreFile gestore = new GestoreFile(".\\inclasse\\inclasse\\Prodotti_4IF_TuoCognome_ProvaOriginale\\prodotti.txt");
        prodottiInVendita = gestore.getListaProdotti();
        for (Prodotto p:prodottiInVendita){
            try {
                ((ProdottoAlimentare) p).applicaSconto(10);
            } catch(ScontoNonApplicabileException e) {
                System.out.println(e.getMessage());
            } catch(ClassCastException e) {
                System.out.println("Per il prodotto " + p.getDescrizione() + " NON E' PREVISTO LO SCONTO");
            }
            System.out.println(p + "\n");
        }
        
    }
}
