/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author Nafia Ruwaida C
 */
public class ConnectionManager {
    private Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/db_rumahsakit";
    private String username = "root";
    private String password = "";
    
    public Connection logOn(){
        try{
            //load JDBC Driver
            Class.forName(driver).newInstance();
            //Buat object Connection
            
            con = DriverManager.getConnection(url, username, password);
            System.out.println("KONEKSI BERHASIL");
           
        }
        catch(Exception ex){
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return con;
    }
    
    public void logOff(){
        try{
            //Tutup Koneksi
            con.close();
        }
        catch(Exception ex){
           Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
