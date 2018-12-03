package ca.qc.cgmatane.informatique.marinaconnect.modele;

import com.google.android.gms.maps.model.LatLng;

public class Commentaire {
    protected double notecommentaire;
    protected String urlimagecomm;
    protected String textcom;
    protected int idetrevivant;
    protected int id;
    protected LatLng longitudeLatitude;


    public Commentaire() {

    }
    public Commentaire(int idetrevivant, String textcom, LatLng longitudeLatitude)
    {
        this.idetrevivant = idetrevivant;
        this.textcom = textcom;
        this.longitudeLatitude = longitudeLatitude;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LatLng getLongitudeLatitude() {
        return longitudeLatitude;
    }

    public void setLongitudeLatitude(LatLng longitudeLatitude) {
        this.longitudeLatitude = longitudeLatitude;
    }

    public double getNotecommentaire() {
        return notecommentaire;
    }

    public void setNotecommentaire(double notecommentaire) {
        this.notecommentaire = notecommentaire;
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
