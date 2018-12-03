<?php 

	include "../../accesseur/CommentaireDAO.php";
	$commentaireDAO = new CommentaireDAO();
	//print_r($etreVivantDAO);
	$ID_ETRE_VIVANT = $_GET["idEtreVivant"];
	$listerPositions = $commentaireDAO->listerPositions($ID_ETRE_VIVANT);
	//print_r($listePensees);
	
?>
<?php

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<commentaires>

<?php

foreach($listerPositions as $commentaire)
{
	?>
	<commentaire>
		<longitude><?=($commentaire->longitude)?></longitude>
		<latitude><?=($commentaire->latitude)?></latitude>
		<idEtreVivant><?=$commentaire->idetrevivant?></idEtreVivant>
		<id><?=$commentaire->idCommentaire?></id>
	</commentaire>
	<?php
}
?>
</commentaires>


