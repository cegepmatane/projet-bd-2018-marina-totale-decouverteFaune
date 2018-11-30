 <?php
 
 include "../../accesseur/CommentaireDAO.php";
 $commentaireDAO = new CommentaireDAO();
 $commentaire = new stdClass();

 $commentaire->notecommentaire= $_POST['notecommentaire'];
 $commentaire->coordgpscommentaire= $_POST['coordgpscommentaire'];
 $commentaire->urlimagecomm= $_POST['urlimagecomm'];
 $commentaire->textcom= $_POST['textcom'];
 $commentaire->idetrevivant= $_POST['idetrevivant'];
 
 $commentaireDAO->ajouterCommentaire($commentaire);
 
 
 
 ?>
