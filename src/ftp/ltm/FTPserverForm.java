/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp.ltm;

import static ftp.ltm.FTPserverForm.loadHashMap;
import static ftp.ltm.FTPserverForm.mapQuyenUser;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author theph
 */
public class FTPserverForm extends javax.swing.JFrame {

    private static ServerSocket serverSocket = null;
    private static Socket socket = null;
    private static DataInputStream din = null;
    private static DataOutputStream dout = null;

    public static LinkedHashMap<String, String> mapQuyenUser = null;

    public FTPserverForm() throws FileNotFoundException {
        initComponents();
        loadHashMap();
        loadTableUser();
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_user = new javax.swing.JTable();
        jButton_ok = new javax.swing.JButton();
        jCheckBox_block_up = new javax.swing.JCheckBox();
        jCheckBox_block_down = new javax.swing.JCheckBox();
        jButton_lammoi = new javax.swing.JButton();
        jCheckBox_blockDirUser = new javax.swing.JCheckBox();
        jCheckBox_blockDirChung = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_dungluong = new javax.swing.JTextField();
        jTextField_maxUP = new javax.swing.JTextField();
        jTextField_maxDOWN = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        jLabel1.setText("Server");

        jTable_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username ", "UPload ", "Download", "Dir user", "Dir chung", "Dung lượng", "MAX_upload", "MAX_download"
            }
        ));
        jTable_user.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_user);
        if (jTable_user.getColumnModel().getColumnCount() > 0) {
            jTable_user.getColumnModel().getColumn(1).setMaxWidth(60);
            jTable_user.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable_user.getColumnModel().getColumn(3).setMaxWidth(65);
            jTable_user.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jButton_ok.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton_ok.setText("OK");
        jButton_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_okActionPerformed(evt);
            }
        });

        jCheckBox_block_up.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jCheckBox_block_up.setText("block UP");
        jCheckBox_block_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_block_upActionPerformed(evt);
            }
        });

        jCheckBox_block_down.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jCheckBox_block_down.setText("block DOWN");

        jButton_lammoi.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jButton_lammoi.setText("Làm mới");
        jButton_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_lammoiActionPerformed(evt);
            }
        });

        jCheckBox_blockDirUser.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jCheckBox_blockDirUser.setText("block Dir User");

        jCheckBox_blockDirChung.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jCheckBox_blockDirChung.setText("block Dir Chung");
        jCheckBox_blockDirChung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_blockDirChungActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Dung Lương");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("MAX_UP");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("MAX_DOWN");

        jTextField_dungluong.setText(" ");
        jTextField_dungluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_dungluongActionPerformed(evt);
            }
        });

        jTextField_maxUP.setText(" ");

        jTextField_maxDOWN.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox_blockDirChung)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 442, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox_block_up)
                                    .addComponent(jCheckBox_block_down)
                                    .addComponent(jCheckBox_blockDirUser))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_maxUP)
                                            .addComponent(jTextField_maxDOWN)))
                                    .addComponent(jTextField_dungluong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_lammoi))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox_block_up)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox_block_down)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox_blockDirUser)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_blockDirChung))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_dungluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton_lammoi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_maxUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_maxDOWN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_ok)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_okActionPerformed
        int row = jTable_user.getSelectedRow();
        TableModel model = jTable_user.getModel();
        String username = model.getValueAt(row, 0).toString();
        String quyen = username;
        if (jCheckBox_block_up.isSelected()) {
            quyen += ";no;";
        } else {
            quyen += ";yes;";
        }
        if (jCheckBox_block_down.isSelected()) {
            quyen += "no;";
        } else {
            quyen += "yes;";
        }
        if (jCheckBox_blockDirUser.isSelected()) {
            quyen += "no;";
        } else {
            quyen += "yes;";
        }
        if (jCheckBox_blockDirChung.isSelected()) {
            quyen += "no";
        } else {
            quyen += "yes";
        }
        String dungluong = jTextField_dungluong.getText();
        String max_up = jTextField_maxUP.getText();
        String max_down = jTextField_maxDOWN.getText();
        quyen += ";" + dungluong + ";" + max_up + ";" + max_down;
        mapQuyenUser.put(username, quyen);
        try {
            FileWriter fw = new FileWriter(".\\src\\ftp\\ltm\\quyen_user.txt");
            Set<String> keySet = mapQuyenUser.keySet();
            for (String key : keySet) {
                fw.write(mapQuyenUser.get(key) + "\n");
            }
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            loadTableUser();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FTPserverForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_okActionPerformed

    private void jButton_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_lammoiActionPerformed
        try {
            loadHashMap();
            loadTableUser();

        } catch (Exception e) {
        }
     }//GEN-LAST:event_jButton_lammoiActionPerformed

    private void jCheckBox_blockDirChungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_blockDirChungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_blockDirChungActionPerformed

    private void jCheckBox_block_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_block_upActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_block_upActionPerformed

    private void jTextField_dungluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_dungluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_dungluongActionPerformed

    private void jTable_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_userMouseClicked
        int row = jTable_user.getSelectedRow();
        TableModel model = jTable_user.getModel();
        String up = model.getValueAt(row, 1).toString();
        String down = model.getValueAt(row, 2).toString();
        String Dir_user = model.getValueAt(row, 3).toString();
        String Dir_chung = model.getValueAt(row, 4).toString();
        String dungluong = model.getValueAt(row, 5).toString();
        String max_up = model.getValueAt(row, 6).toString();
        String max_down = model.getValueAt(row, 7).toString();
        if (up.equals("no")) {
            jCheckBox_block_up.setSelected(true);
        } else {
            jCheckBox_block_up.setSelected(false);
        }
        if (down.equals("no")) {
            jCheckBox_block_down.setSelected(true);
        } else {
            jCheckBox_block_down.setSelected(false);
        }
        if (Dir_user.equals("no")) {
            jCheckBox_blockDirUser.setSelected(true);
        } else {
            jCheckBox_blockDirUser.setSelected(false);
        }
        if (Dir_chung.equals("no")) {
            jCheckBox_blockDirChung.setSelected(true);
        } else {
            jCheckBox_blockDirChung.setSelected(false);
        }
        jTextField_dungluong.setText(dungluong);
        jTextField_maxUP.setText(max_up);
        jTextField_maxDOWN.setText(max_down);


    }//GEN-LAST:event_jTable_userMouseClicked

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
            java.util.logging.Logger.getLogger(FTPserverForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FTPserverForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FTPserverForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FTPserverForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FTPserverForm().setVisible(true);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FTPserverForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        FTPserverForm server = new FTPserverForm();
        server.StartServer(2210);
    }

    public void StartServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        //jLabel_client.setText("new Client accepted");
        while (true) {
            System.out.println("Waiting for Connection ...");
            transferfile t = new transferfile(serverSocket.accept());
        }
    }

    public void loadTableUser() throws FileNotFoundException {

        StringTokenizer st = null;
        DefaultTableModel tableUser = (DefaultTableModel) jTable_user.getModel();
        tableUser.getDataVector().removeAllElements();
        revalidate();

        Set<String> keySet = mapQuyenUser.keySet();
        for (String key : keySet) {
            String s = mapQuyenUser.get(key);
            st = new StringTokenizer(s, ";");
            String username = st.nextToken();
            String up = st.nextToken();
            String down = st.nextToken();
            String Dir_user = st.nextToken();
            String Dir_chung = st.nextToken();
            String dungluong = st.nextToken();
            String max_up = st.nextToken();
            String max_down = st.nextToken();
            tableUser.addRow(new Object[]{
                username, up, down, Dir_user, Dir_chung, dungluong, max_up, max_down
            });
        }

    }

    public static void loadHashMap() throws FileNotFoundException {
        mapQuyenUser = new LinkedHashMap<String, String>();
        String url = ".\\src\\ftp\\ltm\\quyen_user.txt";
        // Đọc dữ liệu từ File với Scanner
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);
        StringTokenizer st = null;

        try {
            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                st = new StringTokenizer(scanner.nextLine(), ";");
                String username = st.nextToken();
                String up = st.nextToken();
                String down = st.nextToken();
                String Dir_user = st.nextToken();
                String Dir_chung = st.nextToken();
                String dungluong = st.nextToken();
                String max_up = st.nextToken();
                String max_down = st.nextToken();
                mapQuyenUser.put(username, username + ";" + up + ";" + down + ";" + Dir_user + ";" + Dir_chung + ";" + dungluong + ";" + max_up + ";" + max_down);
            }

        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException ex) {

            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_lammoi;
    private javax.swing.JButton jButton_ok;
    private javax.swing.JCheckBox jCheckBox_blockDirChung;
    private javax.swing.JCheckBox jCheckBox_blockDirUser;
    private javax.swing.JCheckBox jCheckBox_block_down;
    private javax.swing.JCheckBox jCheckBox_block_up;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_user;
    private javax.swing.JTextField jTextField_dungluong;
    private javax.swing.JTextField jTextField_maxDOWN;
    private javax.swing.JTextField jTextField_maxUP;
    // End of variables declaration//GEN-END:variables

}

class transferfile extends Thread {

    Socket ClientSoc;

    DataInputStream din;
    DataOutputStream dout;

    transferfile(Socket soc) {
        try {
            ClientSoc = soc;
            din = new DataInputStream(ClientSoc.getInputStream());
            dout = new DataOutputStream(ClientSoc.getOutputStream());
            System.out.println("FTP Client Connected ...");
            start();

        } catch (Exception ex) {
        }
    }

    public static boolean checkLogin(String username, String pass) throws FileNotFoundException {

        String url = ".\\src\\ftp\\ltm\\info_user.txt";
        // Đọc dữ liệu từ File với Scanner
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);
        StringTokenizer st = null;

        try {
            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                st = new StringTokenizer(scanner.nextLine(), ";");
                String temp1 = st.nextToken();
                String temp2 = st.nextToken();
                if (temp1.equals(username) && temp2.equals(pass)) {
                    return true;
                }

            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException ex) {

            }
        }
        return false;

    }

    public void receiveFile(String user, String url) throws FileNotFoundException, IOException {

//        in = socket.getInputStream(); // nhận file 
        //C:\Users\theph\OneDrive\Máy tính\test.txt
        StringTokenizer st = new StringTokenizer(url, "\\");
        String nameFile = null;
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
            nameFile = st.nextToken(); //lấy tên file
        }
        File f = new File(".\\FILE-SERVER\\" + user + "\\" + nameFile);
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
        System.out.println("Server đã nhận file");
    }

    public void sendFile(String user, String dir, String nameFile) {
        String urlDir = ".\\FILE-SERVER\\" + dir + "\\" + nameFile;

        File file = new File(urlDir);

        if (!file.exists()) {
            try {
                dout.writeUTF("File not Exists");
                dout.flush();
            } catch (Exception e) {
            }
        } else {

            try {
                dout.writeUTF("File Exists");
                dout.flush();

                int sizeFile = (int) file.length();

                int MaxDown = checkMaxDown(user);

                System.out.println("sizeFile " + sizeFile);
                System.out.println("MaxDown " + MaxDown);
                if (sizeFile > MaxDown) {
                    dout.writeUTF("File lớn hơn giới hạn");
                    dout.flush();
                } else {
                    dout.writeUTF("ok");
                    dout.flush();
                    FileInputStream fin = new FileInputStream(file);
                    int ch;
                    do {
                        ch = fin.read();
                        dout.writeUTF(String.valueOf(ch));
                    } while (ch != -1);
                    fin.close();
                    System.out.println("server đã gửi file");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FTPclientFrom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writeFile(String info_user, String name_user) {
        // ghi file info_user
        try {

            //Specify the file name and path here
            File file = new File(".\\src\\ftp\\ltm\\info_user.txt");

            /* This logic is to create the file if the
         * file is not already present
             */
            if (!file.exists()) {
                file.createNewFile();
            }

            //Here true is to append the content to file
            FileWriter fw = new FileWriter(file, true);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(info_user + "\n");
            //Closing BufferedWriter Stream
            bw.close();

            System.out.println("Đã thêm tài khoản vào file info");

        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }
        //ghi file quyen_user
        try {
            String content = name_user + ";yes;yes;yes;yes;1000;100;100\n";
            //Specify the file name and path here
            File file = new File(".\\src\\ftp\\ltm\\quyen_user.txt");

            /* This logic is to create the file if the
         * file is not already present
             */
            if (!file.exists()) {
                file.createNewFile();
            }

            //Here true is to append the content to file
            FileWriter fw = new FileWriter(file, true);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            //Closing BufferedWriter Stream
            bw.close();

            System.out.println("Đã thêm tài khoản vào file quyền");

        } catch (IOException ioe) {
            System.out.println("Exception occurred:");
            ioe.printStackTrace();
        }

    }

    public void createDir(String name_user) {
        File dir = new File(".//FILE-SERVER//" + name_user);
        if (dir.mkdir()) {
            System.out.println("Create directory " + dir.getAbsolutePath() + " success.");
        }
    }

    private String loadDirForUser(String user) {
        String url = ".\\FILE-SERVER\\" + user;
        File dir = new File(url);
        String[] listFiles = dir.list();
        String listFile = "";
        for (int i = 0; i < listFiles.length; i++) {
            listFile += listFiles[i] + ":";
        }
        return listFile;
    }

    public boolean checkUP(String username) throws FileNotFoundException {
        loadHashMap();
        String quyen = mapQuyenUser.get(username);
        StringTokenizer st = new StringTokenizer(quyen, ";");
        st.nextToken();
        String up = st.nextToken();
        if (up.equals("yes")) {
            return true;
        }
        return false;
    }

    public boolean checkDOWN(String username) throws FileNotFoundException {
        loadHashMap();
        String quyen = mapQuyenUser.get(username);
        StringTokenizer st = new StringTokenizer(quyen, ";");
        st.nextToken();
        st.nextToken();
        String down = st.nextToken();
        if (down.equals("yes")) {
            return true;
        }
        return false;
    }

    public boolean checkDirUser(String username) throws FileNotFoundException {
        loadHashMap();
        String quyen = mapQuyenUser.get(username);
        StringTokenizer st = new StringTokenizer(quyen, ";");
        st.nextToken();
        st.nextToken();
        st.nextToken();
        String dirUser = st.nextToken();
        if (dirUser.equals("yes")) {
            return true;
        }
        return false;
    }

    public boolean checkDirChung(String username) throws FileNotFoundException {
        loadHashMap();
        String quyen = mapQuyenUser.get(username);
        StringTokenizer st = new StringTokenizer(quyen, ";");
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        String dirChung = st.nextToken();
        if (dirChung.equals("yes")) {
            return true;
        }
        return false;
    }

    public int checkDungLuongTrong(String username) throws FileNotFoundException {
        loadHashMap();
        String quyen = mapQuyenUser.get(username);
        StringTokenizer st = new StringTokenizer(quyen, ";");
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        int dungluong = Integer.valueOf(st.nextToken());
        System.out.println(dungluong);

        File dir = new File(".\\FILE-SERVER\\" + username);
        int dungluongUsed = (int) getFolderSize(dir);
        System.out.println("dung lượng đã sử dụng: " + dungluongUsed);
        int dungluong_conlai = dungluong - dungluongUsed;
        System.out.println("dung lượng còn lại: " + dungluong_conlai);

        return dungluong_conlai;
    }

    public int checkMaxUP(String username) throws FileNotFoundException {
        loadHashMap();
        String quyen = mapQuyenUser.get(username);
        StringTokenizer st = new StringTokenizer(quyen, ";");
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        int maxUP = Integer.valueOf(st.nextToken());
        System.out.println("max up: " + maxUP);

        return maxUP;
    }

    public int checkMaxDown(String username) throws FileNotFoundException {
        loadHashMap();
        String quyen = mapQuyenUser.get(username);
        StringTokenizer st = new StringTokenizer(quyen, ";");
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        st.nextToken();
        int maxDOWN = Integer.valueOf(st.nextToken());
        System.out.println("max down: " + maxDOWN);

        return maxDOWN;
    }

    private static long getFolderSize(File folder) {
        long length = 0;

        // listFiles() is used to list the
        // contents of the given folder
        File[] files = folder.listFiles();

        int count = files.length;

        // loop for traversing the directory
        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            } else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }

    public int sizeFile(String username, String nameFile) {
        File file = new File(".\\FILE-SERVER\\" + username + "\\" + nameFile);

        return (int) file.length();
    }

    public void run() {

        while (true) {
            try {
                String line = din.readUTF();
                if (line.equals("login")) {
                    String user = din.readUTF();
                    String pass = din.readUTF();
                    if (checkLogin(user, pass)) {
                        dout.writeUTF("ok");
                        dout.flush();
//                        String[] listFile = loadDirForUser(user);
//                        objectOutput.writeObject(listFile);

                    } else {
                        dout.writeUTF("no ok");
                        dout.flush();
                    }

                }
                if (line.equals("register")) {
                    String user = din.readUTF();
                    // phải viết thêm 1 hàm kiểm tra user đã tồn tại chưa nữa
                    String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
                    dout.writeUTF(otp);
                    dout.flush();
                    String info_user = din.readUTF();
                    String name_user = din.readUTF();
                    // sendMail.sendMail("ftpltm2021@gmail.com", "Mã OTP của bạn : " + otp);
                    writeFile(info_user, name_user);
                    createDir(name_user);
                }
                if (line.equals("reload")) {
                    String username = din.readUTF();
                    dout.writeUTF(loadDirForUser(username));
                    dout.flush();

                }
                if (line.equals("send")) {
                    String user = din.readUTF();
                    if (checkUP(user)) {
                        dout.writeUTF("UP");
                        dout.flush();
                        String nameDir = din.readUTF();
                        if (!nameDir.equals("chung")) {
                            if (checkDirUser(user)) {
                                dout.writeUTF("UPdir");
                                dout.flush();
                                long sizeFile = Long.parseLong(din.readUTF());
                                if (sizeFile > checkDungLuongTrong(user)) { // kiểm tra dung lượng còn chống
                                    dout.writeUTF("không đủ dung lượng");
                                    dout.flush();
                                } else {
                                    if (sizeFile > checkMaxUP(user)) {
                                        dout.writeUTF("file quá lớn");
                                        dout.flush();
                                    } else {
                                        dout.writeUTF("ok");
                                        dout.flush();
                                        String urlFile = din.readUTF();
                                        receiveFile(nameDir, urlFile);
                                    }

                                }

                            } else {
                                dout.writeUTF("blockdir");
                                dout.flush();
                            }
                        } else {
                            if (checkDirChung(user)) {
                                dout.writeUTF("UPdirchung");
                                dout.flush();
                                long sizeFile = Long.parseLong(din.readUTF());
                                if (sizeFile > checkMaxUP(user)) {
                                    dout.writeUTF("file quá lớn");
                                    dout.flush();
                                } else {
                                    dout.writeUTF("ok");
                                    dout.flush();
                                    String urlFile = din.readUTF();
                                    receiveFile(nameDir, urlFile);
                                }
                            } else {
                                dout.writeUTF("blockdir");
                                dout.flush();
                            }
                        }

                    } else {
                        dout.writeUTF("blockUP");
                        dout.flush();
                    }
                }
                if (line.equals("receive")) {
                    String user = din.readUTF();
                    if (checkDOWN(user)) {
                        dout.writeUTF("down");
                        dout.flush();
                        String nameDir = din.readUTF();
                        if (!nameDir.equals("chung")) {
                            if (checkDirUser(user)) {
                                dout.writeUTF("DOWdir");
                                dout.flush();
                                String nameFile = din.readUTF();
                                sendFile(user, nameDir, nameFile);
                            } else {
                                dout.writeUTF("blockdir");
                                dout.flush();
                            }
                        } else {

                            if (checkDirChung(user)) {
                                dout.writeUTF("DOWdir");
                                dout.flush();
                                String nameFile = din.readUTF();
                                System.out.println("nameFile :" + nameFile);
                                sendFile(user, nameDir, nameFile);
                            } else {
                                dout.writeUTF("blockdir");
                                dout.flush();
                            }
                        }
                    } else {
                        dout.writeUTF("blockdown");
                        dout.flush();
                    }

                }

            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        }
    }
}
