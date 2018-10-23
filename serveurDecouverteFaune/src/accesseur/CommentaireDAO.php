<?php
	include_once "baseDeDonnee.php";
	class CommentaireDAO
	{
		function listerCommentaire()
		{			
			$LISTER_COMMENTAIRE = "SELECT * FROM commentaire";
			global $basededonnees;
			$requeteListerCommentaire = $basededonnees->prepare($LISTER_COMMENTAIRE);
			$requeteListerCommentaire->execute();
			return $requeteListerCommentaire->fetchAll(PDO::FETCH_OBJ);
		}
		 function ajouterCommentaire($commentaire)
		{
			$SQL_AJOUTER_COMMENTAIRE = "INSERT into commentaire(notecommentaire,coordgpscommentaire,urlimagecomm,textcom,idetrevivant) VALUES('$commentaire->notecommentaire','$commentaire->coordgpscommentaire','$commentaire->urlimagecomm','$commentaire->textcom','$commentaire->idetrevivant')";
			
			global $basededonnees;
			
			$requeteAjouterCommentaire = $basededonnees->prepare($SQL_AJOUTER_COMMENTAIRE);
			$reussite = $requeteAjouterCommentaire->execute();
			
			return $reussite;
			
		}
	}
?>