<?php
include_once "basededonnees.php";
class VoteDAO
{
    function recupererMoyenneVote($idCommentaire)
    {
        $MOYENNE = "SELECT (total_values / total_votes) AS moyenne from votes WHERE$idCommentaire = $idCommentaire";
        global $basededonnees;
        $requeteCalculerMoyenne = $basededonnees->prepare($MOYENNE);
        $requeteCalculerMoyenne->execute();
        return $requeteCalculerMoyenne->fetch(PDO::FETCH_OBJ);
    }
    function insererUnVote($idCommentaire,$vote)
    {
        global $basededonnees;
        $AJOUTER_UN_VOTE = "INSERT into votes$idCommentaire, total_votes, total_values) VALUES($idCommentaire,1, :totalValues)";
        $requeteAjouterVote = $basededonnees->prepare($AJOUTER_UN_VOTE);
        $requeteAjouterVote->bindParam('$idCommentaire', $idCommentaire, PDO::PARAM_STR);
        $requeteAjouterVote->bindParam(':totalValues', $vote, PDO::PARAM_STR);
        $requeteAjouterVote->execute();
    }
    
    function mettreAJourUneMoyenne($idCommentaire, $totalVote, $nombreVotes)
    {
        global $basededonnees;
        $MODIFIER_VOTE = "UPDATE votes SET total_values = '".$totalVote."', total_votes = '".$nombreVotes."' WHERE$idCommentaire = '".$idCommentaire."'";
        //echo $MODIFIER_APPARITION;
        $requeteModifierVote = $basededonnees->prepare($MODIFIER_VOTE);
        $requeteModifierVote->execute();
    }
    function recupererIdVote($idCommentaire)
    {
        $idCommentaire = "SELECT vote_id, total_votes, total_values from votes WHERE$idCommentaire = $idCommentaire";
        global $basededonnees;
        $requeteIdVote = $basededonnees->prepare($idCommentaire);
        $requeteIdVote->execute();
        return $requeteIdVote->fetch(PDO::FETCH_OBJ);
    }
}
?>