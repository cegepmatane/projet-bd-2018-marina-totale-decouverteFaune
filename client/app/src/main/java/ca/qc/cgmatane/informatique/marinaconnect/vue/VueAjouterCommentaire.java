package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import ca.qc.cgmatane.informatique.marinaconnect.R;

public class VueAjouterCommentaire extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_ajout_commentaire);
        Intent intention = getIntent();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        FragmentMap fragmentMap = new FragmentMap();
        fragmentMap.setIdEtreVivant(Integer.parseInt(intention.getStringExtra("idEtreVivant")));
        System.out.println(fragmentMap);
        fragmentTransaction.add(R.id.fragment_container,fragmentMap);
        fragmentTransaction.commit();
    }
}
