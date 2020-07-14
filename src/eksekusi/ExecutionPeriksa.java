/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eksekusi;

import Connection.ConnectionManager;
import classRS.Pasien;
import classRS.RekamMedis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ExecutionPeriksa {
        public String InsertRekam(RekamMedis rm){
        String query="INSERT INTO tabel_periksa(No_periksa, tgl_periksa,kode_doktor,kode_pasien, gejala, penyakit,nama_obat)"+
                "Values(?,?,?,?,?,?,?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.logOn();
        String Respon;
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,rm.getNoPeriksa());
            pstm.setString(2,rm.getTglPeriksa());
            pstm.setString(3,rm.getKodeDokter());
            pstm.setString(4,rm.getKodePas());
            pstm.setString(5,rm.getGejala());
            pstm.setString(6,rm.getPenyakit());
            pstm.setString(7,rm.getNamaObat());
            pstm.executeUpdate();
            Respon="Insert Sukses";
        }catch (SQLException ex){
            Respon="Insert Gagal";
            Logger.getLogger(ExecutionPeriksa.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.logOff();
        return Respon;
    }
    
    public ArrayList<RekamMedis>ListRm(){
        ArrayList<RekamMedis>arlistrm=new ArrayList<>();
        String query = "Select * from tabel_periksa";
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.logOn();
        try {
            Statement stn = con.createStatement();
            ResultSet rs = stn.executeQuery(query);
            while(rs.next()){
               RekamMedis rm = new RekamMedis();
               rm.setNoPeriksa(rs.getString("No_Periksa"));
               rm.setTglPeriksa(rs.getString("tgl_periksa"));
               rm.setKodePas(rs.getString("kode_pasien"));
               rm.setKodeDokter(rs.getString("kode_dokter"));
               rm.setGejala(rs.getString("gejala"));
               rm.setPenyakit(rs.getString("penyakit"));
               rm.setNamaObat(rs.getString("nama_obat"));
               arlistrm.add(rm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutionPeriksa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arlistrm;
    }
}
