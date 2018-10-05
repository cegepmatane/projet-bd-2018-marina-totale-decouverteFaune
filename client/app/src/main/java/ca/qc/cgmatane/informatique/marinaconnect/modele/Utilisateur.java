package ca.qc.cgmatane.informatique.marinaconnect.modele;

public class Utilisateur {
    protected int id;
    protected String mail;

    public Utilisateur() {
        super();

    }

    public Utilisateur(String mail, String mdp) {
        super();
        this.mail = mail;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    protected String mdp;
}
