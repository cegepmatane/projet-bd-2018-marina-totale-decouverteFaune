package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import java.util.List;


import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.EtreVivantDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class VueDetailFaune extends AppCompatActivity {
    EtreVivant etreVivant;
    private GoogleMap carteTerrains;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_detail_faune);
        etreVivant = new EtreVivant();
        Intent intent = getIntent();

        etreVivant.setId(Integer.parseInt(intent.getStringExtra("idEtreVivant")));
        etreVivant.setCategorie(intent.getStringExtra("categorie"));
        etreVivant.setEspece(intent.getStringExtra("espece"));
        etreVivant.setUrlImage(intent.getStringExtra("urlImage"));
        etreVivant.setCategorie(intent.getStringExtra("urlWiki"));


        TextView espece = (TextView)findViewById(R.id.vue_detail_faune_espece);
        espece.setText(etreVivant.getEspece());
    }

    public void onMapReady(GoogleMap carte){

    }

}
