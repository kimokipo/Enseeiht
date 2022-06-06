<?php

$user = 'Kamal';
$pass = '#m2I29br';

try {
    $db = new PDO ('mysql:host=82.165.100.213:3306;dbname=group_fb_lcc',$user,$pass);
}catch (PDOException $e) {
        print "Erreur :". $e->getMessage() . "<br/>";
        die;
}
