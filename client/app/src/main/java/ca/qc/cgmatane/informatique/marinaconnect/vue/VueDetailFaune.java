package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import org.w3c.dom.Text;

import java.util.List;


import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.EtreVivantDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class VueDetailFaune extends AppCompatActivity {
    EtreVivant etreVivant;
    Intent intentionNaviguerVueCommentaire;
    private GoogleMap carteTerrains;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_detail_faune);
        etreVivant = new EtreVivant();
        Intent intent = getIntent();
        intentionNaviguerVueCommentaire = new Intent(this, VueCommentaire.class);


        etreVivant.setId(Integer.parseInt(intent.getStringExtra("idEtreVivant")));
        etreVivant.setCategorie(intent.getStringExtra("categorie"));
        etreVivant.setEspece(intent.getStringExtra("espece"));
        etreVivant.setUrlImage(intent.getStringExtra("urlImage"));
        etreVivant.setCategorie(intent.getStringExtra("urlWiki"));


        TextView espece = (TextView)findViewById(R.id.vue_detail_faune_espece);
        TextView jaiVu = (TextView) findViewById(R.id.action_j_ai_vu);
        espece.setText(etreVivant.getEspece()+ " :");
        jaiVu.setText("J'ai vu " + etreVivant.getEspece());

        Button actionNaviguerCommentaire =
                (Button) findViewById(R.id.action_commentaires);

        actionNaviguerCommentaire.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View arg0){

                        //startActivityForResult(intentionNaviguerVueCommentaire, ACTIVITE_ACCUEIL);
                    }
                });

        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_swipe);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case (R.id.naviguer_se_deconnecter):
                        SharedPreferences.Editor editeur = getSharedPreferences("details_connexion_utilisateur", MODE_PRIVATE).edit();
                        editeur.clear();
                        editeur.commit();
                        startActivity(new Intent(getApplicationContext(), VueConnection.class));
                        finish();
                        break;

                }
                return true;
            }
        });

    }

    public void onMapReady(GoogleMap carte){

    }

}
