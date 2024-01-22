import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AscoltatoreEsterno implements ActionListener {
    private Contatore c;
    private JLabel lblCont;
    private JTextField txtCont;
    private JCheckBox cbInc;
    private JCheckBox cbDec;

    public AscoltatoreEsterno(Contatore c, JLabel lblCont, JTextField txtCont,
                              JCheckBox cbInc, JCheckBox cbDec) {
        this.c = c;
        this.lblCont = lblCont;
        this.txtCont = txtCont;
        this.cbInc = cbInc;
        this.cbDec = cbDec;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getActionCommand().equals("Go! da btnGo2")) {
            if(cbInc.isSelected() && !cbDec.isSelected()) c.incrementa();
            if(!cbInc.isSelected() && cbDec.isSelected()) c.decrementa();
            if(cbInc.isSelected() && cbDec.isSelected()) c.reset();
    
            lblCont.setText(c.toString());
            txtCont.setText(c.toString());
        }
    }
}