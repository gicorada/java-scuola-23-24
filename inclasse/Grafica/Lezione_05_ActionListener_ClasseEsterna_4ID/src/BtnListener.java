import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class BtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSorgente = (JButton) e.getSource();
        
        if(btnSorgente.getActionCommand().equals("esegui_conferma")) {
            System.out.println("Hai cliccato il pulsante CONFERMA. Sono l'ascoltatore della classe ESTERNA");
        } else {
            System.out.println("Hai cliccato il pulsante ANNULLA. Sono l'ascoltatore della classe ESTERNA");
        }
    }
}
