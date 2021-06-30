/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DanhGia;

import java.awt.HeadlessException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import quanlydoannhanh.DisplayValueModel;
import quanlydoannhanh.JavaConnect;
import quanlydoannhanh.Login;

/**
 *
 * @author Admin
 */
public class DanhGia extends javax.swing.JFrame {

    Connection connHD = null;
    Connection conn = null;
    ResultSet rsHoiDap = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dtHoiDap = null;
    PreparedStatement pstHoiDap = null;
    String datenow = null;
    DefaultComboBoxModel dcb = null;

    public DanhGia() {
        initComponents();
        setTitle("Đánh Giá");
        setLocationRelativeTo(null);
        LocalDate localDate = LocalDate.now();
        datenow = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
        connHD = JavaConnect.ConnectDB();
        conn = JavaConnect.ConnectDB();
        dtHoiDap = (DefaultTableModel) jTableHoiDap.getModel();
        dcb = new DefaultComboBoxModel();
        fillComboxTaiKhoan();
        updateTableHoiDap();
    }

    private void updateTableHoiDap() {
        while (dtHoiDap.getRowCount() > 0) {
            dtHoiDap.removeRow(0);
        }
        String sql = "select TaiKhoan.TenNguoiDung,DanhGia.NgayHoi,DanhGia.NoiDungHoi from  TaiKhoan INNER JOIN DanhGia ON TaiKhoan.TenTaiKhoan = DanhGia.TenTaiKhoan";
        String row[] = new String[3];
        try {
            pstHoiDap = connHD.prepareStatement(sql);
            rsHoiDap = pstHoiDap.executeQuery();
            while (rsHoiDap.next()) {
                row[0] = rsHoiDap.getString(1);
                row[1] = rsHoiDap.getString(2);
                row[2] = rsHoiDap.getString(3);

                dtHoiDap.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        NoiDungHoi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHoiDap = new javax.swing.JTable();
        jComboBoxHoiDap = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đánh Giá");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 2000));

        jLabel1.setBackground(new java.awt.Color(0, 51, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐÁNH GIÁ CỦA KHÁCH HÀNG");

        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gui2.png"))); // NOI18N
        jButton1.setText("Gửi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        NoiDungHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoiDungHoiActionPerformed(evt);
            }
        });

        jTableHoiDap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên Người Hỏi", "Ngày đánh giá", "Nội Dung đánh giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableHoiDap);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/huy1.PNG"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên Khách Hàng/Nhân viên");

        jLabel5.setText("Nội dung");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(NoiDungHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(jButton3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56)
                                                .addComponent(jComboBoxHoiDap, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 651, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxHoiDap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(9, 9, 9)
                        .addComponent(NoiDungHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1486, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        quanlydoannhanh.Login M = new Login();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void NoiDungHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoiDungHoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoiDungHoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DisplayValueModel dvm = (DisplayValueModel) jComboBoxHoiDap.getSelectedItem();

        if (NoiDungHoi.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập nội dung");

        } else {

            try {
                String sql = "Insert into DanhGia(TenTaiKhoan,NgayHoi,NoiDungHoi) values (?,CONVERT(DATETIME,?, 102),?)";
                pstHoiDap = connHD.prepareStatement(sql);

                pstHoiDap.setString(1, dvm.valueMember.toString());
                pstHoiDap.setString(3, NoiDungHoi.getText());
                pstHoiDap.setString(2, datenow);
                pstHoiDap.execute();
                JOptionPane.showMessageDialog(null, "Lưu thành công");
                NoiDungHoi.setText("");
                //clean();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Mã bị trùng" + e);
            }
            updateTableHoiDap();
        }


    }//GEN-LAST:event_jButton1ActionPerformed
    public void fillComboxTaiKhoan() {
        String sql = "Select * from TaiKhoan";
        try {
            pst = conn.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String tennguoidung = rs.getString("TenNguoiDung");
                String manguoidung = rs.getString("TenTaiKhoan");
                DisplayValueModel dvn = new DisplayValueModel(tennguoidung, manguoidung);
                dcb.addElement(dvn);
            }
            jComboBoxHoiDap.setModel(dcb);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NoiDungHoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxHoiDap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHoiDap;
    // End of variables declaration//GEN-END:variables
}
