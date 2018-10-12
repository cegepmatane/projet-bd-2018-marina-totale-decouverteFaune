package ca.qc.cgmatane.informatique.marinaconnect;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ca.qc.cgmatane.informatique.marinaconnect.donnee.UtilisateurDAO;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueAccueil;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueConnection;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueInscription;
import ca.qc.cgmatane.informatique.marinaconnect.vue.VueListeFaune;

public class MarinaConnect extends AppCompatActivity {

    static final public int ACTIVITE_ACCUEIL = 1;
    static final public int ACTIVITE_LISTE_FAUNE = 2;

    protected Intent intentionNaviguerAccueil;
    protected Intent intentionNaviguerListeFaune;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_commencer);

        preferences = getSharedPreferences("detail_utilisateur",MODE_PRIVATE);

        intentionNaviguerAccueil = new Intent(this, VueAccueil.class);
        intentionNaviguerListeFaune = new Intent(this, VueListeFaune.class);
        Button actionNaviguerSeConnecter = (Button) findViewById(R.id.vue_commencer_bouton);
        TextView textUtilisateur = (TextView) findViewById(R.id.textView_utilisateur_vue_accueil);

        if(preferences.getBoolean("estConnecter",false)){
            textUtilisateur.setText("Welcome : " + preferences.getString("mail", null));

        }else{
            //Vidage des session si l'utilisateur n'a pas cocher rester connecter
            SharedPreferences.Editor editeur = preferences.edit();
            editeur.clear();
            editeur.commit();
        }

        actionNaviguerSeConnecter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                if (preferences.getBoolean("estConnecter", false)){
                    startActivityForResult(intentionNaviguerListeFaune, ACTIVITE_LISTE_FAUNE);
                }
                else{
                    startActivityForResult(intentionNaviguerAccueil, ACTIVITE_ACCUEIL);
                }
            }
        });
    }
}
