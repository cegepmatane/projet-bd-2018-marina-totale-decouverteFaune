<?php 

	include "../../accesseur/CommentaireDAO.php";
	$commentaireDAO = new CommentaireDAO();
	//print_r($etreVivantDAO);
	$listerCommentaire = $commentaireDAO->listerCommentaire();
	//print_r($listePensees);
	
?>
<?php

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<commentaires>

<?php

foreach($listerCommentaire as $commentaire)
{
	?>
	<commentaire>
		<notecommentaire><?=($commentaire->notecommentaire)?></notecommentaire>
		<coordgpscommentaire><?=($commentaire->coordgpscommentaire)?></coordgpscommentaire>
		<urlimagecomm><?=$commentaire->urlimagecomm?></urlimagecomm>
		<textecom><?=$commentaire->textecom?></textecom>
        <idetrevivant><?=$commentaire->idetrevivant?></idetrevivant>

		<id><?=$commentaire->id?></id>
	</commentaire>
	<?php
}
?>
</commentaires>


