package ca.qc.cgmatane.informatique.decouvertefaune.modele;

public class commentaire {
    protected int id_commentaire;
    protected int noteCommentaire;
    protected String coordonneGpsCommentaire;
    protected String textCommentaire;
    protected int id_etreVivant;
    protected String urlImageCommentaire;

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public int getNoteCommentaire() {
        return noteCommentaire;
    }

    public void setNoteCommentaire(int noteCommentaire) {
        this.noteCommentaire = noteCommentaire;
    }

    public String getCoordonneGpsCommentaire() {
        return coordonneGpsCommentaire;
    }

    public void setCoordonneGpsCommentaire(String coordonneGpsCommentaire) {
        this.coordonneGpsCommentaire = coordonneGpsCommentaire;
    }

    public String getTextCommentaire() {
        return textCommentaire;
    }

    public void setTextCommentaire(String textCommentaire) {
        this.textCommentaire = textCommentaire;
    }

    public int getId_etreVivant() {
        return id_etreVivant;
    }

    public void setId_etreVivant(int id_etreVivant) {
        this.id_etreVivant = id_etreVivant;
    }

    public String getUrlImageCommentaire() {
        return urlImageCommentaire;
    }

    public void setUrlImageCommentaire(String urlImageCommentaire) {
        this.urlImageCommentaire = urlImageCommentaire;
    }
}
