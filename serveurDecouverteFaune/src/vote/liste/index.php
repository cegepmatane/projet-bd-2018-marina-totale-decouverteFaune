<?php

include "../../accesseur/VotesDAO.php";
$votesDAO = new VoteDAO();

$idCommentaire = $_GET["idCommentaire"];

$moyenne = $votesDAO->recupererMoyenneVote($idCommentaire);
?>
<?php

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<vote>
<moyenne><?=$moyenne?></moyenne>
</vote>