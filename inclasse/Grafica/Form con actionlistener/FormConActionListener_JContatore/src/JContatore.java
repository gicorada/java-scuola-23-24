
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author radaelli11353
 */
public class JContatore extends JTextField {
    private int n;
    private JLabel lblCont;
    private JTextField txtCont;
    
    public JContatore() {
        n = 0;
    }
    
    public void incrementa() {
        n++;
        setText(n);
    }
    
    public void decrementa() {
        n--;
        setText(n);
    }
    
    public void reset() {
        n = 0;
        setText(n);
    }
    
    
    public void setText(int val) {
        setText(String.valueOf(n));
    }
    
    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
