package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class HttpPostRequete extends AsyncTask<HttpURLConnection, Void, OutputStreamWriter>{
    @Override
    protected OutputStreamWriter doInBackground(HttpURLConnection... httpURLConnections) {
        HttpURLConnection connection = httpURLConnections[0];

        OutputStreamWriter envoyeur = null;
        try {
            OutputStream fluxEcriture = connection.getOutputStream();
            envoyeur = new OutputStreamWriter(fluxEcriture);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return envoyeur;
    }
}

