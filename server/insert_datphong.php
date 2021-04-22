<?php
	include 'connect.php';

	$maks = $_POST['maks'];
	$vitriphong = $_POST['vitriphong'];
	$loaiphong = $_POST['loaiphong'];
	$soluong = $_POST['soluong'];
	$ngayden = $_POST['ngayden'];
	$ngaydi = $_POST['ngaydi'];
	$makh = $_POST['makh'];



	$selectPhong = "SELECT maphong  FROM phong WHERE maks = '$maks' AND vitriphong = '$vitriphong' AND loaiphong = '$loaiphong' LIMIT 0,".$soluong;
	$data = mysqli_query($conn,$selectPhong);

	while ($row = mysqli_fetch_array($data) ){
		$maphong = $row['maphong'];
		if(strlen($maphong) > 0 && strlen($makh) > 0 && strlen($ngayden) > 0 &&  strlen($ngaydi) > 0){
			$query = "INSERT INTO datphong(madp,makh,maphong,ngayden,ngaydi)
				  VALUES (null, '$makh','$maphong','$ngayden','$ngaydi')";
			$data1 = mysqli_query($conn,$query);
			if($data1){
				$updatePhong = "UPDATE phong set trangthai = '1' WHERE maphong = "."'$maphong'";
				mysqli_query($conn,$updatePhong);
			}
		}else{
			echo "0";
		}
	}
	if($data1){
		echo "1";
	}else{
		echo "0";
	}
?>