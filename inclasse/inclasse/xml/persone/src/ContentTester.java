import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class ContentTester {
    public static void main(String[] args) {
        PersonaReader gestore;
        
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            gestore = new PersonaReader();
            
            saxParser.parse(new File("./src/persone.xml"), gestore);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
