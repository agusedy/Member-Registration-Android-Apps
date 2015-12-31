<?php 
//Getting Id
 $id = $_GET['id'];
 
 //Importing database
 require_once('dbConnect.php');
 
 //Creating sql query
 $sql = "DELETE FROM anggota WHERE id=$id;";
 
 //Deleting record in database 
 if(mysqli_query($con,$sql)){
 echo 'Data Deleted Successfully';
 }else{
 echo 'Could Not Delete Data Try Again';
 }
 
 //closing connection 
 mysqli_close($con);
 ?>