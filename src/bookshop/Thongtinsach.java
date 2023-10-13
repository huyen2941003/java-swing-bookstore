/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package bookshop;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author Huyen
 */
public class Thongtinsach extends javax.swing.JPanel {
    ConnectDataBase db = new ConnectDataBase();
    Connection conn;
    /**
     * Creates new form Thongtinsach
     */
    public Thongtinsach() {
        initComponents();
        Hienthi_tablesach2();
        Hienthi_tablesach();
        LoadDataCmb();
        txt_giaban.setEnabled(false);
    }
    
    public void LoadDataCmb(){
        conn =  db.getConnection();
        String query1 = "Select * from TheLoai";
        try{
            PreparedStatement ps = conn.prepareStatement(query1);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                this.cmb_theloai.addItem(rs.getString("TenTheLoai"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e, "Lỗi",1);
        }
        
        String query2 = "Select * from NhaXuatBan";
        try{
            PreparedStatement ps = conn.prepareStatement(query2);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                this.cmb_nxb.addItem(rs.getString("TenNhaXuatBan"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e, "Lỗi",1);
        }
        
        String query3 = "Select * from TacGia";
        try{
            PreparedStatement ps = conn.prepareStatement(query3);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                this.cmb_tacgia.addItem(rs.getString("TenTongChuBien"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e, "Lỗi",1);
        }
        
    }
    
    public void Hienthi_tablesach()
    {
        conn =  db.getConnection();

        try {
            Statement st =  conn.createStatement();
            String query = "Select * from Sach";
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
            table_sach.setModel(model);
            st.close();
            rs.close();
            conn.close();
	} catch (SQLException e1) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e1.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    public void Hienthi_tablesach2()
    {
        conn =  db.getConnection();

        try {
            Statement st =  conn.createStatement();
            String query = "Select * from Sach";
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
            table_sach2.setModel(model);
            st.close();
            rs.close();
            conn.close();
	} catch (SQLException e1) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e1.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
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

        jButton7 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_sach = new javax.swing.JTable();
        btn_timkiem = new javax.swing.JButton();
        btn_hienthi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmb_timkiem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_sach2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txt_maSach = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_tenSach = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_soluongton = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        label_biasach = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_xuatbanlanthu = new javax.swing.JTextField();
        btn_xoa = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_chonanh = new javax.swing.JButton();
        cmb_theloai = new javax.swing.JComboBox<>();
        cmb_nxb = new javax.swing.JComboBox<>();
        cmb_tacgia = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txt_gianhap = new javax.swing.JTextField();
        txt_giaban = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setText("Thêm Sách");

        jRadioButton2.setText("jRadioButton2");

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tìm kiếm theo:");

        txt_timkiem.setBackground(new java.awt.Color(255, 255, 255));
        txt_timkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_timkiem.setForeground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table_sach.setBackground(new java.awt.Color(255, 255, 255));
        table_sach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_sach.setForeground(new java.awt.Color(0, 0, 0));
        table_sach.setModel(new javax.swing.table.DefaultTableModel(
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
        table_sach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_sach);

        btn_timkiem.setBackground(new java.awt.Color(255, 255, 255));
        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(0, 0, 0));
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        btn_hienthi.setBackground(new java.awt.Color(255, 255, 255));
        btn_hienthi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_hienthi.setForeground(new java.awt.Color(0, 0, 0));
        btn_hienthi.setText("Hiện thị tất cả sách");
        btn_hienthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hienthiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nhập thông tin:");

        cmb_timkiem.setBackground(new java.awt.Color(255, 255, 255));
        cmb_timkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_timkiem.setForeground(new java.awt.Color(0, 0, 0));
        cmb_timkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Thể Loại Sách", "Tác Giả", "Nhà Xuất Bản" }));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/book_demo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_timkiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_hienthi)
                    .addComponent(btn_timkiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hienthi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Tìm kiếm Sách", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        table_sach2.setBackground(new java.awt.Color(255, 255, 255));
        table_sach2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_sach2.setForeground(new java.awt.Color(0, 0, 0));
        table_sach2.setModel(new javax.swing.table.DefaultTableModel(
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
        table_sach2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sach2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_sach2);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Mã Sách:");

        txt_maSach.setBackground(new java.awt.Color(255, 255, 255));
        txt_maSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_maSach.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tên Sách:");

        txt_tenSach.setBackground(new java.awt.Color(255, 255, 255));
        txt_tenSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_tenSach.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Số Lượng Tồn:");

        txt_soluongton.setBackground(new java.awt.Color(255, 255, 255));
        txt_soluongton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_soluongton.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Thể Loại:");

        label_biasach.setBackground(new java.awt.Color(255, 255, 255));

        btn_them.setBackground(new java.awt.Color(255, 255, 255));
        btn_them.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(0, 0, 0));
        btn_them.setText("Thêm Sách");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 255, 255));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(0, 0, 0));
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Nhà Xuất Bản:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Tổng Chủ Biên:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Tái Bản Lần Thứ:");

        txt_xuatbanlanthu.setBackground(new java.awt.Color(255, 255, 255));
        txt_xuatbanlanthu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_xuatbanlanthu.setForeground(new java.awt.Color(0, 0, 0));

        btn_xoa.setBackground(new java.awt.Color(255, 255, 255));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(0, 0, 0));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(255, 255, 255));
        btn_reset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(0, 0, 0));
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_chonanh.setBackground(new java.awt.Color(255, 255, 255));
        btn_chonanh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_chonanh.setForeground(new java.awt.Color(0, 0, 0));
        btn_chonanh.setText("Chọn ảnh");
        btn_chonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonanhActionPerformed(evt);
            }
        });

        cmb_theloai.setBackground(new java.awt.Color(255, 255, 255));
        cmb_theloai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cmb_nxb.setBackground(new java.awt.Color(255, 255, 255));
        cmb_nxb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cmb_tacgia.setBackground(new java.awt.Color(255, 255, 255));
        cmb_tacgia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Giá nhập:");

        txt_gianhap.setBackground(new java.awt.Color(255, 255, 255));
        txt_gianhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_gianhap.setForeground(new java.awt.Color(0, 0, 0));

        txt_giaban.setBackground(new java.awt.Color(255, 255, 255));
        txt_giaban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_giaban.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Giá bán:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tenSach, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(txt_maSach, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(txt_soluongton, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(txt_xuatbanlanthu, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(cmb_theloai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_nxb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_tacgia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_gianhap, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(label_biasach, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_chonanh, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_soluongton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmb_theloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmb_nxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cmb_tacgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_xuatbanlanthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_biasach, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_chonanh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jTabbedPane2.addTab("Thêm Sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hienthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hienthiActionPerformed
        // TODO add your handling code here:
        Hienthi_tablesach();
    }//GEN-LAST:event_btn_hienthiActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        String test = txt_timkiem.getText();
        if(test.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm!");
        } else{
            String selectedValue = (String) cmb_timkiem.getSelectedItem();
            if (selectedValue.equals("Sách"))
            {
                String searchKeyword = txt_timkiem.getText();
                DefaultTableModel model = (DefaultTableModel) table_sach.getModel();
                model.setRowCount(0);
                try {
                    Connection conn = db.getConnection();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM Sach WHERE Sach.TenSach LIKE ?");
                    ps.setNString(1, "%" + searchKeyword + "%");
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Object[] rowData = {rs.getString("MaSach"), rs.getString("TenSach"), rs.getInt("SoLuongTon"),
                                rs.getString("MaTheLoai"), rs.getString("MaNhaXuatBan"), rs.getString("MaTacGia"),
                                rs.getInt("XuatBanLanThu"),rs.getFloat("GiaNhap"), null, rs.getFloat("GiaBan")};

                        Blob b = rs.getBlob("BiaSach");
                        if (b != null) {
                            byte[] imageBytes = b.getBytes(1, (int) b.length());
                            ImageIcon biaSach = new ImageIcon(imageBytes);
                            rowData[8] = biaSach;
                        } else {
                            rowData[8] = null;
                        }

                        model.addRow(rowData);
                    }

                    if (model.getRowCount() > 0) {
                        JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " sách mà bạn muốn tìm!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Không có sách nào!");
                    }

                    rs.close();
                    ps.close();
                    conn.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                }

            }

             else if(selectedValue.equals("Thể Loại Sách"))
             {
                String theloai = txt_timkiem.getText();
                DefaultTableModel model = (DefaultTableModel) table_sach.getModel();
                model.setRowCount(0);
                try {
                    conn = db.getConnection();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM Sach INNER JOIN TheLoai ON Sach.MaTheLoai = TheLoai.MaTheLoai WHERE TheLoai.TenTheLoai LIKE ?");
                    ps.setNString(1, "%" + theloai + "%");
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Object[] rowData = {rs.getString("MaSach"), rs.getString("TenSach"), rs.getInt("SoLuongTon"),
                                rs.getString("MaTheLoai"), rs.getString("MaNhaXuatBan"), rs.getString("MaTacGia"),
                                rs.getInt("XuatBanLanThu"),rs.getFloat("GiaNhap"), null, rs.getFloat("GiaBan")};

                        Blob b = rs.getBlob("BiaSach");
                        if (b != null) {
                            byte[] imageBytes = b.getBytes(1, (int) b.length());
                            ImageIcon biaSach = new ImageIcon(imageBytes);
                            rowData[8] = biaSach;
                        } else {
                            rowData[8] = null;
                        }

                        model.addRow(rowData);
                    }

                    if (model.getRowCount() > 0) {
                        JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " sách mà bạn muốn tìm!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Không có sách nào!");
                    }

                    conn.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                }
             }

             else if(selectedValue.equals("Tác Giả"))
             {
                String theloai = txt_timkiem.getText();
                DefaultTableModel model = (DefaultTableModel) table_sach.getModel();
                model.setRowCount(0);
                try {
                    conn = db.getConnection();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM Sach INNER JOIN TacGia ON Sach.MaTacGia = TacGia.MaTacGia WHERE TacGia.TenTongChuBien LIKE ? or TacGia.TenPhoChuBien LIKE ?");
                    ps.setNString(1, "%" + theloai + "%");
                    ps.setNString(2, "%" + theloai + "%");
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Object[] rowData = {rs.getString("MaSach"), rs.getString("TenSach"), rs.getInt("SoLuongTon"),
                                rs.getString("MaTheLoai"), rs.getString("MaNhaXuatBan"), rs.getString("MaTacGia"),
                                rs.getInt("XuatBanLanThu"),rs.getFloat("GiaNhap"), null, rs.getFloat("GiaBan")};

                        Blob b = rs.getBlob("BiaSach");
                        if (b != null) {
                            byte[] imageBytes = b.getBytes(1, (int) b.length());
                            ImageIcon biaSach = new ImageIcon(imageBytes);
                            rowData[8] = biaSach;
                        } else {
                            rowData[8] = null;
                        }

                        model.addRow(rowData);
                    }

                    if (model.getRowCount() > 0) {
                        JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " sách mà bạn muốn tìm!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Không có sách nào!");
                    }

                    conn.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                }
             }

             else if(selectedValue.equals("Nhà Xuất Bản"))
             {
                 String theloai = txt_timkiem.getText();
                DefaultTableModel model = (DefaultTableModel) table_sach.getModel();
                model.setRowCount(0);
                try {
                    conn = db.getConnection();
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM Sach INNER JOIN NhaXuatBan ON Sach.MaNhaXuatBan = NhaXuatBan.MaNhaXuatBan WHERE NhaXuatBan.TenNhaXuatBan LIKE ?");
                    ps.setNString(1, "%" + theloai + "%");
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Object[] rowData = {rs.getString("MaSach"), rs.getString("TenSach"), rs.getInt("SoLuongTon"),
                                rs.getString("MaTheLoai"), rs.getString("MaNhaXuatBan"), rs.getString("MaTacGia"),
                                rs.getInt("XuatBanLanThu"),rs.getFloat("GiaNhap"), null, rs.getFloat("GiaBan")};

                        Blob b = rs.getBlob("BiaSach");
                        if (b != null) {
                            byte[] imageBytes = b.getBytes(1, (int) b.length());
                            ImageIcon biaSach = new ImageIcon(imageBytes);
                            rowData[8] = biaSach;
                        } else {
                            rowData[8] = null;
                        }

                        model.addRow(rowData);
                    }

                    if (model.getRowCount() > 0) {
                        JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " sách mà bạn muốn tìm!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Không có sách nào!");
                    }

                    conn.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void table_sach2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sach2MouseClicked
        // TODO add your handling code here:
        conn =  db.getConnection();
        
        table_sach2.setDefaultEditor(Object.class, null);

        try{
            int row = table_sach2.getSelectedRow();
            if (row >= 0) {
                String maSach = table_sach2.getValueAt(row, 0).toString();
                String tenSach = table_sach2.getValueAt(row, 1).toString();
                String soluongton = table_sach2.getValueAt(row, 2).toString();
                String maTheloai = (String) table_sach2.getValueAt(row, 3);
                String maNxb = (String) table_sach2.getValueAt(row, 4);
                String maTacgia = (String) table_sach2.getValueAt(row, 5);
                String xuatbanlanthu = table_sach2.getValueAt(row, 6).toString();
                String gianhap = table_sach2.getValueAt(row, 7).toString();
                String giaban = table_sach2.getValueAt(row, 9).toString();

                txt_maSach.setText(maSach);
                txt_tenSach.setText(tenSach);
                txt_soluongton.setText(soluongton);
                
                String tentheloai = null;
                PreparedStatement ps1 = conn.prepareStatement("SELECT TenTheLoai FROM TheLoai WHERE MaTheLoai = ?");
                ps1.setString(1, maTheloai);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    tentheloai = rs1.getNString("TenTheLoai");
                }

                if (tentheloai != null) 
                {
                    for (int i = 0; i < cmb_theloai.getItemCount(); i++) {
                        String theLoaiValue = cmb_theloai.getItemAt(i).toString();
                        if (theLoaiValue.equals(tentheloai)) 
                        {
                            cmb_theloai.setSelectedIndex(i);
                            break;
                        }
                    }
                }
                
                String tennxb = null;
                PreparedStatement ps2 = conn.prepareStatement("SELECT TenNhaXuatBan FROM NhaXuatBan WHERE MaNhaXuatBan = ?");
                ps2.setString(1, maNxb);
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    tennxb = rs2.getNString("TenNhaXuatBan");
                }
                if (tennxb != null) 
                {
                    for (int i = 0; i < cmb_nxb.getItemCount(); i++) 
                    {
                        String nxbValue = cmb_nxb.getItemAt(i).toString();
                        if (nxbValue.equals(tennxb)) 
                        {
                            cmb_nxb.setSelectedIndex(i);
                            break;
                        }
                    }
                }
                
                String tentacgia = null;
                PreparedStatement ps3 = conn.prepareStatement("SELECT TenTongChuBien FROM TacGia WHERE MaTacGia = ?");
                ps3.setString(1, maTacgia);
                ResultSet rs3 = ps3.executeQuery();
                if (rs3.next()) {
                    tentacgia = rs3.getNString("TenTongChuBien");
                }
                if (tentacgia != null) 
                {
                    for (int i = 0; i < cmb_tacgia.getItemCount(); i++) 
                    {
                        String tacgiaValue = cmb_tacgia.getItemAt(i).toString();
                        if (tacgiaValue.equals(tentacgia)) 
                        {
                            cmb_tacgia.setSelectedIndex(i);
                            break;
                        }
                    }
                }
                
                txt_xuatbanlanthu.setText(xuatbanlanthu);
                txt_gianhap.setText(gianhap);
                txt_giaban.setText(giaban);

                byte[] imageData = (byte[]) table_sach2.getValueAt(row, 8);
                if (imageData != null) {
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    Image image = imageIcon.getImage().getScaledInstance(label_biasach.getWidth(), label_biasach.getHeight(), Image.SCALE_SMOOTH);
                    label_biasach.setIcon(new ImageIcon(image));
                } else {
                    label_biasach.setIcon(null);
                }
    
                txt_maSach.setEnabled(false);
                btn_them.setEnabled(false);
                btn_sua.setEnabled(true);
                btn_xoa.setEnabled(true);  
            }
            
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_table_sach2MouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        conn =  db.getConnection();
        try{
            String maSach = txt_maSach.getText();
            String tenSach = txt_tenSach.getText();	
            String soluongton = txt_soluongton.getText();
            String maTheloai = String.valueOf(cmb_theloai.getSelectedItem());
            String maNxb = String.valueOf(cmb_nxb.getSelectedItem());
            String maTacgia = String.valueOf(cmb_tacgia.getSelectedItem());
            String xuatbanlanthu = txt_xuatbanlanthu.getText();
            String gianhap = txt_gianhap.getText();
            byte[] anhbia = null;
            if (label_biasach.getIcon() != null) {
                ImageIcon imageIcon = (ImageIcon) label_biasach.getIcon();
                BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics graphics = bufferedImage.createGraphics();
                imageIcon.paintIcon(null, graphics, 0, 0);
                graphics.dispose();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                }
                anhbia = byteArrayOutputStream.toByteArray();
            }

            int soluong = 0, xuatban = 0;
            float gian = 0;
            if(!soluongton.isEmpty() && !xuatbanlanthu.isEmpty() && !gianhap.isEmpty()) 
            {
                soluong = Integer.parseInt(soluongton);
                xuatban = Integer.parseInt(xuatbanlanthu);
                gian = Float.parseFloat(gianhap);
            }

            if (soluong <= 0 || xuatban <= 0 || gian <= 0) {
                JOptionPane.showMessageDialog(this, "Có giá trị bé hơn 0", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                return; // Kết thúc hàm không cho thêm sản phẩm vào cơ sở dữ liệu
            }
            try{
                if(maSach.isEmpty() || tenSach.isEmpty() || maTheloai.isEmpty() || maTacgia.isEmpty() || maNxb.isEmpty())
                {
                    JOptionPane.showMessageDialog(this, "Không được để dữ liệu trống!");
                }
                else{
                    StringBuffer sb = new StringBuffer();
                    String querry = "select MaSach from Sach where MaSach = '" + txt_maSach.getText() + "'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(querry);
                    if(rs.next()){
                        sb.append("Mã sách này đã tồn tại");
                    }
                    if(sb.length() > 0){
                        JOptionPane.showMessageDialog(this, sb.toString());
                    } else{
                        try {
                            PreparedStatement ps = conn.prepareStatement("insert into Sach values(?, ?, ?, (SELECT MaTheLoai FROM TheLoai WHERE TenTheLoai = ?), (SELECT MaNhaXuatBan FROM NhaXuatBan WHERE TenNhaXuatBan = ?), (SELECT MaTacGia FROM TacGia WHERE TenTongChuBien = ?), ?, ?, ?,?)");
                            ps.setNString(1, maSach);
                            ps.setNString(2, tenSach);
                            ps.setInt(3, soluong);
                            ps.setNString(4, maTheloai);
                            ps.setNString(5, maNxb);
                            ps.setNString(6, maTacgia);
                            ps.setInt(7, xuatban);
                            ps.setFloat(8, gian);
                            ps.setBytes(9, anhbia);
                            ps.setString(10, null);
                            int rowInsert = ps.executeUpdate();
                            if(rowInsert > 0) 
                            {
                                JOptionPane.showMessageDialog(this, "Thêm Thành Công!");
                                Hienthi_tablesach2();
                                btn_reset.doClick();
                            }else{
                                JOptionPane.showMessageDialog(this, "Thêm Thất Bại!");
                            }
                            ps.close();
                            conn.close();
                        }catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số không nhập chữ vào ô Số Lượng Tồn, Tái Bản Lần Thứ, Giá Nhập");
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void table_sachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sachMouseClicked
        // TODO add your handling code here:
        table_sach.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_table_sachMouseClicked

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        // TODO add your handling code here:
        btn_xoa.enable(true);
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void btn_chonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonanhActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        if (file != null) {
            ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
            Image image = imageIcon.getImage().getScaledInstance(label_biasach.getWidth(), label_biasach.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            label_biasach.setIcon(scaledIcon);
        }
    }//GEN-LAST:event_btn_chonanhActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        txt_maSach.setText("");
        txt_tenSach.setText("");
        txt_soluongton.setText("");
        cmb_theloai.setSelectedIndex(0);
        cmb_nxb.setSelectedIndex(0);
        cmb_tacgia.setSelectedIndex(0);
        txt_xuatbanlanthu.setText("");
        txt_gianhap.setText("");
        txt_giaban.setText("");
        label_biasach.setIcon(null);

        txt_maSach.setEnabled(true);
        btn_them.setEnabled(true);
        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        conn =  db.getConnection();
        String maSach = txt_maSach.getText();
        try {
            PreparedStatement ps = conn.prepareStatement("Delete from Sach where MaSach = ? ");
            ps.setNString(1, maSach);
            int rowDelete = ps.executeUpdate();

            if(rowDelete > 0)
            {
                JOptionPane.showMessageDialog(this, "Xóa Thành Công!");
                Hienthi_tablesach2();
                btn_reset.doClick();
            }else {
                JOptionPane.showMessageDialog(this, "Xóa Thất Bại!");
            }

            ps.close();
            conn.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Mã Sách " + txt_maSach.getText().toString() + " đang liên kết với Hóa Đơn nên bạn không thể xóa được");
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        conn =  db.getConnection();
        try{
            String maSach = txt_maSach.getText();
            String tenSach = txt_tenSach.getText();
            String soluongton = txt_soluongton.getText();
            String maTheloai = String.valueOf(cmb_theloai.getSelectedItem());
            String maNxb = String.valueOf(cmb_nxb.getSelectedItem());
            String maTacgia = String.valueOf(cmb_tacgia.getSelectedItem());
            String xuatbanlanthu = txt_xuatbanlanthu.getText();
            String gianhap = txt_gianhap.getText();
            String giaban = txt_giaban.getText();
            byte[] anhbia = null;
            if (label_biasach.getIcon() != null) {
                ImageIcon imageIcon = (ImageIcon) label_biasach.getIcon();
                BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics graphics = bufferedImage.createGraphics();
                imageIcon.paintIcon(null, graphics, 0, 0);
                graphics.dispose();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                }
                anhbia = byteArrayOutputStream.toByteArray();
            }

            int soluong = 0, xuatban = 0;
            float gian = 0;
            if(!soluongton.isEmpty() && !xuatbanlanthu.isEmpty() && !gianhap.isEmpty())
            {
                soluong = Integer.parseInt(soluongton);
                xuatban = Integer.parseInt(xuatbanlanthu);
                gian = Float.parseFloat(gianhap);
            }

            if (soluong <= 0 || xuatban <= 0 || gian <= 0) {
                JOptionPane.showMessageDialog(this, "Có giá trị bé hơn 0", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                return; // Kết thúc hàm không cho thêm sản phẩm vào cơ sở dữ liệu
            } else{
                try {
                    PreparedStatement ps = conn.prepareStatement("Update Sach set TenSach = ?, "
                        + "SoLuongTon = ?, MaTheLoai = (SELECT MaTheLoai FROM TheLoai WHERE TenTheLoai = ?), "
                        + "MaNhaXuatBan = (SELECT MaNhaXuatBan FROM NhaXuatBan WHERE TenNhaXuatBan = ?), "
                        + "MaTacGia = (SELECT MaTacGia FROM TacGia WHERE TenTongChuBien = ?), "
                        + "XuatBanLanThu = ?, GiaNhap = ?, BiaSach = ?, GiaBan = ? where MaSach = ?");

                    ps.setNString(1, tenSach);
                    ps.setInt(2, soluong);
                    ps.setNString(3, maTheloai);
                    ps.setNString(4, maNxb);
                    ps.setNString(5, maTacgia);
                    ps.setInt(6, xuatban);
                    ps.setFloat(7, gian);
                    ps.setBytes(8, anhbia);
                    ps.setString(9, null);
                    ps.setNString(10, maSach);

                    int rowUpdate = ps.executeUpdate();
                    if(rowUpdate > 0)
                    {
                        JOptionPane.showMessageDialog(this, "Sửa Thành Công!");
                        Hienthi_tablesach2();
                        btn_reset.doClick();
                    }else{
                        JOptionPane.showMessageDialog(this, "Sửa Thất Bại!");
                    }
                    ps.close();
                    conn.close();
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + e.getMessage(), "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số không nhập chữ vào ô Số Lượng Tồn, Tái Bản Lần Thứ, Giá Nhập");
            System.out.println("Lỗi: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_suaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chonanh;
    private javax.swing.JButton btn_hienthi;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cmb_nxb;
    private javax.swing.JComboBox<String> cmb_tacgia;
    private javax.swing.JComboBox<String> cmb_theloai;
    private javax.swing.JComboBox<String> cmb_timkiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel label_biasach;
    private javax.swing.JTable table_sach;
    private javax.swing.JTable table_sach2;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextField txt_gianhap;
    private javax.swing.JTextField txt_maSach;
    private javax.swing.JTextField txt_soluongton;
    private javax.swing.JTextField txt_tenSach;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_xuatbanlanthu;
    // End of variables declaration//GEN-END:variables
}
