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

public class VueConnection extends AppCompatActivity {
    static final public int ACTIVITE_LISTE_FAUNE= 1;

    protected Intent intentionNaviguerVueListeFaune;
    protected EditText champMail;
    protected EditText champMdp;

    protected UtilisateurDAO accesseurUtilisateur = UtilisateurDAO.getInstance();

    protected Utilisateur utilisateur;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_connection);

        champMail = (EditText)findViewById(R.id.vue_se_connecter_champ_mail);
        champMdp = (EditText)findViewById(R.id.vue_se_connecter_champ_mot_de_passe);
        intentionNaviguerVueListeFaune = new Intent(this, VueListeFaune.class);
        Button actionNaviguerListeFaune =
                (Button) findViewById(R.id.action_se_connecter);

        actionNaviguerListeFaune.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View arg0){
                        verifierUtilisateur();
                    }
                });

    }


    private void verifierUtilisateur() {
        utilisateur = new Utilisateur(champMail.getText().toString(), champMdp.getText().toString());
        if (accesseurUtilisateur.verifierConnection(utilisateur)) {
            System.out.println("GAGNER");
            startActivityForResult(intentionNaviguerVueListeFaune, ACTIVITE_LISTE_FAUNE);
        }
    }

}
