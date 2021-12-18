/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp.ltm;

import java.awt.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FTPclientFrom extends javax.swing.JFrame {

    private static Socket socket = null;
    private static DataInputStream din = null;
    private static DataOutputStream dout = null;
    public static String username;
    private static LinkedHashMap<String, String> mapQuyenUser = null;

    /**
     * Creates new form client
     */
    public FTPclientFrom(String username, Socket socket) throws IOException, ClassNotFoundException {
        initComponents();
        this.username = username;
        jLabel_username.setText(username);
        this.socket = socket;
        start(socket);
        loadData(username);

    }

    public void start(Socket socket) {
        try {
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa mở server");
        }

        System.out.println(username);
    }

    public void loadData(String user) throws IOException {
        if (!user.equals("anonymous")) {
            loadDir(username, list_file_user);

        } else {
            jCheckBox_chung.setSelected(rootPaneCheckingEnabled);
            jCheckBox_chung.setVisible(false);
            jButton_sua_thongtin.show(false);
            list_file_user.setVisible(false);
            jLabel_dirUser.setVisible(false);
            
        }
        loadDir("chung", list_file_chung);
    }

    private void loadDir(String username, java.awt.List list) throws IOException {
        list.clear();
        dout.writeUTF("reload");
        dout.flush();
        dout.writeUTF(username);
        dout.flush();
        String listFile = din.readUTF();
        StringTokenizer st = new StringTokenizer(listFile, ":");
        while (st.hasMoreElements()) {
            list.add(st.nextToken());
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
        jtext_file = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton_Browse = new javax.swing.JButton();
        jButton_receiveFile_C = new javax.swing.JButton();
        btGui = new javax.swing.JButton();
        list_file_user = new java.awt.List();
        jLabel_dirUser = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        list_file_chung = new java.awt.List();
        jCheckBox_chung = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel_username = new javax.swing.JLabel();
        jButton_sua_thongtin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FTP - Client");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Client:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setText("Chọn file");

        jButton_Browse.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jButton_Browse.setText("Duyệt");
        jButton_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BrowseActionPerformed(evt);
            }
        });

        jButton_receiveFile_C.setFont(new java.awt.Font("Tahoma", 3, 22)); // NOI18N
        jButton_receiveFile_C.setText("Download");
        jButton_receiveFile_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_receiveFile_CActionPerformed(evt);
            }
        });

        btGui.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        btGui.setText("Upload");
        btGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuiActionPerformed(evt);
            }
        });

        list_file_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_file_userActionPerformed(evt);
            }
        });

        jLabel_dirUser.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel_dirUser.setText("Thư mục của user (server)");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setText("Thư mục chung");

        list_file_chung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_file_chungActionPerformed(evt);
            }
        });

        jCheckBox_chung.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jCheckBox_chung.setText("DIR chung");

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 22)); // NOI18N
        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel_username.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel_username.setText("Username");

        jButton_sua_thongtin.setText("Cập nhật thông tin");
        jButton_sua_thongtin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sua_thongtinActionPerformed(evt);
            }
        });

        jButton2.setText("Đăng xuất");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_receiveFile_C)
                .addGap(36, 36, 36)
                .addComponent(btGui, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox_chung)
                .addGap(114, 114, 114))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(list_file_user, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_dirUser, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                        .addGap(211, 211, 211))
                                    .addComponent(list_file_chung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jtext_file, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Browse)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_username, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(504, 504, 504)
                                        .addComponent(jButton_sua_thongtin))))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_username)
                    .addComponent(jButton_sua_thongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtext_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGui)
                    .addComponent(jCheckBox_chung)
                    .addComponent(jButton_receiveFile_C)
                    .addComponent(jButton1))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_dirUser)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(list_file_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(list_file_chung, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuiActionPerformed
        // TODO add your handling code here:

        if (jtext_file.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên file");
        } else {
            try {
                sendFile();
            } catch (Exception ex) {
                Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btGuiActionPerformed

    private void jButton_BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(jButton_Browse);
        
        if(chooser.getSelectedFile()!=null){
            jtext_file.setText(chooser.getSelectedFile().getAbsolutePath());
        }else{
            System.out.println("Đã tắt cửa sổ duyệt file");
        }
        

    }//GEN-LAST:event_jButton_BrowseActionPerformed

    private void jButton_receiveFile_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_receiveFile_CActionPerformed
        String nameFile = jtext_file.getText();

        if (nameFile.equals("")) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên file");
        } else {
            try {
                receiveFile(nameFile);
            } catch (Exception ex) {
                Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton_receiveFile_CActionPerformed

    private void list_file_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_file_userActionPerformed
        jtext_file.setText(list_file_user.getSelectedItem());
        jCheckBox_chung.setSelected(false);
    }//GEN-LAST:event_list_file_userActionPerformed

    private void list_file_chungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_file_chungActionPerformed
        jtext_file.setText(list_file_chung.getSelectedItem());
        jCheckBox_chung.setSelected(true);
    }//GEN-LAST:event_list_file_chungActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            loadData(username);
        } catch (IOException ex) {
            Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_sua_thongtinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sua_thongtinActionPerformed
        try {
            update_infoForm f = new update_infoForm(socket, username);
            f.setVisible(true);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (Exception e) {
        }


    }//GEN-LAST:event_jButton_sua_thongtinActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        loginForm lgForm = new loginForm(socket);
        lgForm.setVisible(true);
        lgForm.pack();
        lgForm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(FTPclientFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTPclientFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTPclientFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTPclientFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FTPclientFrom(username, socket).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public void sendFile() throws FileNotFoundException {
        String urlFile = jtext_file.getText();
        System.out.println(urlFile);
        File file = new File(urlFile);
        if (!file.exists()) {

            JOptionPane.showMessageDialog(this, "File not Exists...");
        } else {
            try {
                dout.writeUTF("send");
                dout.flush();
                dout.writeUTF(username);
                dout.flush();
                String message = din.readUTF();
                if (message.equals("UP")) {
                    if (jCheckBox_chung.isSelected()) {
                        dout.writeUTF("chung");
                        dout.flush();

                    } else {
                        dout.writeUTF(username);
                        dout.flush();
                    }
                    message = din.readUTF();
                    System.out.println(message);
                    if (message.equals("UPdirchung")) {

                        dout.writeUTF(String.valueOf(file.length()));
                        dout.flush();
                        message = din.readUTF();
                        if (!message.equals("ok")) {
                            JOptionPane.showMessageDialog(this, message);
                        } else {
                            dout.writeUTF(urlFile);
                            dout.flush();
                            message = din.readUTF();
                            if (message.equals("file_exists")) {
                                int n = JOptionPane.showConfirmDialog(this, "File đã tồn tại, bạn có muốn ghi đè ?",
                                        "Alert",
                                        JOptionPane.YES_NO_OPTION);
                                if (n == JOptionPane.YES_OPTION) {
                                    dout.writeUTF("ghi_de");
                                    dout.flush();
                                    FileInputStream fin = new FileInputStream(file);
                                    int ch;
                                    do {
                                        ch = fin.read();
                                        dout.writeUTF(String.valueOf(ch));
                                    } while (ch != -1);
                                    fin.close();
                                    JOptionPane.showMessageDialog(this, "Send File success ");
                                    loadData(username);
                                } else {
                                    dout.writeUTF("khong_ghi_de");
                                    dout.flush();
                                }

                            } else {
                                FileInputStream fin = new FileInputStream(file);
                                int ch;
                                do {
                                    ch = fin.read();
                                    dout.writeUTF(String.valueOf(ch));
                                } while (ch != -1);
                                fin.close();
                                JOptionPane.showMessageDialog(this, "Send File success ");
                                loadData(username);

                            }

                        }
                    } else if (message.equals("UPdir")) {

                        dout.writeUTF(String.valueOf(file.length()));
                        dout.flush();
                        message = din.readUTF();
                        if (!message.equals("ok")) {
                            JOptionPane.showMessageDialog(this, message);
                        } else {
                            dout.writeUTF(urlFile);
                            dout.flush();
                            message = din.readUTF();
                            if (message.equals("file_exists")) {
                                int n = JOptionPane.showConfirmDialog(this, "File đã tồn tại, bạn có muốn ghi đè ?",
                                        "Alert",
                                        JOptionPane.YES_NO_OPTION);
                                if (n == JOptionPane.YES_OPTION) {
                                    dout.writeUTF("ghi_de");
                                    dout.flush();
                                    FileInputStream fin = new FileInputStream(file);
                                    int ch;
                                    do {
                                        ch = fin.read();
                                        dout.writeUTF(String.valueOf(ch));
                                    } while (ch != -1);
                                    fin.close();
                                    JOptionPane.showMessageDialog(this, "Send File success ");
                                    loadDir(username, list_file_user);
                                    loadDir("chung", list_file_chung);
                                } else {
                                    dout.writeUTF("khong_ghi_de");
                                    dout.flush();
                                }

                            } else {
                                FileInputStream fin = new FileInputStream(file);
                                int ch;
                                do {
                                    ch = fin.read();
                                    dout.writeUTF(String.valueOf(ch));
                                } while (ch != -1);
                                fin.close();
                                JOptionPane.showMessageDialog(this, "Send File success ");
                                loadDir(username, list_file_user);
                                loadDir("chung", list_file_chung);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Bạn đã bị block UP dir này ");
                    }

                } else if (message.equals("blockUP")) {
                    JOptionPane.showMessageDialog(this, "Bạn đã bị block UP");
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void receiveFile(String nameFile) {
        try {

            dout.writeUTF("receive");
            dout.flush();
            dout.writeUTF(username);
            dout.flush();
            String message = din.readUTF();
            if (message.equals("down")) {
                if (jCheckBox_chung.isSelected()) {
                    dout.writeUTF("chung");
                    dout.flush();
                } else {
                    dout.writeUTF(username);
                    dout.flush();
                }
                message = din.readUTF();

                if (message.equals("DOWdir")) {
                    dout.writeUTF(nameFile);
                    dout.flush();

                    message = din.readUTF();
                    if (message.equals("File not Exists")) {
                        JOptionPane.showMessageDialog(this, "Server : file không tồn tại");
                    } else if (message.equals("File Exists")) {
                        message = din.readUTF();
                        if (message.equals("ok")) {
                            File dir = new File("D://FTP_receive");
                            if (dir.mkdir()) {
                                System.out.println("Create directory " + dir.getAbsolutePath() + " success.");
                            }
                            File f = new File("D://FTP_receive//" + nameFile);
                            if (f.exists()) {
                                int n = JOptionPane.showConfirmDialog(this, "File đã tồn tại, bạn có muốn ghi đè ?",
                                        "Alert",
                                        JOptionPane.YES_NO_OPTION);
                                if (n == JOptionPane.YES_OPTION) {
                                    dout.writeUTF("ok");
                                    dout.flush();
                                    FileOutputStream fout = new FileOutputStream(f);
                                    int ch;
                                    String temp;
                                    do {
                                        temp = din.readUTF();
                                        ch = Integer.parseInt(temp);
                                        if (ch != -1) {
                                            fout.write(ch);
                                        }
                                    } while (ch != -1);
                                    fout.close();
                                    JOptionPane.showMessageDialog(this, "Nhận file thành công\n File tải về nằm ở\n\tD:/FTP_receive");
                                } else {
                                    dout.writeUTF("no_ok");
                                    dout.flush();
                                }
                            } else {
                                dout.writeUTF("ok");
                                dout.flush();
                                FileOutputStream fout = new FileOutputStream(f);
                                int ch;
                                String temp;
                                do {
                                    temp = din.readUTF();
                                    ch = Integer.parseInt(temp);
                                    if (ch != -1) {
                                        fout.write(ch);
                                    }
                                } while (ch != -1);
                                fout.close();
                                JOptionPane.showMessageDialog(this, "Nhận file thành công\n File tải về nằm ở\n\tD:/FTP_receive");
                            }

                            // System.out.println("Đã nhận");
                        } else {
                            JOptionPane.showMessageDialog(this, message);

                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn đã bị block DOWN dir này ");
                }

            } else if (message.equals("blockdown")) {
                JOptionPane.showMessageDialog(this, "Bạn đã bị block Down");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhận file thất bại, server lỗi");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGui;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_Browse;
    private javax.swing.JButton jButton_receiveFile_C;
    private javax.swing.JButton jButton_sua_thongtin;
    private javax.swing.JCheckBox jCheckBox_chung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_dirUser;
    private javax.swing.JLabel jLabel_username;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jtext_file;
    private java.awt.List list_file_chung;
    private java.awt.List list_file_user;
    // End of variables declaration//GEN-END:variables

}
