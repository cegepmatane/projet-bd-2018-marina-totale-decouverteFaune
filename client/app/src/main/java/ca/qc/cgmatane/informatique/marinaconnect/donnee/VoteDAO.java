package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import ca.qc.cgmatane.informatique.marinaconnect.modele.Vote;

public class VoteDAO {
    private static VoteDAO instance = null;
    protected VoteDAO vote;


    public static VoteDAO getInstance() {
        if (null == instance)
            instance = new VoteDAO();
        return instance;
    }

    public void ajouterVoteSQL(Vote vote){
        //TODO Fonction ajouter
    }
    public int lireVote()
    {
        //TODO Fonction lire
        return 0;
    }


}
