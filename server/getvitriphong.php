<?php
	include 'connect.php';

	$array = array();
	$query = "SELECT DISTINCT vitriphong FROM phong";
	
	$data = mysqli_query($conn,$query);

	while ($row = mysqli_fetch_assoc($data)) {
		array_push($array, $row['vitriphong']);
	}
	sort($array);
	echo json_encode($array,true);
?>