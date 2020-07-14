/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classRS;

/**
 *
 * @author Nafia Ruwaida C
 */
public class Dokter {
    private String kode;
    private String nama;
    private String alamat;
    private String keahlian;
    private String nohp;

    public Dokter() {
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNohp() {
        return nohp;
    }
    
    public String getKeahlian() {
        return keahlian;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

}
