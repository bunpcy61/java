/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaoCao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlydoannhanh.JavaConnect;

/**
 *
 * @author Admin
 */
public class BaoCaoDoanhThuTheoNgay extends javax.swing.JFrame {

    Connection connN = null;
    ResultSet rsN = null;
    DefaultTableModel dtN = null;
    PreparedStatement pstN = null;

    public BaoCaoDoanhThuTheoNgay() {
        initComponents();
        setTitle("Báo Cáo Doanh Thu");
        setLocationRelativeTo(null);

        connN = JavaConnect.ConnectDB();
        dtN = (DefaultTableModel) TT.getModel();
    }

    private void updateT() {
        while (dtN.getRowCount() > 0) {
            dtN.removeRow(0);
        }
        String sql = " Select sum(HoaDonNhap.ThanhTien),sum(HoaDonNhap.SoLuong), sum(HoaDonXuat.ThanhTien) ,sum(HoaDonXuat.SoLuong),sum(HoaDonXuat.ThanhTien)-Sum(HoaDonNhap.ThanhTien),getdate() from HoaDonNhap inner join HoaDonXuat on HoaDonNhap.MaSP=HoaDonXuat.MaSP";
        String row[] = new String[6];
        try {
            pstN = connN.prepareStatement(sql);
            rsN = pstN.executeQuery();
            while (rsN.next()) {
                row[0] = rsN.getString(1);
                row[1] = rsN.getString(2);
                row[2] = rsN.getString(3);
                row[3] = rsN.getString(4);
                row[4] = rsN.getString(5);
                row[5] = rsN.getString(6);
                dtN.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Báo Cáo Doanh Thu");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/huy1.PNG"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tkiem.PNG"))); // NOI18N
        jButton2.setText("Thống Kê");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tiền Nhập", "Sản Phẩn Nhập", " Tiền Xuất", " Sản Phẩn Xuất", " Doanh thu", "NgàyThống Kê"
            }
        ));
        jScrollPane1.setViewportView(TT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(46, 46, 46)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addGap(93, 93, 93))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String sql = "Select sum(HoaDonNhap.ThanhTien),sum(HoaDonNhap.SoLuong), sum(HoaDonXuat.ThanhTien) ,sum(HoaDonXuat.SoLuong),sum(HoaDonXuat.ThanhTien)- Sum(HoaDonNhap.ThanhTien),getdate() from HoaDonNhap inner join HoaDonXuat on HoaDonNhap.MaSP=HoaDonXuat.MaSP";
            pstN = connN.prepareStatement(sql);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        updateT();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
