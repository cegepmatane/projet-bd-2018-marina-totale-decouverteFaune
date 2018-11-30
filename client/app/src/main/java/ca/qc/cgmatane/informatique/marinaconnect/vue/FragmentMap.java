package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import ca.qc.cgmatane.informatique.marinaconnect.R;

public class FragmentMap extends Fragment implements OnMapReadyCallback {
    private static final String TAG = "fragmentMap";
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vue = inflater.inflate(R.layout.fragment_map, container, false);
        return vue;
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.carte_vue_ajout_commentaire);
        mapFragment.getMapAsync(FragmentMap.this);
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
