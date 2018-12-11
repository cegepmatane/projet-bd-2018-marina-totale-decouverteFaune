<?php
	include_once "baseDeDonnee.php";
	class EtreVivantDAOPostgre
	{
		function listerEtreVivant()
		{			
			$LISTER_ETRE_VIVANT = "SELECT * FROM etrevivant";
			global $basededonnees;
			$requeteListerEtreVivant = $basededonnees->prepare($LISTER_ETRE_VIVANT);
			$requeteListerEtreVivant->execute();
			return $requeteListerEtreVivant->fetchAll(PDO::FETCH_OBJ);
		}
		
		function ajoutEtreVivant($etreVivant){
			$SQL_AJOUTER_ETREVIVANT = "INSERT into etreVivant(espece) VALUES('$etreVivant->titre')";

			global $basededonnees;
			$requeteAjouterEtreVivant = $basededonnees->prepare($SQL_AJOUTER_ETREVIVANT);
			$reussite = $requeteAjouterEtreVivant->execute();
			echo($reussite);
			return $reussite;
			
		}
	}
?>