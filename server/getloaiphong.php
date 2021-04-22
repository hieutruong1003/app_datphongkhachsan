<?php
	include 'connect.php';

	$array = array();
	$query = "SELECT DISTINCT loaiphong FROM phong";
	
	$data = mysqli_query($conn,$query);

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($array, $row['loaiphong']);
	}
	sort($array);
	echo json_encode($array,true);
?>