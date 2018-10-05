package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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
                String url = "http://158.69.113.110/findItServeur/utilisateur/ajouter/index.php?mail="+utilisateur.getMail()+"&mdp="+utilisateur.getMdp();

                String resultat;
                HttpGetRequete getRequete = new HttpGetRequete();
                resultat = getRequete.execute(url).get();
            }catch(InterruptedException e){
                System.out.println("got interrupted!");
            }catch(ExecutionException e){
                System.out.println("got interrupted!");
            }
        }
    }

