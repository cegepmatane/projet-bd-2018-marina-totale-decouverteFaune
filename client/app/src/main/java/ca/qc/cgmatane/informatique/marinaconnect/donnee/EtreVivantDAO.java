package ca.qc.cgmatane.informatique.marinaconnect.donnee;

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

import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class EtreVivantDAO {

    private static EtreVivantDAO instance = null;
    List<EtreVivant> listeEtreVivant;


    public static EtreVivantDAO getInstance() {

        if (null == instance) {
            instance = new EtreVivantDAO();
        }

        return instance;
    }

    public EtreVivantDAO() {

    }


    public List<EtreVivant> listerEtreVivant() {
        try {
            listeEtreVivant = new ArrayList<>();
            listeEtreVivant.clear();
            String url = "http://158.69.113.110/serveurDecouverteFaune/src/etreVivant/liste/index.php";
            String xml;
            String derniereBalise = "</etreVivants>";
            HttpGetRequete getRequete = new HttpGetRequete();
            xml = getRequete.execute(url, derniereBalise).get();

            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(new StringBufferInputStream(xml));
            String racine = document.getDocumentElement().getNodeName();
            NodeList listeNoeudEtreVivant = document.getElementsByTagName("etreVivant");

            for (int position = 0; position < listeNoeudEtreVivant.getLength(); position++) {
                Element noeudEtreVivant = (Element) listeNoeudEtreVivant.item(position);
                EtreVivant etreVivant = new EtreVivant();
                String id = noeudEtreVivant.getElementsByTagName("id").item(0).getTextContent();
                etreVivant.setId(Integer.parseInt(id));
                String information = noeudEtreVivant.getElementsByTagName("description").item(0).getTextContent();
                etreVivant.setInformation(information);
                String espece = noeudEtreVivant.getElementsByTagName("espece").item(0).getTextContent();
                etreVivant.setEspece(espece);

                listeEtreVivant.add(etreVivant);
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
        return listeEtreVivant;
    }
}
