package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpGetRequete extends AsyncTask<String, Void, String> {

    public static final String METHODE_REQUETE = "GET";
    public static final int TEMPS_LECTURE = 15000;
    public static final int TEMPS_CONNECTION = 15000;
    private String xml = null;


    @Override
    protected String doInBackground(String... param) {
        String stringUrl = param[0];
        String delimiteur = param[1];
        String resultat;
        String inputLine;
        xml = recupererXML(stringUrl, delimiteur);

        if(null == xml)
            return null;

        return xml;

      /*  try{
            //Creation de l'objet URL
            URL monUrl = new URL(stringUrl);

            //Creation de la connection
            HttpURLConnection connection = (HttpURLConnection) monUrl.openConnection();


            connection.setRequestMethod(METHODE_REQUETE);
            connection.setReadTimeout(TEMPS_LECTURE);
            connection.setConnectTimeout(TEMPS_CONNECTION);
            //Connection a l'url
            connection.connect();

            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());

            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);
            }

            reader.close();
            streamReader.close();

            resultat = stringBuilder.toString();

        }catch (IOException e){
            e.printStackTrace();
            resultat = null;
        }
        return resultat;*/

    }

    protected void onPostExecute(String result){
        super.onPostExecute(result);
    }

    private String recupererXML(String stringUrlXML, String delimiteur){
        try{
            URL urlXML = new URL(stringUrlXML);
            InputStream flux = urlXML.openConnection().getInputStream();
            Scanner lecteur = new Scanner(flux).useDelimiter(delimiteur);
            xml = lecteur.next() + delimiteur;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xml;
    }


}
