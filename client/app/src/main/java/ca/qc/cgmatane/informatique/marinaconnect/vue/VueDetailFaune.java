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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;
import java.util.List;


import ca.qc.cgmatane.informatique.marinaconnect.MarinaConnect;
import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.CommentaireDAO;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.PositionDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.Commentaire;
import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;
import ca.qc.cgmatane.informatique.marinaconnect.modele.Position;

public class VueDetailFaune extends AppCompatActivity implements OnMapReadyCallback {
    EtreVivant etreVivant;
    Intent intentionNaviguerVueCommentaire;
    Intent intentionNaviguerVueAjouterCommentaire;
    //protected PositionDAO accesseurPosition = PositionDAO.getInstance();
    protected CommentaireDAO accesseurCommentaire = CommentaireDAO.getInstance();

    //private GoogleMap carte;
    //private List<Position> listePositions;
    private List<Commentaire> listeCommentaire;

    static final public int ACTIVITE_COMMENTAIRE = 1;
    static final public int ACTIVITE_AJOUT_COMMENTAIRE = 2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_detail_faune);
        etreVivant = new EtreVivant();
        Intent intent = getIntent();
        intentionNaviguerVueCommentaire = new Intent(this, VueCommentaire.class);
        intentionNaviguerVueAjouterCommentaire = new Intent(this, VueAjouterCommentaire.class);

        MapFragment fragementCarte = (MapFragment) getFragmentManager().findFragmentById(R.id.carte_terrains);
        System.out.println("fragment carte : ");
        System.out.println(fragementCarte);
        fragementCarte.getMapAsync(this);


        etreVivant.setId(Integer.parseInt(intent.getStringExtra("idEtreVivant")));
        etreVivant.setCategorie(intent.getStringExtra("categorie"));
        etreVivant.setEspece(intent.getStringExtra("espece"));
        etreVivant.setUrlImage(intent.getStringExtra("urlImage"));
        etreVivant.setInformation(intent.getStringExtra("information"));


        TextView espece = (TextView)findViewById(R.id.vue_detail_faune_espece);
        TextView jaiVu = (TextView) findViewById(R.id.action_ajouter_commentaire);
        TextView information = (TextView) findViewById(R.id.text_information_etreVivant);

        espece.setText(etreVivant.getEspece()+ " :");
        jaiVu.setText("J'ai vu " + etreVivant.getEspece());
        information.setText(etreVivant.getInformation());


        final Button actionNaviguerAjouterCommentaire =
                (Button) findViewById(R.id.action_ajouter_commentaire);

        actionNaviguerAjouterCommentaire.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View arg0){
                        intentionNaviguerVueAjouterCommentaire.putExtra("idEtreVivant", etreVivant.getId() + "");
                        startActivityForResult(intentionNaviguerVueAjouterCommentaire, ACTIVITE_AJOUT_COMMENTAIRE);
                    }
                });

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

    }

    public void onMapReady(GoogleMap carte){
        LatLng camera = new LatLng(48.851552, -67.537350);
        System.out.println( "MAP");

        carte.moveCamera(CameraUpdateFactory.newLatLngZoom(camera,12));
        listeCommentaire = new ArrayList<>();

        listeCommentaire = accesseurCommentaire.listerPositionsCommentaire(etreVivant.getId());
        System.out.println( accesseurCommentaire.listerPositionsCommentaire(etreVivant.getId()));

        if (listeCommentaire != null){
            for(Commentaire commentaire : listeCommentaire){
                carte.addMarker(new MarkerOptions().position(commentaire.getLongitudeLatitude()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))).setTag(commentaire);
            }

            carte.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    Commentaire commentaireMarque = (Commentaire) marker.getTag();
                    System.out.println(commentaireMarque.getId());
                    startActivityForResult(intentionNaviguerVueCommentaire, ACTIVITE_COMMENTAIRE);
                    return false;
                }
            });
        }


    }

}
