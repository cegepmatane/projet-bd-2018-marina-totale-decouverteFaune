package ca.qc.cgmatane.informatique.marinaconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.qc.cgmatane.informatique.marinaconnect.donnee.UtilisateurDAO;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueAccueil;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueConnection;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueInscription;

public class MarinaConnect extends AppCompatActivity {

    static final public int ACTIVITE_ACCUEIL = 1;

    protected Intent intentionNaviguerAccueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_commencer);


        intentionNaviguerAccueil = new Intent(this, VueAccueil.class);
        Button actionNaviguerSeConnecter = (Button) findViewById(R.id.vue_commencer_bouton);
        actionNaviguerSeConnecter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                startActivityForResult(intentionNaviguerAccueil, ACTIVITE_ACCUEIL);
            }
        });
    }
}
