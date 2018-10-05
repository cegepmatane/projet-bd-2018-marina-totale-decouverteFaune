package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import ca.qc.cgmatane.informatique.marinaconnect.R;

public class VueConnection extends AppCompatActivity {
    static final public int ACTIVITE_ACCUEIL = 1;

    protected Intent intentionNaviguerAccueil;
    protected EditText champPseudo;
    protected EditText champMdp;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_connection);


    }

}
