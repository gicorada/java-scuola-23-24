import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        this.setSize(larghezza, altezza);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container topContainer = this.getContentPane();

        JLabel lblNord = new JLabel("NORD");
        lblNord.setBackground(Color.ORANGE);
        lblNord.setOpaque(true);
        lblNord.setPreferredSize(new Dimension(150, 150));

        JLabel lblCentro = new JLabel("CENTRO");
        lblCentro.setBackground(Color.YELLOW);
        lblCentro.setOpaque(true);
        lblCentro.setPreferredSize(new Dimension(150, 150));

        JLabel lblOvest = new JLabel("OVEST");
        lblOvest.setBackground(Color.GREEN);
        lblOvest.setOpaque(true);
        lblOvest.setPreferredSize(new Dimension(150, 150));


        JButton btnEst = new JButton("EST");
        btnEst.setPreferredSize(new Dimension(150, 150));
        
        JButton btnSud = new JButton("SUD");
        btnSud.setPreferredSize(new Dimension(150, 150));

        JButton btnSud2 = new JButton("SUD 2");
        btnSud2.setPreferredSize(new Dimension(150, 150));


        JPanel pnlNord = new JPanel();
        pnlNord.add(lblNord);

        JPanel pnlCentro = new JPanel();
        pnlCentro.add(lblCentro);

        JPanel pnlOvest = new JPanel();
        pnlOvest.add(lblOvest);

        JPanel pnlEst = new JPanel();
        pnlEst.add(btnEst);


        JPanel sudL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sudL.add(btnSud);

        JPanel sudR = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sudR.add(btnSud2);

        JPanel pnlSud = new JPanel(new GridLayout(1, 2));
        pnlSud.add(sudL);
        pnlSud.add(sudR);


        topContainer.add(pnlNord, BorderLayout.NORTH);
        topContainer.add(pnlCentro, BorderLayout.CENTER);
        topContainer.add(pnlOvest, BorderLayout.WEST);
        topContainer.add(pnlEst, BorderLayout.EAST);
        topContainer.add(pnlSud, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}