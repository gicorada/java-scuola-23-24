import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SlotMachine extends JFrame{

    private final CasellaSlot[] txtCaselleSlot;
    private JButton btnCoin,btnRipristina;
    protected JButton btnGioca;
    private JCheckBox cbConferma;
    private JComboBox<String> comboCoin;
    protected MyLabel lblJackpot, lblCoin;
    private final int numCaselleSlot;
    
    public SlotMachine(int numCaselle) {
        super("SlotMachine a Linea Singola ("+numCaselle+")");
        this.setSize(750, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        numCaselleSlot = numCaselle;
        txtCaselleSlot = new CasellaSlot[numCaselleSlot];

        initComponenti();
        initPannelli();
        initAscoltatori();
        
        pack();
        setVisible(true);
        btnRipristina.doClick();
    }
    
    private void initComponenti(){
        lblJackpot = new MyLabel("Jackpot", 100);
        
        for (int i = 0; i < numCaselleSlot; i++) {
            txtCaselleSlot[i] = new CasellaSlot();
        }
        
        btnCoin = new JButton("Insert Coin");
        
        comboCoin = new JComboBox<>();
        comboCoin.addItem("");
        comboCoin.addItem("Full");
        comboCoin.addItem("20 euro");
        comboCoin.addItem("10 euro");
        comboCoin.addItem("5 euro");
        
        lblCoin = new MyLabel("", 0);
        
        cbConferma = new JCheckBox("Conferma Giocata");
        
        btnGioca = new JButton("GAME OVER");
        btnGioca.setEnabled(false);
        
        btnRipristina = new JButton("Ripristina");
    } /*----------------  FINE initComponenti ----------------- */
    
    private void initPannelli(){
        /* INIT PANNELLO NORD (pnlNord): ETICHETTA JACKPOT */
        JPanel pnlNord = new JPanel();
        pnlNord.add(lblJackpot);
        
        /* INIT PANNELLO CENTRO (pnlCentro): LA LINEA DELLE CASELLE SLOT 
          Se volete creare un padding tra il pannello e 
          il bordo del frame, scrivete la seguente riga di istruzione:
          pnlCentro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        */
        JPanel pnlCentro = new JPanel(new GridLayout(1, numCaselleSlot));
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        pnlCentro.setBackground(Color.GRAY);
        for (CasellaSlot c : txtCaselleSlot) {
            pnlCentro.add(c);
        }
       
        /* INIT PANNELLO SUD (pnlSud): COMPOSTO DA 2 SOTTOPANNELLI 
            pnlSudUP è un GridLayout (2,3) Vedi DEMO
            pnlSudDown è un FlowLayout con allineamento a destra Vedi DEMO
        */
        JPanel pnlSud = new JPanel(new GridLayout(2, 1));
        
        JPanel pnlSudUp = new JPanel(new GridLayout(2, 3));
        JPanel pnlSudDown = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        pnlSudUp.add(btnCoin);
        pnlSudUp.add(comboCoin);
        pnlSudUp.add(new JPanel());
        pnlSudUp.add(lblCoin);
        pnlSudUp.add(cbConferma);
        pnlSudUp.add(new JPanel());
        
        pnlSudDown.add(btnGioca);
        pnlSudDown.add(btnRipristina);
        
        pnlSud.add(pnlSudUp);
        pnlSud.add(pnlSudDown);
        
        /* INIT CONTENT PANE */

        Container main = getContentPane();
        main.add(pnlNord, BorderLayout.NORTH);
        main.add(pnlCentro, BorderLayout.CENTER);
        main.add(pnlSud, BorderLayout.SOUTH);
        
         
    }/*----------------  FINE initPannelli ----------------- */

    
    private void initAscoltatori(){
        
        /* ASCOLTATORE 1:
            Su btnCoin deve essere associato un ascoltatore ActionListener su classe ANONIMA
            l'Ascoltatore risponde come da DEMO del file JAR
        */
        btnCoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblCoin.incrementa();
            }
        });
        
        /* ASCOLTATORE 2:
            Su ComboCoin deve essere associato un ascoltatore ActionListener su classe ANONIMA
            l'Ascoltatore risponde come da DEMO del file JAR
        */
        comboCoin.addActionListener(new ActionListener() {
            private void setMax() {
                lblCoin.setValore(50);
                
                comboCoin.setEnabled(false);
                btnCoin.setEnabled(false);
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Object sel = comboCoin.getSelectedItem();
                
                int distTo50 = 50 - lblCoin.getValore();
                
                switch (sel.toString()) {
                    case "Full":
                        setMax();
                        break;
                    case "20 euro":
                        if(distTo50 <= 20) setMax();
                        else lblCoin.setValore(lblCoin.getValore() + 20);
                        break;
                    case "10 euro":
                        if(distTo50 <= 10) setMax();
                        else lblCoin.setValore(lblCoin.getValore() + 10);
                        break;
                    case "5 euro":
                        if(distTo50 <= 5) setMax();
                        else lblCoin.setValore(lblCoin.getValore() + 5);
                        break;
                    default:
                        break;
                }
            }
        });
        
        /* ASCOLTATORE 3:
            Su cbConferma, btnGioca e btnRipristina deve essere associato un unico ascoltatore ActionListener su classe INTERNA
            Tale ascoltatore sarà in grado di risalire alla sorgente 
            che ha generato l'evento per mezzo del metodo getActionCommand()
            l'Ascoltatore risponde come da DEMO del file JAR
        */
        ActionListener giocaAL = new GiocaActionListener();
        
        cbConferma.addActionListener(giocaAL);
        btnGioca.addActionListener(giocaAL);
        btnRipristina.addActionListener(giocaAL);
        
        /* ASCOLTATORE 4 :
            Sull'array delle caselle Slot devi associate un ascoltatore che estende MouseAdapter su classe INTERNA
            L'evento da intercettare è: "il mouse entra in una casella slot ... "
            l'Ascoltatore risponde come da DEMO del file JAR
        */
        MouseAdapter caselleMA = new CaselleMouseAdapter();
        
        for(CasellaSlot c : txtCaselleSlot) {
            c.addMouseListener(caselleMA);
        }

        /* ASCOLTATORE 5 (alternativo al numero 4):
            Sull'array delle caselle Slot devi associate un ascoltatore che implementa MouseListener su classe INTERNA
            L'evento da intercettare è: "è stato cliccato il bottone destro nel mouse in una casella slot ... "
            l'Ascoltatore risponde come da DEMO del file JAR
        */
        //Commentato per evitare azione doppia
        /*
        MouseListener caselleML = new CaselleSlotMListenerExternal(this);
        
        for(CasellaSlot c : txtCaselleSlot) {
            c.addMouseListener(caselleML);
        }*/
    }/*----------------  FINE initAscoltatori ----------------- */

    
    /**
     * Metodo che estrae i numeri nelle caselle non bloccate
     */
    private void extract() {
        for(CasellaSlot c : txtCaselleSlot) {
            if(c.isBloccata()) {
                c.bloccaSblocca();
            } else {
                c.setValoreCasuale();
            }
        }
    }
    
    /** 
     * Metodo che verifica se il contenuto delle caselle ha generato una
     * sequenza particolare che equivale ad un jackpot
     * @return 1 se uguale, 2 se palindroma, 3 se crescente consecutiva,
     *          0 se non jackpot
     */
    private int checkIfJackpot() {
        int[] val = new int[numCaselleSlot];
        
        for (int i = 0; i < numCaselleSlot; i++) {
            val[i] = txtCaselleSlot[i].getValore();
        }
        
        boolean isJackpot = true;
        
        // Sequenza uguale
        for(int i = 1; i < numCaselleSlot && isJackpot; i++) {
            if(val[i] != val[i-1]) isJackpot = false;
        }
        if(isJackpot) return 1;
        
        // Sequenza palindroma
        isJackpot = true;
        for(int i = 0; i < numCaselleSlot/2; i++) {
            if(val[i] != val[numCaselleSlot-1-i]) isJackpot = false;
        }
        if(isJackpot) return 2;
        
        // Sequenza crescente consecutiva
        isJackpot = true;
        for(int i = 1; i < numCaselleSlot && isJackpot; i++) {
            if(val[i] != val[i-1]+1) isJackpot = false;
        }
        if(isJackpot) return 3;
        
        return 0;
    }
    
    /**
     * MouseAdapter dedicato al clic destro su una casella slot
     */
    private class CaselleMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON3) {
                if(lblCoin.getValore() > 0) {
                    ((CasellaSlot) e.getSource()).bloccaSblocca();
                    lblCoin.decrementa();
                    lblJackpot.incrementa();
                } else {
                    btnGioca.setEnabled(false);
                    btnGioca.setText("GAME OVER");
                } 
            }
        }
    }
    
    /**
     * Ascoltatore per i bottoni che riguardano gioca, ripristina e conferma
     */
    private class GiocaActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            if(src.equals(cbConferma)) {
                cbConferma.setEnabled(false);
                btnCoin.setEnabled(false);
                btnGioca.setEnabled(true);
                
                btnGioca.setText("Gioca");
            } else if(src.equals(btnGioca)) {
                if(lblCoin.getValore() > 0) {
                    lblCoin.decrementa();
                    lblJackpot.incrementa();
                    extract();
                    
                    switch (checkIfJackpot()) {
                        case 1:
                            btnGioca.setEnabled(false);
                            btnGioca.setText("JACKPOT per sequenza UGUALE");
                            break;
                        case 2:
                            btnGioca.setEnabled(false);
                            btnGioca.setText("JACKPOT per sequenza PALINDROMA");
                            break;
                        case 3:
                            btnGioca.setEnabled(false);
                            btnGioca.setText("JACKPOT per sequenza CRESCENTE");
                            break;
                        default:
                            break;
                    }
                } else {
                    btnGioca.setEnabled(false);
                    btnGioca.setText("GAME OVER");
                }
            } else if (src.equals(btnRipristina)) {
                lblCoin.setValore(0);
                lblJackpot.setValore(100);

                for(CasellaSlot c : txtCaselleSlot) {
                    c.resetCasella();
                }
                
                comboCoin.setEnabled(true);
                btnCoin.setEnabled(true);
                cbConferma.setEnabled(true);
                cbConferma.setSelected(false);
                btnGioca.setEnabled(false);
            }
        }
    }
} /* ------------- FINE CLASSE SLOTMACHINE -----------------------*/