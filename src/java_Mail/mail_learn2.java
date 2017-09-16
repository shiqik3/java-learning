package java_Mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.Authenticator;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class mail_learn2 {  
    public static void main(String[] args) throws Exception {  
        Properties  props = new Properties();  
        props.setProperty("mail.smtp.auth", "true");  
        props.setProperty("mail.transport.protocol", "smtp");  
        props.setProperty("mail.host", "smtp.163.com"); 
        Session session = Session.getInstance(props,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){  
                return new PasswordAuthentication("smszcll","smszcll19951229");  
            }
        });  
        session.setDebug(true);  
          
        Message msg = new MimeMessage(session);  
        msg.setFrom(new InternetAddress("smszcll@163.com"));  
          
        msg.setSubject("JavaMail测试程序...");  
        msg.setContent("<span style='color:red'>这是我的第二个javaMail测试程序....</span>", "text/html;charset=gbk");  
        //msg.setRecipients(RecipientType.TO, new Address[]{new InternetAddress("1111@@qq.com"),new InternetAddress("2222@qq.cpm")});  
        msg.setRecipients(RecipientType.TO, InternetAddress.parse("1406515827@qq.com,tiny_enactus@yeah.net"));  
          
        Transport.send(msg);  
    }  
  
} 