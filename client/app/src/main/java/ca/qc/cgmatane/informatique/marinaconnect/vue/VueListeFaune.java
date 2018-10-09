package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.EtreVivantDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class VueListeFaune extends AppCompatActivity {
    protected EtreVivantDAO accesseurEtreVivant = EtreVivantDAO.getInstance();
    List<EtreVivant> etreVivants;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_liste_faune);


        final ListView listView = (ListView)findViewById(R.id.vue_liste_faune);



        etreVivants = accesseurEtreVivant.listerEtreVivant();

        listView.setAdapter(new CustomListAdapter(this, etreVivants));
    }
}
