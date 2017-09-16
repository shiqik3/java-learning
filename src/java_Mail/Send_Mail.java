package java_Mail;

import java.util.Date;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Send_Mail {
	public static boolean Mail_Text(Mail_SendProper mailSender){
		MailAttorney attorney=null;
		if(mailSender.isIsvalidate()){
			attorney=new MailAttorney(mailSender.getUserName(),mailSender.getPassword());
		}
		
		Session sendMailSession=Session.getInstance(mailSender.getProperties(),attorney);
		sendMailSession.setDebug(true);
		try{
			Message mailMessage=new MimeMessage(sendMailSession);
			Address from=new InternetAddress(mailSender.getSendAddress());
			mailMessage.setFrom(from);
			Address to=new InternetAddress(mailSender.getReceiveAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			mailMessage.setSentDate(new Date());
			String mailContent=mailSender.getContent();
			mailMessage.setText(mailContent);
			Transport.send(mailMessage);
			return true;
		}catch(MessagingException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean Html_Mail(Mail_SendProper mailSender){
		MailAttorney attorney=null;
		if(mailSender.isIsvalidate()){
			attorney=new MailAttorney(mailSender.getUserName(),mailSender.getPassword());
		}
		Session sendMailSession=Session.getInstance(mailSender.getProperties(),attorney);
		sendMailSession.setDebug(true);
		try{
			Message mailMessage=new MimeMessage(sendMailSession);
			Address from=new InternetAddress(mailSender.getSendAddress());
			mailMessage.setFrom(from);
			Address to=new InternetAddress(mailSender.getReceiveAddress());
			mailMessage.setRecipient(Message.RecipientType.TO,to);
			mailMessage.setSubject(mailSender.getSubject());
			mailMessage.setSentDate(new Date());
			Multipart mainPart=new MimeMultipart();
			BodyPart html=new MimeBodyPart();
			html.setContent(mailSender.getContent(),"text/html;charse=GBK");
			mainPart.addBodyPart(html);
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
			return true;
			
		}catch(MessagingException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[]args){
		Mail_SendProper mailSender=new Mail_SendProper();
		mailSender.setHost("smtp.163.com");
		mailSender.setPort("25");
		mailSender.setIsvalidate(true);
		mailSender.setUserName("smszcll");
		mailSender.setPassword("smszcll19951229");
		mailSender.setSendAddress("smszcll@163.com");
		mailSender.setReceiveAddress("1406515827@qq.com");
		mailSender.setSubject("我的邮件测试");
		mailSender.setContent("我的邮件测试My First Mail\n\rMytest mail\n\r测试成功");
		Send_Mail.Mail_Text(mailSender);
		Send_Mail.Html_Mail(mailSender);
	}
}






