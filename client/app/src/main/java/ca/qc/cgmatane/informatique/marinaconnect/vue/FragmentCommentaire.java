package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import ca.qc.cgmatane.informatique.marinaconnect.R;
import ca.qc.cgmatane.informatique.marinaconnect.donnee.CommentaireDAO;
import ca.qc.cgmatane.informatique.marinaconnect.modele.Commentaire;

public class FragmentCommentaire extends Fragment {

    LatLng latitudeLongitude;
    Commentaire commentaire;
    protected EditText champCommentaire;
    int idEtreVivant;

    protected CommentaireDAO accesseurCommentaire = CommentaireDAO.getInstance();


    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vue = inflater.inflate(R.layout.fragment_ajout_commentaire, container, false);
        return vue;
    }
    @Override
    public void onViewCreated(View vue, Bundle savedInstanceState) {
        super.onViewCreated(vue, savedInstanceState);

        champCommentaire = (EditText) vue.findViewById(R.id.fragment_ajout_text_commentaire);
        Button boutonAjout = (Button) vue.findViewById(R.id.action_fragment_navigation_detail);

        boutonAjout.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View arg0){
                        enregistrerCommentaire();
                        //startActivityForResult(intentionNaviguerAccueil, ACTIVITE_ACCUEIL);
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
