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

		function listerPositions($idEtreVivant){
			$LISTER_POSITIONS = 'SELECT * FROM commentaire WHERE "idetrevivant" = ' . $idEtreVivant;
			global $basededonnees;
			$requeteListerPositons = $basededonnees->prepare($LISTER_POSITIONS);
			$requeteListerPositons->execute();
			return $requeteListerPositons->fetchAll(PDO::FETCH_OBJ);

		}


		 function ajouterCommentaire($commentaire)
		{
			//$SQL_AJOUTER_COMMENTAIRE = "INSERT into commentaire(notecommentaire,urlimagecomm,textcom,idetrevivant) VALUES('$commentaire->notecommentaire','$commentaire->coordgpscommentaire','$commentaire->urlimagecomm','$commentaire->textcom','$commentaire->idetrevivant')";
			$SQL_AJOUTER_COMMENTAIRE = "INSERT into commentaire(textecom,idetrevivant,latitude,longitude) VALUES('$commentaire->textcom',$commentaire->idetrevivant,'$commentaire->latitude', '$commentaire->longitude')";

			global $basededonnees;
			$requeteAjouterCommentaire = $basededonnees->prepare($SQL_AJOUTER_COMMENTAIRE);
			$reussite = $requeteAjouterCommentaire->execute();
			echo($reussite);

			return $reussite;
			
		}

		function recupererCommentaire($idCommentaire)
		{			
			$RECUPERER_COMMENTAIRE = 'SELECT * FROM commentaire WHERE "idCommentaire" ='. $idCommentaire;
			global $basededonnees;
			$requeteRecupererCommentaire = $basededonnees->prepare($RECUPERER_COMMENTAIRE);
			$requeteRecupererCommentaire->execute();
			return $requeteRecupererCommentaire->fetchAll(PDO::FETCH_OBJ);
		}
	}
?>