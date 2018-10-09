package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
        listeEtreVivant = new ArrayList<>();
    }


    /*public List<EtreVivant> listerEtreVivant(){
        try{
            String url = "http://158.69.113.110/serveurDecouverteFaune/src/etreVivant/liste/index.php";
            String xml;
            String nombre;
            String derniereBalise = "</etreVivants>";
            HttpPostRequete postRequete = new HttpPostRequete();
            xml = postRequete.execute(url, derniereBalise).get();

            DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            @SuppressWarnings("deprecation")
            Document document = parseur.parse(new StringBufferInputStream(xml));
            String racine = document.getDocumentElement().getNodeName();
            NodeList listeNoeudEtreVivant = document.getElementsByTagName("etreVivant");

            for (int position = 0; position < listeNoeudEtreVivant.getLength(); position++) {
                Element noeudEtreVivant = (Element) listeNoeudEtreVivant.item(position);
                nombre = noeudEtreVivant.getElementsByTagName("nombre").item(0).getTextContent();
            }
    }*/
}
