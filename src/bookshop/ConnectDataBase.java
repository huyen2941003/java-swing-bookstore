/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookshop;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Huyen
 */
public class ConnectDataBase {
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=BCCD_JAVA;user=sa;password=123456789;encrypt=false;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionUrl);
            if(conn != null){
                System.out.println("Ket noi thanh cong");
            }
        } catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
