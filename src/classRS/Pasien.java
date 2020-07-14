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
public class Pasien {
    private String kode;
    private String nama;
    private String alamat;
    private String nohp;
    private String jeniskel;
    private String kk;
    private String tanggal_lahir;

    public Pasien() {
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
    
    public String getJeniskel() {
        return jeniskel;
    }
    public String getKk() {
        return kk;
    }
    public String getTanggalLahir() {
        return tanggal_lahir;
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
    public void setJeniskel(String jeniskel) {
        this.jeniskel = jeniskel;
    }
    public void setKk(String kk) {
        this.kk = kk;
    }
    public void setTanggalLahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }
}
