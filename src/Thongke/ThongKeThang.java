package Thongke;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class ThongKeThang {
    private double DoanhThu;
    private String Thang;
    private int SoSachTon;

    public ThongKeThang() {
    }

    public ThongKeThang(double DoanhThu, String Thang) {
        this.DoanhThu = DoanhThu;
        this.Thang = Thang;
    }

    public double getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(double DoanhThu) {
        this.DoanhThu = DoanhThu;
    }

    public String getThang() {
        return Thang;
    }

    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public int getSoSachTon() {
        return SoSachTon;
    }

    public void setSoSachTon(int SoSachTon) {
        this.SoSachTon = SoSachTon;
    }
}
