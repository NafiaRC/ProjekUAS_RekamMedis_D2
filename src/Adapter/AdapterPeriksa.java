/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import classRS.Pasien;
import classRS.RekamMedis;
import eksekusi.ExecutionPasien;
import eksekusi.ExecutionPeriksa;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class AdapterPeriksa {
    public Object[][]getAllPeriksa(){
        ExecutionPeriksa ed = new ExecutionPeriksa();
        ArrayList<RekamMedis>lstrm;
        lstrm=ed.ListRm();
        Object[][]dataperiksa=new Object[lstrm.size()][5];
        
        //isi data ke array 2 dimensi
        int mysize = 0;
        for(RekamMedis rm : lstrm){
            dataperiksa[mysize][0] = rm.getNoPeriksa();
            dataperiksa[mysize][1] = rm.getTglPeriksa();
            dataperiksa[mysize][2] = rm.getKodeDokter();
            dataperiksa[mysize][3] = rm.getKodePas();
            dataperiksa[mysize][4] = rm.getGejala();
            dataperiksa[mysize][5] = rm.getPenyakit();
            dataperiksa[mysize][6] = rm.getNamaObat();
            mysize++;
        }
        return dataperiksa;
    }
    
}
