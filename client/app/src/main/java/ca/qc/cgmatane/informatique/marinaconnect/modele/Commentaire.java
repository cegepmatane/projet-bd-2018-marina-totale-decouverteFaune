package ca.qc.cgmatane.informatique.marinaconnect.modele;

public class Commentaire {
    protected double notecommentaire;
    protected int coordgpscommentaire;
    protected String urlimagecomm;
    protected String textcom;
    protected int  idetrevivant;

    public Commentaire() {

    }


    public double getNotecommentaire() {
        return notecommentaire;
    }

    public void setNotecommentaire(double notecommentaire) {
        this.notecommentaire = notecommentaire;
    }

    public int getCoordgpscommentaire() {
        return coordgpscommentaire;
    }

    public void setCoordgpscommentaire(int coordgpscommentaire) {
        this.coordgpscommentaire = coordgpscommentaire;
    }

    public String getUrlimagecomm() {
        return urlimagecomm;
    }

    public void setUrlimagecomm(String urlimagecomm) {
        this.urlimagecomm = urlimagecomm;
    }

    public String getTextcom() {
        return textcom;
    }

    public void setTextcom(String textcom) {
        this.textcom = textcom;
    }

    public int getIdetrevivant() {
        return idetrevivant;
    }

    public void setIdetrevivant(int idetrevivant) {
        this.idetrevivant = idetrevivant;
    }


}
