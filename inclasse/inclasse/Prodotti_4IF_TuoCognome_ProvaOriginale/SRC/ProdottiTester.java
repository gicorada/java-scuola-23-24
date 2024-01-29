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
        GestoreFile gestore = new GestoreFile("prodotti.txt");
        prodottiInVendita = gestore.getListaProdotti();
        for (Prodotto p:prodottiInVendita){
            /*CANCELLAMI E COMPLETA*/
        }
        
    }
}
