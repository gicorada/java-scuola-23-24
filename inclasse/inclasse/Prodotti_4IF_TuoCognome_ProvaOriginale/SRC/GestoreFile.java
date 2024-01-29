package inclasse.Prodotti_4IF_TuoCognome_ProvaOriginale.SRC;

import java.util.ArrayList;

/* COGNOME e NOME:
   CLASSE:
   DATA:
*/
/* QUESTA CLASSE DEVE ESSERE COMPLETATA SOLO NELLE PARTI IN CUI APPARE LA STRINGA "CANCELLAMI E COMPLETA"
   LE PARTI GIA' SCRITTE NON POSSONO ESSERE MODIFICATE!!
   I COMMENTI CONTRASSEGNATI DA "NOTA" SONO INDICAZIONI O INTEGRAZIONI DI CONSEGNA
*/

/*
 * NOTA: La seguente classe ha il compito di leggere un file di testo strutturato 
 * a colonne come segue:
 * 
 * COLONNA 1        COLONNA 2   COLONNA 3                   COLONNA 4
 * DESCRIZIONE      PREZZO      GGSCADENZA/INGOMBRO         DA BANCO
 * (String)         (double)    (int / String)              (boolean)       
 * -------------------------------------------------------------------
 * Burro            10,0            20                      TRUE
 * Latte            10,0            3                       FALSE
 * Detersivo        10,0            MEDIO                   FALSE
 * Pasta            10,0            9                       FALSE
 * 
 * Crea una ArrayList di Prodotti (ALIMENTARI (ANCHE DA BAMCO) e NON ALIMENTARI) che potrà essere restituito. 
 * 
 */
public class GestoreFile {

    private ArrayList<Prodotto> listaProdotti;

    public GestoreFile(String nomeFile){
        /* NOTA: Il costruttore accetta il nome di un file di testo contenente prodotti da supermercato.
           Se il file NON ESISTE CATTURA l'eccezione 
           Se ESISTE lo "visita" per ottenere le informazioni necessarie per istanziare e aggiunge 
           i vari prodotti nell'ArrayList listaProdotti 
        */
        listaProdotti = new ArrayList<>(); 
        
        /* CANCELLAMI E COMPLETA */
        
    }
    
    public ArrayList<Prodotto> getListaProdotti(){
        return listaProdotti;
    }
    
    private boolean isNumeroIntero(String str) {
        try {
            Integer.parseInt(str);
            /* CANCELLAMI E COMPLETA */
        } catch (/* CANCELLAMI E COMPLETA */) {
            /* CANCELLAMI E COMPLETA */
        }
    }  
}
