<?php 
 //Defining Constants
 //define('HOST','localhost');
// define('USER','root');
// define('PASS','');
// define('DB','androiddb');

    define('HOST','mysql.idhostinger.com');
	define('USER','u400916999_user');
	define('PASS','agusedyc');
	define('DB','u400916999_db');
 
 //Connecting to Database
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 ?>
	