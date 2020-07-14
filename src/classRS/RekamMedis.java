/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classRS;

/**
 *
 * @author ASUS
 */
public class RekamMedis {
    private String no_periksa;
    private String tgl_periksa;
    private String kodePas;
    private String kodeDokter;
    private String kodePasien;
    private String gejala;
    private String penyakit;
    private String nama_obat;

    public RekamMedis() {
    }

    public String getNoPeriksa() {
        return no_periksa;
    }

    public String getTglPeriksa() {
        return tgl_periksa;
    }

    public String getKodePas() {
        return kodePas;
    }

    public String getKodeDokter() {
        return kodeDokter;
    }
    
    public String getGejala() {
        return gejala;
    }
    public String getPenyakit() {
        return penyakit;
    }
    public String getNamaObat() {
        return nama_obat;
    }
    public void setNoPeriksa(String no_periksa) {
        this.no_periksa = no_periksa;
    }

    public void setTglPeriksa(String tgl_periksa) {
        this.tgl_periksa = tgl_periksa;
    }

    public void setKodePas(String kodePas) {
        this.kodePas = kodePas;
    }

    public void setKodeDokter(String kodeDokter) {
        this.kodeDokter = kodeDokter;
    }
    public void setGejala(String gejala) {
        this.gejala = gejala;
    }
    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }
    public void setNamaObat(String nama_obat) {
        this.nama_obat = nama_obat;
    }
}
