package quanlydoannhanh;


import java.awt.HeadlessException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class KhachHang extends javax.swing.JInternalFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel kh = null;

    
    public KhachHang() {
        initComponents();
        conn = JavaConnect.ConnectDB();
        kh = (DefaultTableModel) jTableKhachHang.getModel();
        updateTableKhachHang();
    }

    //auto complete text field seach
    public  void updateTableKhachHang() {
        while (kh.getRowCount() > 0) {
            kh.removeRow(0);
        }
        String sql = "select * from KhachHang";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            String row[] = new String[4];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                kh.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTimKiem = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnThemKH = new javax.swing.JButton();
        btnSuaKH = new javax.swing.JButton();
        btnXoaKH = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKhachHang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setTitle("Khách hàng");
        setPreferredSize(new java.awt.Dimension(1143, 676));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText(" Tên Khách Hàng");

        jLabel1.setText(" Mã khách hàng");

        jLabel4.setText(" Số điện thoại");

        jLabel3.setText(" Địa chỉ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT)
                    .addComponent(txtDiachi)
                    .addComponent(txtTenKhachHang)
                    .addComponent(txtMaKhachHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 0, 102))); // NOI18N

        btnThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them1.png"))); // NOI18N
        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnSuaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sửa1.png"))); // NOI18N
        btnSuaKH.setText("Sửa");
        btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKHActionPerformed(evt);
            }
        });

        btnXoaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thunggiac2.png"))); // NOI18N
        btnXoaKH.setText("Xóa");
        btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKHActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset1.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnThemKH)
                .addGap(31, 31, 31)
                .addComponent(btnSuaKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaKH)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKH)
                    .addComponent(btnSuaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset))
                .addContainerGap())
        );

        jTableKhachHang.setBackground(new java.awt.Color(204, 204, 204));
        jTableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại"
            }
        ));
        jTableKhachHang.setToolTipText("");
        jTableKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKhachHang);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Danh sách khách hàng");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "                                                   Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 0, 204))); // NOI18N

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tkiem.PNG"))); // NOI18N
        jLabel8.setText(" Mã khách hàng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel7))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 215, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1178, 526);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        if (txtMaKhachHang.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã khách hàng");
        } else if (txtTenKhachHang.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập tên khách hàng");
        } else if (txtSDT.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập số điện thoại");
        } else if (txtDiachi.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập địa chỉ");
        } else if (ExceptionString.isNumber(txtSDT.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải phải là 1 số");
        } else {
            try {
                if (ExceptionString.isUnicode(txtMaKhachHang.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm không chứa kí tự đặc biệt");
                } else if (ExceptionString.isSpace(txtMaKhachHang.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm không khoảng trắng");
                } else {
                    try {

                        String sql = "Insert into KhachHang(MaKH,TenKH,DiaChi,SoDienThoai) values (?,?,?,?)";

                        pst = conn.prepareStatement(sql);
                        pst.setString(1, txtMaKhachHang.getText());
                        pst.setString(2, txtTenKhachHang.getText());

                        pst.setString(3, txtDiachi.getText());
                        pst.setString(4, txtSDT.getText());

                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Lưu thành công");
                        clean();
                    } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "Lưu thất bại" + e);
                    }
                    updateTableKhachHang();
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnSuaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKHActionPerformed
       
      
        if (txtTenKhachHang.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Cần chọn dòng cần sửa");
        } else if (txtSDT.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập số điện thoại");
        } else if (txtDiachi.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập địa chỉ");
        } else if (ExceptionString.isNumber(txtSDT.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải phải là 1 số");
        } else {
            try {
                String value1 = txtMaKhachHang.getText();
                String value2 = txtTenKhachHang.getText();
                String value3 = txtDiachi.getText();
                String value4 = txtSDT.getText();
                String sql = "update KhachHang set  TenKH =?, DiaChi =?, SoDienThoai =? where MaKH=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, value2);
                pst.setString(2, value3);
                pst.setString(3, value4);
                pst.setString(4, value1);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                clean();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "sửa thất bại" + e);
            }
            updateTableKhachHang();
        }
       
    }//GEN-LAST:event_btnSuaKHActionPerformed

    private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKHActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa", "Xóa", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from KhachHang where MaKH =?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtMaKhachHang.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Xóa thành công");
               clean();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Xóa thất bại" + e);
            }
            updateTableKhachHang();
        }

    }//GEN-LAST:event_btnXoaKHActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
       while (kh.getRowCount() > 0) {
            kh.removeRow(0);
        }
        String sql = "select * from KhachHang where MaKH=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtTimKiem.getText());
            rs = pst.executeQuery();
            String row[] = new String[4];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                kh.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void clean()
    {
        txtMaKhachHang.setText("");
        txtTenKhachHang.setText("");
        txtSDT.setText("");
        txtDiachi.setText("");
        txtMaKhachHang.enable(true);
    }
    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        clean();
        updateTableKhachHang();
    }//GEN-LAST:event_btnResetMouseClicked

    private void jTableKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKhachHangMouseClicked
        try {
            int row = jTableKhachHang.getSelectedRow();
            txtMaKhachHang.setText(jTableKhachHang.getModel().getValueAt(row, 0).toString());
            txtTenKhachHang.setText(jTableKhachHang.getModel().getValueAt(row, 1).toString());
            txtDiachi.setText(jTableKhachHang.getModel().getValueAt(row, 2).toString());
            txtSDT.setText(jTableKhachHang.getModel().getValueAt(row, 3).toString());
            txtMaKhachHang.enable(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTableKhachHangMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSuaKH;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnXoaKH;
    private javax.swing.ButtonGroup buttonGroupTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableKhachHang;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
