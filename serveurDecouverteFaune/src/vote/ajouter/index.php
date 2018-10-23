<?php

include "../../accesseur/VotesDAO.php";
$voteDAO = new VotesDAO();
$cote = $_GET["cote"];
$idCommentaire = $_GET["idCommentaire"];

$commentaireMoyenne = $voteDAO->recupererMoyenneVote($idCommentaire);

if($commentaireMoyenne == null)
{
    $voteDAO->insererUnVote($idCommentaire,$cote);
}
else
{
  $votes = $voteDAO -> recupererIdVote($idCommentaire);
  $nouveauTotal = $votes["total_values"] + $cote;
  $nouveauNombre = $votes["total_votes"] + 1;
  $voteDAO->mettreAJourUneMoyenne($idCommentaire, $nouveauTotal, $nouveauNombre);
}







?>