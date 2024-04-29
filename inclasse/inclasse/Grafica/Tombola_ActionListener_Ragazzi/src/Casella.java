
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Casella extends JButton{
    
    private boolean isEstratta;
    private Color bgOriginale;
    
    public Casella(int valore){
        
        super(String.valueOf(valore));
        
        bgOriginale = this.getBackground();
        isEstratta = false;
        
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
