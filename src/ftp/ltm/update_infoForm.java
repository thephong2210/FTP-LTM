/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp.ltm;

import com.toedter.calendar.JTextFieldDateEditor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author theph
 */
public class update_infoForm extends javax.swing.JFrame {

    private static Socket socket = null;
    private static DataInputStream din = null;
    private static DataOutputStream dout = null;
    private static String username = null;
    private static String pass = null;

    /**
     * Creates new form update_infoForm
     */
    public update_infoForm(Socket socket, String username) throws IOException, ParseException {
        initComponents();
        this.socket = socket;
        this.username = username;
        jLabel_username.setText(username);
        // chặn người dùng nhập ngày sinh
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jDateChooser_ngaysinh.getDateEditor();
        editor.setEditable(false);
        start(socket);
        loadInfo();
    }

    public void start(Socket socket) {
        try {
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa mở server");
        }
    }

    public void loadInfo() throws IOException, ParseException {
        dout.writeUTF("get_info");
        dout.flush();
        dout.writeUTF(username);
        dout.flush();
        String info_user = din.readUTF();
        StringTokenizer st = new StringTokenizer(info_user, ";");
        st.nextToken(); // bỏ qua user name vì mình đã có rồi
        pass = st.nextToken();
        String hoten = st.nextToken();
        String gioitinh = st.nextToken();
        String ngaysinh = st.nextToken();
        jTextField_hoten.setText(hoten);
        if (gioitinh.equals("Nam")) {
            jRadioButton_nam.setSelected(rootPaneCheckingEnabled);
        } else {
            jRadioButton_nu.setSelected(rootPaneCheckingEnabled);
        }
        Date date1 = new SimpleDateFormat("MMM d,yyyy").parse(ngaysinh);
        jDateChooser_ngaysinh.setDate(date1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_hoten = new javax.swing.JTextField();
        jTextField_pass = new javax.swing.JTextField();
        jRadioButton_nam = new javax.swing.JRadioButton();
        jRadioButton_nu = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser_ngaysinh = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel_username = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setText("Họ tên :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setText("Ngày sinh :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 35)); // NOI18N
        jLabel6.setText("Cập nhật thông tin");

        jTextField_hoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_hotenActionPerformed(evt);
            }
        });

        jTextField_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_passActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton_nam);
        jRadioButton_nam.setText("Nam");

        buttonGroup1.add(jRadioButton_nu);
        jRadioButton_nu.setText("Nữ");
        jRadioButton_nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_nuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Username :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setText("Mật khẩu:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Cập nhật");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setText("Giới tính :");

        jLabel_username.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel_username.setText("username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_hoten)
                            .addComponent(jTextField_pass)
                            .addComponent(jLabel_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton_nam)
                                        .addGap(34, 34, 34)
                                        .addComponent(jRadioButton_nu))
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_username))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_nam)
                    .addComponent(jRadioButton_nu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_hotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_hotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_hotenActionPerformed

    private void jTextField_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_passActionPerformed

    private void jRadioButton_nuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_nuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_nuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ms = "";

        if (!jTextField_pass.getText().equals("")) {
            String regex1 = "^(?=\\S+$).{8,}$";
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(jTextField_pass.getText());
            if (!matcher1.matches()) {
                ms += "Pass không chứa khoản trắng và ít nhất 8 kí tự \n";
            } else {
                pass = jTextField_pass.getText();

            }
        }

        if (jTextField_hoten.getText().equals("")) {
            ms += "Họ tên chưa điền \n";
        } else {
            String regex2 = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";

            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(jTextField_hoten.getText());
            if (!matcher2.matches()) {
                ms += "Họ tên không chứa số và kí tự đặc biệt \n";
            }

        }

        if (!jRadioButton_nam.isSelected() && !jRadioButton_nu.isSelected()) {
            ms += "Giới tính chưa điền \n";
        }
        if (jDateChooser_ngaysinh.getDate() == null) {
            ms += "Ngày sinh chưa điền hoặc điền sai vui lòng chọn , chứ đừng điền ngày sinh";
        }

        if (!ms.equals("")) {
            JOptionPane.showMessageDialog(this, ms);
        } else {

            String username, hoten, gioitinh, ngaysinh;
            username = jLabel_username.getText();
            hoten = jTextField_hoten.getText();
            if (jRadioButton_nam.isSelected()) {
                gioitinh = jRadioButton_nam.getText();
            } else {
                gioitinh = jRadioButton_nu.getText();
            }
            Date date = jDateChooser_ngaysinh.getDate();
            ngaysinh = DateFormat.getDateInstance().format(date);

            String info_user = hoten + ";" + gioitinh + ";" + ngaysinh;

            try {
                dout.writeUTF("update_information");
                dout.flush();
                dout.writeUTF(username);
                dout.flush();
                dout.writeUTF(pass);
                dout.flush();
                dout.writeUTF(info_user);
                dout.flush();
                String message = din.readUTF();
                if (message.equals("updated")) {
                    JOptionPane.showMessageDialog(rootPane, "update thành công");
                }
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(update_infoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(update_infoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(update_infoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(update_infoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new update_infoForm(socket, username).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(update_infoForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(update_infoForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser_ngaysinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_username;
    private javax.swing.JRadioButton jRadioButton_nam;
    private javax.swing.JRadioButton jRadioButton_nu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_hoten;
    private javax.swing.JTextField jTextField_pass;
    // End of variables declaration//GEN-END:variables
}
