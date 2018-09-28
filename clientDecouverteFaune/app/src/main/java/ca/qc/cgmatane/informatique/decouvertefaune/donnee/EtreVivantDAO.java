package ca.qc.cgmatane.informatique.decouvertefaune.donnee;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import ca.qc.cgmatane.informatique.decouvertefaune.modele.EtreVivant;

public class EtreVivantDAO<T> {

    List<EtreVivant> listeEtreVivant;

    public EtreVivantDAO(){
        this.listeEtreVivant = new ArrayList<>();
    }


    public List<EtreVivant> getListeEtreVivant() {

        String xmlRssEtreVivant = "";
        URL urlRssEtreVivant;
        try{
            urlRssEtreVivant = new URL("http://158.69.113.110/serveurDecouverteFaune/src/etreVivant/liste/index.php");

            BufferedReader influx = new BufferedReader(new InputStreamReader(urlRssEtreVivant.openStream()));
            String ligne;
            while ((ligne = influx.readLine()) != null) xmlRssEtreVivant+=ligne;
            influx.close();

            try {
                DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                try {
                    Document docListeEtreVivant = parseur.parse(new StringBufferInputStream(xmlRssEtreVivant));
                    String racine = docListeEtreVivant.getDocumentElement().getNodeName();
                    //System.out.println("Racine:" + racine);
                    NodeList noeudListeEtreVivant = docListeEtreVivant.getElementsByTagName("row");

                } catch (SAXException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        catch (MalformedURLException e) { e.printStackTrace();}
        catch (IOException e) { e.printStackTrace(); }

        return listeEtreVivant;
    }
}
