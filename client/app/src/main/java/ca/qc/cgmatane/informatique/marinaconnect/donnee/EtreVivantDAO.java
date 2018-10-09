package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import java.util.List;

import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class EtreVivantDAO {

    private static EtreVivantDAO instance = null;

    public static EtreVivantDAO getInstance() {

        if (null == instance) {
            instance = new EtreVivantDAO();
        }

        return instance;
    }


    /*public List<EtreVivant> listerEtreVivant(){
        String xml;
        String derniereBalise = "</etreVivants>";
        HttpPostRequete postRequete = new HttpPostRequete();
    }*/
}
