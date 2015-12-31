<?php 
if($_SERVER['REQUEST_METHOD']=='POST'){
 //Getting values 
 $id = $_POST['id'];
 $nama = $_POST['nama'];
 $alamat = $_POST['alamat'];
 $nohp = $_POST['nohp'];
 
 //importing database connection script 
 require_once('dbConnect.php');
 
 //Creating sql query 
 $sql = "UPDATE anggota SET nama = '$nama', alamat = '$alamat', nohp = '$nohp' WHERE id = $id;";
 
 //Updating database table 
 if(mysqli_query($con,$sql)){
 echo 'Data Updated Successfully';
 }else{
 echo 'Could Not Update Data Try Again';
 }
 
 //closing connection 
 mysqli_close($con);
 }
 ?>