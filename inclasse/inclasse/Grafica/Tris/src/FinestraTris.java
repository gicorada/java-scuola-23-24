package inclasse.Grafica.Tris.src;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author radaelli11353
 */
public class FinestraTris extends JFrame {
    private final int LARGHEZZA = 400;
    private final int ALTEZZA = 200;
    
    private JButton[][] bottoni;
    private JLabel[][] caselle;
    
    public FinestraTris(){
        super("Tris");
        init(LARGHEZZA, ALTEZZA);
        initListener();
    }
    
    private void initListener() {
        
    }
    
    private void init(int larghezza,int altezza) {
        this.setSize(larghezza,altezza);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        
        JPanel pMain = new JPanel();
        
        JPanel pnlSx = new JPanel(new GridLayout(3, 3));
        JPanel pnlDx = new JPanel(new GridLayout(3, 3));
        
        bottoni = new JButton[3][3];
        int nCelle = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                bottoni[i][j] = new JButton(String.valueOf(++nCelle));
                pnlSx.add(bottoni[i][j]);
            }
        }
        
        caselle = new JLabel[3][3];
        nCelle = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                caselle[i][j] = new JLabel(String.valueOf(++nCelle));
                pnlDx.add(caselle[i][j]);
            }
        }
        
        pMain.add(pnlSx);
        pMain.add(pnlDx);
        
        
        
        
        
        
        

        getContentPane().add(pMain, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }
    
}
