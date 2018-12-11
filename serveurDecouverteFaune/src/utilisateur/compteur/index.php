<?php

include "../../accesseur/UtilisateurDAO.php";
$utilisateurDAO = new UtilisateurDAO();

$utilisateur = new stdClass();

$utilisateur->mail = $_GET['mail'];
$utilisateur->mdp = $_GET['mdp'];
/*$utilisateur->nom = $utilisateurTableau ['pseudo'];
$utilisateur->mail = $utilisateurTableau ['mail'];
$utilisateur->mdp = $utilisateurTableau ['mdp'];*/
    
$compteur = $utilisateurDAO->verifierConnection($utilisateur);
?>
<?php 
header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>  
<compteurs>
<?php
    foreach ($compteur as $unCompteur) {
?>
    <compteur>
        <nombre><?=$unCompteur->nombre?></nombre>
    </compteur>
<?php
    }
?>
</compteurs>

