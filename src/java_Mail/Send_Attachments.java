package java_Mail;

import java.io.File;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class Send_Attachments {
	public static boolean Send_Mail(Mail_SendProper mailSender){
		MailAttorney authenticator=null;
		if(mailSender.isIsvalidate()){
			//判断是否需要身份认证
			authenticator=new MailAttorney(mailSender.getUserName(),
					mailSender.getPassword());    //如果需要身份认证，则创建一个密码验证器
		}
		Session sendMailSession=Session.getInstance(mailSender.getProperties(),authenticator);
		//根据邮件发送的属性和密码验证器构造一个发送邮件的session
		try{
			Message mailMessage=new MimeMessage(sendMailSession);
			Address from=new InternetAddress(mailSender.getSendAddress());
			mailMessage.setFrom(from);    //设置邮件消息的发送者地址
			Address to=new InternetAddress(mailSender.getReceiveAddress());
			//创建邮件的接收者地址
			mailMessage.setRecipient(Message.RecipientType.TO, to);    //设置邮件消息的接收者地址
			mailMessage.setSubject(mailSender.getSubject());    //设置邮件消息的主题
			mailMessage.setSentDate(new Date());    //设置邮件消息发送的时间
			Multipart mainPart=new MimeMultipart();    //MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
			BodyPart html=new MimeBodyPart();    //创建一个包含html内容的MimeBodyPart
			html.setContent(mailSender.getContent(),"text/html;charset=GBK");    //设置html内容
			mainPart.addBodyPart(html);
			String[]attachFileNames=mailSender.getAttachFileNames();    //为邮件添加附件
			if(attachFileNames!=null&&attachFileNames.length>0){
				MimeBodyPart attachment=null;    //从放邮件附件的MimeBodyPart
				File file=null;
				for(int i=0;i<attachFileNames.length;i++){
					attachment=new MimeBodyPart();
					file=new File(attachFileNames[i]);    //更具附件文件创建文件数据源
					FileDataSource fds=new FileDataSource(file);
					attachment.setDataHandler(new DataHandler(fds));
					attachment.setFileName(MimeUtility.encodeWord(file.getName(),"GBK",null));
					//为附件设置文件名
					mainPart.addBodyPart(attachment);
				}
			}
			mailMessage.setContent(mainPart);    //将MimeMultipart对象设置为邮件内容
			Transport.send(mailMessage);    //发送邮件
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[]args){
		Mail_SendProper mailSender=new Mail_SendProper();
		mailSender.setHost("smtp.sina.com.cn");
		mailSender.setPort("25");
		mailSender.setIsvalidate(true);
		mailSender.setUserName("*********");
		mailSender.setPassword("*****");
		mailSender.setSendAddress("********");
		mailSender.setReceiveAddress("******");
		mailSender.setSubject("带附件的邮件测试");
		mailSender.setContent("afsasf");
		String[]fileNames=new String[2];
		fileNames[0]="D:";
		fileNames[1]="";
		mailSender.setAttachFileNames(fileNames);
		Send_Attachments.Send_Mail(mailSender);
	}
}
