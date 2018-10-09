package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import ca.qc.cgmatane.informatique.marinaconnect.modele.Utilisateur;

public class UtilisateurDAO {

    private static UtilisateurDAO instance = null;

    public static UtilisateurDAO getInstance() {

        if (null == instance) {
            instance = new UtilisateurDAO();
        }

        return instance;
    }

        public void ajouterUtilisateurSQL(Utilisateur utilisateur){

            try{

                String url = "http://158.69.113.110/serveurDecouverteFaune/src/Utilisateur/ajouter/index.php?mail="+utilisateur.getMail()+"&mdp="+utilisateur.getMdp();

                String resultat;
                HttpGetRequete getRequete = new HttpGetRequete();
                resultat = getRequete.execute(url).get();
            }catch(InterruptedException e){
                System.out.println("got interrupted!");
            }catch(ExecutionException e){
                System.out.println("got interrupted!");
            }
        }

        public boolean verifierConnection(Utilisateur utilisateur){

        try{
            String url = "http://158.69.113.110/serveurDecouverteFaune/src/Utilisateur/compteur/index.php?mail="+utilisateur.getMail()+"&mdp="+utilisateur.getMdp();
            String xml;
            String nombre;
            String derniereBalise = "</compteurs>";
            HttpPostRequete postRequete = new HttpPostRequete();
            xml = postRequete.execute(url, derniereBalise).get();

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

