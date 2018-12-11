 <?php
  include "../../modele/EtreVivant.php";

 $etreVivant = new EtreVivant($_POST['espece'],$_POST['description']);

 include "../../accesseur/EtreVivantDAOMediaWiki.php";
 include "../../accesseur/EtreVivantDAOPostgre.php";
 
 $etreVivantDAOMediaWiki = new EtreVivantDAOMediaWiki();
 $etreVivantDAOPostgre = new EtreVivantDAOPostgre();

 /* $commentaire->notecommentaire= $_POST['notecommentaire'];
 $commentaire->urlimagecomm= $_POST['urlimagecomm']; */


 $etreVivantDAOPostgre->ajoutEtreVivant($etreVivant);

 $etreVivantDAOMediaWiki->ajouterEtreVivant($etreVivant);


 ?>
