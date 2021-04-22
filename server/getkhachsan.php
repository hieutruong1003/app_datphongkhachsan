<?php
	include 'connect.php';

	$arraykhachsan = array();
	$query = "SELECT * FROM khachsan limit 0,10";

	$data = mysqli_query($conn, $query);

	while ($row = mysqli_fetch_assoc($data)) {
		$makhachsan = $row['maks'];
		$queryMaxGia = "SELECT MAX(giaphong) as max_gia from phong WHERE maks = "."'$makhachsan'";
		$queryMinGia = "SELECT MIN(giaphong) as min_gia from phong WHERE maks ="."'$makhachsan'";
		$max = mysqli_query($conn,$queryMaxGia);
		$min = mysqli_query($conn,$queryMinGia);

		$rowmin = mysqli_fetch_assoc($min);
		$rowmax = mysqli_fetch_assoc($max);

		$formatMin = number_format($rowmin['min_gia']);
		$formatMax = number_format($rowmax['max_gia']);
		$gia = "từ ". $formatMin. "VNĐ đến ". $formatMax. "VNĐ";
		
		array_push($arraykhachsan,new khachsan(
		$row['maks'],
		$row['tenks'],
		$gia,
		$row['sdt'],
		$row['email'],
		$row['diachi'],
		$row['hinhanh'],
		$row['mota']));
	}
	echo json_encode($arraykhachsan,true);
	$conn -> close();
	class khachsan{

		function khachsan($maks,$tenks,$gia,$sdt,$email,$diachi,$hinhanh,$mota){
			$this -> maks = $maks;
			$this -> tenks = $tenks;
			$this -> gia = $gia;
			$this -> sdt = $sdt;
			$this -> email = $email;
			$this -> diachi = $diachi;
			$this -> hinhanh = $hinhanh;
			$this -> mota = $mota;
		}
	}
?>