/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bookshop;

import Thongke.QuanLyThongKeController;
import java.awt.HeadlessException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huyen
 */
public class Thongke extends javax.swing.JPanel {

    ConnectDataBase db = new ConnectDataBase();
    Connection conn;
    /**
     * Creates new form Thongke
     */
    public Thongke() {
        initComponents();
        LoadDataCmb();
        HienThi1();
        HienThi2();
        txt_thanhtoannhap.setEnabled(false);
        txt_thanhtoanban.setEnabled(false);
    }
    public void LoadDataCmb(){
        conn =  db.getConnection();
        String query1 = "Select * from Sach";
        try{
            PreparedStatement ps = conn.prepareStatement(query1);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                this.cmb_sachnhap.addItem(rs.getString("TenSach"));
                this.cmb_sachban.addItem(rs.getString("TenSach"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e, "Lỗi",1);
        }
    }
    private  void loadLai1(){
        txt_mahdn.setText("");
        cmb_sachnhap.setSelectedIndex(0);
        txt_soluongnhap.setText("");
        cbb_Ngay.setSelectedIndex(1);
        cbb_Thang.setSelectedIndex(1);
        cbb_Nam.setSelectedIndex(20);
        txt_thanhtoannhap.setText("");
    }
    
    private  void loadLai2(){
        txt_mahdb.setText("");
        cmb_sachban.setSelectedIndex(0);
        txt_soluongban.setText("");
        cbb_Ngay1.setSelectedIndex(1);
        cbb_Thang1.setSelectedIndex(1);
        cbb_Nam1.setSelectedIndex(20);
        txt_thanhtoanban.setText("");
    }
    
    public void HienThi1(){
        conn =  db.getConnection();

        try {
            Statement st =  conn.createStatement();
            String query = "SELECT HoaDonNhap.MaHoaDonNhap, CTHDN.MaSach, CTHDN.SoLuong, HoaDonNhap.NgayNhap, HoaDonNhap.TongThanhToanHoaDon\n" +
                            "FROM HoaDonNhap\n" +
                            "INNER JOIN CTHDN ON HoaDonNhap.MaHoaDonNhap = CTHDN.MaHoaDonNhap";
            ResultSet rs =  st.executeQuery(query);
            DefaultTableModel model  = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
            {
                model.addColumn(metaData.getColumnLabel(columnIndex));
            }
            while(rs.next()) 
            {
                Object[] rowData = new Object[columnCount];
                for(int i=0; i<columnCount; i++) 
                {
                    rowData[i] = rs.getObject(i + 1); 
                }
                model.addRow(rowData);
            }
            table_Hoadonnhap.setModel(model);
            st.close();
            rs.close();
            conn.close();
	} catch (SQLException e1) {
            e1.toString();
	}
    }
    
    public void HienThi2(){
        conn =  db.getConnection();

        try {
            Statement st =  conn.createStatement();
            String query = "SELECT HoaDonBan.MaHoaDonBan, CTHDB.MaSach, CTHDB.SoLuong, HoaDonBan.NgayBan, HoaDonBan.TongThanhToanHoaDon\n" +
                            "FROM HoaDonBan\n" +
                            "INNER JOIN CTHDB ON HoaDonBan.MaHoaDonBan = CTHDB.MaHoaDonBan";
            ResultSet rs =  st.executeQuery(query);
            DefaultTableModel model  = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
            {
                model.addColumn(metaData.getColumnLabel(columnIndex));
            }
            while(rs.next()) 
            {
                Object[] rowData = new Object[columnCount];
                for(int i=0; i<columnCount; i++) 
                {
                    rowData[i] = rs.getObject(i + 1); 
                }
                model.addRow(rowData);
            }
            table_Hoadonban.setModel(model);
            st.close();
            rs.close();
            conn.close();
	} catch (SQLException e1) {
            e1.toString();
	}
    }
    public void HienThi3(){
        conn =  db.getConnection();
        try {
            Statement st =  conn.createStatement();
            String query = "Select * from HoaDonNhap";
            ResultSet rs =  st.executeQuery(query);
            DefaultTableModel model  = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
            {
                model.addColumn(metaData.getColumnLabel(columnIndex));
            }
            while(rs.next()) 
            {
                Object[] rowData = new Object[columnCount];
                for(int i=0; i<columnCount; i++) 
                {
                    rowData[i] = rs.getObject(i + 1); 
                }
                model.addRow(rowData);
            }
            table_hdn.setModel(model);
            st.close();
            rs.close();
            conn.close();
	} catch (SQLException e1) {
            e1.toString();
	}
        
        conn =  db.getConnection();
        try {
            Statement st =  conn.createStatement();
            String query = "Select * from HoaDonBan";
            ResultSet rs =  st.executeQuery(query);
            DefaultTableModel model  = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) 
            {
                model.addColumn(metaData.getColumnLabel(columnIndex));
            }
            while(rs.next()) 
            {
                Object[] rowData = new Object[columnCount];
                for(int i=0; i<columnCount; i++) 
                {
                    rowData[i] = rs.getObject(i + 1); 
                }
                model.addRow(rowData);
            }
            table_hdb.setModel(model);
            st.close();
            rs.close();
            conn.close();
	} catch (SQLException e1) {
            e1.toString();
	}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Hoadonnhap = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txt_mahdn = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_soluongnhap = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_thanhtoannhap = new javax.swing.JTextField();
        btn_Suanhap = new javax.swing.JButton();
        btn_Xoanhap = new javax.swing.JButton();
        btn_resetnhap = new javax.swing.JButton();
        btn_timkiemnhap = new javax.swing.JButton();
        txt_timkiemnhap = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cmb_sachnhap = new javax.swing.JComboBox<>();
        cbb_Nam = new javax.swing.JComboBox<>();
        cbb_Ngay = new javax.swing.JComboBox<>();
        cbb_Thang = new javax.swing.JComboBox<>();
        btn_tinhnhap = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Hoadonban = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        txt_mahdb = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_soluongban = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_thanhtoanban = new javax.swing.JTextField();
        btn_tinhban = new javax.swing.JButton();
        btn_Suaban = new javax.swing.JButton();
        btn_Xoaban = new javax.swing.JButton();
        btn_resetban = new javax.swing.JButton();
        btn_timkiemban = new javax.swing.JButton();
        txt_timkiemban = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cmb_sachban = new javax.swing.JComboBox<>();
        cbb_Ngay1 = new javax.swing.JComboBox<>();
        cbb_Thang1 = new javax.swing.JComboBox<>();
        cbb_Nam1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jpnView1 = new javax.swing.JPanel();
        jpnView2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_hdb = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_hdn = new javax.swing.JTable();
        txt_mahoadonxoa = new javax.swing.JTextField();
        btn_xoa = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        table_Hoadonnhap.setBackground(new java.awt.Color(255, 255, 255));
        table_Hoadonnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_Hoadonnhap.setForeground(new java.awt.Color(0, 0, 0));
        table_Hoadonnhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_Hoadonnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HoadonnhapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Hoadonnhap);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Sách:");

        txt_mahdn.setBackground(new java.awt.Color(255, 255, 255));
        txt_mahdn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_mahdn.setForeground(new java.awt.Color(0, 0, 0));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Mã Hóa đơn:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Số lượng:");

        txt_soluongnhap.setBackground(new java.awt.Color(255, 255, 255));
        txt_soluongnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_soluongnhap.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Ngày nhập:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/thong_ke.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("THANH TOÁN");

        txt_thanhtoannhap.setBackground(new java.awt.Color(255, 255, 255));
        txt_thanhtoannhap.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_thanhtoannhap.setForeground(new java.awt.Color(0, 0, 0));

        btn_Suanhap.setBackground(new java.awt.Color(255, 255, 255));
        btn_Suanhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Suanhap.setForeground(new java.awt.Color(0, 0, 0));
        btn_Suanhap.setText("Sửa");
        btn_Suanhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuanhapActionPerformed(evt);
            }
        });

        btn_Xoanhap.setBackground(new java.awt.Color(255, 255, 255));
        btn_Xoanhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Xoanhap.setForeground(new java.awt.Color(0, 0, 0));
        btn_Xoanhap.setText("Xóa");
        btn_Xoanhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoanhapActionPerformed(evt);
            }
        });

        btn_resetnhap.setBackground(new java.awt.Color(255, 255, 255));
        btn_resetnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_resetnhap.setForeground(new java.awt.Color(0, 0, 0));
        btn_resetnhap.setText("Reset");
        btn_resetnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetnhapActionPerformed(evt);
            }
        });

        btn_timkiemnhap.setBackground(new java.awt.Color(255, 255, 255));
        btn_timkiemnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_timkiemnhap.setForeground(new java.awt.Color(0, 0, 0));
        btn_timkiemnhap.setText("Tìm kiếm");
        btn_timkiemnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemnhapActionPerformed(evt);
            }
        });

        txt_timkiemnhap.setBackground(new java.awt.Color(255, 255, 255));
        txt_timkiemnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_timkiemnhap.setForeground(new java.awt.Color(0, 0, 0));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Tìm kiếm:");

        cmb_sachnhap.setBackground(new java.awt.Color(255, 255, 255));
        cmb_sachnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_sachnhap.setForeground(new java.awt.Color(0, 0, 0));

        cbb_Nam.setBackground(new java.awt.Color(255, 255, 255));
        cbb_Nam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbb_Nam.setForeground(new java.awt.Color(0, 0, 0));
        cbb_Nam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbb_Ngay.setBackground(new java.awt.Color(255, 255, 255));
        cbb_Ngay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbb_Ngay.setForeground(new java.awt.Color(0, 0, 0));
        cbb_Ngay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbb_Thang.setBackground(new java.awt.Color(255, 255, 255));
        cbb_Thang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbb_Thang.setForeground(new java.awt.Color(0, 0, 0));
        cbb_Thang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbb_Thang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_ThangItemStateChanged(evt);
            }
        });
        cbb_Thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_ThangActionPerformed(evt);
            }
        });

        btn_tinhnhap.setBackground(new java.awt.Color(255, 255, 255));
        btn_tinhnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_tinhnhap.setForeground(new java.awt.Color(0, 0, 0));
        btn_tinhnhap.setText("Tính");
        btn_tinhnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tinhnhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_soluongnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_mahdn, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmb_sachnhap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbb_Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbb_Thang, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(59, 59, 59))))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_resetnhap, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                        .addComponent(btn_tinhnhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_Suanhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_Xoanhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(txt_thanhtoannhap, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel23))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timkiemnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timkiemnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mahdn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cmb_sachnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soluongnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbb_Ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_Thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_thanhtoannhap, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Suanhap)
                                    .addComponent(btn_tinhnhap)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_resetnhap)
                            .addComponent(btn_Xoanhap))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_timkiemnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemnhap))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Hóa đơn nhập", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        table_Hoadonban.setBackground(new java.awt.Color(255, 255, 255));
        table_Hoadonban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_Hoadonban.setForeground(new java.awt.Color(0, 0, 0));
        table_Hoadonban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_Hoadonban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_HoadonbanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_Hoadonban);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Sách:");

        txt_mahdb.setBackground(new java.awt.Color(255, 255, 255));
        txt_mahdb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_mahdb.setForeground(new java.awt.Color(0, 0, 0));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Mã Hóa đơn:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Số lượng:");

        txt_soluongban.setBackground(new java.awt.Color(255, 255, 255));
        txt_soluongban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_soluongban.setForeground(new java.awt.Color(0, 0, 0));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Ngày bán:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/thong_ke.png"))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("THANH TOÁN");

        txt_thanhtoanban.setBackground(new java.awt.Color(255, 255, 255));
        txt_thanhtoanban.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_thanhtoanban.setForeground(new java.awt.Color(0, 0, 0));

        btn_tinhban.setBackground(new java.awt.Color(255, 255, 255));
        btn_tinhban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_tinhban.setForeground(new java.awt.Color(0, 0, 0));
        btn_tinhban.setText("Tính");
        btn_tinhban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tinhbanActionPerformed(evt);
            }
        });

        btn_Suaban.setBackground(new java.awt.Color(255, 255, 255));
        btn_Suaban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Suaban.setForeground(new java.awt.Color(0, 0, 0));
        btn_Suaban.setText("Sửa");
        btn_Suaban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuabanActionPerformed(evt);
            }
        });

        btn_Xoaban.setBackground(new java.awt.Color(255, 255, 255));
        btn_Xoaban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Xoaban.setForeground(new java.awt.Color(0, 0, 0));
        btn_Xoaban.setText("Xóa");
        btn_Xoaban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoabanActionPerformed(evt);
            }
        });

        btn_resetban.setBackground(new java.awt.Color(255, 255, 255));
        btn_resetban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_resetban.setForeground(new java.awt.Color(0, 0, 0));
        btn_resetban.setText("Reset");
        btn_resetban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetbanActionPerformed(evt);
            }
        });

        btn_timkiemban.setBackground(new java.awt.Color(255, 255, 255));
        btn_timkiemban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_timkiemban.setForeground(new java.awt.Color(0, 0, 0));
        btn_timkiemban.setText("Tìm kiếm");
        btn_timkiemban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiembanActionPerformed(evt);
            }
        });

        txt_timkiemban.setBackground(new java.awt.Color(255, 255, 255));
        txt_timkiemban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_timkiemban.setForeground(new java.awt.Color(0, 0, 0));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Tìm kiếm:");

        cmb_sachban.setBackground(new java.awt.Color(255, 255, 255));
        cmb_sachban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_sachban.setForeground(new java.awt.Color(0, 0, 0));

        cbb_Ngay1.setBackground(new java.awt.Color(255, 255, 255));
        cbb_Ngay1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbb_Ngay1.setForeground(new java.awt.Color(0, 0, 0));
        cbb_Ngay1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbb_Thang1.setBackground(new java.awt.Color(255, 255, 255));
        cbb_Thang1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbb_Thang1.setForeground(new java.awt.Color(0, 0, 0));
        cbb_Thang1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbb_Thang1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_Thang1ItemStateChanged(evt);
            }
        });
        cbb_Thang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_Thang1ActionPerformed(evt);
            }
        });

        cbb_Nam1.setBackground(new java.awt.Color(255, 255, 255));
        cbb_Nam1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbb_Nam1.setForeground(new java.awt.Color(0, 0, 0));
        cbb_Nam1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_soluongban, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_mahdb, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmb_sachban, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbb_Ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbb_Thang1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbb_Nam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(59, 59, 59))))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_tinhban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_resetban, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_Suaban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_Xoaban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(txt_thanhtoanban, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel27))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_timkiemban, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timkiemban, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mahdb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(cmb_sachban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soluongban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbb_Ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbb_Thang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbb_Nam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel26))
                        .addGap(60, 60, 60))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_thanhtoanban, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_tinhban)
                                    .addComponent(btn_Suaban)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_resetban)
                            .addComponent(btn_Xoaban))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txt_timkiemban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemban))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hóa đơn bán", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));

        jpnView1.setBackground(new java.awt.Color(255, 255, 255));
        jpnView1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jpnView1Layout = new javax.swing.GroupLayout(jpnView1);
        jpnView1.setLayout(jpnView1Layout);
        jpnView1Layout.setHorizontalGroup(
            jpnView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jpnView1Layout.setVerticalGroup(
            jpnView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jpnView2.setBackground(new java.awt.Color(255, 255, 255));
        jpnView2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jpnView2Layout = new javax.swing.GroupLayout(jpnView2);
        jpnView2.setLayout(jpnView2Layout);
        jpnView2Layout.setHorizontalGroup(
            jpnView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnView2Layout.setVerticalGroup(
            jpnView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jpnView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Thống kê", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Hóa Đơn Bán");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Hóa Đơn Nhập");

        table_hdb.setBackground(new java.awt.Color(255, 255, 255));
        table_hdb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_hdb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_hdbMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_hdb);

        table_hdn.setBackground(new java.awt.Color(255, 255, 255));
        table_hdn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_hdn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_hdnMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_hdn);

        txt_mahoadonxoa.setBackground(new java.awt.Color(255, 255, 255));
        txt_mahoadonxoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_mahoadonxoa.setForeground(new java.awt.Color(0, 0, 0));

        btn_xoa.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(0, 0, 0));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mahoadonxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_xoa))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mahoadonxoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Xóa Hóa Đơn", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void btn_timkiembanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiembanActionPerformed
        // TODO add your handling code here:
        conn = db.getConnection();
        try {
            if(txt_timkiemban.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn cần nhập tên mã hóa đơn 'Nhập thông tin tìm kiếm'");
            }else{
                PreparedStatement ps = conn.prepareStatement("SELECT HoaDonBan.MaHoaDonBan, CTHDB.MaSach, CTHDB.SoLuong, HoaDonBan.NgayBan, HoaDonBan.TongThanhToanHoaDon\n" +
                            "FROM HoaDonBan\n" +
                            "INNER JOIN CTHDB ON HoaDonBan.MaHoaDonBan = CTHDB.MaHoaDonBan where HoaDonBan.MaHoaDonBan like ?");
                ps.setNString(1, "%" + txt_timkiemban.getText() + "%");
                ResultSet rs = ps.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table_Hoadonban.getModel();
                model.setRowCount(0);
                while (rs.next()) {
                    Object[] rowData = {rs.getString("MaHoaDonBan"), rs.getString("MaSach"), rs.getString("SoLuong"),
                        rs.getString("NgayBan"), rs.getString("TongThanhToanHoaDon")};
                    model.addRow(rowData);
                }

                if (model.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " hóa đơn mà bạn muốn tìm!");
                } else {
                    JOptionPane.showMessageDialog(this, "Không có hóa đơn nào!");
                }

                conn.close();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_timkiembanActionPerformed

    private void btn_resetbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetbanActionPerformed
        // TODO add your handling code here:
        txt_mahdb.setText("");
        cmb_sachban.setSelectedIndex(0);
        txt_soluongban.setText("");
        cbb_Ngay1.setSelectedIndex(0);
        cbb_Thang1.setSelectedIndex(0);
        cbb_Nam1.setSelectedIndex(0);
        txt_thanhtoanban.setText("");
        txt_timkiemban.setText("");
        
        txt_mahdb.setEnabled(true);
        btn_tinhban.setEnabled(true);
        cmb_sachban.setEnabled(true);
        cbb_Ngay1.setEnabled(true);
        cbb_Thang1.setEnabled(true);
        cbb_Nam1.setEnabled(true);
    }//GEN-LAST:event_btn_resetbanActionPerformed

    private void btn_XoabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoabanActionPerformed
        // TODO add your handling code here:
        conn =  db.getConnection();
        String masach = (String) cmb_sachban.getSelectedItem();
        try {
            PreparedStatement ps = conn.prepareStatement("Delete from CTHDB where MaHoaDonBan = ? and MaSach = (Select MaSach from Sach Where TenSach = ?) ");
            ps.setNString(1, txt_mahdb.getText().toString());
            ps.setNString(2, masach);
            int rowDelete = ps.executeUpdate();

            if(rowDelete > 0)
            {
                int t = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa?","Thông báo!", JOptionPane.YES_NO_OPTION);
                if(t == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    HienThi2();
                    loadLai2();
                }else{
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }else {
                JOptionPane.showMessageDialog(this, "Xóa Thất Bại!");
            }
            ps.close();
            conn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_XoabanActionPerformed

    private void btn_SuabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuabanActionPerformed
        // TODO add your handling code here:
        try{
            String mahdb, sach, soluong, NgayBan, thanhtoan;
            mahdb = txt_mahdb.getText() ;
            sach = (String) cmb_sachban.getSelectedItem();
            soluong = txt_soluongban.getText();
            String ngay, thang, nam;
            ngay = cbb_Ngay1.getSelectedItem().toString();
            thang = cbb_Thang1.getSelectedItem().toString();
            nam = cbb_Nam1.getSelectedItem().toString();
            NgayBan = nam + "-" + thang + "-" + ngay;

            int soluongban = 0;
            if(!soluong.isEmpty()){
                soluongban = Integer.parseInt(soluong) ;

            }
            if(soluongban <= 0){
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(mahdb.equals("")||soluong.equals("")){
               JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
            }

            conn = db.getConnection();
            try {
                    PreparedStatement ps = conn.prepareStatement("update CTHDB set SoLuong = ? where MaHoaDonBan = ? and MaSach = (Select MaSach from Sach where TenSach = ?)");
                    ps.setNString(2, mahdb);
                    ps.setNString(3, sach);
                    ps.setInt(1, soluongban);

                    int kq = ps.executeUpdate();

                    if(kq>0){
                        JOptionPane.showMessageDialog(this, "Sửa hóa đơn thành công!");
                        loadLai1();
                        HienThi1();
                    }else{
                        JOptionPane.showMessageDialog(this, "Sửa hóa đơn thất bại");
                    }
                    ps.close();
                    loadLai2();
                    HienThi2();
                    conn.close();
            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số, không nhập chữ vào ô Số lượng");
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_SuabanActionPerformed

    private void btn_tinhbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tinhbanActionPerformed
        // TODO add your handling code here:
        try{
            String mahdb, sach, soluong, NgayBan, thanhtoan;
            mahdb = txt_mahdb.getText() ;
            sach = (String) cmb_sachban.getSelectedItem();
            soluong = txt_soluongban.getText();
            String ngay, thang, nam;
            ngay = cbb_Ngay1.getSelectedItem().toString();
            thang = cbb_Thang1.getSelectedItem().toString();
            nam = cbb_Nam1.getSelectedItem().toString();
            NgayBan = nam + "-" + thang + "-" + ngay;

            int soluongban = 0;
            if(!soluong.isEmpty()){
                soluongban = Integer.parseInt(soluong) ;

            }
            if(soluongban <= 0){
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            conn = db.getConnection();
            try {
                if(mahdb.equals("")||soluong.equals("")){
                    JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
                } else{
                    StringBuffer sb = new StringBuffer();
                    String querry = "select MaHoaDonBan from HoaDonBan where MaHoaDonBan = '"+ mahdb +"'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(querry);
                    if(rs.next()){
                        PreparedStatement ps2 = conn.prepareStatement("insert into CTHDB values (?, (Select MaSach from Sach where TenSach = ?), ?)");
                        ps2.setNString(1, mahdb);
                        ps2.setNString(2, sach);
                        ps2.setInt(3, soluongban);

                        int kq2 = ps2.executeUpdate();
                        if(kq2>0){
                            JOptionPane.showMessageDialog(this, "Tính hóa đơn thành công!");
                            loadLai2();
                            HienThi2();
                        }else{
                            JOptionPane.showMessageDialog(this, "Tính hóa đơn lương thất bại");
                        }
                        ps2.close();
                    }
                    else{
                        PreparedStatement ps = conn.prepareStatement("insert into HoaDonBan values (?, ?, ?)");
                        ps.setNString(1, mahdb);
                        ps.setNString(2, NgayBan);
                        ps.setString(3, null);

                        PreparedStatement ps1 = conn.prepareStatement("insert into CTHDB values (?, (Select MaSach from Sach where TenSach = ?), ?)");
                        ps1.setNString(1, mahdb);
                        ps1.setNString(2, sach);
                        ps1.setInt(3, soluongban);

                        int kq = ps.executeUpdate();
                        int kq1 = ps1.executeUpdate();

                        if(kq>0 && kq1>0){
                            JOptionPane.showMessageDialog(this, "Tính hóa đơn thành công!");
                            loadLai2();
                            HienThi2();
                        }else{
                            JOptionPane.showMessageDialog(this, "Tính hóa đơn lương thất bại");
                        }
                        ps1.close();
                        ps.close();
                        conn.close();
                    }
                    loadLai2();
                    HienThi2();
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số, không nhập chữ vào ô Số lượng");
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_tinhbanActionPerformed

    private void table_HoadonbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HoadonbanMouseClicked
        // TODO add your handling code here:
        table_Hoadonban.setDefaultEditor(Object.class, null);
        conn =  db.getConnection();
        try{
            int row = table_Hoadonban.getSelectedRow();
            if (row >= 0) {
                String mahd = table_Hoadonban.getValueAt(row, 0).toString();
                String sach = (String) table_Hoadonban.getValueAt(row, 1);
                String soluong = table_Hoadonban.getValueAt(row, 2).toString();
                String date1 = table_Hoadonban.getModel().getValueAt(row, 3).toString();
                String thanhtoan = table_Hoadonban.getValueAt(row, 4).toString();

                txt_mahdb.setText(mahd);
                String tensach = null;
                PreparedStatement ps1 = conn.prepareStatement("SELECT TenSach FROM Sach WHERE MaSach = ?");
                ps1.setString(1, sach);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    tensach = rs1.getNString("TenSach");
                }
                if (tensach != null)
                {
                    for (int i = 0; i < cmb_sachban.getItemCount(); i++) {
                        String tensach1 = cmb_sachban.getItemAt(i).toString();
                        if (tensach1.equals(tensach))
                        {
                            cmb_sachban.setSelectedIndex(i);
                            break;
                        }
                    }
                }
                txt_soluongban.setText(soluong);

                String[] parts;
                parts = date1.split("-");
                String year1 = parts[0];
                cbb_Nam1.setSelectedItem(year1);

                String month1 = parts[1];
                if(month1.indexOf("0") == 0){
                    month1 = month1.replace("0", "");
                    cbb_Thang1.setSelectedItem(month1);
                }else{
                    cbb_Thang1.setSelectedItem(month1);
                }

                String day1 = parts[2];
                if(day1.indexOf("0")== 0){
                    day1 = day1.replace("0", "");
                    cbb_Ngay1.setSelectedItem(day1);
                }else{
                    cbb_Ngay1.setSelectedItem(day1);
                }

                txt_thanhtoanban.setText(thanhtoan);

                txt_mahdb.setEnabled(false);
                btn_tinhban.setEnabled(false);
                btn_Suaban.setEnabled(true);
                btn_Xoaban.setEnabled(true);
                cmb_sachban.setEnabled(false);
                cbb_Ngay1.setEnabled(false);
                cbb_Thang1.setEnabled(false);
                cbb_Nam1.setEnabled(false);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_table_HoadonbanMouseClicked

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        // TODO add your handling code here:
        for (int i = 1; i < 32; i++) {
            cbb_Ngay.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            cbb_Thang.addItem(String.valueOf(i));
        }
        for (int i = 2023; i > 1950; i--) {
            cbb_Nam.addItem(String.valueOf(i));
        }
    }//GEN-LAST:event_jPanel2ComponentShown

    private void btn_tinhnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tinhnhapActionPerformed
        // TODO add your handling code here:
        try{
            String mahdn, sach, soluong, NgayNhap, thanhtoan;
            mahdn = txt_mahdn.getText() ;
            sach = (String) cmb_sachnhap.getSelectedItem();
            soluong = txt_soluongnhap.getText();
            String ngay, thang, nam;
            ngay = cbb_Ngay.getSelectedItem().toString();
            thang = cbb_Thang.getSelectedItem().toString();
            nam = cbb_Nam.getSelectedItem().toString();
            NgayNhap = nam + "-" + thang + "-" + ngay;

            int soluongnhap = 0;
            if(!soluong.isEmpty()){
                soluongnhap = Integer.parseInt(soluong) ;

            }
            if(soluongnhap <= 0){
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            conn = db.getConnection();
            try {
                if(mahdn.equals("")||soluong.equals("")){
                    JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
                } else{
                    StringBuffer sb = new StringBuffer();
                    String querry = "select MaHoaDonNhap from HoaDonNhap where MaHoaDonNhap = '"+ mahdn +"'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(querry);
                    if(rs.next()){
                        PreparedStatement ps2 = conn.prepareStatement("insert into CTHDN values (?, (Select MaSach from Sach where TenSach = ?), ?)");
                        ps2.setNString(1, mahdn);
                        ps2.setNString(2, sach);
                        ps2.setInt(3, soluongnhap);

                        int kq2 = ps2.executeUpdate();
                        if(kq2>0){
                            JOptionPane.showMessageDialog(this, "Tính hóa đơn thành công!");
                            loadLai1();
                            HienThi1();
                        }else{
                            JOptionPane.showMessageDialog(this, "Tính hóa đơn lương thất bại");
                        }
                    }
                    else{
                        PreparedStatement ps = conn.prepareStatement("insert into HoaDonNhap values (?, ?, ?)");
                        ps.setNString(1, mahdn);
                        ps.setNString(2, NgayNhap);
                        ps.setString(3, null);

                        PreparedStatement ps1 = conn.prepareStatement("insert into CTHDN values (?, (Select MaSach from Sach where TenSach = ?), ?)");
                        ps1.setNString(1, mahdn);
                        ps1.setNString(2, sach);
                        ps1.setInt(3, soluongnhap);

                        int kq = ps.executeUpdate();
                        int kq1 = ps1.executeUpdate();

                        if(kq>0 && kq1>0){
                            JOptionPane.showMessageDialog(this, "Tính hóa đơn thành công!");
                            loadLai1();
                            HienThi1();
                        }else{
                            JOptionPane.showMessageDialog(this, "Tính hóa đơn lương thất bại");
                        }
                        ps1.close();
                        ps.close();
                        conn.close();
                    }
                    loadLai1();
                    HienThi1();
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số, không nhập chữ vào ô Số Lượng");
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_tinhnhapActionPerformed

    private void cbb_ThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_ThangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_ThangActionPerformed

    private void cbb_ThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_ThangItemStateChanged
        int tam=0;
        String thang = cbb_Thang.getSelectedItem().toString();
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        String thanght;
        if (tam == 0) {
            thanght = "0";
        } else {
            thanght = cbb_Ngay.getSelectedItem().toString();
        }
        tam = 1;

        switch (thang) {
            case "4", "6", "9", "11" -> {
                cbb_Ngay.setModel(cbbmodel);
                for (int i = 1; i < 31; i++) {
                    cbb_Ngay.addItem(String.valueOf(i));
                }   if (Integer.parseInt(thanght) < 31) {
                    cbb_Ngay.setSelectedItem(thanght);
                }
            }
            case "1", "3", "5", "7", "8", "12", "10" -> {
                cbb_Ngay.setModel(cbbmodel);
                for (int i = 1; i < 32; i++) {
                    cbb_Ngay.addItem(String.valueOf(i));
                }   if (Integer.parseInt(thanght) < 32) {
                    cbb_Ngay.setSelectedItem(thanght);
                }
            }
            default -> {
                cbb_Ngay.setModel(cbbmodel);
                for (int i = 1; i < 29; i++) {
                    cbb_Ngay.addItem(String.valueOf(i));
                }   if (Integer.parseInt(thanght) < 29) {
                    cbb_Ngay.setSelectedItem(thanght);
                }
            }
        }
    }//GEN-LAST:event_cbb_ThangItemStateChanged

    private void btn_timkiemnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemnhapActionPerformed
        // TODO add your handling code here:
        conn = db.getConnection();
        try {
            if(txt_timkiemnhap.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Bạn cần nhập tên mã hóa đơn 'Nhập thông tin tìm kiếm'");
            }else{
                PreparedStatement ps = conn.prepareStatement("SELECT HoaDonNhap.MaHoaDonNhap, CTHDN.MaSach, CTHDN.SoLuong, HoaDonNhap.NgayNhap, HoaDonNhap.TongThanhToanHoaDon\n" +
                            "FROM HoaDonNhap\n" +
                            "INNER JOIN CTHDN ON HoaDonNhap.MaHoaDonNhap = CTHDN.MaHoaDonNhap where HoaDonNhap.MaHoaDonNhap like ?");
                ps.setNString(1, "%" + txt_timkiemnhap.getText() + "%");
                ResultSet rs = ps.executeQuery();
                DefaultTableModel model = (DefaultTableModel) table_Hoadonnhap.getModel();
                model.setRowCount(0);
                while (rs.next()) {
                    Object[] rowData = {rs.getString("MaHoaDonNhap"), rs.getString("MaSach"), rs.getString("SoLuong"),
                        rs.getString("NgayNhap"), rs.getString("TongThanhToanHoaDon")};
                    model.addRow(rowData);
                }

                if (model.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " hóa đơn mà bạn muốn tìm!");
                } else {
                    JOptionPane.showMessageDialog(this, "Không có hóa đơn nào!");
                }

                conn.close();
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_timkiemnhapActionPerformed

    private void btn_resetnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetnhapActionPerformed
        // TODO add your handling code here:
        txt_mahdn.setText("");
        cmb_sachnhap.setSelectedIndex(0);
        txt_soluongnhap.setText("");
        cbb_Ngay.setSelectedIndex(0);
        cbb_Thang.setSelectedIndex(0);
        cbb_Nam.setSelectedIndex(0);
        txt_thanhtoannhap.setText("");
        txt_timkiemnhap.setText("");
        
        txt_mahdn.setEnabled(true);
        btn_tinhnhap.setEnabled(true);

        btn_Suanhap.setEnabled(false);
        btn_Xoanhap.setEnabled(false);
        cmb_sachnhap.setEnabled(true);
        cbb_Ngay.setEnabled(true);
        cbb_Thang.setEnabled(true);
        cbb_Nam.setEnabled(true);
    }//GEN-LAST:event_btn_resetnhapActionPerformed

    private void btn_XoanhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoanhapActionPerformed
        // TODO add your handling code here:
        conn =  db.getConnection();
        String masach = (String) cmb_sachnhap.getSelectedItem();
        try {
            PreparedStatement ps = conn.prepareStatement("Delete from CTHDN where MaHoaDonNhap = ? and MaSach = (Select MaSach from Sach Where TenSach = ?) ");
            ps.setNString(1, txt_mahdn.getText().toString());
            ps.setNString(2, masach);
            int rowDelete = ps.executeUpdate();

            if(rowDelete > 0)
            {
                int t = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa?","Thông báo!", JOptionPane.YES_NO_OPTION);
                if(t == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    HienThi1();
                    loadLai1();
                }else{
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }else {
                JOptionPane.showMessageDialog(this, "Xóa Thất Bại!");
            }
            ps.close();
            conn.close();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_XoanhapActionPerformed

    private void btn_SuanhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuanhapActionPerformed
        // TODO add your handling code here:
        try{
            String mahdn, sach, soluong, NgayNhap, thanhtoan;
            mahdn = txt_mahdn.getText() ;
            sach = (String) cmb_sachnhap.getSelectedItem();
            soluong = txt_soluongnhap.getText();
            String ngay, thang, nam;
            ngay = cbb_Ngay.getSelectedItem().toString();
            thang = cbb_Thang.getSelectedItem().toString();
            nam = cbb_Nam.getSelectedItem().toString();
            NgayNhap = nam + "-" + thang + "-" + ngay;

            int soluongnhap = 0;
            if(!soluong.isEmpty()){
                soluongnhap = Integer.parseInt(soluong) ;

            }
            if(soluongnhap <= 0){
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(mahdn.equals("")||soluong.equals("")){
               JOptionPane.showMessageDialog(this, "Bạn cần nhập đủ dữ liệu");
            }

            conn = db.getConnection();
            try {
                    PreparedStatement ps = conn.prepareStatement("update CTHDN set SoLuong = ? where MaHoaDonNhap = ? and MaSach = (Select MaSach from Sach where TenSach = ?)");
                    ps.setNString(2, mahdn);
                    ps.setNString(3, sach);
                    ps.setInt(1, soluongnhap);

                    int kq = ps.executeUpdate();

                    if(kq>0){
                        JOptionPane.showMessageDialog(this, "Sửa hóa đơn thành công!");
                        loadLai1();
                        HienThi1();
                    }else{
                        JOptionPane.showMessageDialog(this, "Sửa hóa đơn thất bại");
                    }
                    ps.close();
                    loadLai1();
                    HienThi1();
                    conn.close();
            }
            catch (HeadlessException | SQLException e) {
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số, không nhập chữ vào ô Số lượng");
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_SuanhapActionPerformed

    private void table_HoadonnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_HoadonnhapMouseClicked
        // TODO add your handling code here:
        table_Hoadonnhap.setDefaultEditor(Object.class, null);
        conn =  db.getConnection();
        try{
            int row = table_Hoadonnhap.getSelectedRow();
            if (row >= 0) {
                String mahd = table_Hoadonnhap.getValueAt(row, 0).toString();
                String sach = (String) table_Hoadonnhap.getValueAt(row, 1);
                String soluong = table_Hoadonnhap.getValueAt(row, 2).toString();
                String date = table_Hoadonnhap.getModel().getValueAt(row, 3).toString();
                String thanhtoan = table_Hoadonnhap.getValueAt(row, 4).toString();

                txt_mahdn.setText(mahd);
                String tensach = null;
                PreparedStatement ps1 = conn.prepareStatement("SELECT TenSach FROM Sach WHERE MaSach = ?");
                ps1.setString(1, sach);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    tensach = rs1.getNString("TenSach");
                }
                if (tensach != null)
                {
                    for (int i = 0; i < cmb_sachnhap.getItemCount(); i++) {
                        String tensach1 = cmb_sachnhap.getItemAt(i).toString();
                        if (tensach1.equals(tensach))
                        {
                            cmb_sachnhap.setSelectedIndex(i);
                            break;
                        }
                    }
                }
                txt_soluongnhap.setText(soluong);

                String[] parts;
                parts = date.split("-");
                String year = parts[0];
                cbb_Nam.setSelectedItem(year);

                String month = parts[1];
                if(month.indexOf("0") == 0){
                    month = month.replace("0", "");
                    cbb_Thang.setSelectedItem(month);
                }else{
                    cbb_Thang.setSelectedItem(month);
                }

                String day = parts[2];
                if(day.indexOf("0")== 0){
                    day = day.replace("0", "");
                    cbb_Ngay.setSelectedItem(day);
                }else{
                    cbb_Ngay.setSelectedItem(day);
                }

                txt_thanhtoannhap.setText(thanhtoan);
            }
            conn.close();
            
            txt_mahdn.setEnabled(false);
            btn_tinhnhap.setEnabled(false);

            btn_Suanhap.setEnabled(true);
            btn_Xoanhap.setEnabled(true);
            cmb_sachnhap.setEnabled(false);
            cbb_Ngay.setEnabled(false);
            cbb_Thang.setEnabled(false);
            cbb_Nam.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_table_HoadonnhapMouseClicked

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        // TODO add your handling code here:
//        for (int i = 1; i < 32; i++) {
//            cbb_Ngay.addItem(String.valueOf(i));
//            cbb_Ngay1.addItem(String.valueOf(i));
//        }
//        for (int i = 1; i < 13; i++) {
//            cbb_Thang.addItem(String.valueOf(i));
//            cbb_Thang1.addItem(String.valueOf(i));
//        }
//        for (int i = 2010; i > 1950; i--) {
//            cbb_Nam.addItem(String.valueOf(i));
//            cbb_Nam1.addItem(String.valueOf(i));
//        }
    }//GEN-LAST:event_jPanel3ComponentShown

    private void cbb_Thang1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_Thang1ItemStateChanged
        // TODO add your handling code here:
        int tam1 = 0;
        String thang1 = cbb_Thang1.getSelectedItem().toString();
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        String thanght1;
        if (tam1 == 0) {
            thanght1 = "0";
        } else {
            thanght1 = cbb_Ngay1.getSelectedItem().toString();
        }
        tam1 = 1;

        switch (thang1) {
            case "4", "6", "9", "11" -> {
                cbb_Ngay1.setModel(cbbmodel);
                for (int i = 1; i < 31; i++) {
                    cbb_Ngay1.addItem(String.valueOf(i));
                }   if (Integer.parseInt(thanght1) < 31) {
                    cbb_Ngay1.setSelectedItem(thanght1);
                }
            }
            case "1", "3", "5", "7", "8", "12", "10" -> {
                cbb_Ngay1.setModel(cbbmodel);
                for (int i = 1; i < 32; i++) {
                    cbb_Ngay1.addItem(String.valueOf(i));
                }   if (Integer.parseInt(thanght1) < 32) {
                    cbb_Ngay1.setSelectedItem(thanght1);
                }
            }
            default -> {
                cbb_Ngay1.setModel(cbbmodel);
                for (int i = 1; i < 29; i++) {
                    cbb_Ngay1.addItem(String.valueOf(i));
                }   if (Integer.parseInt(thanght1) < 29) {
                    cbb_Ngay1.setSelectedItem(thanght1);
                }
            }
        }
    }//GEN-LAST:event_cbb_Thang1ItemStateChanged

    private void cbb_Thang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_Thang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_Thang1ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        HienThi1();
        HienThi2();
        HienThi3();
        for (int i = 1; i < 32; i++) {
            cbb_Ngay1.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            cbb_Thang1.addItem(String.valueOf(i));
        }
        for (int i = 2023; i > 1950; i--) {
            cbb_Nam1.addItem(String.valueOf(i));
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jPanel3ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3ComponentHidden

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        QuanLyThongKeController controller = new QuanLyThongKeController();
        controller.setDateToChar1(jpnView1);
        controller.setDataToChar2(jpnView2);
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void table_hdbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_hdbMouseClicked
        // TODO add your handling code here:
        table_hdb.setDefaultEditor(Object.class, null);
        try{
            int row = table_hdb.getSelectedRow();
            if (row >= 0) {
                String mahd = table_hdb.getValueAt(row, 0).toString();
                txt_mahoadonxoa.setText(mahd);
                txt_mahoadonxoa.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_table_hdbMouseClicked

    private void table_hdnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_hdnMouseClicked
        // TODO add your handling code here:
        table_hdn.setDefaultEditor(Object.class, null);
        try{
            int row = table_hdn.getSelectedRow();
            if (row >= 0) {
                String mahd = table_hdn.getValueAt(row, 0).toString();
                txt_mahoadonxoa.setText(mahd);
                txt_mahoadonxoa.setEnabled(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_table_hdnMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        conn = db.getConnection();
        try{
            String querry = "Select * from HoaDonBan where MaHoaDonBan = '" + txt_mahoadonxoa.getText() + "'" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(querry);
            if(rs.next()){
                PreparedStatement ps = conn.prepareStatement("Delete from HoaDonBan where MaHoaDonBan = ?");
                ps.setNString(1, txt_mahoadonxoa.getText().toString());
                int rowDelete = ps.executeUpdate();
                if(rowDelete > 0)
                {
                    int t = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không?","Thông báo!", JOptionPane.YES_NO_OPTION);
                    if(t == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                        HienThi3();
                    }else{
                        JOptionPane.showMessageDialog(this, "Xóa thất bại");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Xóa Thất Bại!");
                }
                ps.close();
            } else{
                PreparedStatement ps1 = conn.prepareStatement("Delete from HoaDonNhap where MaHoaDonNhap = ?");
                ps1.setNString(1, txt_mahoadonxoa.getText().toString());
                int rowDelete1 = ps1.executeUpdate();
                if(rowDelete1 > 0)
                {
                    int t = JOptionPane.showConfirmDialog(this,"Bạn có muốn xóa không?","Thông báo!", JOptionPane.YES_NO_OPTION);
                    if(t == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                        HienThi3();
                    }else{
                        JOptionPane.showMessageDialog(this, "Xóa thất bại");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Xóa Thất Bại!");
                }
                ps1.close();
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Bạn cần phải xóa hết Chi tiết hóa đơn có mã hóa đơn là " + txt_mahoadonxoa.getText().toString() + " trước khi xóa hóa đơn này.");
        }
    }//GEN-LAST:event_btn_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Suaban;
    private javax.swing.JButton btn_Suanhap;
    private javax.swing.JButton btn_Xoaban;
    private javax.swing.JButton btn_Xoanhap;
    private javax.swing.JButton btn_resetban;
    private javax.swing.JButton btn_resetnhap;
    private javax.swing.JButton btn_timkiemban;
    private javax.swing.JButton btn_timkiemnhap;
    private javax.swing.JButton btn_tinhban;
    private javax.swing.JButton btn_tinhnhap;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_Nam;
    private javax.swing.JComboBox<String> cbb_Nam1;
    private javax.swing.JComboBox<String> cbb_Ngay;
    private javax.swing.JComboBox<String> cbb_Ngay1;
    private javax.swing.JComboBox<String> cbb_Thang;
    private javax.swing.JComboBox<String> cbb_Thang1;
    private javax.swing.JComboBox<String> cmb_sachban;
    private javax.swing.JComboBox<String> cmb_sachnhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpnView1;
    private javax.swing.JPanel jpnView2;
    private javax.swing.JTable table_Hoadonban;
    private javax.swing.JTable table_Hoadonnhap;
    private javax.swing.JTable table_hdb;
    private javax.swing.JTable table_hdn;
    private javax.swing.JTextField txt_mahdb;
    private javax.swing.JTextField txt_mahdn;
    private javax.swing.JTextField txt_mahoadonxoa;
    private javax.swing.JTextField txt_soluongban;
    private javax.swing.JTextField txt_soluongnhap;
    private javax.swing.JTextField txt_thanhtoanban;
    private javax.swing.JTextField txt_thanhtoannhap;
    private javax.swing.JTextField txt_timkiemban;
    private javax.swing.JTextField txt_timkiemnhap;
    // End of variables declaration//GEN-END:variables
}
