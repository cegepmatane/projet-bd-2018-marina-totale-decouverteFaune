package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import ca.qc.cgmatane.informatique.marinaconnect.MarinaConnect;
import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.CommentaireDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.Commentaire;

public class VueCommentaire extends AppCompatActivity implements OnMapReadyCallback {

    protected CommentaireDAO accesseurCommentaire = CommentaireDAO.getInstance();
    Commentaire commentaire;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_commentaire);
        Intent intent = getIntent();
        int idCommentaire = Integer.parseInt(intent.getStringExtra("idCommentaire"));
        Log.d("idCommentaire","id: " + idCommentaire);

        commentaire = accesseurCommentaire.recupererCommentaire(idCommentaire);
        Log.d("textCom","Com: " + commentaire.getTextcom());

        TextView textecom = (TextView)findViewById(R.id.text_vue_commentaire);
        textecom.setText(commentaire.getTextcom());

        // menu slide
        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_swipe);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case (R.id.naviguer_se_deconnecter):
                        SharedPreferences.Editor editeur = getSharedPreferences("detail_utilisateur", MODE_PRIVATE).edit();
                        editeur.clear();
                        editeur.commit();
                        startActivity(new Intent(getApplicationContext(), MarinaConnect.class));
                        finish();
                        break;
                }
                return true;
            }
        });

        // Map
        MapFragment fragementCarte = (MapFragment) getFragmentManager().findFragmentById(R.id.carte_vue_commentaire);
        fragementCarte.getMapAsync(this);


    }
    public void onMapReady(GoogleMap carte) {
        carte.moveCamera(CameraUpdateFactory.newLatLngZoom(commentaire.getLongitudeLatitude(),14));

    }
}
