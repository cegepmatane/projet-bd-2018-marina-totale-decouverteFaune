package ca.qc.cgmatane.informatique.marinaconnect.donnee;

public class EtreVivantDAO {

    private static EtreVivantDAO instance = null;

    public static EtreVivantDAO getInstance() {

        if (null == instance) {
            instance = new EtreVivantDAO();
        }

        return instance;
    }


    public void listerEtreVivant(){

    }
}
