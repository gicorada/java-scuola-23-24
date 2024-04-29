package inclasse.Grafica.CalcoloIMC_4IF_AlunnoA_AlunnoB.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltaBottoniEsterna implements ActionListener{
	private FrameImc f;

	public AscoltaBottoniEsterna(FrameImc f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Cancella")) {
            System.out.println(e.getActionCommand()+ " ASCOLTATORE su classe MEDESIMA");
            f.resetData();
        } else if(e.getActionCommand().equals("Esci")) {
            f.dispose();
        }
	}
}
