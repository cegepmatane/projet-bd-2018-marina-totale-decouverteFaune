package ca.qc.cgmatane.informatique.marinaconnect.donnee;

public class CommentaireDAO {
    private static  CommentaireDAO instance = null;
    protected  CommentaireDAO commentaire;

    public static CommentaireDAO getInstance() {
        if (null == instance)
            instance = new CommentaireDAO();
        return instance;
    }

    public  void ajouteCommentaireSQL(CommentaireDAO commentaire){

    }
}
