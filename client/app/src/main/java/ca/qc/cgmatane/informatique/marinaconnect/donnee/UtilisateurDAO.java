package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

import ca.qc.cgmatane.informatique.marinaconnect.modele.Utilisateur;

public class UtilisateurDAO implements UtilisateurURL {

    private static UtilisateurDAO instance = null;

    public static UtilisateurDAO getInstance() {

        if (null == instance) {
            instance = new UtilisateurDAO();
        }

        return instance;
    }

        public void ajouterUtilisateurSQL(Utilisateur utilisateur){

            try {
                //String url = "http://158.69.113.110/serveurDecouverteFaune/src/commentaire/ajouter/index.php?notecommentaire" + commentaire.getNotecommentaire() + "coordgpscommentaire" + commentaire.getCoordgpscommentaire() + "urlimagecomm" + commentaire.getUrlimagecomm() + "textcom" + commentaire.getTextcom() + "idetrevivant" + commentaire.getIdetrevivant();
                URL urlAjouterUtilisateur = new URL(URL_AJOUTER_UTILISATEUR);
                HttpURLConnection connection = (HttpURLConnection) urlAjouterUtilisateur.openConnection();
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");

                OutputStreamWriter envoyeur = new HttpPostRequete().execute(connection).get();

                envoyeur.write("mail=" + utilisateur.getMail()
                        + "&mdp=" + utilisateur.getMdp());

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

        public boolean verifierConnection(Utilisateur utilisateur){

        try{
            String url = URL_VERIFIER_UTILISATEUR + "?mail="+utilisateur.getMail()+"&mdp="+utilisateur.getMdp();
            String xml;
            String nombre;
            String derniereBalise = "</compteurs>";
            HttpGetRequete getRequete = new HttpGetRequete();
            xml = getRequete.execute(url, derniereBalise).get();

            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(new StringBufferInputStream(xml));
            String racine = document.getDocumentElement().getNodeName();
            NodeList listeNoeudCompteur = document.getElementsByTagName("compteur");
            for (int position = 0; position < listeNoeudCompteur.getLength(); position++) {
                Element noeudCompteur = (Element) listeNoeudCompteur.item(position);
                nombre = noeudCompteur.getElementsByTagName("nombre").item(0).getTextContent();
                if(Integer.parseInt(nombre) >=1){
                    return true;
                }
            }
        } catch (InterruptedException e) {
        e.printStackTrace();

        } catch (ParserConfigurationException e) {
        e.printStackTrace();

        } catch (SAXException e) {
        e.printStackTrace();

        } catch (IOException e) {
        e.printStackTrace();

        } catch (ExecutionException e) {
        e.printStackTrace();

        }
        return false;


    }
}

