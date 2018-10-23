package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import java.util.concurrent.ExecutionException;

import ca.qc.cgmatane.informatique.marinaconnect.modele.Commentaire;

public class CommentaireDAO {
    private static  CommentaireDAO instance = null;
    protected  CommentaireDAO commentaire;

    public static CommentaireDAO getInstance() {
        if (null == instance)
            instance = new CommentaireDAO();
        return instance;
    }

    public  void ajouteCommentaireSQL(Commentaire commentaire){


        try {
            String url = "http://158.69.113.110/serveurDecouverteFaune/src/commentaire/ajouter/index.php?notecommentaire" + commentaire.getNotecommentaire() + "coordgpscommentaire" + commentaire.getCoordgpscommentaire() + "urlimagecomm" + commentaire.getUrlimagecomm() + "textcom" + commentaire.getTextcom() + "idetrevivant" + commentaire.getIdetrevivant();
            String resultat;
            HttpGetRequete getRequete = new HttpGetRequete();
            resultat = getRequete.execute(url).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
