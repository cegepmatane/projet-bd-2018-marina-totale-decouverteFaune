package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;


import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.EtreVivantDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.EtreVivant;

public class VueDetailFaune extends AppCompatActivity {
    EtreVivantDAO etreVivantDAO;
    EtreVivant etreVivant;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_detail_faune);
        //System.out.println(etreVivant.getEspece());
        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("idEtreVivant"));
        etreVivantDAO = EtreVivantDAO.getInstance();
       List<EtreVivant> listeEtreVivant = etreVivantDAO.listerEtreVivant();
       int i =0;
       while (i != listeEtreVivant.size()){
           if (listeEtreVivant.get(i).getId()== id) {
               etreVivant = listeEtreVivant.get(i);
               break;
           }
               i++;

       }
        TextView espece = (TextView)findViewById(R.id.vue_detail_faune_espece);
       espece.setText(etreVivant.getEspece());
    }

}
