package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
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
        listePositions = new ArrayList<>();
        listePositions.clear();

        String url = URL_LISTER_POSITIONS+"?idEtreVivant="+idEtreVivant;
        String moyenne;
        String derniereBalise = "</positions>";
        String xml;

        HttpGetRequete getRequete = new HttpGetRequete();
        //postRequete.execute(arguments);

        try {
            xml = getRequete.execute(url, derniereBalise).get();
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(new StringBufferInputStream(xml));
            NodeList listeNoeudPositions = document.getElementsByTagName("position");

            for (int pos= 0; pos < listeNoeudPositions.getLength(); pos++){
                Position position = new Position();

                Element noeudPosition = (Element) listeNoeudPositions.item(pos);

                String id = noeudPosition.getElementsByTagName("id").item(0).getTextContent();
                position.setId(Integer.valueOf(id));
                String longitude = noeudPosition.getElementsByTagName("longitude").item(0).getTextContent();
                //position.setLongitude(Double.valueOf(longitude));
                String latitude = noeudPosition.getElementsByTagName("latitude").item(0).getTextContent();
                LatLng longlat = new LatLng(Double.valueOf(longitude),Double.valueOf(latitude));
                position.setLongitudeLatitude(longlat);
                //position.setLatitude(Double.valueOf(longitude));
                position.setIdEtreVivant(idEtreVivant);
                System.out.println("POSITIONS : ");
                System.out.println(position.getLongitudeLatitude());
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
