package ca.qc.cgmatane.informatique.marinaconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.qc.cgmatane.informatique.marinaconnect.donnee.UtilisateurDAO;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueConnection;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueInscription;

public class MarinaConnect extends AppCompatActivity {

    static final public int ACTIVITE_SE_CONNECTER = 1;
    static final public int ACTIVITE_CREER_COMPTE = 2;
    protected UtilisateurDAO utilisateurDAO;


    protected Intent intentionNaviguerSeConnecter;
    protected Intent intentionNaviguerCreerCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_accueil);
        utilisateurDAO = utilisateurDAO.getInstance();


        intentionNaviguerSeConnecter = new Intent(this, VueConnection.class);
        Button actionNaviguerSeConnecter = (Button) findViewById(R.id.action_naviguer_connection);
        actionNaviguerSeConnecter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                startActivityForResult(intentionNaviguerSeConnecter, ACTIVITE_SE_CONNECTER);
            }
        });
        intentionNaviguerCreerCompte = new Intent(this, VueInscription.class);
        Button actionNaviguerCreerCompte = (Button) findViewById(R.id.action_naviguer_inscription);
        actionNaviguerCreerCompte.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                startActivityForResult(intentionNaviguerCreerCompte, ACTIVITE_CREER_COMPTE);
            }
        });

    }
}
