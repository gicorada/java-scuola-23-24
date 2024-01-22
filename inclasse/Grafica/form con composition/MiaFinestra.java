import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

        Container frmNuovoContatto = this.getContentPane();

        /* Creo i label per i testi indicatori della casella */
        JLabel lblCognome = new JLabel("Cognome:", JLabel.RIGHT);
        JLabel lblNome = new JLabel("Nome:", JLabel.RIGHT);
        JLabel lblEmail = new JLabel("Email:", JLabel.RIGHT);
        JLabel lblTelefono = new JLabel("Telefono:", JLabel.RIGHT);

        /* Aggiungo i testi al pannello */
        JPanel pnlLabel = new JPanel(new GridLayout(4, 1));
        pnlLabel.add(lblCognome);
        pnlLabel.add(lblNome);
        pnlLabel.add(lblEmail);
        pnlLabel.add(lblTelefono);



        /* Creo le caselle di testo */
        JTextField txtCognome = new JTextField(25);
        JTextField txtNome = new JTextField(25);
        JTextField txtEmail = new JTextField(25);
        JTextField txtTelefono = new JTextField(25);

        /* Aggiungo le caselle al pannello */
        JPanel pnlTxt = new JPanel(new GridLayout(4, 1));
        pnlTxt.add(txtCognome);
        pnlTxt.add(txtNome);
        pnlTxt.add(txtEmail);
        pnlTxt.add(txtTelefono);

        /* Aggiungo i pannelli per label e testi al pannello centrale */
        JPanel pnlCentro_02 = new JPanel();
        pnlCentro_02.add(pnlLabel);
        pnlCentro_02.add(pnlTxt);



        /* Creo i bottoni per annullare e confermare*/
        JButton btnAnnulla = new JButton("Annulla");
        JButton btnConferma = new JButton("Conferma");

        /* Creo il pannello sud e aggiungo i bottoni */
        JPanel pnlSud = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlSud.add(btnAnnulla);
        pnlSud.add(btnConferma);


        /* Aggiungo il pannello centrale e sud al pannello principale del frame */
        frmNuovoContatto.add(pnlCentro_02, BorderLayout.CENTER);
        frmNuovoContatto.add(pnlSud, BorderLayout.SOUTH);

        setVisible(true);
    }
}