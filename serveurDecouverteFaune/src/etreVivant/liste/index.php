<?php 

	include "../../accesseur/EtreVivantDAOMediaWiki.php";
	include "../../accesseur/EtreVivantDAOPostgre.php";

	$etreVivantDAOMediaWiki = new EtreVivantDAOMediaWiki();
	//print_r($etreVivantDAO);
	$listeEtreVivant = $etreVivantDAOMediaWiki->listerEtreVivant();
	//print_r($listePensees);
	$etreVivantDAOPostgre = new EtreVivantDAOPostgre();
	$listeEtreVivantPostgre = $etreVivantDAOPostgre->listerEtreVivant();

	
?>
<?php

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<etreVivants>

<?php

foreach($listeEtreVivant as $etreVivant)
{
	foreach($listeEtreVivantPostgre as $etreVivantPostgre){
		if($etreVivant->titre == $etreVivantPostgre->espece){
	?>
			<etreVivant>
				<id><?=($etreVivantPostgre->id)?></id>
				<espece><?=($etreVivant->titre)?></espece>
				<description><?=($etreVivant->description)?></description>
			</etreVivant>
	<?php
		}
	}

}
?>
</etreVivants>


