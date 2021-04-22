package com.example.appdatphongkhachsan.model;

public class LichSu {
    private String makh, maphong,tenks,maks,vitriphong,loaiphong,giaphong,ngayden,ngaydi;

    public LichSu(String makh, String maphong, String tenks, String maks, String vitriphong, String loaiphong, String giaphong, String ngayden, String ngaydi) {
        this.makh = makh;
        this.maphong = maphong;
        this.tenks = tenks;
        this.maks = maks;
        this.vitriphong = vitriphong;
        this.loaiphong = loaiphong;
        this.giaphong = giaphong;
        this.ngayden = ngayden;
        this.ngaydi = ngaydi;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getTenks() {
        return tenks;
    }

    public void setTenks(String tenks) {
        this.tenks = tenks;
    }

    public String getMaks() {
        return maks;
    }

    public void setMaks(String maks) {
        this.maks = maks;
    }

    public String getVitriphong() {
        return vitriphong;
    }

    public void setVitriphong(String vitriphong) {
        this.vitriphong = vitriphong;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public String getGiaphong() {
        return giaphong;
    }

    public void setGiaphong(String giaphong) {
        this.giaphong = giaphong;
    }

    public String getNgayden() {
        return ngayden;
    }

    public void setNgayden(String ngayden) {
        this.ngayden = ngayden;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }
}
