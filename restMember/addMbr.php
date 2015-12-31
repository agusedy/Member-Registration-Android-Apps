<?php 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 
 //Getting values
 $nama = $_POST['nama'];
 $alamat = $_POST['alamat'];
 $nohp = $_POST['nohp'];
 
 //Creating an sql query
 $sql = "INSERT INTO anggota (nama,alamat,nohp) VALUES ('$nama','$alamat','$nohp')";
 
 //Importing our db connection script
 require_once('dbConnect.php');
 
 //Executing query to database
 if(mysqli_query($con,$sql)){
 echo 'Data Added Successfully';
 }else{
 echo 'Could Not Add Data';
 }
 
 //Closing the database 
 mysqli_close($con);
 }
 ?>