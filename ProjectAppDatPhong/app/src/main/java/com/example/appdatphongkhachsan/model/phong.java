package com.example.appdatphongkhachsan.model;

public class phong {
    private String maphong;
    private String maks;
    private String loaiphong;
    private String vitriphong;
    private String giaphong;
    private String trangthai;

    public phong(String maphong, String maks, String loaiphong, String vitriphong, String giaphong, String trangthai) {
        this.maphong = maphong;
        this.maks = maks;
        this.loaiphong = loaiphong;
        this.vitriphong = vitriphong;
        this.giaphong = giaphong;
        this.trangthai = trangthai;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getMaks() {
        return maks;
    }

    public void setMaks(String maks) {
        this.maks = maks;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public String getVitriphong() {
        return vitriphong;
    }

    public void setVitriphong(String vitriphong) {
        this.vitriphong = vitriphong;
    }

    public String getGiaphong() {
        return giaphong;
    }

    public void setGiaphong(String giaphong) {
        this.giaphong = giaphong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
