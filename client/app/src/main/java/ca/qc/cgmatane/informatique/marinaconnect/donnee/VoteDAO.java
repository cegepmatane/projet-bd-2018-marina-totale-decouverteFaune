package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import android.provider.DocumentsContract;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import ca.qc.cgmatane.informatique.marinaconnect.modele.Vote;

public class VoteDAO implements VoteURL {
    private static VoteDAO instance = null;
    protected VoteDAO vote;


    public static VoteDAO getInstance() {
        if (null == instance)
            instance = new VoteDAO();
        return instance;
    }

    public void ajouterVoteSQL(Vote vote) {

        try {
            //String url = "http://158.69.113.110/serveurDecouverteFaune/src/commentaire/ajouter/index.php?notecommentaire" + commentaire.getNotecommentaire() + "coordgpscommentaire" + commentaire.getCoordgpscommentaire() + "urlimagecomm" + commentaire.getUrlimagecomm() + "textcom" + commentaire.getTextcom() + "idetrevivant" + commentaire.getIdetrevivant();
            URL urlAjouterVote = new URL(URL_AJOUTER_VOTE);
            HttpURLConnection connection = (HttpURLConnection) urlAjouterVote.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStreamWriter envoyeur = new HttpPostRequete().execute(connection).get();

            envoyeur.write("cote=" + vote.getCote()
                    + "&idCommentaire=" + vote.getIdCommentaire()
                    + "&moyenne=" + vote.getMoyenne());

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

    public float lireVote(int idCommentaire) {
        String url = "http://158.69.113.110/serveurDecouverteFaune/src/vote/liste/index.php?idCommentaire=" + idCommentaire;
        String xml;
        String moyenne;


        HttpGetRequete getRequete = new HttpGetRequete();
        try {
            xml = getRequete.execute(url).get();
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
