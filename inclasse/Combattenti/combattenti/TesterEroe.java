package inclasse.Combattenti.combattenti;

import java.util.ArrayList;

/**
 * Tester per la classe Eroe
 * @author radaelli11353
 */
public class TesterEroe {
    public static void main(String[] args) {
        ArrayList<Combattente> testEroe = new ArrayList<>();
        Eroe tester = new Eroe("tester");
        
        testEroe.add(new Licantropo("Jacob", "Bestia", false));
        testEroe.add(new Eroe("Mario Bros"));
        testEroe.add(new SuperEroe("Superman"));
        
        
        while(testEroe.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testEroe.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 1 " + testEroe.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testEroe.get(0).riposa();
        testEroe.get(0).trasformati();
        
        while(testEroe.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testEroe.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 2 " + testEroe.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        // Eroe
        
        tester.attacca(testEroe.get(1));
        System.out.println("^^ Dovrebbe stampare la stringa: \"Puoi attaccare solo licantropi\"");
        
        tester.riposa();
        
        // Supereroe
        
        tester.attacca(testEroe.get(2));
        System.out.println("^^ Dovrebbe stampare la stringa: \"Puoi attaccare solo licantropi\"");
        
        tester.riposa();
        
        testEroe.get(2).riposa();
        testEroe.get(2).trasformati();
        
        tester.attacca(testEroe.get(2));
        System.out.println("^^ Dovrebbe stampare la stringa: \"Puoi attaccare solo licantropi\"");
    }
}
