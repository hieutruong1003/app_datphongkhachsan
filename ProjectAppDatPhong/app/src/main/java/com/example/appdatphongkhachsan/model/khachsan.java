package com.example.appdatphongkhachsan.model;

import java.io.Serializable;

public class khachsan implements Serializable {
    private String maks;
    private String tenks;
    private String gia;
    private String sdt;
    private String email;
    private String diachi;
    private String hinhanh;
    private String mota;

    public khachsan(String maks, String tenks, String gia, String sdt, String email, String diachi, String hinhanh, String mota) {
        this.maks = maks;
        this.tenks = tenks;
        this.gia = gia;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.hinhanh = hinhanh;
        this.mota = mota;
    }

    public khachsan() {
        this.maks ="";
        this.tenks = "";
        this.sdt = "";
        this.email = "";
        this.diachi = "";
        this.hinhanh = "";
        this.mota = "";
        this.gia = "";
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaks() {
        return maks;
    }

    public void setMaks(String maks) {
        this.maks = maks;
    }

    public String getTenks() {
        return tenks;
    }

    public void setTenks(String tenks) {
        this.tenks = tenks;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
