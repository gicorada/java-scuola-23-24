
import java.util.Scanner;

/* Argomenti:
    1) Layout Manager
        BorderLayout, FlowLayout
    2) Le classi JPanel, JLabel, JButton
    3) Cenni alla progettazione della GUI (Graphic User Interface)

*/

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Inserisci un numero da 1 a 4 per avviare:");
        System.out.println("1. Interna");
        System.out.println("2. Esterna");
        System.out.println("3. Medesima");
        System.out.println("4. Anonima");
        
        do {
            int n = in.nextInt();
            
            if(n == 0) break;
            switch(n) {
                
            }
        } while(true);
        
        
        MiaFinestraInterna frmNuovoContattoI = new MiaFinestraInterna("I Nuovo Contatto");
        MiaFinestraEsterna frmNuovoContattoE = new MiaFinestraEsterna("E Nuovo Contatto");
        MiaFinestraMedesima frmNuovoContattoM = new MiaFinestraMedesima("M Nuovo Contatto");
        MiaFinestraAnonima frmNuovoContattoA = new MiaFinestraAnonima("A Nuovo Contatto");
        //f.setVisible(true);
        
    }
    
}
