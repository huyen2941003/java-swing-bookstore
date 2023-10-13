package Thongke;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import java.awt.Font;
import java.awt.Color;

/**
 *
 * @author Admin
 */
public class QuanLyThongKeController {
    
    private ThongKeService thongKeService = null;
    
    public QuanLyThongKeController() {
        this.thongKeService = new ThongKeServiceImpl();
    }
    public void setDateToChar1(JPanel jpnItem) {
        List<SachBean> listItem = thongKeService.getListBySach();
        if(listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(SachBean item : listItem) {
                dataset.addValue(item.getSoLuong(), "Số lượng", item.getNgayBan());
            }
            JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ SỐ LƯỢNG BÁN THEO NGÀY", "THỜI GIAN", "sỐ LƯỢNG", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.repaint();
        }
    }
    public void setDataToChar2(JPanel jpnItem) {
        List<ThongKeThang> listItem = thongKeService.getListByThongKeThang();
        if (listItem != null) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (ThongKeThang item : listItem) {
            dataset.addValue(item.getDoanhThu(), "VNĐ", item.getThang() + " - Bán: " + item.getSoSachTon());
        }
        JFreeChart chart = ChartFactory.createBarChart(
            "THỐNG KÊ DOANH THU VÀ SỐ LƯỢNG BÁN ĐƯỢC THEO THÁNG",
            "THỜI GIAN",
            "DOANH SỐ (VNĐ)",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        CategoryPlot plot = chart.getCategoryPlot();
//        BarRenderer renderer = (BarRenderer) plot.getRenderer();
//        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        renderer.setBaseItemLabelsVisible(true);
//        renderer.setBaseItemLabelFont(new Font("Arial", Font.PLAIN, 12));
//        renderer.setBaseItemLabelPaint(Color.black);



        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.revalidate(); // Use revalidate() instead of repaint() to update the layout
    }
    }
}
