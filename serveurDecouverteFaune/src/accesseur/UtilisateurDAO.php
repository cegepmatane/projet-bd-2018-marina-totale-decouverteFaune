<?php
	include_once "baseDeDonnees.php";
	class UtilisateurDAO
	{

        function ajouterUtilisateur($utilisateur)
		{
			echo "ajouterUtilisateur()";
			print_r($utilisateur);
			
			$SQL_AJOUTER_UTILISATEUR = "INSERT into utilisateur(mail, mdp) VALUES('$utilisateur->mail','$utilisateur->mdp')";
			
			echo $SQL_AJOUTER_UTILISATEUR;
			global $basededonnees;
			print_r($basededonnees);
			
			$requeteAjouterUtilisateur = $basededonnees->prepare($SQL_AJOUTER_UTILISATEUR);
			$reussite = $requeteAjouterUtilisateur->execute();
			
			echo "Code erreur : " . $basededonnees->errorCode();
			echo "Erreurs : ";
			print_r($basededonnees->errorInfo());
			return $reussite;
			
		}
		
		/*function verifierConnection($utilisateur){
			$SQL_VERIF_CONNECTION = "SELECT count(utilisateur_id) as compteur FROM utilisateur WHERE pseudo ='$utilisateur->pseudo' AND mdp ='$utilisateur->mdp'";
			global $basededonnees;
			$requeteVerifUtilisateur = $basededonnees->prepare($SQL_VERIF_CONNECTION);
			$requeteVerifUtilisateur->execute();
			return $requeteListeUtilisateurs->fetchAll(PDO::FETCH_OBJ);
		}*/
    }
?>