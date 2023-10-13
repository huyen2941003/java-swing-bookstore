package Thongke;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Admin
 */
public class SachBean {
    private String NgayBan;
    private int SoLuong;

    public SachBean() {
    }

    public SachBean(String NgayBan, int SoLuong) {
        this.NgayBan = NgayBan;
        this.SoLuong = SoLuong;
    }

    public String getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(String NgayBan) {
        this.NgayBan = NgayBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
