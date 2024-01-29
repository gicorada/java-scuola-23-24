import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersonaReader extends DefaultHandler {
    private String prev;
    private String nome, cognome;
    private char sesso;
    private int eta;
    
    private ArrayList<Persona> persone;

    @Override
    public void startDocument() throws SAXException {
        persone = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("persona")) {
            eta = Integer.parseInt(attributes.getValue("eta"));
            sesso = attributes.getValue("sesso").charAt(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        prev = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "nome":
                nome = prev.trim();
                break;
            case "cognome":
                cognome = prev.trim();
                break;
            case "persona":
                persone.add(new Persona(nome, cognome, sesso, eta));
                resetInternalData();
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        for(Persona p : persone) {
            System.out.println(p);
        }
    }
    
    private void resetInternalData() {
        nome = "";
        cognome = "";
        sesso = ' ';
        eta = -1;
    }
}
