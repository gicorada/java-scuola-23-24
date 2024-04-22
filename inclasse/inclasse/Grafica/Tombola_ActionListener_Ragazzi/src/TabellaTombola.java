import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TabellaTombola extends JFrame {

    private Casella[] tabellone;
    private JButton btnRipristina;

    public TabellaTombola() {
        super("Tabella Tombola");
        setSize(550, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponenti();
        initPannelli();
        initAscoltatori();

        setVisible(true);
        setResizable(false);
    }

    private void initComponenti(){
        tabellone = new Casella[90];
        for(int i=0;i<90;i++)
            tabellone[i] =  new Casella(i+1);
        btnRipristina = new JButton("RIPRISTINA");
      
    }
        
    private void initPannelli(){
        JPanel pnlTabellone = new JPanel(new GridLayout(9,10,5,5) );
        pnlTabellone.setBackground(Color.YELLOW);
        for(int i=0;i<90;i++)
            pnlTabellone.add(tabellone[i]);
        
        JPanel pnlSud = new JPanel();
        pnlSud.add(btnRipristina);
        this.getContentPane().add(pnlTabellone,BorderLayout.CENTER);
        this.getContentPane().add(pnlSud,BorderLayout.SOUTH);
        
    }

    private void initAscoltatori(){
        AscoltaBottoni_2 ascoltatore = new AscoltaBottoni_2();
        for(int i=0;i<90;i++){
            // tabellone[i].addActionListener(new AscoltBottoni_1(i));
            tabellone[i].addActionListener(ascoltatore);
        }
        btnRipristina.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                  for (Casella c:tabellone)
                                                      if (c.isEstratta())
                                                        c.reset();
                                            }
                                        });
        
        
        
    }


    private class AscoltBottoni_1 implements ActionListener {

        private int posButton;

        public AscoltBottoni_1(int pos) {
            posButton = pos;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            tabellone[posButton].depenna();
        }
    }

    private class AscoltaBottoni_2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ((Casella) e.getSource()).depenna();
            System.out.println("Su ascoltatore 2");
            
        }
    }

    
    

} /* FINE classe TabellaTombola */