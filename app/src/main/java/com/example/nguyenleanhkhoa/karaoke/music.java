package com.example.nguyenleanhkhoa.karaoke;

/**
 * Created by nguyen le anh khoa on 04/02/2017.
 */

public class music {
    public String ma;
    public String ten;
    public String casi;
    public boolean thich;

    public music() {
    }

    public music(String ma, String ten, String casi, boolean thich) {
        this.ma = ma;
        this.ten = ten;
        this.casi = casi;
        this.thich = thich;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public boolean isThich() {
        return thich;
    }

    public void setThich(boolean thich) {
        this.thich = thich;
    }
}
