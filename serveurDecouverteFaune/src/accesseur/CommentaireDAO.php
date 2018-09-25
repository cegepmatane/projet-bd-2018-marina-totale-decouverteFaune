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
	}
?>