
import Connection.ConnectionManager;
import classRS.Dokter;
import classRS.Pasien;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import eksekusi.ExecutionDoktor;
import eksekusi.ExecutionPasien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class formPasien extends javax.swing.JFrame {
private Connection con;
private Statement st;
private ResultSet RsPasien;
private String sql="";

private String kode, jeniskel, nama, nohp, kk, alamat,Tanggal ;
    /**
     * Creates new form 
     */
    public formPasien() {
        initComponents();
        tampildata("SELECT * FROM tabel_pasien");
    }
    private void form_awal(){
        form_disable();
        form_clear(); 
        Btn_Simpan.setText("Simpan");
        Btn_Tambah.requestFocus(true);
        Btn_Tambah.setEnabled(true);
        Btn_Simpan.setEnabled(false);
        Btn_Batal.setEnabled(false);
        Btn_Hapus.setEnabled(false);
        Btn_Ubah.setEnabled(false);
        
    }
  private void form_disable(){
        Txt_kodepasien.setEnabled(false);
        Txt_namapasien.setEnabled(false);
        Txt_alamatpasien.setEnabled(false);
        Txt_kk.setEnabled(false);
        Txt_nohp.setEnabled(false);
        Cmb_jeniskelamin.setEnabled(false);
  }
  private void form_enable(){
      Txt_alamatpasien.setEnabled(true);
        Txt_kk.setEnabled(true);
        Txt_kodepasien.setEnabled(true);
        Txt_namapasien.setEnabled(true);
       Txt_nohp.setEnabled(true);
        Cmb_jeniskelamin.setEnabled(true);
  }
      private void form_clear(){
       Txt_kodepasien.setText("");
       Txt_alamatpasien.setText("");
       Txt_kk.setText("");
       Txt_namapasien.setText("");
       Txt_nohp.setText("");
       Cmb_jeniskelamin.setSelectedItem("Pilih");
      }
        private void aksi_tambah(){
        form_enable();
        Btn_Tambah.setEnabled(true);
        Btn_Simpan.setEnabled(true);
        Btn_Ubah.setEnabled(true);
        Btn_Batal.setEnabled(true);
        Btn_Hapus.setEnabled(false);
        
        Txt_kodepasien.requestFocus(true);
        }

    private void tampildata(String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("Kode Pasien");
        datalist.addColumn("Nama Pasien");
        datalist.addColumn("Alamat Pasien");
        datalist.addColumn("Tanggal Lahir");
        datalist.addColumn("Jenis Kelamin");
        datalist.addColumn("Kepala Keluarga");
        datalist.addColumn("Handphone");
        try {
            ConnectionManager kon = new ConnectionManager();
            Connection conn = kon.logOn();
            Statement stm = conn.createStatement();
            int i = 1;
            RsPasien=stm.executeQuery("SELECT * FROM tabel_pasien");
            while (RsPasien.next()){
                datalist.addRow(new Object[]{
                    (""+i++),RsPasien.getString(1), RsPasien.getString(2), 
                    RsPasien.getString(3), RsPasien.getString(4), RsPasien.getString(5), 
                    RsPasien.getString(6), RsPasien.getString(7)
                });
                Gridpasien.setModel(datalist);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GAGAL TAMPIL \n"+e.getMessage());
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Txt_kodepasien = new javax.swing.JTextField();
        Txt_namapasien = new javax.swing.JTextField();
        Txt_nohp = new javax.swing.JTextField();
        Cmb_jeniskelamin = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Gridpasien = new javax.swing.JTable();
        Btn_Simpan = new javax.swing.JButton();
        Btn_Ubah = new javax.swing.JButton();
        Btn_Hapus = new javax.swing.JButton();
        Btn_Batal = new javax.swing.JButton();
        Btn_Keluar = new javax.swing.JButton();
        Btn_Tambah = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        Txt_kk = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Txt_alamatpasien = new javax.swing.JTextField();
        Tanggal_Lahir = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
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

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, 10));

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

        jLabel7.setText("Kode Pasien");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel8.setText("Nama Pasien");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel9.setText("Tanggal Lahir");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel10.setText("Jenis Kelamin");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel11.setText("No Handphone");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        Txt_kodepasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_kodepasienKeyPressed(evt);
            }
        });
        jPanel1.add(Txt_kodepasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 160, 120, -1));
        jPanel1.add(Txt_namapasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 190, 120, -1));
        jPanel1.add(Txt_nohp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 120, -1));

        Cmb_jeniskelamin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "Laki-laki", "Perempuan" }));
        jPanel1.add(Cmb_jeniskelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 120, -1));

        Gridpasien.setModel(new javax.swing.table.DefaultTableModel(
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
        Gridpasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GridpasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Gridpasien);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 160, 710, 180));

        Btn_Simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/export-16x16.png"))); // NOI18N
        Btn_Simpan.setText("SIMPAN");
        Btn_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SimpanActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, -1, -1));

        Btn_Ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/cut-16x16.png"))); // NOI18N
        Btn_Ubah.setText("UBAH");
        Btn_Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UbahActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, -1, -1));

        Btn_Hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/cancel-16x16.png"))); // NOI18N
        Btn_Hapus.setText("HAPUS");
        Btn_Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HapusActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, -1, -1));

        Btn_Batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/refresh-16x16.png"))); // NOI18N
        Btn_Batal.setText("BATAL");
        Btn_Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BatalActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 90, -1));

        Btn_Keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/forward-16x16.png"))); // NOI18N
        Btn_Keluar.setText("KELUAR");
        Btn_Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_KeluarActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 350, 90, -1));

        Btn_Tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon3/add-16x16.png"))); // NOI18N
        Btn_Tambah.setText("TAMBAH");
        Btn_Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_TambahActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        jLabel12.setText("Kepala Keluarga");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));
        jPanel1.add(Txt_kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 120, -1));

        jLabel13.setText("Alamat Pasien");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jPanel1.add(Txt_alamatpasien, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 120, -1));
        jPanel1.add(Tanggal_Lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BatalActionPerformed
        // TODO add your handling code here:
        form_clear();
        Btn_Tambah.setEnabled(true);
        Btn_Simpan.setEnabled(true);
        Txt_kodepasien.requestFocus();
        Btn_Hapus.setEnabled(true);
        Txt_kodepasien.setEnabled(true);
       
    }//GEN-LAST:event_Btn_BatalActionPerformed

    private void Btn_KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_KeluarActionPerformed
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_Btn_KeluarActionPerformed

    private void Btn_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SimpanActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        Pasien pas=new Pasien();
        pas.setKode(Txt_kodepasien.getText());
        pas.setNama(Txt_namapasien.getText());
        pas.setAlamat(Txt_alamatpasien.getText());
        pas.setTanggalLahir(format.format(Tanggal_Lahir.getDate()));
        pas.setKk(Txt_kk.getText());
        pas.setJeniskel(Cmb_jeniskelamin.getItemAt(Cmb_jeniskelamin.getSelectedIndex()).toString());
        pas.setNohp(Txt_nohp.getText());
        
        ExecutionPasien ed=new ExecutionPasien();
        String hasil =ed.InsertPasien(pas);
        ConnectionManager kon = new ConnectionManager();
        Connection conn = kon.logOn();
        JOptionPane.showMessageDialog(rootPane, hasil);
        tampildata("SELECT * FROM tabel_pasien");      
    }//GEN-LAST:event_Btn_SimpanActionPerformed

    private void Btn_UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UbahActionPerformed
        // TODO add your handling code here:
    
    SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
    Tanggal=format.format(Tanggal_Lahir.getDate());
    kode=String.valueOf(Txt_kodepasien.getText());
    nama=String.valueOf(Txt_namapasien.getText());
    nohp=String.valueOf(Txt_nohp.getText());
    jeniskel=Cmb_jeniskelamin.getItemAt(Cmb_jeniskelamin.getSelectedIndex()).toString();
    kk=String.valueOf(Txt_kk.getText());
    alamat=String.valueOf(Txt_alamatpasien.getText());
           
    try {
        String query ="UPDATE tabel_pasien set nama_pasien= '"+nama+"', "
                        + "alamat_pasien = '"+alamat+"', tanggal_lahir = '"+Tanggal+"', "
                        + "kepala_keluarga = '"+kk+"', handphone = '"+nohp+"' "
                        + "where kode_pasien ='"+kode+"'";
        ConnectionManager kon = new ConnectionManager();
        Connection conn = kon.logOn();
        Statement stm = conn.createStatement();
        stm.executeUpdate(query);
        tampildata("SELECT * FROM tabel_pasien");
        form_awal();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        Txt_kodepasien.requestFocus();
        } catch (Exception e) {
            Logger.getLogger(Pasien.class.getName()).log(Level.SEVERE, null, e);
        }

    }//GEN-LAST:event_Btn_UbahActionPerformed

    private void Txt_kodepasienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_kodepasienKeyPressed
        // TODO add your handling code here:
        kode=Txt_kodepasien.getText();
        int tekanenter=evt.getKeyCode();
        if (tekanenter==10){
            try {
                sql="Select * from tabel_pasien "
                        + "where kode_pasien='"+ kode +"'";
                st=con.createStatement();
                RsPasien=st.executeQuery(sql);
                while (RsPasien.next()) {
                   Txt_namapasien.setText(RsPasien.getString("nama_pasien"));
                   Txt_alamatpasien.setText(RsPasien.getString("alamat_pasien"));
                   Tanggal_Lahir.setDate(RsPasien.getDate("tanggal_lahir"));
                   Cmb_jeniskelamin.setSelectedItem(RsPasien.getString("jenis_kelamin"));
                   Txt_kk.setText(RsPasien.getString("kepala_keluarga"));
                   Txt_nohp.setText(RsPasien.getString("handphone"));
                   JOptionPane.showMessageDialog(null,
                           "Data Ditemukan");
                   Btn_Tambah.setEnabled(false);
                   Btn_Simpan.setEnabled(false);
                   Btn_Hapus.setEnabled(true);
                   Txt_kodepasien.setEnabled(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan \n"+e.getMessage());
                Txt_kodepasien.requestFocus();
            }
        }
    }//GEN-LAST:event_Txt_kodepasienKeyPressed

    private void Btn_TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_TambahActionPerformed
        // TODO add your handling code here:
        aksi_tambah();
    }//GEN-LAST:event_Btn_TambahActionPerformed

    private void Btn_HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HapusActionPerformed
        String msg = "Data Akan Dihapus ?";
        int pesan = JOptionPane.showConfirmDialog(null,msg,"Konfirmasi",JOptionPane.YES_NO_OPTION);
        
        if (pesan == JOptionPane.YES_OPTION){
        kode=String.valueOf(Txt_kodepasien.getText());
        
        String query =  "DELETE from tabel_pasien where kode_pasien = '"+kode+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        Statement stm;
        int hasil = 0;
        try {
            stm = conn.createStatement();
            hasil = stm.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
            Txt_kodepasien.requestFocus();
        } catch (Exception e) {
            Logger.getLogger(ExecutionPasien.class.getName()).log(Level.SEVERE, null, e);
        }
        conMan.logOff();
        tampildata("select*from tabel_pasien");
        }
    }//GEN-LAST:event_Btn_HapusActionPerformed

    private void GridpasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GridpasienMouseClicked
        // TODO add your handling code here:
     
    }//GEN-LAST:event_GridpasienMouseClicked

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Batal;
    private javax.swing.JButton Btn_Hapus;
    private javax.swing.JButton Btn_Keluar;
    private javax.swing.JButton Btn_Simpan;
    private javax.swing.JButton Btn_Tambah;
    private javax.swing.JButton Btn_Ubah;
    private javax.swing.JComboBox<String> Cmb_jeniskelamin;
    private javax.swing.JTable Gridpasien;
    private com.toedter.calendar.JDateChooser Tanggal_Lahir;
    private javax.swing.JTextField Txt_alamatpasien;
    private javax.swing.JTextField Txt_kk;
    private javax.swing.JTextField Txt_kodepasien;
    private javax.swing.JTextField Txt_namapasien;
    private javax.swing.JTextField Txt_nohp;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
