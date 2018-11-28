package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import ca.qc.cgmatane.informatique.marinaconnect.R;

public class FragmentMap extends Fragment implements OnMapReadyCallback {
    private static final String TAG = "fragmentMap";

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //MapFragment fragementCarte = (MapFragment) getFragmentManager().findFragmentById(R.id.carte_vue_commentaire);
        //fragementCarte.getMapAsync(this);
        View vue = inflater.inflate(R.layout.fragment_map, container, false);


        return vue;
    }

    public void onMapReady(GoogleMap carte) {
        LatLng camera = new LatLng(48.851552, -67.537350);
        carte.moveCamera(CameraUpdateFactory.newLatLngZoom(camera,12));

        carte.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                FragmentCommentaire fragmentCommentaire = new FragmentCommentaire();
                fragmentCommentaire.setLatitudeLongitude(latLng);
                FragmentTransaction fragment = getFragmentManager().beginTransaction();
                fragment.replace(R.id.fragment_container, fragmentCommentaire);
                fragment.commit();

            }
        });
    }
}
