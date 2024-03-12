import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JTextField;

public class CasellaSlot extends JTextField{
        
    private boolean bloccata;
        
    /**
     * Costruttore della classe
     */
    public CasellaSlot(){
        bloccata = false;
        setFont(new Font("SANS-SERIF", Font.PLAIN, 40));
        setHorizontalAlignment(JTextField.CENTER);
        setEditable(false);
        setBackground(Color.YELLOW);
    }

    /**
     * Imposta il valore della casella al valore fornito
     * @param valore 
     */
    public void setValore(int valore){
        /* invoca il metodo della superclasse setText impostanto valore in formato stringa */
        super.setText(Integer.toString(valore));
    }

    /**
     * Imposta il valore della casella ad un valore casuale
     */
    public void setValoreCasuale(){
        /* imposta un valore casuale tra i primi 10 numeri naturali (0..9) */
        Random r = new Random();
        setValore(r.nextInt(10));
    }

    /**
     * Restituisce il valore attualmente presente nella casella
     * @return Valore della casella
     */
    public int getValore(){
        /* invoca il metodo della superclasse getText (che si presenta in formato String) e restituisce il corrispondente valore intero */ 
        return Integer.valueOf(getText());
    }

    /**
     * Ripristina la casella alla condizione iniziale (colori e testo)
     */
    public void resetCasella(){
        /* il contenuto della casella è una stringa vuota
           non è bloccata
           il colore di sfondo è GIALLO
           il colore del testo è NERO
        */
        setText("");
        setBackground(Color.YELLOW);
    }

    /**
     * Restituisce lo stato di blocco della casella
     * @return true se la casella è bloccata, false se non lo è
     */
    public boolean isBloccata(){
        return bloccata;
    }

    /**
     * Effettua alternativamente il cambio dello stato della casella,
     * e modifica i colori
     */
    public void bloccaSblocca(){
        /* imposta alternativamente nella casella lo stato di bloccata | Non Bloccata

            Se è bloccata appare su sfondo BLUE e testo BIANCO
            Se NON è bloccata appare su sfondo GIALLO e testo NERO
        */
        if(!bloccata) {
            setBackground(Color.BLUE);
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.YELLOW);
            setForeground(Color.BLACK);
        }

        bloccata = !bloccata;
    }
} 
