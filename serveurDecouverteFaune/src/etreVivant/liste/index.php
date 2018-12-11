<?php 

	include "../../accesseur/EtreVivantDAOMediaWiki.php";
	$etreVivantDAO = new EtreVivantDAOMediaWiki();
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
		<titre><?=($etreVivant->titre)?></titre>
		<description><?=($etreVivant->description)?></description>
	</etreVivant>
	<?php
}
?>
</etreVivants>


