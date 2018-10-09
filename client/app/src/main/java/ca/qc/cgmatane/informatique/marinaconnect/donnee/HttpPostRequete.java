package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpPostRequete extends AsyncTask<String, Void, String>{

    public static final String METHODE_REQUETE = "POST";
    public static final int TEMPS_LECTURE = 15000;
    public static final int TEMPS_CONNECTION = 15000;
    String xml = null;


    @Override
    protected String doInBackground(String... param) {

        String stringUrl = param[0];
        String derniereBalise = param[1];
        String resultat;
        String inputLine;
        InputStream flux;


        try {
            URL monUrl = new URL(stringUrl);

            //Creation de la connection
            HttpURLConnection connection = (HttpURLConnection) monUrl.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "text/xml");

            connection.setRequestMethod(METHODE_REQUETE);

            connection.setRequestProperty("Authorization", "someAuthString");

            flux = connection.getInputStream();

            Scanner lecteur = new Scanner(flux);
            lecteur.useDelimiter(derniereBalise);
            xml = lecteur.next() + derniereBalise;

        }catch(IOException e){
            e.printStackTrace();

        }
        return xml;
    }
}
