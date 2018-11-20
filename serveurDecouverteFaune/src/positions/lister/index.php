<?php 

	include "../../accesseur/PositionsDAO.php";
	$positionsDAO = new PositionsDAO();
	//print_r($etreVivantDAO);
	$ID_ETRE_VIVANT = $_GET["idEtreVivant"];
	$listerPositions = $positionsDAO->listerPositions($ID_ETRE_VIVANT);
	//print_r($listePensees);
	
?>
<?php

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<positions>

<?php

foreach($listerPositions as $position)
{
	?>
	<position>
		<longitude><?=($position->longitude)?></longitude>
		<latitude><?=($position->latitude)?></latitude>
		<idEtreVivant><?=$position->idEtreVivant?></idEtreVivant>
		<id><?=$position->id?></id>
	</position>
	<?php
}
?>
</positions>


