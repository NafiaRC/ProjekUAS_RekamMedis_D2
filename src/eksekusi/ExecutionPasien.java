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
public class ExecutionPasien {
    public String InsertPasien(Pasien pas){
        String query="INSERT INTO tabel_pasien(kode_pasien, nama_pasien,alamat_pasien,tanggal_lahir, jenis_kelamin, kepala_keluarga,handphone)"+
                "Values(?,?,?,?,?,?,?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.logOn();
        String Respon;
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,pas.getKode());
            pstm.setString(2,pas.getNama());
            pstm.setString(3,pas.getAlamat());
            pstm.setString(4,pas.getTanggalLahir());
            pstm.setString(5,pas.getJeniskel());
            pstm.setString(6,pas.getKk());
            pstm.setString(7,pas.getNohp());
            pstm.executeUpdate();
            Respon="Insert Sukses";
        }catch (SQLException ex){
            Respon="Insert Gagal";
            Logger.getLogger(ExecutionPasien.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.logOff();
        return Respon;
    }
    
    public ArrayList<Pasien>ListPas(){
        ArrayList<Pasien>arlistpas=new ArrayList<>();
        String query = "Select * from tabel_pasien";
        ConnectionManager conMan = new ConnectionManager();
        Connection con = conMan.logOn();
        try {
            Statement stn = con.createStatement();
            ResultSet rs = stn.executeQuery(query);
            while(rs.next()){
               Pasien pas = new Pasien();
               pas.setKode(rs.getString("kode_pasien_"));
               pas.setNama(rs.getString("nama_pasien"));
               pas.setAlamat(rs.getString("alamat_pasien"));
               pas.setTanggalLahir(rs.getString("tanggal_lahir"));
               pas.setJeniskel(rs.getString("jenis_kelamin"));
               pas.setKk(rs.getString("kepala_keluarga"));
               pas.setNohp(rs.getString("handphone"));
               arlistpas.add(pas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutionPasien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arlistpas;
    }
}
