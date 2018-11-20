package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import ca.qc.cgmatane.informatique.marinaconnect.modele.Position;

public class PositionDAO implements PositionsURL{

    private static PositionDAO instance = null;
    List<Position> listePositions;

    public static PositionDAO getInstance() {

        if (null == instance) {
            instance = new PositionDAO();
        }

        return instance;
    }

    public List<Position> lirePositionsEtreVivant(int idEtreVivant) {
        String url = URL_LISTER_POSITIONS+idEtreVivant;
        String moyenne;
        String derniereBalise = "</positions>";
        String xml;

        HttpGetRequete getRequete = new HttpGetRequete();
        //postRequete.execute(arguments);

        try {
            xml = getRequete.execute(url,String.valueOf(idEtreVivant)).get();
            Position position = new Position();
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(new StringBufferInputStream(xml));
            String racine = document.getDocumentElement().getNodeName();
            NodeList listeNoeudEtreVivant = document.getElementsByTagName("etreVivant");

            for (int pos= 0; pos < listeNoeudEtreVivant.getLength(); pos++){
                Element noeudVote = (Element) document.getElementsByTagName("vote");
                String id = noeudVote.getElementsByTagName("id").item(0).getTextContent();
                position.setId(Integer.valueOf(id));
                String longitude = noeudVote.getElementsByTagName("longitude").item(0).getTextContent();
                position.setLongitude(Double.valueOf(longitude));
                String latitude = noeudVote.getElementsByTagName("latitude").item(0).getTextContent();
                position.setLatitude(Double.valueOf(longitude));
                position.setIdEtreVivant(idEtreVivant);
                listePositions.add(position);
            }
            return listePositions ;

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
        return null;
    }
}
