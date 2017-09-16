package java_Mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class mail_learn3 {  
	  
    public static void main(String[] args) throws Exception {  
        Properties props = new Properties();  
        props.setProperty("mail.smtp.auth", "true");  
        props.setProperty("mail.transport.protocol", "smtp");  
        props.setProperty("mail.host", "smtp.163.com");  
        Session session = Session.getInstance(props,  
                new Authenticator(){  
                    protected PasswordAuthentication getPasswordAuthentication(){  
                        return new PasswordAuthentication("smszcll","smszcll19951229");  
                    }  
        });  
        session.setDebug(true);
        Message message = new MimeMessage(session);  
        message.setSubject("第三个JavaMail测试程序");  
        message.setFrom(new InternetAddress("\""+MimeUtility.encodeText("haha")+"\"<smszcll@163.com>"));  
        message.setRecipients(RecipientType.TO, new Address[]{new InternetAddress("1406515827@qq.com")});  
          
        //邮件正文  
        MimeMultipart multipart = new MimeMultipart("mixed");  
        message.setContent(multipart);  
        /* 
         * 创建邮件的内容 
         * 包括一个邮件正文和两个附件 
         */  
        MimeBodyPart content = new MimeBodyPart();      //邮件内容  
        MimeBodyPart attch1 = new MimeBodyPart();      //附件1  
        MimeBodyPart attch2 = new MimeBodyPart();      //附件2  
        //将邮件内容添加到multipart中  
        multipart.addBodyPart(content);  
        multipart.addBodyPart(attch1);  
        multipart.addBodyPart(attch2);  
          
        //设置附件1  
        DataSource ds1 = new FileDataSource("D:\\bbb.txt");  
        DataHandler dh1 = new DataHandler(ds1);  
        attch1.setDataHandler(dh1);  
        attch1.setFileName("bbb.txt");  
        //设置附件2  
        DataSource ds2 = new FileDataSource("D:\\aaa.txt");  
        DataHandler dh2 = new DataHandler(ds2);  
        attch2.setDataHandler(dh2);  
        attch2.setFileName(MimeUtility.encodeText("aaa.txt"));  
        /* 
         * 设置内容（正文）---是一个复杂体 
         * 包括HTML正文和显示一张图片 
         */  
        MimeMultipart bodyMultipart = new MimeMultipart("related");  
        content.setContent(bodyMultipart);  
        //构造正文  
        MimeBodyPart htmlBody = new MimeBodyPart();  
        MimeBodyPart gifBody = new MimeBodyPart();  
        bodyMultipart.addBodyPart(htmlBody);  
        bodyMultipart.addBodyPart(gifBody);  
      
        //设置图片  
        DataSource gifds = new FileDataSource("D:\\001.jpg");  
        DataHandler gifdh = new DataHandler(gifds);  
        gifBody.setDataHandler(gifdh);  
        gifBody.setHeader("Content-ID", "<"+gifds.getName()+">");  
        //gifBody.setHeader("Content-Location", "http://www.itcast.cn/logo.gif");  
        //设置HTML正文  
        htmlBody.setContent("<span style='color:red;font-size:16px'>这是我的第三个JavaMail测试哦!包括了附件和图片，有点儿复杂...</span><br>" +  
                "显示的图片<img src='cid:001.jpg'/>", "text/html;charset=UTF-8");  
          
          
        message.saveChanges();        //生成邮件  
        Transport.send(message);  
    }  
  
}  