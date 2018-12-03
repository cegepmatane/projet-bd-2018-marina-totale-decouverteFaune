<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);
require_once (__DIR__ . '/vendor/autoload.php' );
$api = new \Mediawiki\Api\MediawikiApi( 'http://158.69.113.110/serveurDecouverteFaune/wikimedia/api.php' );
$api->login( new \Mediawiki\Api\ApiUser( 'webmestre', 'bdd2018Marina' ) );
$services = new \Mediawiki\Api\MediawikiFactory( $api );


/*$page = $services->newPageGetter()->getFromTitle( 'Phoque' );
print_r($page);*/
$newContent = new \Mediawiki\DataModel\Content( 'Test' );
$title = new \Mediawiki\DataModel\Title( 'Test' );
$identifier = new \Mediawiki\DataModel\PageIdentifier( $title );
$revision = new \Mediawiki\DataModel\Revision( $newContent, $identifier );
$services->newRevisionSaver()->save( $revision );



?>