<?php
	$host = "localhost";
	$userName = "root";
	$passWord = "";
	$database = "appkhachsan";

	$conn = mysqli_connect($host,$userName,$passWord,$database);
	mysqli_query($conn,"SET NAMES 'utf8'");
?>