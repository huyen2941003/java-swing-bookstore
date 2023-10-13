package Thongke;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.List;

/**
 *
 * @author Admin
 */
public interface ThongKeDAO {
    public List<SachBean> getListBySach();
    
    public List<ThongKeThang> getListByThongKeThang();
    
}
