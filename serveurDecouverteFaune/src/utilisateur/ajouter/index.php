<?php

    include "../../accesseur/UtilisateurDAO.php";
    $utilisateurDAO = new UtilisateurDAO();

    $utilisateurTableau = $_POST;
    $utilisateur = new stdClass();

    $utilisateur->mail= $_GET['mail'];
    $utilisateur->mdp = $_GET['mdp'];

    $succes = $utilisateurDAO->ajouterUtilisateur($utilisateur);

?>
<?php 
    header("Content-type: text/xml");
    echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<actions>
    <action>
	    <type>ajouter</type>
        <succes><?=$succes?></succes>
	    <message></message>
    </action>
</actions>
