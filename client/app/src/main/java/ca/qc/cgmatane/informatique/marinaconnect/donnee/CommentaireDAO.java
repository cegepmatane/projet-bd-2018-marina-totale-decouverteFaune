package ca.qc.cgmatane.informatique.marinaconnect.donnee;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import ca.qc.cgmatane.informatique.marinaconnect.modele.Commentaire;

public class CommentaireDAO implements CommentaireURL {
    private static  CommentaireDAO instance = null;
    protected  CommentaireDAO commentaire;

    public static CommentaireDAO getInstance() {
        if (null == instance)
            instance = new CommentaireDAO();
        return instance;
    }

    public  void ajouteCommentaireSQL(Commentaire commentaire){
        try {
            //String url = "http://158.69.113.110/serveurDecouverteFaune/src/commentaire/ajouter/index.php?notecommentaire" + commentaire.getNotecommentaire() + "coordgpscommentaire" + commentaire.getCoordgpscommentaire() + "urlimagecomm" + commentaire.getUrlimagecomm() + "textcom" + commentaire.getTextcom() + "idetrevivant" + commentaire.getIdetrevivant();
            URL urlAjouterCommentaire = new URL(URL_AJOUTER_COMMENTAIRE);
            HttpURLConnection connection = (HttpURLConnection) urlAjouterCommentaire.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            OutputStreamWriter envoyeur = new HttpPostRequete().execute(connection).get();

            /*envoyeur.write("noteCommentaire=" + commentaire.getNotecommentaire()
            + "&urlimagecomm=" + commentaire.getUrlimagecomm()
            + "&textcom=" + commentaire.getTextcom()
            + "&idetrevivant=" + commentaire.getIdetrevivant());*/
            envoyeur.write("textcom=" + commentaire.getTextcom()
                    + "&idetrevivant=" + commentaire.getIdetrevivant());

            Log.d("HELLO", "1 " + envoyeur);
            envoyeur.close();

            InputStream fluxLecture = new ServiceFluxDAO().execute(connection).get(); // NE PAS RETIRER NECESSAIRE AU FONCTIONNEMENT
            Log.d("HELLO", "2 " + fluxLecture);
            connection.disconnect();


            } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
