 <?php
 
 include "../../accesseur/CommentaireDAO.php";
 $commentaireDAO = new CommentaireDAO();
 $commentaire->notecommentaire= $_GET['notecommentaire'];
 $commentaire->coordgpscommentaire= $_GET['coordgpscommentaire'];
 $commentaire->urlimagecomm= $_GET['urlimagecomm'];
 $commentaire->textcom= $_GET['textcom'];
 $commentaire-> idetrevivant= $_GET['idetrevivant'];
 
 $commentaireDAO->ajouterCommentaire($notecommentaire,$coordgpscommentaire,$urlimagecomm,$textcom,$idetrevivant);
 
 
 
 ?>
 <?php 
    header("Content-type: text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<actions>
    <action>
	    <type>ajouterCommentaire</type>
        <succes><?=$succes?></succes>
	    <message></message>
    </action>
</actions>