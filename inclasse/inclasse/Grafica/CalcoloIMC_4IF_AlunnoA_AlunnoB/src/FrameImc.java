package inclasse.Grafica.CalcoloIMC_4IF_AlunnoA_AlunnoB.src;

/* NOME E COGNOME
   CLASSE
   DATA
*/

/* NOTA: Prendi visione di come e' stata implementata questa classe che "specializza" un JFrame e completa */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FrameImc extends JFrame implements ActionListener {
    
    private LabelImc lblImc; /* NON MODIFICARE */
    /* Inserisci qui le altre varibili di esemplare che ritieni necessarie */
    private JPanel pnlNord;
    private JPanel pnlCenter;
    private JPanel pnlSud;

    private JTextField txtPeso;

    private JLabel lblAltezza;
    private JTextField txtAltezza;

    private JPanel pnlRadioAltezza;
    private JRadioButton rbCentimetri;
    private JRadioButton rbMetri;

    private JButton btnAbilita;
    private JButton btnCalcola;
    private JButton btnCancella;
    private JButton btnEsci;
    
    public FrameImc(){
        super("Calcolo dell' Indice di Massa Corporea (IMC)");
        setSize(300,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponenti();
        initPannelli();
        initAscoltatori();
        pack(); /* Minimizza le dimensioni del JFrame garantendo una buone visibilità a tutte le componenti */
        setVisible(true);
        
    } /* ---- FINE costruttore ---- */
    
    
    private void initComponenti(){
        /* Istanzia tutte le componenti necessarie cercando di mantenere una 
           sequenza logica e chiara. Scrivi dei commenti esplicativi se necessario !
        */

        // PANNELLO GIALLO
        // Textfield peso
        txtPeso = new JTextField("0");
        txtPeso.setHorizontalAlignment(JTextField.RIGHT);

        // Radio Button
        pnlRadioAltezza = new JPanel();
        pnlRadioAltezza.setBackground(Color.YELLOW);

        rbCentimetri = new JRadioButton("In centimetri");
        rbCentimetri.setBackground(Color.YELLOW);
        rbMetri = new JRadioButton("In metri");
        rbMetri.setBackground(Color.YELLOW);

        ButtonGroup rbGroupAltezza = new ButtonGroup();
        rbGroupAltezza.add(rbCentimetri);
        rbGroupAltezza.add(rbMetri);
        rbCentimetri.setSelected(true);

        pnlRadioAltezza.add(rbCentimetri);
        pnlRadioAltezza.add(rbMetri);

        // Label altezza
        lblAltezza = new JLabel("Altezza (cm)");

        // TextField altezza
        txtAltezza = new JTextField("0");
        txtAltezza.setHorizontalAlignment(JTextField.RIGHT);



        // PANNELLO CENTRO
        btnAbilita = new JButton("Abilita");

        btnCalcola = new JButton("Calcola");
        btnCalcola.setEnabled(false);

        btnCancella = new JButton("Cancella");
        btnCancella.setEnabled(false);
        btnCancella.setActionCommand("TO RESET");

        btnEsci = new JButton("Esci");



        // PANNELLO ARANCIONE
        lblImc = new LabelImc(0);
    } /* ---- FINE initComponenti() ---- */

    
    private void initPannelli(){
        /* Istanzia tutti i pannelli necessari cercando di mantenere una 
           sequenza logica e chiara. Scrivi dei commenti esplicativi se necessario !
        */
        /* 1) Pannello NORD (QUELLO di colore GIALLO) */
        pnlNord = new JPanel(new GridLayout(3, 2));
        pnlNord.setBackground(Color.YELLOW);
        
        // Label Peso
        pnlNord.add(new JLabel("Peso (KG)"));
        // Textfield Peso
        pnlNord.add(txtPeso);
        // Label unità misura
        pnlNord.add(new JLabel("Unità di misura dell'altezza"));
        // Radio button
        pnlNord.add(pnlRadioAltezza);
        // Label altezza
        pnlNord.add(lblAltezza);
        // TextField altezza
        pnlNord.add(txtAltezza);


        
        /* 2) Pannello CENTRO (QUELLO di colore VERDE) */
        pnlCenter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlCenter.setBackground(Color.GREEN);

        pnlCenter.add(btnAbilita);
        pnlCenter.add(btnCalcola);
        pnlCenter.add(btnCancella);
        pnlCenter.add(btnEsci);


        
        /* 3) Pannello SUD (QUELLO di colore ARANCIONE) */
        pnlSud = new JPanel();
        pnlSud.setBackground(Color.ORANGE);

        pnlSud.add(lblImc);


        
        /* 4) Il ContentPane del JFrame */
        Container contentPane = this.getContentPane();

        contentPane.add(pnlNord, BorderLayout.NORTH);
        contentPane.add(pnlCenter, BorderLayout.CENTER);
        contentPane.add(pnlSud, BorderLayout.SOUTH);

    } /* ---- FINE initPannelli() ---- */
    
    
    private void initAscoltatori(){
        /* Associa qui gli ascoltatori alle relative sorgenti riuspettando le consegne descritte nel PDF
           Scrivi dei commenti esplicativi se necessario !
        */

        rbCentimetri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAltezza.setText("Altezza (cm)");
                txtAltezza.setText("0");
            }
        });

        rbMetri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAltezza.setText("Altezza (m)");
                txtAltezza.setText("0");
            }
        });

        /*
        btnEsci.addActionListener(this);
        btnCancella.addActionListener(this);
        */

        btnAbilita.addActionListener(new AscoltaBottoniInterna());
        btnCalcola.addActionListener(new AscoltaBottoniInterna());
        btnCancella.addActionListener(new AscoltaBottoniInterna());


        btnEsci.addActionListener(new AscoltaBottoniEsterna(this));
        btnCancella.addActionListener(new AscoltaBottoniEsterna(this));
        
    } /* ---- FINE initAscoltatori() ---- */


    public void resetData() {
        txtAltezza.setText("0");
        txtPeso.setText("0");
        rbCentimetri.setSelected(true);
        lblAltezza.setText("Altezza (cm)");
        lblImc.setValoreIMC(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        if(e.getActionCommand().equals("Cancella")) {
            System.out.println(e.getActionCommand()+ " ASCOLTATORE su classe MEDESIMA");
            resetData();
        } else if(e.getActionCommand().equals("Esci")) {
            dispose();
        }*/
    }
    

    public class AscoltaBottoniInterna implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(btnCalcola)) {
                double peso = Double.parseDouble(txtPeso.getText());
                double altezza = rbMetri.isSelected() ? Double.parseDouble(txtAltezza.getText()) : Double.parseDouble(txtAltezza.getText())/100;
                lblImc.setValoreIMC(peso/(altezza*altezza));
            } else if(e.getSource().equals(btnCancella)) {
                System.out.println(e.getActionCommand()+ " ASCOLTATORE su classe INTERNA");
                resetData();
            } else if(e.getSource().equals(btnAbilita)) {
                boolean state = !btnCalcola.isEnabled();
                btnCalcola.setEnabled(state);
                btnCancella.setEnabled(state);
            }
        }
    }

    
} /* ---- FINE classe FrameImc ---- */
