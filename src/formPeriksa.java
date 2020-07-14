
import Connection.ConnectionManager;
import classRS.RekamMedis;
import eksekusi.ExecutionDoktor;
import eksekusi.ExecutionPeriksa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bona
 */
public class formPeriksa extends javax.swing.JFrame {
private Connection con;
private Statement st;
private ResultSet RsPasien;
private ResultSet RsDoktor;
private ResultSet RsPeriksa;
private ResultSet RsDetail;


private ResultSet RsObat;
private String sql="";

private String no, kodepas, namapas, 
        kk, alamat, nohp, gejala, kodedok, namaobat, namadok, keahlian, penyakit, Tanggal;

    /**
     * Creates new form formPeriksa
     */
    public formPeriksa() {
        initComponents();
        DaftarPasien();
        DaftarDoktor();
        JOptionPane.showMessageDialog(null, "Data Rekam Medis");
        tampildata("SELECT * FROM tabel_periksa");
    }
    
    private void form_awal(){
        form_disable();
        form_clear(); 
        Btn_Simpan.setText("Simpan");
        Btn_Simpan.setEnabled(false);
        
    }
  private void form_disable(){
        Txt_namapasien.setEnabled(false);
        Txt_alamatpasien.setEnabled(false);
        Txt_nohp.setEnabled(false);
        Txt_gejala.setEnabled(false);
        Txt_keahlian.setEnabled(false);
        Txt_penyakit.setEnabled(false);
        Txt_namadoktor.setEnabled(false);
        Txt_namaobat.setEnabled(false);
        Txt_jenisobat.setEnabled(false);
        Cmb_kodedoktor.setEnabled(false);
        Cmb_kodepasien.setEnabled(false);
        Rb1.setEnabled(false);
        Rb2.setEnabled(false);
        Rb3.setEnabled(false);
               
  }
  private void form_enable(){
        Txt_no.setEnabled(true);
        Txt_namapasien.setEnabled(true);
        Txt_alamatpasien.setEnabled(true);
        Txt_nohp.setEnabled(true);
        Txt_gejala.setEnabled(true);
        Txt_keahlian.setEnabled(true);
        Txt_penyakit.setEnabled(true);
        Txt_namadoktor.setEnabled(true);
        Txt_namaobat.setEnabled(true);
        Txt_jenisobat.setEnabled(true);
        Cmb_kodedoktor.setEnabled(true);
        Cmb_kodepasien.setEnabled(true);
        Rb1.setEnabled(true);
        Rb2.setEnabled(true);
        Rb3.setEnabled(true);
  }
      private void form_clear(){
        Txt_no.setText("");
        Txt_namapasien.setText("");
        Txt_alamatpasien.setText("");
        Txt_nohp.setText("");
        Txt_gejala.setText("");
        Txt_keahlian.setText("");
        Txt_penyakit.setText("");                   
        Txt_namadoktor.setText("");
        Txt_namaobat.setText("");
        Txt_jenisobat.setText("");      

        Cmb_kodedoktor.setSelectedItem("Pilih");
        Cmb_kodepasien.setSelectedItem("Pilih");
      }

   
    private void tampildata(String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("Nomor Periksa");
        datalist.addColumn("Tanggal Periksa");
        datalist.addColumn("Kode Doktor");
        datalist.addColumn("Kode Pasien");
        datalist.addColumn("Gejala");
        datalist.addColumn("Penyakit");
        datalist.addColumn("Nama Obat");
        try {
            ConnectionManager kon = new ConnectionManager();
            Connection conn = kon.logOn();
            Statement stm = conn.createStatement();
            int i = 1;
            RsPeriksa=stm.executeQuery("SELECT * FROM tabel_periksa");
            while (RsPeriksa.next()){
                datalist.addRow(new Object[]{
                    (""+i++),RsPeriksa.getString(1), RsPeriksa.getString(2), 
                    RsPeriksa.getString(3), RsPeriksa.getString(4), RsPeriksa.getString(5), 
                    RsPeriksa.getString(6), RsPeriksa.getString(7), 
                });
                Gridperiksa.setModel(datalist);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " "+e.getMessage());
        }
        
    }

    private void DaftarPasien(){
        Cmb_kodepasien.removeAllItems();
        Cmb_kodepasien.addItem("Pilih");
        try {
            ConnectionManager kon = new ConnectionManager();
            Connection conn = kon.logOn();
            Statement stm = conn.createStatement();
            
            String sql ="Select * FROM tabel_pasien";
            RsPasien=stm.executeQuery(sql);
            while(RsPasien.next()){
                String Alliasps=RsPasien.getString("kode_pasien");
                Cmb_kodepasien.addItem(Alliasps);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Kode pasien \n"
                +e.getMessage());
        }
    }private void DaftarDoktor(){
        Cmb_kodedoktor.removeAllItems();
        Cmb_kodedoktor.addItem("Pilih");
        try {
            ConnectionManager kon = new ConnectionManager();
            Connection conn = kon.logOn();
            Statement stm = conn.createStatement();
            String sql ="Select * FROM tabel_doktor";
            RsDoktor=stm.executeQuery(sql);
            while(RsDoktor.next()){
                String AlliasD=RsDoktor.getString("kode_doktor");
                Cmb_kodedoktor.addItem(AlliasD);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Kode Doktor \n"
                +e.getMessage());
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Txt_no = new javax.swing.JTextField();
        Txt_namapasien = new javax.swing.JTextField();
        Txt_alamatpasien = new javax.swing.JTextField();
        Cmb_kodepasien = new javax.swing.JComboBox<String>();
        Btn_Simpan = new javax.swing.JButton();
        Btn_Batal = new javax.swing.JButton();
        Btn_Keluar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Txt_nohp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Txt_namadoktor = new javax.swing.JTextField();
        Cmb_kodedoktor = new javax.swing.JComboBox<String>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Rb3 = new javax.swing.JRadioButton();
        Rb2 = new javax.swing.JRadioButton();
        Rb1 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        Cmb_periksa = new javax.swing.JButton();
        Txt_keahlian = new javax.swing.JTextField();
        Txt_penyakit = new javax.swing.JTextField();
        Txt_gejala = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Txt_namaobat = new javax.swing.JTextField();
        Txt_jenisobat = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Gridperiksa = new javax.swing.JTable();
        tgl_periksa = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon0/&System&Library&CoreServices&CoreTypes 67.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon0/Help 1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 8, 120, 120));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel3.setText("Rumah Sakit ITENAS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 510, 40));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel4.setText("Siap Melayani Anda 24 Jam");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 176, 12));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel5.setText("Jl. PH.H. Mustapa No. 23, Bandung");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 970, 10));

        jLabel7.setText("No Periksa");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel8.setText("Tanggal Periksa");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        jLabel9.setText("Nama Pasien");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel10.setText("Kode Doktor");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jLabel11.setText("No Handphone");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        Txt_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_noKeyPressed(evt);
            }
        });
        jPanel1.add(Txt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 160, 120, -1));
        jPanel1.add(Txt_namapasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 120, -1));

        Txt_alamatpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_alamatpasienActionPerformed(evt);
            }
        });
        jPanel1.add(Txt_alamatpasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 120, -1));

        Cmb_kodepasien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Laki-laki", "Perempuan" }));
        Cmb_kodepasien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cmb_kodepasienItemStateChanged(evt);
            }
        });
        Cmb_kodepasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_kodepasienActionPerformed(evt);
            }
        });
        jPanel1.add(Cmb_kodepasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 120, -1));

        Btn_Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/export-16x16.png"))); // NOI18N
        Btn_Simpan.setText("SIMPAN");
        Btn_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SimpanActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, -1, -1));

        Btn_Batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/refresh-16x16.png"))); // NOI18N
        Btn_Batal.setText("BATAL");
        Btn_Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BatalActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 530, 90, -1));

        Btn_Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/forward-16x16.png"))); // NOI18N
        Btn_Keluar.setText("KELUAR");
        Btn_Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_KeluarActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, 90, -1));

        jLabel12.setText("Alamat Pasien");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));
        jPanel1.add(Txt_nohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 120, -1));

        jLabel13.setText("Kode Pasien");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jPanel1.add(Txt_namadoktor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 110, -1));

        Cmb_kodedoktor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih" }));
        Cmb_kodedoktor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cmb_kodedoktorItemStateChanged(evt);
            }
        });
        Cmb_kodedoktor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_kodedoktorActionPerformed(evt);
            }
        });
        jPanel1.add(Cmb_kodedoktor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 110, -1));

        jLabel14.setText("Nama Doktor");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        jLabel15.setText("Keahlian");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        jLabel16.setText("Indikasi");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel17.setText("Gejala");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        Rb3.setBackground(new java.awt.Color(0, 204, 204));
        Rb3.setText("Hidung Tersumbat");
        Rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb3ActionPerformed(evt);
            }
        });
        jPanel1.add(Rb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        Rb2.setBackground(new java.awt.Color(0, 204, 204));
        Rb2.setText("Badan Pegal");
        Rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb2ActionPerformed(evt);
            }
        });
        jPanel1.add(Rb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 120, -1));

        Rb1.setBackground(new java.awt.Color(0, 204, 204));
        Rb1.setText("Kepala Berdenyut");
        Rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rb1ActionPerformed(evt);
            }
        });
        jPanel1.add(Rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

        jLabel18.setText("Diagnosa");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        Cmb_periksa.setText("PERIKSA");
        Cmb_periksa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_periksaActionPerformed(evt);
            }
        });
        jPanel1.add(Cmb_periksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, -1, -1));
        jPanel1.add(Txt_keahlian, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 110, -1));
        jPanel1.add(Txt_penyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 106, -1));

        Txt_gejala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_gejalaActionPerformed(evt);
            }
        });
        jPanel1.add(Txt_gejala, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 110, -1));

        jLabel20.setText("Nama Obat");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, -1));

        jLabel21.setText("Jenis Obat");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, -1, -1));
        jPanel1.add(Txt_namaobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 120, -1));
        jPanel1.add(Txt_jenisobat, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 120, -1));

        Gridperiksa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(Gridperiksa);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 950, 170));
        jPanel1.add(tgl_periksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_noKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_noKeyPressed
        // TODO add your handling code here:
        no=Txt_no.getText();
        int tekanenter=evt.getKeyCode();
        if (tekanenter==10){
            try {
                sql="Select * from tabel_periksa "
                + "where No_Periksa='"+ no +"'";
                ConnectionManager kon = new ConnectionManager();
                Connection conn = kon.logOn();
                Statement stm = conn.createStatement();
                
                RsPeriksa=st.executeQuery(sql);
                while (RsPeriksa.next()) {
                    tgl_periksa.setDate(RsPeriksa.getDate("tgl_periksa"));
                    Cmb_kodedoktor.setSelectedItem(RsPeriksa.getString("kode_doktor"));
                    Cmb_kodepasien.setSelectedItem(RsPeriksa.getString("kode_pasien"));
                    Txt_gejala.setText(RsPeriksa.getString("gejala"));
                    Txt_penyakit.setText(RsPeriksa.getString("penyakit"));
                    JOptionPane.showMessageDialog(null,
                        "Selamat Datang");
                    Btn_Simpan.setEnabled(false);
                    Rb1.setEnabled(false);
                    Rb2.setEnabled(false);
                    Rb3.setEnabled(false);
                    form_disable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan \n"+e.getMessage());
                Txt_no.requestFocus();
            }
        }
    }//GEN-LAST:event_Txt_noKeyPressed

    private void Btn_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SimpanActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        RekamMedis rm=new RekamMedis();
        rm.setNoPeriksa(Txt_no.getText());
        rm.setTglPeriksa(format.format(tgl_periksa.getDate()));       
        rm.setKodePas(Cmb_kodepasien.getItemAt(Cmb_kodepasien.getSelectedIndex()).toString());
        rm.setKodeDokter(Cmb_kodedoktor.getItemAt(Cmb_kodedoktor.getSelectedIndex()).toString());
        rm.setGejala(Txt_gejala.getText());        
        rm.setPenyakit(Txt_penyakit.getText());
        rm.setNamaObat(Txt_namaobat.getText());
        
        ExecutionPeriksa ed=new ExecutionPeriksa();
        String hasil =ed.InsertRekam(rm);
        ConnectionManager kon = new ConnectionManager();
        Connection conn = kon.logOn();
        JOptionPane.showMessageDialog(rootPane, hasil);
        tampildata("SELECT * FROM tabel_periksa");
    }//GEN-LAST:event_Btn_SimpanActionPerformed

    private void Btn_BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BatalActionPerformed
        // TODO add your handling code here:
        form_clear();
        form_enable();
        Btn_Simpan.setEnabled(true);
        Txt_no.requestFocus();
        Txt_no.setEnabled(true);
        Rb1.setEnabled(true);
        Rb3.setEnabled(true);
        Rb2.setEnabled(true);

    }//GEN-LAST:event_Btn_BatalActionPerformed

    private void Btn_KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_KeluarActionPerformed
        // TODO add your handling code here:
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_Btn_KeluarActionPerformed

    private void Cmb_kodepasienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cmb_kodepasienItemStateChanged
        // TODO add your handling code here:
         try {
            ConnectionManager kon = new ConnectionManager();
            Connection conn = kon.logOn();
            Statement stm = conn.createStatement();
            sql="Select * FROM tabel_pasien WHERE "
                    + "kode_pasien='" + Cmb_kodepasien.getSelectedItem() +"'";
           
            RsPasien=stm.executeQuery(sql);
                while(RsPasien.next()){
                    Txt_namapasien.setText(RsPasien.getString("nama_pasien"));
                     Txt_alamatpasien.setText(RsPasien.getString("alamat_pasien"));
                     Txt_nohp.setText(RsPasien.getString("handphone"));
                                   
                }
                
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Detail Pelanggan \n"
                +e.getMessage());
        }
    }//GEN-LAST:event_Cmb_kodepasienItemStateChanged

    private void Txt_alamatpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_alamatpasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_alamatpasienActionPerformed

    private void Cmb_kodedoktorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cmb_kodedoktorItemStateChanged
        // TODO add your handling code here:
        try {
            ConnectionManager kon = new ConnectionManager();
            Connection conn = kon.logOn();
            Statement stm = conn.createStatement();
            sql="Select * FROM tabel_doktor WHERE "
                    + "kode_doktor='" + Cmb_kodedoktor.getSelectedItem() +"'";
          
            RsDoktor=stm.executeQuery(sql);
                while(RsDoktor.next()){
                    Txt_namadoktor.setText(RsDoktor.getString("nama_dokter"));
                     Txt_keahlian.setText(RsDoktor.getString("keahlian"));                             
                }
                           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Detail doktor \n"
                +e.getMessage());
        }
    }//GEN-LAST:event_Cmb_kodedoktorItemStateChanged

    private void Rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb1ActionPerformed
        // TODO add your handling code here:
        if ((Rb1.isSelected())) {
            gejala="Gejala1";
           Rb2.setSelected(false);
           Rb3.setSelected(false);
           Txt_penyakit.setText("");
            }
                   Txt_gejala.setText(String.valueOf(gejala));
    }//GEN-LAST:event_Rb1ActionPerformed

    private void Cmb_periksaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_periksaActionPerformed
        // TODO add your handling code here:
        if ((Rb1.isSelected())) {
            penyakit="tipus";}
            if ((Rb2.isSelected())) {
            penyakit="demam";}
            if ((Rb3.isSelected())) {
            penyakit="pilek";
            
            
            }
            Txt_penyakit.setText(String.valueOf(penyakit));
    }//GEN-LAST:event_Cmb_periksaActionPerformed

    private void Rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb2ActionPerformed
        // TODO add your handling code here:
        if ((Rb2.isSelected())) {
           gejala="Gejala2";
           Rb1.setSelected(false);
           Rb3.setSelected(false);
           Txt_penyakit.setText("");
            }
                   Txt_gejala.setText(String.valueOf(gejala));
    }//GEN-LAST:event_Rb2ActionPerformed

    private void Rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rb3ActionPerformed
        // TODO add your handling code here:
        if ((Rb3.isSelected())) {
            gejala="Gejala3";
           Rb1.setSelected(false);
           Rb2.setSelected(false);
           Txt_penyakit.setText("");
            }
                   Txt_gejala.setText(String.valueOf(gejala));
    }//GEN-LAST:event_Rb3ActionPerformed

    private void Txt_gejalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_gejalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_gejalaActionPerformed

    private void Cmb_kodepasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_kodepasienActionPerformed
        // TODO add your handling code here:
        try {
            ConnectionManager kon = new ConnectionManager();
            Connection conn = kon.logOn();
            Statement stm = conn.createStatement();
            sql="Select * FROM tabel_pasien WHERE "
                    + "kode_pasien='" + Cmb_kodepasien.getSelectedItem() +"'";
            
            RsPasien=stm.executeQuery(sql);
                while(RsPasien.next()){
                    Txt_namapasien.setText(RsPasien.getString("nama_pasien"));
                     Txt_alamatpasien.setText(RsPasien.getString("alamat_pasien"));
                     Txt_nohp.setText(RsPasien.getString("handphone"));
                                   
                }
                
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menampilkan Detail Pelanggan \n"
                +e.getMessage());
        }
    }//GEN-LAST:event_Cmb_kodepasienActionPerformed

    private void Cmb_kodedoktorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_kodedoktorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_kodedoktorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formPeriksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPeriksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPeriksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPeriksa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPeriksa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Batal;
    private javax.swing.JButton Btn_Keluar;
    private javax.swing.JButton Btn_Simpan;
    private javax.swing.JComboBox<String> Cmb_kodedoktor;
    private javax.swing.JComboBox<String> Cmb_kodepasien;
    private javax.swing.JButton Cmb_periksa;
    private javax.swing.JTable Gridperiksa;
    private javax.swing.JRadioButton Rb1;
    private javax.swing.JRadioButton Rb2;
    private javax.swing.JRadioButton Rb3;
    private javax.swing.JTextField Txt_alamatpasien;
    private javax.swing.JTextField Txt_gejala;
    private javax.swing.JTextField Txt_jenisobat;
    private javax.swing.JTextField Txt_keahlian;
    private javax.swing.JTextField Txt_namadoktor;
    private javax.swing.JTextField Txt_namaobat;
    private javax.swing.JTextField Txt_namapasien;
    private javax.swing.JTextField Txt_no;
    private javax.swing.JTextField Txt_nohp;
    private javax.swing.JTextField Txt_penyakit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser tgl_periksa;
    // End of variables declaration//GEN-END:variables

   
}
