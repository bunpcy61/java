/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KiemSoat;

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
public class ThietLapThongSo extends javax.swing.JFrame {

    Connection connN = null;
    ResultSet rsN = null;
    DefaultTableModel dtN = null;
    DefaultTableModel dtN1 = null;
    DefaultTableModel dtN2 = null;
    DefaultTableModel dtN3 = null;
    DefaultTableModel dtN4 = null;
    DefaultTableModel dtN5 = null;
    PreparedStatement pstN = null;
    
    public ThietLapThongSo() {
        initComponents();
        setTitle("Thiết Lập Thông Số");
        setLocationRelativeTo(null);
         connN = JavaConnect.ConnectDB();
        dtN = (DefaultTableModel) jtk.getModel();
        dtN1 = (DefaultTableModel) jtk1.getModel();
         dtN2 = (DefaultTableModel) jtk2.getModel();
          dtN3 = (DefaultTableModel) jtk3.getModel();
           dtN4 = (DefaultTableModel) jtk4.getModel();
            dtN5 = (DefaultTableModel) jtk5.getModel();

    }
private void updateN() {
        while (dtN.getRowCount() > 0) {
            dtN.removeRow(0);
        }
        String sql = "select count(TaiKhoan.TenTaiKhoan)  from TaiKhoan";
        String row[] = new String[1];
        try {
            pstN = connN.prepareStatement(sql);
            rsN = pstN.executeQuery();
            while (rsN.next()) {
                row[0] = rsN.getString(1);
                
                dtN.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }
private void updateN1() {
        while (dtN1.getRowCount() > 0) {
            dtN1.removeRow(0);
        }
        String sql1 = "select count(SanPham.TenSP) from SanPham";
        String row[] = new String[1];
        try {
            pstN = connN.prepareStatement(sql1);
            rsN = pstN.executeQuery();
            while (rsN.next()) {
                row[0] = rsN.getString(1);
                
                dtN1.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }
private void updateN2() {
        while (dtN2.getRowCount() > 0) {
            dtN2.removeRow(0);
        }
        String sql2 = "select count(KhachHang.TenKH) from KhachHang";
        String row[] = new String[1];
        try {
            pstN = connN.prepareStatement(sql2);
            rsN = pstN.executeQuery();
            while (rsN.next()) {
                row[0] = rsN.getString(1);
                
                dtN2.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }
private void updateN3() {
        while (dtN3.getRowCount() > 0) {
            dtN3.removeRow(0);
        }
        String sql3 = "select count(NhaCungCap.TenNhaCC) from NhaCungCap";
        String row[] = new String[1];
        try {
            pstN = connN.prepareStatement(sql3);
            rsN = pstN.executeQuery();
            while (rsN.next()) {
                row[0] = rsN.getString(1);
                
                dtN3.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }
private void updateN4() {
        while (dtN4.getRowCount() > 0) {
            dtN4.removeRow(0);
        }
        String sql4 = "select count(HoaDonNhap.MaHDN) from HoaDonNhap";
        String row[] = new String[4];
        try {
            pstN = connN.prepareStatement(sql4);
            rsN = pstN.executeQuery();
            while (rsN.next()) {
                row[0] = rsN.getString(1);
                
                dtN4.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }
private void updateN5() {
        while (dtN5.getRowCount() > 0) {
            dtN5.removeRow(0);
        }
        String sql5 = "select count(HoaDonXuat.MaHDX) from HoaDonXuat";
        String row[] = new String[1];
        try {
            pstN = connN.prepareStatement(sql5);
            rsN = pstN.executeQuery();
            while (rsN.next()) {
                row[0] = rsN.getString(1);
                
                dtN5.addRow(row);
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jtk = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtk1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtk2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtk3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtk4 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtk5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("           Thông Số");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/huy1.PNG"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Số Tài Khoản"
            }
        ));
        jScrollPane4.setViewportView(jtk);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tkiem.PNG"))); // NOI18N
        jButton2.setText("Truy Vấn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jtk1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Số Loại sản phẩm"
            }
        ));
        jScrollPane5.setViewportView(jtk1);

        jtk2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Số Khách Hàng"
            }
        ));
        jScrollPane6.setViewportView(jtk2);

        jtk3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Số N Cung Cấp"
            }
        ));
        jScrollPane7.setViewportView(jtk3);

        jtk4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Số HĐ Nhập"
            }
        ));
        jScrollPane8.setViewportView(jtk4);

        jtk5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Số HĐ Xuất"
            }
        ));
        jScrollPane9.setViewportView(jtk5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try {
            String sql = "select count(TaiKhoan.TenTaiKhoan)  from TaiKhoan";
            pstN = connN.prepareStatement(sql);
             String sql1 = "select count(SanPham.TenSP) from SanPham";
             pstN = connN.prepareStatement(sql1);
             String sql2 = "select count(KhachHang.TenKH) from KhachHang";
             pstN = connN.prepareStatement(sql2); 
             String sql3 = "select count(NhaCungCap.TenNhaCC) from NhaCungCap";
             pstN = connN.prepareStatement(sql3); 
             String sql4 = "select count(HoaDonNhap.MaHDN) from HoaDonNhap";
             pstN = connN.prepareStatement(sql4); 
             String sql5 = "select count(HoaDonXuat.MaHDX) from HoaDonXuat";
             pstN = connN.prepareStatement(sql5); 
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
         updateN();
          updateN1();
           updateN2();
           updateN3();
            updateN4();
             updateN5();
                    
           
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jtk;
    private javax.swing.JTable jtk1;
    private javax.swing.JTable jtk2;
    private javax.swing.JTable jtk3;
    private javax.swing.JTable jtk4;
    private javax.swing.JTable jtk5;
    // End of variables declaration//GEN-END:variables
}
