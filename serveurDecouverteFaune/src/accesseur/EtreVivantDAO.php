<?php
	include_once "baseDeDonnee.php";
	class EtreVivantDAO
	{
		function listerEtreVivant()
		{			
			$LISTER_ETRE_VIVANT = "SELECT * FROM etrevivant";
			global $basededonnees;
			$requeteListerEtreVivant = $basededonnees->prepare($LISTER_ETRE_VIVANT);
			$requeteListerEtreVivant->execute();
			return $requeteListerEtreVivant->fetchAll(PDO::FETCH_OBJ);
		}
	}
?>