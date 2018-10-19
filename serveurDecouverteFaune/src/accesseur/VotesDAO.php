<?php
include_once "basededonnees.php";
class VoteDAO
{
    function recupererMoyenneVote($idProduit)
    {
        $MOYENNE = "SELECT (total_values / total_votes) AS moyenne from votes WHERE idProduit = $idProduit";
        global $basededonnees;
        $requeteCalculerMoyenne = $basededonnees->prepare($MOYENNE);
        $requeteCalculerMoyenne->execute();
        return $requeteCalculerMoyenne->fetch(PDO::FETCH_OBJ);
    }
    function insererUnVote($idProduit,$vote)
    {
        global $basededonnees;
        $AJOUTER_UN_VOTE = "INSERT into votes(idProduit, total_votes, total_values) VALUES(:idProduit,1, :totalValues)";
        $requeteAjouterVote = $basededonnees->prepare($AJOUTER_UN_VOTE);
        $requeteAjouterVote->bindParam(':idProduit', $idProduit, PDO::PARAM_STR);
        $requeteAjouterVote->bindParam(':totalValues', $vote, PDO::PARAM_STR);
        $requeteAjouterVote->execute();
    }
    
    function mettreAJourUneMoyenne($idProduit, $totalVote, $nombreVotes)
    {
        global $basededonnees;
        $MODIFIER_VOTE = "UPDATE votes SET total_values = '".$totalVote."', total_votes = '".$nombreVotes."' WHERE idProduit = '".$idProduit."'";
        //echo $MODIFIER_APPARITION;
        $requeteModifierVote = $basededonnees->prepare($MODIFIER_VOTE);
        $requeteModifierVote->execute();
    }
    function recupererIdVote($idProduit)
    {
        $IDPRODUIT = "SELECT vote_id, total_votes, total_values from votes WHERE idProduit = $idProduit";
        global $basededonnees;
        $requeteIdVote = $basededonnees->prepare($IDPRODUIT);
        $requeteIdVote->execute();
        return $requeteIdVote->fetch(PDO::FETCH_OBJ);
    }
}
?>