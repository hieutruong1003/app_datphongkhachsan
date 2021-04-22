<?php
	include 'connect.php';

	$array = array();
	$query = "SELECT * FROM phong";
	$data = mysqli_query($conn, $query);

	while ($row = mysqli_fetch_assoc($data)) {
		
		array_push($array, new phong(
			$row['maphong'],
			$row['maks'],
			$row['loaiphong'],
			$row['vitriphong'],
			$row['giaphong'],
			$row['trangthai']
		));
	}
	$conn -> close();
	echo json_encode($array);
	class phong{
		function phong($maphong,$maks,$loaiphong,$vitriphong,$giaphong,$trangthai){
				$this -> maphong = $maphong;
				$this -> maks = $maks;
				$this -> loaiphong = $loaiphong;
				$this -> vitriphong = $vitriphong;
				$this -> giaphong = $giaphong;
				$this -> trangthai = $trangthai;
		}
	}
?>