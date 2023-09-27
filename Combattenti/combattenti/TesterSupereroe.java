package combattenti;

import java.util.ArrayList;

/**
 * Tester per la classe SuperEroe
 * @author radaelli11353
 */
public class TesterSupereroe {
    public static void main(String[] args) {
        ArrayList<Combattente> testSupereroe = new ArrayList<>();
        SuperEroe tester = new SuperEroe("Superman");
        
        testSupereroe.add(new Licantropo("Jacob", "Bestia", false));
        testSupereroe.add(new Eroe("Mario Bros"));
        testSupereroe.add(new SuperEroe("Superman"));
        
        
        while(testSupereroe.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testSupereroe.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 1 " + testSupereroe.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testSupereroe.get(0).riposa();
        testSupereroe.get(0).trasformati();
        
        while(testSupereroe.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testSupereroe.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 2 " + testSupereroe.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testSupereroe.get(0).riposa();
        testSupereroe.get(0).trasformati();
        
        // Eroe
        
        tester.attacca(testSupereroe.get(1));
        System.out.println("^^ Dovrebbe stampare la stringa: \"Puoi attaccare solo licantropi\"");
        
        tester.riposa();
        
        // Supereroe
        
        tester.attacca(testSupereroe.get(2));
        System.out.println("^^ Dovrebbe stampare la stringa: \"Non puoi attaccare un altro supereroe\"");
        
        tester.riposa();
        
        testSupereroe.get(2).riposa();
        testSupereroe.get(2).trasformati();
        
        tester.attacca(testSupereroe.get(2));
        System.out.println("^^ Dovrebbe stampare la stringa: \"Non puoi attaccare un altro supereroe\"");
        
        testSupereroe.get(2).riposa();
        testSupereroe.get(2).trasformati();
        
        /*
        
         -------- Potere attivato --------
        
        */
        tester.trasformati();
        System.out.println("\n\n");
        
        
        while(testSupereroe.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testSupereroe.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 1 " + testSupereroe.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testSupereroe.get(0).riposa();
        testSupereroe.get(0).trasformati();
        
        while(testSupereroe.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testSupereroe.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 2 " + testSupereroe.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testSupereroe.get(0).riposa();
        testSupereroe.get(0).trasformati();
        
        // Eroe
        
        while(testSupereroe.get(1).isVivo() && tester.isVivo()) {
            tester.attacca(testSupereroe.get(1));
        }
        if(tester.isVivo()) System.out.println("Il combattente 3 " + testSupereroe.get(2) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        testSupereroe.get(1).riposa();
        
        // Supereroe
        
        tester.attacca(testSupereroe.get(2));
        System.out.println("^^ Dovrebbe stampare la stringa: \"Non puoi attaccare un altro supereroe\"");
        
        tester.riposa();
        
        testSupereroe.get(2).riposa();
        testSupereroe.get(2).trasformati();
        
        tester.attacca(testSupereroe.get(2));
        System.out.println("^^ Dovrebbe stampare la stringa: \"Non puoi attaccare un altro supereroe\"");
        
        tester.riposa();
        
        testSupereroe.get(2).riposa();
        testSupereroe.get(2).trasformati();
    }
}
