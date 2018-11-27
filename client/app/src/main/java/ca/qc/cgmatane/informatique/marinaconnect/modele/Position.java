package ca.qc.cgmatane.informatique.marinaconnect.modele;

import com.google.android.gms.maps.model.LatLng;

public class Position {

    protected double longitude;
    protected double latitude;
    protected LatLng longitudeLatitude;
    protected int id;
    protected int idEtreVivant;

    public Position() {
        super();

    }

    public LatLng getLongitudeLatitude() {
        return longitudeLatitude;
    }

    public void setLongitudeLatitude(LatLng longitudeLatitude) {
        this.longitudeLatitude = longitudeLatitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEtreVivant() {
        return idEtreVivant;
    }

    public void setIdEtreVivant(int idEtreVivant) {
        this.idEtreVivant = idEtreVivant;
    }
}
