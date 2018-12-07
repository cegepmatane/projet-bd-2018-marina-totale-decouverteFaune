package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.maps.model.LatLng;

import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.CommentaireDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.Commentaire;

public class FragmentCommentaire extends Fragment {

    LatLng latitudeLongitude;
    Commentaire commentaire;
    protected EditText champCommentaire;
    int idEtreVivant;
    private int cote;
    protected Intent intentionNaviguerVueListeFaune;

    protected CommentaireDAO accesseurCommentaire = CommentaireDAO.getInstance();
    static final public int ACTIVITE_LISTE_FAUNE= 1;
    protected Button bouton1Etoile, bouton2Etoile, bouton3Etoile, bouton4Etoile, bouton5Etoile;
    protected ImageView etoiles;


    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vue = inflater.inflate(R.layout.fragment_ajout_commentaire, container, false);
        return vue;
    }
    @Override
    public void onViewCreated(View vue, Bundle savedInstanceState) {
        super.onViewCreated(vue, savedInstanceState);
        cote = 0;
        champCommentaire = (EditText) vue.findViewById(R.id.fragment_ajout_text_commentaire);
        Button boutonAjout = (Button) vue.findViewById(R.id.action_fragment_navigation_detail);
        intentionNaviguerVueListeFaune = new Intent(getActivity(), VueListeFaune.class);
        etoiles = (ImageView) vue.findViewById(R.id.fragment_ajout_commentaire_image_etoile);
        bouton1Etoile = (Button) vue.findViewById(R.id.fragment_ajout_commentaire_1_etoile);
        bouton2Etoile = (Button) vue.findViewById(R.id.fragment_ajout_commentaire_2_etoile);
        bouton3Etoile = (Button) vue.findViewById(R.id.fragment_ajout_commentaire_3_etoile);
        bouton4Etoile = (Button) vue.findViewById(R.id.fragment_ajout_commentaire_4_etoile);
        bouton5Etoile = (Button) vue.findViewById(R.id.fragment_ajout_commentaire_5_etoile);

        bouton1Etoile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cote = 1;
                System.out.println("la cote est de : " + cote);
                etoiles.setImageResource(R.drawable.starrating1of5);
            }
        });
        bouton2Etoile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cote = 2;
                System.out.println("la cote est de : " + cote);
                etoiles.setImageResource(R.drawable.starrating2of5);
            }
        });

        bouton3Etoile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cote = 3;
                System.out.println("la cote est de : " + cote);
                etoiles.setImageResource(R.drawable.starrating3of5);
            }
        });

        bouton4Etoile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cote = 4;
                System.out.println("la cote est de : " + cote);
                etoiles.setImageResource(R.drawable.starrating4of5);
            }
        });

        bouton5Etoile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cote = 5;
                System.out.println("la cote est de : " + cote);
                etoiles.setImageResource(R.drawable.star1);
            }
        });



        boutonAjout.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View arg0){
                        enregistrerCommentaire();
                        startActivityForResult(intentionNaviguerVueListeFaune, ACTIVITE_LISTE_FAUNE);

                    }
                });
    }

    private void enregistrerCommentaire(){
        commentaire = new Commentaire(idEtreVivant,champCommentaire.getText().toString(), latitudeLongitude);
        System.out.println(commentaire.getLongitudeLatitude());
        accesseurCommentaire.ajouteCommentaireSQL(commentaire);
    }

    public void setLatitudeLongitude(LatLng latLng){
        this.latitudeLongitude = latLng;
    }
    public void setIdEtreVivant(int idEtreVivant)
    {
        this.idEtreVivant = idEtreVivant;
    }

}
