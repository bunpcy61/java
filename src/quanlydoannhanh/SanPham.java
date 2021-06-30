package quanlydoannhanh;

import java.awt.HeadlessException;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class SanPham extends javax.swing.JInternalFrame {

    Connection connSP = null;
    Connection conn = null;
    ResultSet rsSP = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    DefaultTableModel dtSP = null;
    PreparedStatement pstSP = null;
    DefaultComboBoxModel dcb = null;

    public SanPham() {
        initComponents();
        connSP= JavaConnect.ConnectDB();
        conn = JavaConnect.ConnectDB();
        dtSP = (DefaultTableModel) jTableSanPham.getModel();
        dcb = new DefaultComboBoxModel();
        updateTableThuoc();
        //fillComboMaNhaCungCapNhap();

    }

    //update table thuoc
    public void updateTableThuoc() {
        while (dtSP.getRowCount() > 0) {
            dtSP.removeRow(0);
        }
        String sql = "select  SanPham.MaSP, SanPham.TenSP, NhaCungCap.TenNhaCC, SanPham.SoLuong, SanPham.DonGia, SanPham.HanSD, SanPham.NgaySX,SanPham.GhiChu from  NhaCungCap INNER JOIN SanPham ON NhaCungCap.MaNCC = SanPham.MaNCC";
        String row[] = new String[8];
        try {
            pstSP= connSP.prepareStatement(sql);
            rsSP = pstSP.executeQuery();
            while (rsSP.next()) {
                row[0] = rsSP.getString(1);
                row[1] = rsSP.getString(2);
                row[2] = rsSP.getString(3);
                row[3] = rsSP.getString(4);
                row[4] = rsSP.getString(5);
                row[5] = rsSP.getString(6);
                row[6] = rsSP.getString(7);
                row[7] = rsSP.getString(8);
                dtSP.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        jComboBoxNhaCungCap = new javax.swing.JComboBox<>();
        txtDonGia = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtSoLuong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtHSD = new javax.swing.JTextField();
        txtNSX = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSuaSanPham = new javax.swing.JButton();
        btnXoaSanPham = new javax.swing.JButton();
        btnThemSanPham = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiemMaSP = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 204, 204));
        setTitle("Quản lý sản phẩm");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel38.setText("Mã Sản Phẩm");

        jLabel37.setText("Tên Sản Phẩm");

        jLabel43.setText("Nhà cung cấp");

        jLabel39.setText("Số lượng");

        jLabel41.setText("Đơn giá");

        jLabel44.setText("Hạn sử dụng");

        jLabel45.setText("Ghi chú");

        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        jLabel42.setText("Ngày Sản xuất");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel41)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel42)
                            .addComponent(jLabel45))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDonGia)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxNhaCungCap, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuong)
                            .addComponent(txtNSX, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHSD))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jComboBoxNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtHSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel42)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel45))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txtNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức Năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 0, 153))); // NOI18N

        btnSuaSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sửa1.png"))); // NOI18N
        btnSuaSanPham.setText("Sửa");
        btnSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamActionPerformed(evt);
            }
        });

        btnXoaSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaSanPham.setForeground(new java.awt.Color(255, 0, 0));
        btnXoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/thunggiac2.png"))); // NOI18N
        btnXoaSanPham.setText("Xóa");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });

        btnThemSanPham.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemSanPham.setForeground(new java.awt.Color(0, 153, 0));
        btnThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/them1.png"))); // NOI18N
        btnThemSanPham.setText("Thêm");
        btnThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reset1.png"))); // NOI18N
        btnReset.setText("Reset");
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
                .addGap(31, 31, 31)
                .addComponent(btnThemSanPham)
                .addGap(49, 49, 49)
                .addComponent(btnSuaSanPham)
                .addGap(53, 53, 53)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btnXoaSanPham)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaSanPham)
                    .addComponent(btnReset)
                    .addComponent(btnSuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemSanPham))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 0, 153))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tkiem.PNG"))); // NOI18N
        jLabel8.setText("Mã sản phẩm");

        txtTimKiemMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemMaSPActionPerformed(evt);
            }
        });
        txtTimKiemMaSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemMaSPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtTimKiemMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTimKiemMaSP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Nhà cung cấp", "Số lượng", "Đơn giá", "Hạn sử dụng", "Ngày sản xuất", "Ghi chú"
            }
        ));
        jTableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSanPham);
        if (jTableSanPham.getColumnModel().getColumnCount() > 0) {
            jTableSanPham.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSanPhamMouseClicked
        // TODO add your handling code here:

        int row = jTableSanPham.rowAtPoint(evt.getPoint());
        txtMaSP.setText(jTableSanPham.getValueAt(row, 0).toString());
        jComboBoxNhaCungCap.setSelectedItem(jTableSanPham.getValueAt(row, 2).toString());
        txtTenSP.setText(jTableSanPham.getValueAt(row, 1).toString());
        txtSoLuong.setText(jTableSanPham.getValueAt(row, 3).toString());
        txtDonGia.setText(jTableSanPham.getValueAt(row, 4).toString());
        txtHSD.setText(jTableSanPham.getValueAt(row, 5).toString());
        txtNSX.setText(jTableSanPham.getValueAt(row, 6).toString());
        jTextArea1.setText(jTableSanPham.getValueAt(row, 7).toString());
        txtMaSP.enable(false);
    }//GEN-LAST:event_jTableSanPhamMouseClicked

    private void btnThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamActionPerformed
        // TODO add your handling code here:
        DisplayValueModel dvm = (DisplayValueModel) jComboBoxNhaCungCap.getSelectedItem();
        if (txtMaSP.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập mã sản phẩm");
        } else if (txtTenSP.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập tên sản phẩm");
        } else if (txtSoLuong.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập số lượng");
        } else if (txtDonGia.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập đơn giá");
        } else if (jTextArea1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập ghi chú");
        } else {
            try {
                if (ExceptionString.isUnicode(txtMaSP.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm không chứa kí tự đặc biệt");
                } else if (ExceptionString.isSpace(txtMaSP.getText())) {
                    JOptionPane.showMessageDialog(null, "Mã sản phẩm không khoảng trắng");
                } else {
                    try {
                        String sql = "Insert into SanPham(MaSP,TenSP,MaNCC,SoLuong,DonGia,HanSD,NgaySX,GhiChu) values (?,?,?,?,?,CONVERT(DATETIME,?, 102),CONVERT(DATETIME,?, 102),?)";
                        pstSP = connSP.prepareStatement(sql);
                        pstSP.setString(1, txtMaSP.getText());
                        pstSP.setString(2, txtTenSP.getText());
                        pstSP.setString(3, dvm.valueMember.toString());
                        pstSP.setString(4, txtSoLuong.getText());
                        pstSP.setString(5, txtDonGia.getText());
                        pstSP.setString(6, txtHSD.getText());
                        pstSP.setString(7, txtNSX.getText());
                        pstSP.setString(8, jTextArea1.getText());
                        pstSP.execute();
                        JOptionPane.showMessageDialog(null, "Lưu thành công");
                        clean();
                    } catch (SQLException | HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "Mã bị trùng" + e);
                    }
                    updateTableThuoc();
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemSanPhamActionPerformed

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa", "Xóa", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from SanPham where MaSP =?";
            try {
                pstSP = connSP.prepareStatement(sql);
                pstSP.setString(1, txtMaSP.getText());
                pstSP.execute();
                JOptionPane.showMessageDialog(null, "Xóa thành công");
                clean();
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại" + e);
            }
            updateTableThuoc();
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamActionPerformed

        if (txtTenSP.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Cần Chọn dòng cần sửa");
        } else if (txtSoLuong.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập số lượng");
        } else if (txtDonGia.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập đơn giá");
        } else if (jTextArea1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập ghi chú");
        } else if (ExceptionString.isNumber(txtSoLuong.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Số lượng phải là 1 số");
        } else if (ExceptionString.isNumber(txtDonGia.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Đơn giá phải là 1 số");
        } else {
            try {

                String value1 = txtMaSP.getText();
                String value2 = txtTenSP.getText();
                DisplayValueModel Mt = (DisplayValueModel) jComboBoxNhaCungCap.getSelectedItem();
                String value4 = txtSoLuong.getText();
                String value5 = txtDonGia.getText();
                String value6 = txtHSD.getText();
                String value7 = txtNSX.getText();
                String value8 = jTextArea1.getText();

                String sql = "update SanPham set TenSP =?, MaNCC =?, SoLuong =?, DonGia =?, HanSD =?, NgaySX =?, GhiChu =? where MaSP=?";

                pst = connSP.prepareStatement(sql);
                pst.setString(1, value2);
                pst.setString(2, Mt.valueMember.toString());
                pst.setString(3, value4);
                pst.setString(4, value5);
                pst.setString(5, value7);
                pst.setString(6, value6);
                pst.setString(7, value8);
                pst.setString(8, value1);

                pst.execute();
                JOptionPane.showMessageDialog(null, "Sửa thành công");
                clean();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Sửa thất bại" + e);
            }
            updateTableThuoc();
        }


    }//GEN-LAST:event_btnSuaSanPhamActionPerformed

    private void clean() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");
        jTextArea1.setText("");
        txtMaSP.enable(true);
    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        clean();
        updateTableThuoc();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtTimKiemMaSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemMaSPKeyReleased
        while (dtSP.getRowCount() > 0) {
            dtSP.removeRow(0);
        }
        String sql = "select * from SanPham where MaSP=?";
        String row[] = new String[8];
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtTimKiemMaSP.getText());
            rs = pst.executeQuery();
            while (rs.next()) {

                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                dtSP.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Tìm kiếm thất bại");
        }
    }//GEN-LAST:event_txtTimKiemMaSPKeyReleased

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtTimKiemMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemMaSPActionPerformed

    public void fillComboMaNhaCungCapNhap() {
        String sql = "Select * from NhaCungCap";
        try {
            pst = conn.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String tenNhaCungCap = rs.getString("TenNhaCC");
                String maNhaCungCap = rs.getString("MaNCC");
                DisplayValueModel dvn = new DisplayValueModel(tenNhaCungCap, maNhaCungCap);
                dcb.addElement(dvn);
            }
            jComboBoxNhaCungCap.setModel(dcb);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSuaSanPham;
    private javax.swing.JButton btnThemSanPham;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JComboBox<String> jComboBoxNhaCungCap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtHSD;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNSX;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiemMaSP;
    // End of variables declaration//GEN-END:variables
}
