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
public class KhachHangUuTu extends javax.swing.JFrame {

    Connection connU = null;
    ResultSet rsU = null;
    DefaultTableModel dtU = null;
    PreparedStatement pstU = null;

    public KhachHangUuTu() {
        initComponents();
        setTitle("Khách Hàng Tiềm Năng");
        setLocationRelativeTo(null);
        connU = JavaConnect.ConnectDB();
        connU = JavaConnect.ConnectDB();
        dtU = (DefaultTableModel) jUu.getModel();

    }

    private void updateTableU() {
        while (dtU.getRowCount() > 0) {
            dtU.removeRow(0);
        }
        String sql = "SELECT  KhachHang.TenKH,sum(HoaDonXuat.ThanhTien) As \"ThanhTien\"\n"
                + "FROM KhachHang inner join HoaDonXuat on KhachHang.MaKH=HoaDonXuat.MaKH\n"
                + "group by KhachHang.TenKH\n"
                + "order by ThanhTien desc";
        String row[] = new String[2];
        try {
            pstU = connU.prepareStatement(sql);
            rsU = pstU.executeQuery();
            while (rsU.next()) {
                row[0] = rsU.getString(1);
                row[1] = rsU.getString(2);

                dtU.addRow(row);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jUu = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Khách Hàng Tiềm Năng");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/huy1.PNG"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jUu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên Khách Hàng", "Số Tiền Dùng"
            }
        ));
        jScrollPane1.setViewportView(jUu);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tkiem.PNG"))); // NOI18N
        jButton2.setText("Tìm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String sql = "SELECT  KhachHang.TenKH,sum(HoaDonXuat.ThanhTien) As \"ThanhTien\"\n"
                    + "FROM KhachHang inner join HoaDonXuat on KhachHang.MaKH=HoaDonXuat.MaKH\n"
                    + "group by KhachHang.TenKH\n"
                    + "order by ThanhTien desc";
            pstU = connU.prepareStatement(sql);

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        updateTableU();

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jUu;
    // End of variables declaration//GEN-END:variables
}
