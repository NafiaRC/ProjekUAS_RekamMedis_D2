/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eksekusi;

import Connection.ConnectionManager;
import classRS.Dokter;
import classRS.Pasien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nafia Ruwaida C
 */
public class ExecutionDoktor {
    
    public String InsertDokter(Dokter dk){
        String query="INSERT INTO tabel_doktor(kode_doktor, nama_dokter,alamat_dokter,keahlian, no_handphone)"+
                "Values(?,?,?,?,?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.logOn();
        String Respon;
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,dk.getKode());
            pstm.setString(2,dk.getNama());
            pstm.setString(3,dk.getAlamat());
            pstm.setString(4,dk.getKeahlian());
            pstm.setString(5,dk.getNohp());
            pstm.executeUpdate();
            Respon="Insert Sukses";
        }catch (SQLException ex){
            Respon="Insert Gagal";
            Logger.getLogger(ExecutionDoktor.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.logOff();
        return Respon;
    }
    
    public ArrayList<Dokter>ListDkt(){
        ArrayList<Dokter>arlistdkt=new ArrayList<>();
        String query = "Select * from tabel_doktor";
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.logOn();
        try {
            Statement stn = con.createStatement();
            ResultSet rs = stn.executeQuery(query);
            while(rs.next()){
               Dokter dkt = new Dokter();
               dkt.setKode(rs.getString("kode_doktor"));
               dkt.setNama(rs.getString("nama_dokter"));
               dkt.setAlamat(rs.getString("alamat_dokter"));
               dkt.setKeahlian(rs.getString("keahlian"));
               dkt.setNohp(rs.getString("no_handphone"));
               arlistdkt.add(dkt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutionDoktor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arlistdkt;
    }

}
