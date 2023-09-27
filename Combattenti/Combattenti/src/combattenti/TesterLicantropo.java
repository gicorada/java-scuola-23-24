package combattenti;

import java.util.ArrayList;

/**
 * Tester per la classe Licantropo
 * @author radaelli11353
 */
public class TesterLicantropo {
    public static void main(String[] args) {
        ArrayList<Combattente> testLicantropo = new ArrayList<>();
        Licantropo tester = new Licantropo("tester", "testerLupo", false);
        
        testLicantropo.add(new Licantropo("Jacob", "Bestia", false));
        testLicantropo.add(new Eroe("Mario Bros"));
        testLicantropo.add(new SuperEroe("Superman"));
        
        
        while(testLicantropo.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 1 " + testLicantropo.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testLicantropo.get(0).riposa();
        testLicantropo.get(0).trasformati();
        
        while(testLicantropo.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 2 " + testLicantropo.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testLicantropo.get(0).riposa();
        testLicantropo.get(0).trasformati();
        
        // Eroe
        
        while(testLicantropo.get(1).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(1));
        }
        if(tester.isVivo()) System.out.println("Il combattente 3 " + testLicantropo.get(2) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        testLicantropo.get(1).riposa();
        
        // Supereroe
        
        while(testLicantropo.get(2).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(2));
        }
        if(tester.isVivo()) System.out.println("Il combattente 4 " + testLicantropo.get(2) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testLicantropo.get(2).riposa();
        testLicantropo.get(2).trasformati();
        
        while(testLicantropo.get(2).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(2));
        }
        if(tester.isVivo()) System.out.println("Il combattente 5 " + testLicantropo.get(2) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testLicantropo.get(2).riposa();
        testLicantropo.get(2).trasformati();
        
        /*
        
         -------- Lupo --------
        
        */
        tester.trasformati();
        System.out.println("\n\n");
        
        
        while(testLicantropo.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 1 " + testLicantropo.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testLicantropo.get(0).riposa();
        testLicantropo.get(0).trasformati();
        
        while(testLicantropo.get(0).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(0));
        }
        if(tester.isVivo()) System.out.println("Il combattente 2 " + testLicantropo.get(0) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testLicantropo.get(0).riposa();
        testLicantropo.get(0).trasformati();
        
        // Eroe
        
        while(testLicantropo.get(1).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(1));
        }
        if(tester.isVivo()) System.out.println("Il combattente 3 " + testLicantropo.get(2) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        testLicantropo.get(1).riposa();
        
        // Supereroe
        
        while(testLicantropo.get(2).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(2));
        }
        if(tester.isVivo()) System.out.println("Il combattente 4 " + testLicantropo.get(2) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testLicantropo.get(2).riposa();
        testLicantropo.get(2).trasformati();
        
        while(testLicantropo.get(2).isVivo() && tester.isVivo()) {
            tester.attacca(testLicantropo.get(2));
        }
        if(tester.isVivo()) System.out.println("Il combattente 5 " + testLicantropo.get(2) + " è morto");
        else System.out.println("Il tester " + tester + " è morto, l'avversario è ancora vivo");
        
        tester.riposa();
        
        testLicantropo.get(2).riposa();
        testLicantropo.get(2).trasformati();
    }
}
