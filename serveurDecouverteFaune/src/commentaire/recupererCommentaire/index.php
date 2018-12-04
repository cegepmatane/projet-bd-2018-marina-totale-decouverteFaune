<?php

include "../../accesseur/CommentaireDAO.php";
$commentaireDAO = new CommentaireDAO();

$idCommentaire = $_GET["idCommentaire"];

$commentaires = $commentaireDAO->recupererCommentaire($idCommentaire);
?>
<?php

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<commentaires>
<?php
foreach($commentaires as $commentaire)
{
    ?>
    <commentaire>
        <textecom><?=$commentaire->textecom?></textecom>
        <idetrevivant><?=$commentaire->idetrevivant?></idetrevivant>
        <latitude><?=$commentaire->latitude?></latitude>
        <longitude><?=$commentaire->longitude?></longitude>
    </commentaire>
<?php
}
?>
</commentaires>