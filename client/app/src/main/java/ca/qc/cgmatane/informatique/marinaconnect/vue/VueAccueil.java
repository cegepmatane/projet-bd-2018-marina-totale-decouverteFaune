package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class VueAccueil extends AppCompatActivity {

    static final public int ACTIVITE_SE_CONNECTER = 1;
    static final public int ACTIVITE_CREER_COMPTE = 2;

    protected Intent intentionNaviguerSeConnecter;
    protected Intent intentionNaviguerCreerCompte;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
