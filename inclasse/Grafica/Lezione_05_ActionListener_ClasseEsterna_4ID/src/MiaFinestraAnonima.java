/* Argomenti:
    1) La programamzione event driven (guidata dagli eventi)
    2) Concetto di Sorgente, evento e ascoltatore
    3) l'ascoltatore ActionListener implementato su classe esterna
    
    Fino ad ora ci siamo concentrati solo sull'aspetto grafico della finestra
    inserento componenti grafici che sono stati inseriti in contenitori in modo che si dispongano
    mantenento un certo layout.
    Un altro aspetto importante è l'interazione con l'utente
        e' possibile premere un bottone
        e' possibile selezionare una voce da una casella a discesa
        ecc...
    Dobbiamo quindi introdurr eil concetto di
        PROGRAMAMZIONE GUIDATA DAGLI EVENTI
            1) Sorgente (il componente che subisce l'interazione dell'utente)
            2) Evento  (rappresenta il tipo di interazione che sta avvenendo sul componente 
                        esempio evento click di un bottone)
                        Sarà un oggetto che incapsula tutte le informazioni relative all'evento che si 
                        è manifestato su quel particolare componente
            3) Ascoltatore (Un Oggetto che deve essere associato ad una sorgente,
                            e' specializzato nella gestione degli eventi generati da quella sorgente
                            Quando uno sorgente genera un evento, questo viene notificato all'ascoltatore 
                            che prende in carico la gestione dell'evento eseguendo il codice di un opportuno metodo 
                            associato a quell'evento)
        (Vedi immagine)


          
    

*/

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiaFinestraAnonima extends JFrame {
    private final int LARGHEZZA = 400;
    private final int ALTEZZA = 200;

    private JTextField txtCognome;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JButton btnAnnulla;
    private JButton btnConferma;
    
    public MiaFinestraAnonima(String titolo, int larghezza, int altezza){
        super(titolo);
        init(larghezza,altezza);
        initListener();
    }
    
    public MiaFinestraAnonima(String titolo){
        super(titolo);
        init(LARGHEZZA,ALTEZZA);
        initListener();
    } 
    
    private void initListener(){
        //ANONIMA (più utilizzata)
        btnConferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hai cliccato il pulsante CONFERMA. Sono l'ascoltatore della classe ANONIMA");
            }
        });
        btnAnnulla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hai cliccato il pulsante ANNULLA. Sono l'ascoltatore della classe ANONIMA");
            }
        });
    }
    
    private void init(int larghezza,int altezza){
        this.setSize(larghezza,altezza);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
 
        // Da qui parte la lezione 4 Layout Compisition
        
        // Contenitore delle etichette
        JPanel pnlLabel = new JPanel(new GridLayout(4,1));
        pnlLabel.add(new JLabel("Cognome: ",JLabel.RIGHT));
        pnlLabel.add(new JLabel("Nome: ",JLabel.RIGHT));
        pnlLabel.add(new JLabel("Email: ",JLabel.RIGHT));
        pnlLabel.add(new JLabel("Telefono: ",JLabel.RIGHT));
        // Contenitore delle caselle di testo
        // Le caselle di testo devono avere dei riferimenti perchè il loro contenuto potrebbe servirmi
        txtCognome = new JTextField(15); // Imposto solo la prima, tutte le altre saranno uguali 
        txtNome = new JTextField();
        txtEmail = new JTextField();
        txtTelefono = new JTextField();
        JPanel pnlTxt = new JPanel(new GridLayout(4,1));
        pnlTxt.add(txtCognome);
        pnlTxt.add(txtNome);
        pnlTxt.add(txtEmail);
        pnlTxt.add(txtTelefono);
        // Contenitore area CENTER
        JPanel pnlCentro_01 = new JPanel();
        pnlCentro_01.setLayout(new BoxLayout(pnlCentro_01,BoxLayout.X_AXIS));
        pnlCentro_01.add(pnlLabel);
        pnlCentro_01.add(pnlTxt);
        JPanel pnlCentro_02 = new JPanel(); // FlowLayout di default
        pnlCentro_02.add(pnlCentro_01);

        //Contenitore area SOUTH
        btnAnnulla = new JButton("Annulla");
        btnConferma = new JButton("Conferma");
        btnConferma.setActionCommand("esegui_conferma");
       
        JPanel pnlSud = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlSud.add(btnAnnulla);
        pnlSud.add(btnConferma);

        // Mettiamo il tutto sul content pane
        this.getContentPane().add(pnlCentro_02,BorderLayout.CENTER); 
        this.getContentPane().add(pnlSud,BorderLayout.SOUTH); 
        this.pack();
        this.setVisible(true);
    }
}
