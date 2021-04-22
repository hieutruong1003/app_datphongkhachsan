package com.example.appdatphongkhachsan.model;

public class menuapp {
    String img,title;
    public menuapp(String img, String title) {
        this.img = img;
        this.title = title;
    }
    public menuapp(){
        this.img = "";
        this.title = "";
    };
    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
