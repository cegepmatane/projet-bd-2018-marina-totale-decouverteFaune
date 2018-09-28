package ca.qc.cgmatane.informatique.decouvertefaune.donnee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ca.qc.cgmatane.informatique.decouvertefaune.modele.EtreVivant;

public class EtreVivantDAO<T> {

    List<EtreVivant> listeEtreVivant;

    public EtreVivantDAO(){
        this.listeEtreVivant = new ArrayList<>();
    }


    public List<EtreVivant> getListeEtreVivant() {

        String xmlRssEtreVivant = "";
        try{
            URL urlRssEtreVivant = new URL("http://158.69.113.110/serveurDecouverteFaune/src/etreVivant/liste/index.php");

            BufferedReader influx = new BufferedReader(new InputStreamReader(urlRssEtreVivant.openStream()));

        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        return listeEtreVivant;
    }
}
