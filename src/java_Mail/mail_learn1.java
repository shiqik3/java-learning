package java_Mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail_learn1 {  
    public static void main(String[] args) throws Exception {  
        Properties props = new Properties();  
        props.setProperty("mail.smtp.auth", "true");  
        props.setProperty("mail.transport.protocol", "smtp");  
          
        Session session = Session.getInstance(props);  
        session.setDebug(true);  
          
        Message msg = new MimeMessage(session);  
        msg.setSubject("这是一个测试程序....");  
        msg.setText("你好!"); 
        msg.setFrom(new InternetAddress("smszcll@163.com"));
  
        Transport transport = session.getTransport();  
        transport.connect("smtp.163.com", 25, "smszcll", "smszcll19951229");  
        transport.sendMessage(msg,new Address[]{new InternetAddress("1007160080@qq.com")});  
  
        System.out.println("邮件发送成功...");  
        transport.close();  
    }  
} 
