package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ca.qc.cgmatane.informatique.marinaconnect.MarinaConnect;
import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.UtilisateurDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.Utilisateur;

public class VueInscription extends AppCompatActivity {

    static final public int ACTIVITE_ACCUEIL = 1;


    protected Intent intentionNaviguerAccueil;
    protected EditText champMail;
    protected EditText champMdp;
    protected EditText champMdpConfirme;

    protected Utilisateur utilisateur;

    protected UtilisateurDAO accesseurUtilisateur = UtilisateurDAO.getInstance();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_inscription);

        champMail = (EditText)findViewById(R.id.vue_creer_compte_champ_mail);
        champMdp = (EditText)findViewById(R.id.vue_creer_compte_champ_mot_de_passe);
        champMdpConfirme = (EditText)findViewById(R.id.vue_creer_compte_champ_verification_mot_de_passe);
        intentionNaviguerAccueil = new Intent(this, MarinaConnect.class);

        Button actionNaviguerAccueil =
                (Button) findViewById(R.id.action_sinscrire);

        actionNaviguerAccueil.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View arg0){
                        enregistrerUtilisateur();
                        startActivityForResult(intentionNaviguerAccueil, ACTIVITE_ACCUEIL);
                    }
                });

    }

    private void enregistrerUtilisateur(){
        utilisateur = new Utilisateur(champMail.getText().toString(), champMdp.getText().toString());
        accesseurUtilisateur.ajouterUtilisateurSQL(utilisateur);

    }

}
