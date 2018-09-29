package ca.qc.cgmatane.informatique.decouvertefaune;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ca.qc.cgmatane.informatique.decouvertefaune.donnee.EtreVivantDAO;

public class DecouverteFaune extends AppCompatActivity {

    protected EtreVivantDAO accesseurEtreVivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_decouverte_faune);

        accesseurEtreVivant.getListeEtreVivant();
    }
}
