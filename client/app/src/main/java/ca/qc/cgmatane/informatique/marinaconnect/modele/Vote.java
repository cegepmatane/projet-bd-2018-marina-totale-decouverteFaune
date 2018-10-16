package ca.qc.cgmatane.informatique.marinaconnect.modele;

public class Vote {

    protected int id;
    protected int idCommentaire;
    protected int cote;
    protected float moyenne;

    public Vote(int cote, int idCommentaire) {
        this.cote = cote;
        this.idCommentaire = idCommentaire;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
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

    public int getCote() {
        return cote;
    }

    public void setCote(int cote) {
        this.cote = cote;
    }

}
