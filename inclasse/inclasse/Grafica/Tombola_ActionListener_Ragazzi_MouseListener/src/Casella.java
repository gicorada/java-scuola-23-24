import java.awt.Color;
import javax.swing.JTextField;

public class Casella extends JTextField {
    private boolean isEstratta;
    private final Color bgOriginale;
    
    public Casella(int valore){
        super(String.valueOf(valore));
        setHorizontalAlignment(JTextField.CENTER);
        bgOriginale = this.getBackground();
        isEstratta = false;
        setEditable(false);
    }
    
    public void depenna(){
        isEstratta = true;
        this.setBackground(Color.RED);
    }
    
    public void reset(){
        isEstratta = false;
        this.setBackground(bgOriginale);
    }
    
    public boolean isEstratta(){
        return isEstratta;
    }
}
