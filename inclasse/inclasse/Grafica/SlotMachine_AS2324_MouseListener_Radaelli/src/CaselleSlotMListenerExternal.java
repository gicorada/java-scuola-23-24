import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class CaselleSlotMListenerExternal implements MouseListener {
    private SlotMachine frameSlot;

    public CaselleSlotMListenerExternal(SlotMachine f) {
        frameSlot = f;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3) {
            if(frameSlot.lblCoin.getValore() > 0) {
                ((CasellaSlot) e.getSource()).bloccaSblocca();
                frameSlot.lblCoin.decrementa();
                frameSlot.lblJackpot.incrementa();
            } else {
                frameSlot.btnGioca.setEnabled(false);
                frameSlot.btnGioca.setText("GAME OVER");
            } 
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
}
