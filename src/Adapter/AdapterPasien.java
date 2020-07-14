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
public class AdapterPasien {
    public Object[][]getAllPasien(){
        ExecutionPasien ed = new ExecutionPasien();
        ArrayList<Pasien>lstPas;
        lstPas=ed.ListPas();
        Object[][]datapas=new Object[lstPas.size()][5];
        
        //isi data ke array 2 dimensi
        int mysize = 0;
        for(Pasien pas : lstPas){
            datapas[mysize][0] = pas.getKode();
            datapas[mysize][1] = pas.getNama();
            datapas[mysize][2] = pas.getAlamat();
            datapas[mysize][3] = pas.getTanggalLahir();
            datapas[mysize][4] = pas.getJeniskel();
            datapas[mysize][5] = pas.getKk();
            datapas[mysize][6] = pas.getNohp();
            mysize++;
        }
        return datapas;
    }
}
