package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class ServiceFluxDAO  extends AsyncTask<HttpURLConnection, Void, InputStream> {

    @Override
    protected InputStream doInBackground(HttpURLConnection... httpURLConnections) {
        HttpURLConnection connection = httpURLConnections[0];
        InputStream fluxLecture = null;

        try {
            fluxLecture = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fluxLecture;
    }
}
