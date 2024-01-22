import java.awt.Container;
import java.awt.GridLayout;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

        JPanel pnlMain = new JPanel(new GridLayout(1, 2));


        JPanel pnlSX = new JPanel();
        JPanel pnlDX = new JPanel(new GridLayout(5, 1));

        Rectangle2D quadrato = new Rectangle2D.Double();
        
        JLabel lblBase = new JLabel("Base");
        JTextField txtBase = new JTextField();
        JPanel pnlBase = new JPanel();
        pnlBase.add(lblBase);
        pnlBase.add(txtBase);
        pnlDX.add(pnlBase);


        JLabel lblAltezza = new JLabel("Altezza");
        JTextField txtAltezza = new JTextField();
        JPanel pnlAltezza = new JPanel();
        pnlAltezza.add(lblAltezza);
        pnlAltezza.add(txtAltezza);
        pnlDX.add(pnlAltezza);


        JComboBox comboFigura = new JComboBox<>();
        JRadioButton rbnPerimetro = new JRadioButton("Perimetro");
        JRadioButton rbnArea = new JRadioButton("Area");
        JPanel pnlOpzioni = new JPanel();
        pnlOpzioni.add(comboFigura);
        pnlOpzioni.add(rbnPerimetro);
        pnlOpzioni.add(rbnArea);
        pnlDX.add(pnlOpzioni);


        JButton btnCalcola = new JButton("Calcola");
        JButton btnCancella = new JButton("Cancella");
        JPanel pnlComandi = new JPanel();
        pnlComandi.add(btnCalcola);
        pnlComandi.add(btnCancella);
        pnlDX.add(pnlComandi);

        
        JLabel lblRisultato = new JLabel("Perim/area");
        JTextField txtRisultato = new JTextField();
        JPanel pnlRisultati = new JPanel();
        pnlRisultati.add(lblRisultato);
        pnlRisultati.add(txtRisultato);
        pnlDX.add(pnlRisultati);


        pnlMain.add(pnlSX);
        pnlMain.add(pnlDX);
        topContainer.add(pnlMain);
        pack();

        setVisible(true);
    }
}