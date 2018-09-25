<?php
$host = "158.69.113.110";
$dbname = "marinaconnectdb";
//$credentials = "user=webMestre password=bdd2018Marina";
$utilisateur = 'webmestre';
$mdp = "bdd2018Marina";

//$db = pg_connect("$host $port $dbname $credentials");
$conn = new PDO('pgsql:host=localhost;port=5432;dbname=marinaconnectdb', $utilisateur, $mdp);

$sql = "SELECT * FROM etrevivant ";

$resultset = $conn->prepare($sql);

$resultset->execute();
while ($row = $resultset->fetch()) {
    
    echo '<p>' . $row[1] .'</p>' ;

    }

?>