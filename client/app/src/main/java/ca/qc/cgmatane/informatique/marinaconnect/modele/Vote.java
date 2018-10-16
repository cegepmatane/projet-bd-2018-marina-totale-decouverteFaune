package ca.qc.cgmatane.informatique.marinaconnect.modele;

public class Vote {

    protected int id;
    protected int idCommentaire;
    protected int moyenne; //total values
    protected int nombreVote; // total votes

    public Vote(int moyenne, int nombreVote) {
        this.moyenne = moyenne;
        this.nombreVote = nombreVote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public int getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(int moyenne) {
        this.moyenne = moyenne;
    }

    public int getNombreVote() {
        return nombreVote;
    }

    public void setNombreVote(int nombreVote) {
        this.nombreVote = nombreVote;
    }
}
