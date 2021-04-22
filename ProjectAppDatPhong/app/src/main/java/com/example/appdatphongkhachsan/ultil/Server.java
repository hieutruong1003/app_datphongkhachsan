package com.example.appdatphongkhachsan.ultil;

public class Server {
    public static String localhost = "192.168.56.1"; //"192.168.1.4";
    public static String DuongDanKhachSan = "http://"+ localhost + "/server/getkhachsan.php";
    public static String DuongDanLoaiPhong = "http://"+ localhost + "/server/getloaiphong.php";
    public static String DuongDanViTriPhong = "http://"+ localhost + "/server/getvitriphong.php";
    public static String DuongDanPhong = "http://"+ localhost + "/server/getphong.php";
    public static String DuongDanInsertKhachHang = "http://"+ localhost + "/server/insert_thongtinkhachhang.php";
    public static String DuongDanDatPhong = "http://"+ localhost + "/server/insert_datphong.php";
    public static String DuongDanLichSuPhong = "http://"+ localhost + "/server/getdatphong.php";
}
