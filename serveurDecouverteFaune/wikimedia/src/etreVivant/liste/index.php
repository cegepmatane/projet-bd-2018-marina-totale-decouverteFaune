<?php 
	require_once "../../modele/EtreVivant.php";
	require_once"../../accesseur/EtreVivantDAOs.php";
	
	$etreVivantDAO = new EtreVivantDAOs();
	$listeEtreVivantXml = $etreVivantDAO->listerEtreVivantXml();
	header("Content-type: text/xml");
	echo $listeEtreVivantXml;