package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;

import ca.qc.cgmatane.informatique.marinaconnect.R;

public class FragmentCommentaire extends Fragment {

    LatLng latitudeLongitude;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vue = inflater.inflate(R.layout.fragment_ajout_commentaire, container, false);
        System.out.println("LATLNG : " + latitudeLongitude);
        return vue;
    }

    public void setLatitudeLongitude(LatLng latLng){
        this.latitudeLongitude = latLng;
    }

}
