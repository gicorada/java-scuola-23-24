package inclasse.Combattenti.combattenti;

/**
 * Classe che rappresenta un generico combattente
 * @author radaelli11353
 */
public abstract class Combattente {
    private String nome;
    private int stress;

    /**
     * Costruttore
     * @param nome Nome del combattente
     */
    public Combattente(String nome) {
        this.nome = nome;
        stress = 0;
    }

    /**
     * Restituisce il livello di stress accumulato dal combattente
     * Lo stress può andare da 0 a 100, oltre questa soglia il combattente è morto
     * @return Stress accumulato
     */
    public int getStress() {
        return stress;
    }

    /**
     * Restituisce il nome del combattente, assegnato in precedenza
     * @return Nome del combattente
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Indicazione dello stato del combattente
     * @return True se stress minore di 100, false se stress maggiore
     */
    public boolean isVivo() {
        return stress < 100;
    }
    
    /**
     * Metodo per permettere alle sottoclassi di aggiungere diverse quantità di stress
     * @param stress Stress da aggiungere
     */
    public void addStress(int stress) {
        if(isVivo()) this.stress += stress;
    }
    
    /**
     * Metodo che permette di attaccare un altro combattente
     * @param other Altro combattente
     */
    public void attacca(Combattente other) {
        if(isVivo()) {
            this.stress += 5;
            other.difenditi();
        }
    }
    
    /**
     * Metodo che permette di difendersi dall'attacco di un altro combattente
     * Viene automaticamente richiamato quando si viene attaccati
     */
    public void difenditi() {
        if(isVivo()) this.stress += 10;
    }
    
    /**
     * Metodo che riporta lo stress a zero, utilizzabile dopo il combattimento
     */
    public void riposa() {
        stress = 0;
    }

    @Override
    public String toString() {
        return "(" + getClass().getSimpleName() + ") Nome: " + getNome() + " - stress accumulato: " + getStress();
    }
    
    /**
     * Metodo che permette la trasformazione del combattente tra diversi stati
     */
    public abstract void trasformati();
}
