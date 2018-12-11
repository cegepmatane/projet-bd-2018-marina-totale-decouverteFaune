<?php
require_once "AccesMediawiki.php";
require_once __DIR__ ."/../modele/EtreVivant.php";

	class EtreVivantDAOMediaWiki
	{
		function listerEtreVivant()
		{	
			global $services;
			$page = $services->newPageGetter()->getFromTitle( 'Liste des Animaux Marins' );
			//echo $page->getTitle()->getText();
			//echo($page->getRevisions()->getLatest()->getContent()->getData());
			//print_r ($page);
			//return $page;
			//$pageUnAnimal =$services->
			$listeTitrePageDansContenu = $this->recupererListeTitrePageDansContenu($page->getRevisions()->getLatest()->getContent()->getData(),"[[","]]");
			/*echo '<pre>';
			var_dump ($listeTitrePageDansContenu);
			echo '</pre>';*/ 
			$listeEtreVivant = [];
			foreach ($listeTitrePageDansContenu as $titrePageDansContenu)
			{
				//echo $titrePageDansContenu;
				$listeEtreVivant[]= $this->obtenirEtreVivant($titrePageDansContenu);
				
			}
			
			return $listeEtreVivant;
		}
		private function recupererListeTitrePageDansContenu($str,$start,$end)
		{
			$p1 = explode($start,$str);
			for($i=1;$i<count($p1);$i++)
			{
				$p2 = explode($end,$p1[$i]);
				$p[] = $p2[0];
			}
			return $p;
		}
		function obtenirEtreVivant($titre)
		{
			global $services;
			$page = $services->newPageGetter()->getFromTitle( $titre );
			$page->getRevisions()->getLatest()->getContent()->getData();
			$titre = $page->getTitle()->getText();
			$description = $page->getRevisions()->getLatest()->getContent()->getData() ;
			$etreVivant = new EtreVivant($titre,$description);
			return $etreVivant;
			
			
		}
		/*public function listerEtreVivantXml()
		{
			$listeEtreVivant = $this->listerEtreVivant();
			$listeEtreVivantXml ='<?xml version="1.0" encoding="UTF-8"?>' . "<etreVivants>";
			foreach ($listeEtreVivant as $etreVivant)
			{
				$listeEtreVivantXml .= 
					"<etreVivant>".
					"<titre>". $etreVivant->titre . "</titre>" . 
					"<contenu>". $etreVivant->contenu . "</contenu>" .
					"</etreVivant>";
			}
			$listeEtreVivantXml .= "</etreVivants>";
			return $listeEtreVivantXml;
		}*/
		function ajouterEtreVivant($etreVivant)
		{
			global $services;
			echo ($etreVivant->titre);
			$description = new \Mediawiki\DataModel\Content( $etreVivant->description );
			$titre = new \Mediawiki\DataModel\Title( $etreVivant->titre );
			$identifier = new \Mediawiki\DataModel\PageIdentifier( $titre );
			$revision = new \Mediawiki\DataModel\Revision( $description, $identifier );
			$page = $services->newPageGetter()->getFromTitle( 'Liste des Animaux Marins' );
			$services->newRevisionSaver()->save( $revision );
			$contenuOriginal = $page->getRevisions()->getLatest()->getContent()->getData();
			$nouveauContenu = $contenuOriginal . " [[$etreVivant->titre]] <br/>";
			$description = new \Mediawiki\DataModel\Content( $nouveauContenu);
			$revision = new \Mediawiki\DataModel\Revision( $description, $page->getPageIdentifier('Liste des Animaux Marins') );
			$services->newRevisionSaver()->save( $revision );


			
		}


		
	}
?>