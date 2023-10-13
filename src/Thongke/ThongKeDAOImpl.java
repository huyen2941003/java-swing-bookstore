package Thongke;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import bookshop.ConnectDataBase;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
        
/**
 *
 * @author Admin
 */
public class ThongKeDAOImpl implements ThongKeDAO{
    ConnectDataBase db = new ConnectDataBase();
    Connection conn;
    @Override
    public List<SachBean> getListBySach() {
        try {
            conn = db.getConnection();
            String sql = "Select NgayBan, Sum(CTHDB.SoLuong) as 'SoLuong' from CTHDB inner join HoaDonBan on CTHDB.MaHoaDonBan = HoaDonBan.MaHoaDonBan group by NgayBan";
            List<SachBean> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                SachBean sachBean = new SachBean();
                sachBean.setNgayBan(rs.getString("NgayBan"));
                sachBean.setSoLuong(rs.getInt("SoLuong"));
                list.add(sachBean);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThongKeThang> getListByThongKeThang() {
        try {
            conn = db.getConnection();
            String sql = "SELECT MONTH(NgayBan) AS Thang, YEAR(NgayBan) AS Nam, SUM(CTHDB.SoLuong * Sach.GiaBan) AS TongThanhToan, Sum(CTHDB.SoLuong) as SachBanDuoc FROM HoaDonBan"
                    + " inner join CTHDB on CTHDB.MaHoaDonBan = HoaDonBan.MaHoaDonBan inner join Sach on Sach.MaSach = CTHDB.MaSach "
                    + "GROUP BY MONTH(ngayban), YEAR(ngayban)";
            List<ThongKeThang> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ThongKeThang thongKeThang = new ThongKeThang();
                thongKeThang.setDoanhThu(rs.getDouble("TongThanhToan"));
                thongKeThang.setSoSachTon(rs.getInt("SachBanDuoc"));
                thongKeThang.setThang(rs.getString("Thang") + " - " + rs.getString("Nam"));
                list.add(thongKeThang);
            } 
                           
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();   
        }
        return null;    
    }
    
}
