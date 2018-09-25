<?php 

	include "../../accesseur/PenseeDAO.php";
	$etreVivantDAO = new EtreVivantDAO();
	//print_r($etreVivantDAO);
	$listeEtreVivant = $etreVivantDAO->listerEtreVivant();
	print_r($listePensees);
	
?><?php 
