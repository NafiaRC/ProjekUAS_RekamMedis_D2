/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import classRS.Dokter;
import classRS.Pasien;
import eksekusi.ExecutionDoktor;
import eksekusi.ExecutionPasien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nafia Ruwaida C
 */
public class AdapterDokter {
    public Object[][]getAllDokter(){
        ExecutionDoktor ed = new ExecutionDoktor();
        ArrayList<Dokter>lstDkt;
        lstDkt=ed.ListDkt();
        Object[][]datadok=new Object[lstDkt.size()][5];
        
        //isi data ke array 2 dimensi
        int mysize = 0;
        for(Dokter dkt : lstDkt){
            datadok[mysize][0] = dkt.getKode();
            datadok[mysize][1] = dkt.getNama();
            datadok[mysize][2] = dkt.getAlamat();
            datadok[mysize][3] = dkt.getNohp();
            datadok[mysize][4] = dkt.getKeahlian();
            mysize++;
        }
        return datadok;
    }
}
