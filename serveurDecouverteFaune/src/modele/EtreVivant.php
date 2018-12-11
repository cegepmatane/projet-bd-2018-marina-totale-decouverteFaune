<?php
class EtreVivant{
	public  $titre;
	public  $description;
	public 	$id;
	function __construct($titre,$description)	
	{
		$this->titre = $titre;
		$this->description = $description;
	}

	
	function getTitre(){
		return $this->titre ;
	}
	
	function setTitre($titre){
		$this->titre = $titre;
	}
	
	
	function getDescription(){
		return $this->$description ;
	}
	
	function setDescription($description){
		$this->description = $description;
	}
	
	function getId(){
		return $this->id ;
	}
	
	function setId($id){
		$this->id = $id;
		
	}
	
}


?>