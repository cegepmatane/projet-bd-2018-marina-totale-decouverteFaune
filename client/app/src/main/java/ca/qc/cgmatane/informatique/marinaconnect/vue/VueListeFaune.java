package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ca.qc.cgmatane.informatique.marinaconnect.MarinaConnect;
import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.EtreVivantDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class VueListeFaune extends AppCompatActivity {

    protected EtreVivantDAO accesseurEtreVivant = EtreVivantDAO.getInstance();
    List<EtreVivant> etreVivants;

    static final public int ACTIVITE_DETAIL_FAUNE = 1;
    protected Intent intentionNaviguerVueDetailFaune;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_liste_faune);
        intentionNaviguerVueDetailFaune = new Intent(this, VueDetailFaune.class);
        final ListView listView = (ListView) findViewById(R.id.vue_liste_faune);
        //etreVivants.clear();

        etreVivants = accesseurEtreVivant.listerEtreVivant();
        listView.setAdapter(new CustomListAdapter(this, etreVivants));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                EtreVivant etreVivant = (EtreVivant) o;
                intentionNaviguerVueDetailFaune.putExtra("idEtreVivant", etreVivant.getId() + "");
                intentionNaviguerVueDetailFaune.putExtra("information", etreVivant.getInformation());
                intentionNaviguerVueDetailFaune.putExtra("espece", etreVivant.getEspece());

                Toast.makeText(VueListeFaune.this, "Selection :" + " " + etreVivant.getEspece(), Toast.LENGTH_LONG).show();

                startActivityForResult(intentionNaviguerVueDetailFaune, ACTIVITE_DETAIL_FAUNE);
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
}