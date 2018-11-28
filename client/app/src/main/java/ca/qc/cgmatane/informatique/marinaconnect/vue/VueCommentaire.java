package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import ca.qc.cgmatane.informatique.marinaconnect.MarinaConnect;
import ca.qc.cgmatane.informatique.marinaconnect.R;

public class VueCommentaire extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_commentaire);

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
    }
}
