<?php
	include 'connect.php';

	$tenkh = $_POST['tenkh'];
	$cmnd = $_POST['cmnd'];
	$gioitinh = $_POST['gioitinh'];
	$sdt =$_POST['sdt'];
	$email =$_POST['email'];
	$diachi = $_POST['diachi'];

	$selectCMND = "SELECT makh FROM khachhang WHERE makh =".$cmnd;
	$dataKH = mysqli_query($conn,$selectCMND);
	if(mysqli_num_rows($dataKH)<=1){
		echo $cmnd;
	}else{
	if(strlen($tenkh) > 0 && $cmnd > 0 && strlen($gioitinh) > 0 && strlen($email) > 0
		&& $sdt > 0 && strlen($diachi) > 0){
		$query = "INSERT INTO khachhang(makh,tenkh,gioitinh,sdt,email,diachi) VALUES 
				 ('$cmnd','$tenkh','$gioitinh','$sdt','$email','$diachi')";
		if(mysqli_query($conn, $query)){
			echo $cmnd;
		}else{
			echo "Thất bại";
		}
	}
	}
?>