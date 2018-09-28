package ca.qc.cgmatane.informatique.decouvertefaune.modele;

public class EtreVivant {
    protected  int id_etreVivant;
    protected   String categorie;
    protected  String espece;

    public int getId_etreVivant() {
        return id_etreVivant;
    }

    public void setId_etreVivant(int id_etreVivant) {
        this.id_etreVivant = id_etreVivant;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public String getUrlDescriptionWiki() {
        return urlDescriptionWiki;
    }

    public void setUrlDescriptionWiki(String urlDescriptionWiki) {
        this.urlDescriptionWiki = urlDescriptionWiki;
    }

    public String getUrlImageEtreVivant() {
        return urlImageEtreVivant;
    }

    public void setUrlImageEtreVivant(String urlImageEtreVivant) {
        this.urlImageEtreVivant = urlImageEtreVivant;
    }

    protected  String urlDescriptionWiki;
    protected  String urlImageEtreVivant;
}
