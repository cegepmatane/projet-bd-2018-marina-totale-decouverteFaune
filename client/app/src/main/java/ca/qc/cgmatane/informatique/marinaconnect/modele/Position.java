package ca.qc.cgmatane.informatique.marinaconnect.modele;

public class Position {

    protected double longitude;
    protected double latitude;
    protected int id;
    protected int idEtreVivant;

    public Position() {
        super();

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
