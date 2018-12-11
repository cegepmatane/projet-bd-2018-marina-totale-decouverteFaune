package ca.qc.cgmatane.informatique.marinaconnect.modele;

public class EtreVivant {

    protected int id;
    protected String information;
    protected String urlImage;
    protected String espece;

    public EtreVivant getEtreVivant() {
        return etreVivant;
    }

    public void setEtreVivant(EtreVivant etreVivant) {
        this.etreVivant = etreVivant;
    }

    protected EtreVivant etreVivant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

}
