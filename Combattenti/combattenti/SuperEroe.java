package combattenti;

/**
 * Classe che rappresenta un Supereroe, che può trasformarsi
 * @author radaelli11353
 */
public class SuperEroe extends Eroe{
    private boolean superPotere;
    
    /**
     * Costruttore
     * Istanzia automaticamente il superpotere a falso
     * @param nome Nome del supereroe
     */
    public SuperEroe(String nome) {
        super(nome);
        superPotere = false;
    }
    
    @Override
    public void trasformati() {
        superPotere = !superPotere;
    }
    
    @Override
    public void attacca(Combattente other) {
        if(isVivo()) {
            if(!(other instanceof SuperEroe)) {
                if(!superPotere) super.attacca(other);
                else other.addStress(100);
            } else {
                System.out.println("Non puoi attaccare un altro supereroe");
            }
        }
    }

    @Override
    public void difenditi() {
        if(isVivo()) if(!superPotere) super.difenditi();
    }

    @Override
    public String toString() {
        return super.toString() + " - superpotere " + (superPotere ? "attivato" : "disattivato");
    }
}
