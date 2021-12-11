/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp.ltm;

/**
 *
 * @author theph
 */
import java.io.FileWriter;
 
public class FileWriterExample {
    public static void main(String args[]) {
        try {
            FileWriter fw = new FileWriter("D:\\testout.txt");
            for (int i = 0; i < 10; i++) {
                 fw.write("Welcome to java.");
            }
           
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}