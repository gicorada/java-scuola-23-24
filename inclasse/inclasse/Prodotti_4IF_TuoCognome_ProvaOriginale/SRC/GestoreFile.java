package inclasse.Prodotti_4IF_TuoCognome_ProvaOriginale.SRC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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

        try(Scanner s = new Scanner(new File(nomeFile))) {
            while (s.hasNextLine()) {
                String desc = s.next();
                double prezzo = s.nextDouble();
    
                String col3 = s.next();
                if(isNumeroIntero(col3)) {
                    int ggscadenza = Integer.parseInt(col3);
                    boolean daBanco = s.nextBoolean();
    
                    if(daBanco) listaProdotti.add(new ProdottoDaBanco(desc, prezzo, ggscadenza));
                    else listaProdotti.add(new ProdottoAlimentare(desc, prezzo, ggscadenza));
                } else {
                    s.nextBoolean();
                    listaProdotti.add(new ProdottoNonAlimentare(desc, prezzo, col3));
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("Impossibile accedere al file con i dati: " + e.getMessage());
        } catch(InputMismatchException e) {
            System.out.println("Errore nella lettura di un dato");
        }
    }
    
    public ArrayList<Prodotto> getListaProdotti(){
        return listaProdotti;
    }
    
    private boolean isNumeroIntero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }  
}
