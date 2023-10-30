package inclasse.Combattenti.combattenti;

/**
 * Classe che rappresenta un eroe, che può attaccare solo licantropi
 * @author radaelli11353
 */
public class Eroe extends Combattente {

    /**
     * Costruttore
     * @param nome Nome dell'eroe
     */
    public Eroe(String nome) {
        super(nome);
    }

    @Override
    public void trasformati() {}
    
    @Override
    public void attacca(Combattente other) {
        if(isVivo()) {
            if(other instanceof Licantropo) {
                addStress(15);
                other.difenditi();
            } else {
                System.out.println("Puoi attaccare solo licantropi");
            }
            
        }
    }
    
}
