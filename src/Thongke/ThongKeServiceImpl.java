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
public class ThongKeServiceImpl implements ThongKeService{
    private ThongKeDAO thongKeDAO = null;
    public ThongKeServiceImpl() {
        thongKeDAO = new ThongKeDAOImpl();
    }
    
    @Override
    public List<SachBean> getListBySach() {
        return thongKeDAO.getListBySach();
    }

    @Override
    public List<ThongKeThang> getListByThongKeThang() {
        return thongKeDAO.getListByThongKeThang();
    }


    
}
