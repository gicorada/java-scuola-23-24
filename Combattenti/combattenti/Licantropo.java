package combattenti;

/**
 * Classe che rappresenta un licantropo, che può trasformarsi in lupo
 * @author radaelli11353
 */
public class Licantropo extends Combattente {
    private final String nomeLupo;
    private boolean isLupo;

    /**
     * Costruttore
     * @param nome Nome del licantropo
     * @param nomeLupo Nome del licantropo quando è trasformato in lupo
     * @param lunaPiena Dato riguardante la luna piena, corrisponde allo stato iniziale del licantropo (true -> lupo)
     */
    public Licantropo(String nome, String nomeLupo, boolean lunaPiena) {
        super(nome);
        this.nomeLupo = nomeLupo;
        isLupo = lunaPiena;
    }
    
    @Override
    public String getNome() {
        return isLupo ? nomeLupo : super.getNome();
    }

    @Override
    public void trasformati() {
        isLupo = !isLupo;
    }
    
    @Override
    public void difenditi() {
        if(isLupo) addStress(5);
        else super.difenditi();
    }
}
