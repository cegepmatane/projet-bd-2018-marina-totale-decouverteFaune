package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class PositionDAO {

    private static PositionDAO instance = null;

    public static PositionDAO getInstance() {

        if (null == instance) {
            instance = new PositionDAO();
        }

        return instance;
    }

    public float lirePositionsEtreVivant(int idEtreVivant) {
        String url = "http://158.69.113.110/serveurDecouverteFaune/src/vote/liste/index.php?idEtreVivant="+idEtreVivant;
        String moyenne;
        String derniereBalise = "</positions>";
        String xml;

        HttpGetRequete getRequete = new HttpGetRequete();
        //postRequete.execute(arguments);

        try {
            xml = getRequete.execute(url,String.valueOf(idEtreVivant)).get();
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = parseur.parse(new StringBufferInputStream(xml));
            Element noeudVote = (Element) document.getElementsByTagName("vote");
            moyenne = noeudVote.getElementsByTagName("moyenne").item(0).getTextContent();
            return Float.parseFloat(moyenne);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
