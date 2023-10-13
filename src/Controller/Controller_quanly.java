/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Bean.Danhmuc;
import bookshop.Nhanvien;
import bookshop.Nhaxuatban;
import bookshop.Tacgia;
import bookshop.Theloai;
import bookshop.Thongke;
import bookshop.Thongtinsach;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Huyen
 */
public class Controller_quanly {
    private JPanel root;
    private String kinSelected = "";
    
    private List<Danhmuc> listItem = null;
    
    public Controller_quanly(JPanel jpnRoot){
        this.root = jpnRoot;
    }
    
//    public void setView(JPanel jpnItem, JLabel jlbItem){
//        kinSelected = "Nhân viên";
//        
//        root.removeAll();
//        root.setLayout(new BorderLayout());
//        root.add(new Nhanvien());
//        root.validate();
//        root.repaint();
//    }
    
    public void setEvent(List<Danhmuc> listItem){
        this.listItem = listItem;
        for(Danhmuc item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind)
            {
                case "Nhân viên":
                    node = new Nhanvien();
                    break;
                case "Thống kê":
                    node = new Thongke();
                    break;
                default:
                    node = new Nhanvien();
                    break;
            }
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kinSelected = kind;
            jpnItem.setBackground(new Color(226,183,125));
            jlbItem.setBackground(new Color(226,183,125));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(226,183,125));
            jlbItem.setBackground(new Color(226,183,125));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kinSelected.equalsIgnoreCase(kind))
            {
                jpnItem.setBackground(new Color(255,255,255));
                jlbItem.setBackground(new Color(255,255,255));
            }
        }
        
        private void setChangeBackground(String kind)
        {
            for(Danhmuc item : listItem)
            {
                if(item.getKind().equalsIgnoreCase(kind))
                {
                    item.getJlb().setBackground(new Color(226,183,125));
                    item.getJpn().setBackground(new Color(226,183,125));
                }
                else{
                    item.getJlb().setBackground(new Color(255,255,255));
                    item.getJpn().setBackground(new Color(255,255,255));
                }
            }
        }
    }
}
