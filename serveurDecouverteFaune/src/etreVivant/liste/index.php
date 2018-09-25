<?php 

	include "../../accesseur/EtreVivantDAO.php";
	$etreVivantDAO = new EtreVivantDAO();
	//print_r($etreVivantDAO);
	$listeEtreVivant = $etreVivantDAO->listerEtreVivant();
	//print_r($listePensees);
	
?>
<?php

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<etreVivants>

<?php

foreach($listeEtreVivant as $etreVivant)
{
	?>
	<etreVivant>
		<categorie><?=($etreVivant->categorie)?></categorie>
		<urlwiki><?=($etreVivant->urlwiki)?></urlwiki>
		<urlimage><?=$etreVivant->urlimage?></urlimage>
		<espece><?=$etreVivant->espece?></espece>
		<id><?=$etreVivant->id?></id>
	</etreVivant>
	<?php
}
?>
</etreVivants>


