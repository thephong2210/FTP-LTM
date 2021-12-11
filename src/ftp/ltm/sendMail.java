/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp.ltm;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author theph
 */
public class sendMail {

    public static void sendMail(String recepient, String otp) throws Exception {
        System.out.println("Chuẩn bị gửi ");
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        String myAcc = "ftpltm2021@gmail.com";
        String myPas = "123456Phong";

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAcc, myPas);
            }
        });

        Message message = prepareMessage(session, myAcc, recepient,otp);

        Transport.send(message);
        System.out.println("Gửi thành công");
    }

    private static Message prepareMessage(Session session, String myAcc, String recepient, String otp) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAcc));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Kích hoạt tài khoản");
            message.setText(otp);
            return message;

        } catch (Exception ex) {
            Logger.getLogger(sendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
