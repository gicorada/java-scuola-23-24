import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AscoltatoreEsterno implements ActionListener {
    private Finestra f;

    public AscoltatoreEsterno(Finestra f) {
        this.f = f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getActionCommand().equals("Go! da btnGo2")) {
            if(f.cbInc.isSelected() && !f.cbDec.isSelected()) f.txtCont.incrementa();
            if(!f.cbInc.isSelected() && f.cbDec.isSelected()) f.txtCont.decrementa();
            if(f.cbInc.isSelected() && f.cbDec.isSelected()) f.txtCont.reset();
    
            /*f.updateTextCounter();*/
        }
    }
}