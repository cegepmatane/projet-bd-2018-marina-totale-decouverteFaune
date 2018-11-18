<?php 

	include "../../accesseur/PositionsDAO.php";
	$positionsDAO = new PositionsDAO();
	//print_r($etreVivantDAO);
	$listerPositions = $positionsDAO->listerPositions();
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
		<longitude><?=($etreVivant->longitude)?></longitude>
		<latitude><?=($etreVivant->latitude)?></latitude>
		<idEtreVivant><?=$etreVivant->idEtreVivant?></idEtreVivant>
		<id><?=$etreVivant->id?></id>
	</position>
	<?php
}
?>
</positions>


