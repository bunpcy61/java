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
import quanlydoannhanh.MainActivity;
/**
 *
 * @author Admin
 */
public class SanPhamSapHetHan extends javax.swing.JFrame {
      Connection connN = null;
    ResultSet rsN = null;
    DefaultTableModel dtN = null;
    PreparedStatement pstN = null;
    public SanPhamSapHetHan() {
        initComponents();
        setTitle("Sản phẩm Sắp hết hạn sử dụng");
        setLocationRelativeTo(null);
        connN = JavaConnect.ConnectDB();
        dtN = (DefaultTableModel) jHSD.getModel();
    }

    private void updateH() {
        while (dtN.getRowCount() > 0) {
            dtN.removeRow(0);
        }
        String sql = "select SanPham.TenSP,SanPham.HanSD, DATEDIFF(day,GETDATE(),SanPham.HanSD) from SanPham where DATEDIFF(day,GETDATE(),SanPham.HanSD)<90\n" +
"order by DATEDIFF(day,GETDATE(),SanPham.HanSD) asc";
        String row[] = new String[3];
        try {
            pstN = connN.prepareStatement(sql);
            rsN = pstN.executeQuery();
            while (rsN.next()) {
                row[0] = rsN.getString(1);
                row[1] = rsN.getString(2);
                row[2] = rsN.getString(3);
                
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
        jHSD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Sản phẩm Sắp hết HSD ,đã hết hạn");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/huy1.PNG"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tkiem.PNG"))); // NOI18N
        jButton2.setText("Kiểm Tra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jHSD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jHSD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên Sản phẩm", "Hạn Sử Dụng", "Số Ngày "
            }
        ));
        jScrollPane1.setViewportView(jHSD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String sql = "select SanPham.TenSP,SanPham.HanSD, DATEDIFF(day,GETDATE(),SanPham.HanSD) from SanPham where DATEDIFF(day,GETDATE(),SanPham.HanSD)<90\n" +
"order by DATEDIFF(day,GETDATE(),SanPham.HanSD) asc";
            pstN = connN.prepareStatement(sql);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        updateH();
                    
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTable jHSD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
