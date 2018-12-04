package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import ca.qc.cgmatane.informatique.marinaconnect.modele.Commentaire;

public class CommentaireDAO implements CommentaireURL {
    private static CommentaireDAO instance = null;
    protected CommentaireDAO commentaire;
    List<Commentaire> listePositions;


    public static CommentaireDAO getInstance() {
        if (null == instance)
            instance = new CommentaireDAO();
        return instance;
    }

    public void ajouteCommentaireSQL(Commentaire commentaire) {
        try {
            //String url = "http://158.69.113.110/serveurDecouverteFaune/src/commentaire/ajouter/index.php?notecommentaire" + commentaire.getNotecommentaire() + "coordgpscommentaire" + commentaire.getCoordgpscommentaire() + "urlimagecomm" + commentaire.getUrlimagecomm() + "textcom" + commentaire.getTextcom() + "idetrevivant" + commentaire.getIdetrevivant();
            URL urlAjouterCommentaire = new URL(URL_AJOUTER_COMMENTAIRE);
            HttpURLConnection connection = (HttpURLConnection) urlAjouterCommentaire.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStreamWriter envoyeur = new HttpPostRequete().execute(connection).get();

            /*envoyeur.write("noteCommentaire=" + commentaire.getNotecommentaire()
            + "&urlimagecomm=" + commentaire.getUrlimagecomm()
            + "&textcom=" + commentaire.getTextcom()
            + "&idetrevivant=" + commentaire.getIdetrevivant());*/
            System.out.println("POSITIONS !!");
            Double latitude = commentaire.getLongitudeLatitude().latitude;
            Double longitude = commentaire.getLongitudeLatitude().longitude;
            System.out.println("latitude : " + latitude);
            System.out.println("longitude : " + longitude);
            System.out.println("text : " + commentaire.getTextcom());
            System.out.println("idetrevivant : " + commentaire.getIdetrevivant());

            envoyeur.write("textcom=" + commentaire.getTextcom()
                    + "&idetrevivant=" + commentaire.getIdetrevivant()
                    + "&latitude=" + latitude
                    + "&longitude=" + longitude);
            System.out.println(latitude);

            Log.d("HELLO", "1 " + envoyeur);
            envoyeur.close();

            InputStream fluxLecture = new ServiceFluxDAO().execute(connection).get(); // NE PAS RETIRER NECESSAIRE AU FONCTIONNEMENT
            Log.d("HELLO", "2 " + fluxLecture);
            connection.disconnect();


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Commentaire> listerPositionsCommentaire(int idEtreVivant) {

        listePositions = new ArrayList<>();
        listePositions.clear();

        String url = URL_LISTER_POSITIONS + "?idEtreVivant=" + idEtreVivant;
        String moyenne;
        String derniereBalise = "</commentaires>";
        String xml;

        HttpGetRequete getRequete = new HttpGetRequete();

        try {
            xml = getRequete.execute(url, derniereBalise).get();
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(new StringBufferInputStream(xml));
            NodeList listeNoeudPositions = document.getElementsByTagName("commentaire");

            for (int pos = 0; pos < listeNoeudPositions.getLength(); pos++) {
                Commentaire commentaire = new Commentaire();
                Element noeudPosition = (Element) listeNoeudPositions.item(pos);
                String id = noeudPosition.getElementsByTagName("id").item(0).getTextContent();
                commentaire.setId(Integer.valueOf(id));
                String longitude = noeudPosition.getElementsByTagName("longitude").item(0).getTextContent();
                String latitude = noeudPosition.getElementsByTagName("latitude").item(0).getTextContent();
                if (longitude == "" & latitude == "") {
                    return null;
                }
                LatLng longlat = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
                commentaire.setLongitudeLatitude(longlat);
                commentaire.setIdetrevivant(idEtreVivant);

                listePositions.add(commentaire);
            }


            return listePositions;

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

    public Commentaire recupererCommentaire(int idCommentaire) {

        String url = URL_RECUPERER_COMMENTAIRE + "?idCommentaire=" + idCommentaire;
        String derniereBalise = "</commentaires>";
        String xml;
        Commentaire commentaire;

        HttpGetRequete getRequete = new HttpGetRequete();

        try {
            xml = getRequete.execute(url, derniereBalise).get();
            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(new StringBufferInputStream(xml));
            NodeList listeNoeudCommentaire = document.getElementsByTagName("commentaire");

            for (int pos = 0; pos < listeNoeudCommentaire.getLength(); pos++) {
                commentaire = new Commentaire();
                Element noeudCommentaire = (Element) listeNoeudCommentaire.item(pos);
                commentaire.setId(Integer.valueOf(idCommentaire));
                String idEtreVivant = noeudCommentaire.getElementsByTagName("idetrevivant").item(0).getTextContent();
                commentaire.setIdetrevivant(Integer.parseInt(idEtreVivant));
                String longitude = noeudCommentaire.getElementsByTagName("longitude").item(0).getTextContent();
                String latitude = noeudCommentaire.getElementsByTagName("latitude").item(0).getTextContent();
                LatLng longlat = new LatLng(Double.valueOf(latitude), Double.valueOf(longitude));
                commentaire.setLongitudeLatitude(longlat);
                String textecom = noeudCommentaire.getElementsByTagName("textecom").item(0).getTextContent();
                commentaire.setTextcom(textecom);
                return commentaire;
            }

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
