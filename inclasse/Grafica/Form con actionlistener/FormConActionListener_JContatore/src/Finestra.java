import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Finestra extends JFrame {
    private final int LARGHEZZA = 400;
    private final int ALTEZZA = 200;
    
    // Label e TextField
    protected JLabel lblCont;
    protected JContatore txtCont;
    // RadioButton
    private JRadioButton rbInc;
    private JRadioButton rbDec;
    private JRadioButton rbRes;
    private ButtonGroup btnGroup;
    private JButton btnGo1;
    // Checkbox
    protected JCheckBox cbInc;
    protected JCheckBox cbDec;
    private JButton btnGo2;
    // ComboBox
    private JComboBox combo;
    private JButton btnGo3;
    // Button
    private JButton btnInc;
    private JButton btnDec;
    private JButton btnRes;
    private JButton btnEsci;
    
    private AscoltatoreInterno listener;
    
    
    public Finestra(){
        super("Contatore Estremo");
        init(LARGHEZZA, ALTEZZA);
        initListener();
    }
    
    private void initListener() {
        btnGo1.addActionListener(listener);
        btnGo2.addActionListener(new AscoltatoreEsterno(this));
        btnGo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(combo.getSelectedItem().equals("Incrementa")) txtCont.incrementa();
                else if(combo.getSelectedItem().equals("Decrementa")) txtCont.decrementa();
                else if(combo.getSelectedItem().equals("Reset")) txtCont.reset();
                
                /*updateTextCounter();*/
            }
        });
        
        btnInc.addActionListener(listener);
        btnDec.addActionListener(listener);
        btnRes.addActionListener(listener);
        
        btnEsci.addActionListener(listener);
    }
    
    private void init(int larghezza,int altezza) {
        this.setSize(larghezza,altezza);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        
        JPanel pMain = new JPanel(new GridLayout(6, 2));
        txtCont = new JContatore();
        listener = new AscoltatoreInterno();
        
        
        // Pannello giallo SX
        JPanel pnlGialloSx = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlGialloSx.setBackground(Color.YELLOW);
        pnlGialloSx.add(new JLabel("CONTEGGIO su JLabel"));
        
        // Pannello giallo DX
        JPanel pnlGialloDx = new JPanel();
        pnlGialloDx.setBackground(Color.YELLOW);
        lblCont = new JLabel(txtCont.toString());
        pnlGialloDx.add(lblCont);
        
        pMain.add(pnlGialloSx);
        pMain.add(pnlGialloDx);
        

        
        // Pannello Arancione SX
        JPanel pnlArancioSx = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlArancioSx.setBackground(Color.ORANGE);
        pnlArancioSx.add(new JLabel("CONTEGGIO su JTextField"));
        
        // Pannello Arancione DX
        JPanel pnlArancioDx = new JPanel();
        pnlArancioDx.setBackground(Color.ORANGE);
        txtCont = new JContatore();
        pnlArancioDx.add(txtCont);
        
        pMain.add(pnlArancioSx);
        pMain.add(pnlArancioDx);
        
        
        
        // Pannello verde SX
        JPanel pnlVerdeSx = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlVerdeSx.setBackground(Color.GREEN);
        rbInc = new JRadioButton("Incrementa", true);
        rbDec = new JRadioButton("Decrementa");
        rbRes = new JRadioButton("Reset");
        btnGroup = new ButtonGroup();
        btnGroup.add(rbInc);
        btnGroup.add(rbDec);
        btnGroup.add(rbRes);
        pnlVerdeSx.add(rbInc);
        pnlVerdeSx.add(rbDec);
        pnlVerdeSx.add(rbRes);
        
        // Pannello verde DX
        JPanel pnlVerdeDx = new JPanel();
        pnlVerdeDx.setBackground(Color.GREEN);
        btnGo1 = new JButton("Go!");
        btnGo1.setActionCommand("Go! da btnGo1");
        pnlVerdeDx.add(btnGo1);
        
        pMain.add(pnlVerdeSx);
        pMain.add(pnlVerdeDx);
        
        
        
        // Pannello blu SX
        JPanel pnlBluSx = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlBluSx.setBackground(Color.BLUE);
        cbInc = new JCheckBox("Incrementa");
        cbDec = new JCheckBox("Decrementa");
        pnlBluSx.add(cbInc);
        pnlBluSx.add(cbDec);
        
        // Pannello blu DX
        JPanel pnlBluDx = new JPanel();
        pnlBluDx.setBackground(Color.BLUE);
        btnGo2 = new JButton("Go!");
        btnGo2.setActionCommand("Go! da btnGo2");

        pnlBluDx.add(btnGo2);
        
        pMain.add(pnlBluSx);
        pMain.add(pnlBluDx);
        

        
        // Pannello rosso SX
        JPanel pnlRossoSx = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlRossoSx.setBackground(Color.RED);
        combo = new JComboBox(new String[]{"Incrementa", "Decrementa", "Reset"});
        pnlRossoSx.add(combo);
        
        // Pannello rosso DX
        JPanel pnlRossoDx = new JPanel();
        pnlRossoDx.setBackground(Color.RED);
        btnGo3 = new JButton("Go!");
        pnlRossoDx.add(btnGo3);
        
        pMain.add(pnlRossoSx);
        pMain.add(pnlRossoDx);
        
        
        
        // Pannello magenta SX
        JPanel pnlMagentaSx = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlMagentaSx.setBackground(Color.MAGENTA);
        btnInc = new JButton("Incrementa");
        btnDec = new JButton("Decrementa");
        btnRes = new JButton("Reset");
        pnlMagentaSx.add(btnInc);
        pnlMagentaSx.add(btnDec);
        pnlMagentaSx.add(btnRes);
        
        // Pannello magenta DX
        JPanel pnlMagentaDx = new JPanel();
        pnlMagentaDx.setBackground(Color.MAGENTA);
        btnEsci = new JButton("Chiudi il programma");
        pnlMagentaDx.add(btnEsci);
        
        pMain.add(pnlMagentaSx);
        pMain.add(pnlMagentaDx);
        
        

        getContentPane().add(pMain, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
    
    private String getRadioSelected() {
        if(rbInc.isSelected()) return "Incrementa";
        if(rbDec.isSelected()) return "Decrementa";
        if(rbRes.isSelected()) return "Reset";
        
        return "";
    }
    
    /*
    public void updateTextCounter() {
        lblCont.setText(c.toString());
        txtCont.setText(c.toString());
    }*/
    
    public class AscoltatoreInterno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (((JButton)e.getSource()).getActionCommand()) {
                case "Go! da btnGo1":
                    switch(getRadioSelected()) {
                        case "Incrementa":
                            txtCont.incrementa();
                            break;
                        case "Decrementa":
                            txtCont.decrementa();
                            break;
                        case "Reset":
                            txtCont.reset();
                            break;
                    }
                    break;
                case "Incrementa":
                    txtCont.incrementa();
                    break;
                case "Decrementa":
                    txtCont.decrementa();
                    break;
                case "Reset":
                    txtCont.reset();
                    break;
                    
                    
                case "Chiudi il programma":
                    dispose();
                    break;
                default:
                    break;
            }
            
            /*pdateTextCounter();*/
        }
    }
}
