package ca.qc.cgmatane.informatique.marinaconnect.vue;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.qc.cgmatane.informatique.marinaconnect.R;

public class FragmentMap extends Fragment {
    private static final String TAG = "fragmentMap";

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View vue = inflater.inflate(R.layout.fragment_map, container, false);
        return vue;
    }
}
