<?php
	include_once "baseDeDonnee.php";
	class PositionsDAO
	{
		function listerPositions()
		{			
			$LISTER_POSITIONS = "SELECT * FROM position WHERE idEtreVivant";
			global $basededonnees;
			$requeteListerPositons = $basededonnees->prepare($LISTER_POSITIONS);
			$requeteListerPositons->execute();
			return $requeteListerPositons->fetchAll(PDO::FETCH_OBJ);
		}
	}
?>