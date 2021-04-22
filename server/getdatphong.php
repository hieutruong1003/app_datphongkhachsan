<?php
	include 'connect.php';

	//$makh = $_POST['makh'];
	$makh = "187801779";
	$arrayName = array();
	$query = "SELECT * FROM datphong WHERE makh = "."'$makh'";
	$data = mysqli_query($conn,$query);

	while ($row = mysqli_fetch_assoc($data) ){
			$maphong = $row['maphong'];
			$selecPhong = "SELECT maks,vitriphong,loaiphong,giaphong FROM phong WHERE maphong="."'$maphong'";
			$dataPhong = mysqli_query($conn,$selecPhong);
			$rowPhong = mysqli_fetch_array($dataPhong);
			$maks = $rowPhong['maks'];

			$selecKhachSan = "SELECT tenks FROM khachsan WHERE maks="."'$maks'";
			$dataKhachSan = mysqli_query($conn,$selecKhachSan);
			$rowKS = mysqli_fetch_array($dataKhachSan);
			$tenks = $rowKS['tenks'];

			$vitriphong = $rowPhong['vitriphong'];
			$loaiphong = $rowPhong['loaiphong'];
			$giaphong = $rowPhong['giaphong'];
		array_push($arrayName, new lichsudatphong(
			$row['makh'],
			$row['maphong'],
			$tenks,$maks,$vitriphong,$loaiphong,$giaphong,
			$row['ngaydi'],
			$row['ngayden']));
	}

	echo json_encode($arrayName);

	class lichsudatphong{
		function lichsudatphong($makh,$maphong,$tenks,$maks,$vitriphong,$loaiphong,$giaphong,$ngayden,$ngaydi){
			$this -> makh = $makh;
			$this -> maphong = $maphong;
			$this -> vitriphong = $vitriphong;
			$this -> loaiphong = $loaiphong;
			$this -> tenks = $tenks;
			$this -> maks = $maks;
			$this -> giaphong = $giaphong;
			$this -> ngayden = $ngayden;
			$this -> ngaydi = $ngaydi;
		}
	}

?>