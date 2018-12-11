<?php
	include_once "baseDeDonnee.php";
	class UtilisateurDAO
	{

        function ajouterUtilisateur($utilisateur)
		{
			$SQL_AJOUTER_UTILISATEUR = "INSERT into utilisateur(mail, mdp) VALUES('$utilisateur->mail','$utilisateur->mdp')";
			
			global $basededonnees;
			
			$requeteAjouterUtilisateur = $basededonnees->prepare($SQL_AJOUTER_UTILISATEUR);
			$reussite = $requeteAjouterUtilisateur->execute();
			
			return $reussite;
			
		}
		
		function verifierConnection($utilisateur){	
			$SQL_VERIF_CONNECTION = "SELECT count(id) as nombre FROM utilisateur WHERE mail ='$utilisateur->mail' AND mdp ='$utilisateur->mdp';";
			global $basededonnees;
			$requeteVerifUtilisateur = $basededonnees->prepare($SQL_VERIF_CONNECTION);
			$requeteVerifUtilisateur->execute();
			return $requeteVerifUtilisateur->fetchAll(PDO::FETCH_OBJ);
		}
    }
?>