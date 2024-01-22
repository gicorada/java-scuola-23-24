import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiaFinestra extends JFrame {
    private final int LARGHEZZA = 400;
    private final int ALTEZZA = 300;

    public MiaFinestra(String titolo, int larghezza, int altezza) {
        super(titolo);
        init(larghezza, altezza);
    }

    public MiaFinestra(String titolo) {
        super(titolo);
        init(LARGHEZZA, ALTEZZA);
    }


    private void init(int larghezza, int altezza) {
        setSize(larghezza, altezza);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container topContainer = this.getContentPane();

        JPanel pnlMain = new JPanel(new GridLayout(3, 2));

        JButton bottoni[] = new JButton[3];
        JTextField caselle[] = new JTextField[3];
        
        for (int i = 0; i < 3; i++) {
            bottoni[i] = new JButton("Bottone " + i);
            caselle[i] = new JTextField("Casella " + i);
        }

        for (int i = 0; i < caselle.length; i++) {
            pnlMain.add(bottoni[i]);
            pnlMain.add(caselle[i]);
        }

        bottoni[0].setPreferredSize(new Dimension(100, 100));

        topContainer.add(pnlMain);
        pack();

        setVisible(true);
    }
}