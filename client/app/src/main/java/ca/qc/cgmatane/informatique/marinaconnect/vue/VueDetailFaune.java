package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class VueDetailFaune extends AppCompatActivity {

    EtreVivant etreVivant;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_detail_faune);
        //System.out.println(etreVivant.getEspece());
    }
}
