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
        message.setSubject("������JavaMail���Գ���");  
        message.setFrom(new InternetAddress("\""+MimeUtility.encodeText("haha")+"\"<smszcll@163.com>"));  
        message.setRecipients(RecipientType.TO, new Address[]{new InternetAddress("1406515827@qq.com")});  
          
        //�ʼ�����  
        MimeMultipart multipart = new MimeMultipart("mixed");  
        message.setContent(multipart);  
        /* 
         * �����ʼ������� 
         * ����һ���ʼ����ĺ��������� 
         */  
        MimeBodyPart content = new MimeBodyPart();      //�ʼ�����  
        MimeBodyPart attch1 = new MimeBodyPart();      //����1  
        MimeBodyPart attch2 = new MimeBodyPart();      //����2  
        //���ʼ�������ӵ�multipart��  
        multipart.addBodyPart(content);  
        multipart.addBodyPart(attch1);  
        multipart.addBodyPart(attch2);  
          
        //���ø���1  
        DataSource ds1 = new FileDataSource("D:\\bbb.txt");  
        DataHandler dh1 = new DataHandler(ds1);  
        attch1.setDataHandler(dh1);  
        attch1.setFileName("bbb.txt");  
        //���ø���2  
        DataSource ds2 = new FileDataSource("D:\\aaa.txt");  
        DataHandler dh2 = new DataHandler(ds2);  
        attch2.setDataHandler(dh2);  
        attch2.setFileName(MimeUtility.encodeText("aaa.txt"));  
        /* 
         * �������ݣ����ģ�---��һ�������� 
         * ����HTML���ĺ���ʾһ��ͼƬ 
         */  
        MimeMultipart bodyMultipart = new MimeMultipart("related");  
        content.setContent(bodyMultipart);  
        //��������  
        MimeBodyPart htmlBody = new MimeBodyPart();  
        MimeBodyPart gifBody = new MimeBodyPart();  
        bodyMultipart.addBodyPart(htmlBody);  
        bodyMultipart.addBodyPart(gifBody);  
      
        //����ͼƬ  
        DataSource gifds = new FileDataSource("D:\\001.jpg");  
        DataHandler gifdh = new DataHandler(gifds);  
        gifBody.setDataHandler(gifdh);  
        gifBody.setHeader("Content-ID", "<"+gifds.getName()+">");  
        //gifBody.setHeader("Content-Location", "http://www.itcast.cn/logo.gif");  
        //����HTML����  
        htmlBody.setContent("<span style='color:red;font-size:16px'>�����ҵĵ�����JavaMail����Ŷ!�����˸�����ͼƬ���е������...</span><br>" +  
                "��ʾ��ͼƬ<img src='cid:001.jpg'/>", "text/html;charset=UTF-8");  
          
          
        message.saveChanges();        //�����ʼ�  
        Transport.send(message);  
    }  
  
}  