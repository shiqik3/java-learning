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

public class OneToMany_sender {
	public static boolean sendMailOneToMany(OneToMany_senderInfo Info){
		MailAttorney authenticator=null;
		if(Info.isIsvalidate()){
			authenticator=new MailAttorney(Info.getUserName(),Info.getPassword());
		}
		Session sendMailSession=Session.getInstance(Info.getProperties(),authenticator);
		
		try{
			Message mailMessage=new MimeMessage(sendMailSession);
			Address from=new InternetAddress(Info.getSendAddress());
			mailMessage.setFrom(from);
			Address[]ad=null;
			String[]receivers=Info.getReceive();
			if(receivers!=null){
				ad=new InternetAddress[receivers.length];
				for(int i=0;i<receivers.length;i++){
					ad[i]=new InternetAddress(receivers[i]);
				}
			}else{
				ad=new InternetAddress[1];    //如果接收者为0，则发送给默认的发送者
				ad[0]=new InternetAddress(Info.getReceiveAddress());
			}
			mailMessage.setRecipients(Message.RecipientType.TO, ad);
			mailMessage.setSubject("一对多邮件发送测试");
			mailMessage.setSentDate(new Date());
			
			Multipart mainPart=new MimeMultipart();
			BodyPart html=new MimeBodyPart();
			html.setContent("我同事发个了三个人/n/r 他们收到了吗？","text/html;charset=GBK");
			mainPart.addBodyPart(html);
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
			return true;
			
		}catch(MessagingException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public static boolean send_Cc(OneToMany_senderInfo Info){
		MailAttorney authenticator=null;
		if(Info.isIsvalidate()){
			authenticator=new MailAttorney(Info.getUserName(),Info.getPassword());
		}
		Session sendMailSession=Session.getInstance(Info.getProperties(), authenticator);
		
		try{
			Message mailMessage=new MimeMessage(sendMailSession);
			Address from=new InternetAddress(Info.getSendAddress());
			mailMessage.setFrom(from);
			Address to=new InternetAddress(Info.getReceiveAddress());
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			String[]cc=Info.getCcs();
			if(cc!=null){
				Address[]ccAdresses=new InternetAddress[cc.length];
				for(int i=0;i<cc.length;i++){
					ccAdresses[i]=new InternetAddress(cc[i]);
				}
				mailMessage.setRecipients(Message.RecipientType.CC, ccAdresses);
			}
			
			mailMessage.setSubject("抄送的邮件测试");
			mailMessage.setSentDate(new Date());
			Multipart mainPart=new MimeMultipart();
			BodyPart html=new MimeBodyPart();
			html.setContent("发送带抄送的邮件\n\r测试成功","text/html;charset=GBK");
			mainPart.addBodyPart(html);
			mailMessage.setContent(mainPart);
			Transport.send(mailMessage);
			return true;
			
		}catch(MessagingException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	public static class OneToMany_senderInfo extends Mail_SendProper{
		private String[]rec;    //从放邮件的接收者
		private String[]cc;    //存放邮件的抄送这
		public String[]getCcs(){
			return cc;
		}
		
		public void setCcs(String[]cc){
			this.cc=cc;
		}
		
		public String[]getReceive(){
			return rec;
		}
		
		public void setReceive(String[]rec){
			this.rec=rec;
		}
	}
	
	public static void main(String[]args){
		OneToMany_senderInfo mailSender=new OneToMany_senderInfo();
		mailSender.setHost("smtp.163.com");
		mailSender.setPort("25");
		mailSender.setIsvalidate(true);
		mailSender.setUserName("smszcll");
		mailSender.setPassword("smszcll19951229");
		mailSender.setSendAddress("smszcll@163.com");
		mailSender.setReceiveAddress("1406515827@qq.com");
		String[]rec=new String[]{"1406515827@qq.com","tiny_enactus@yeah.net"};
		String[]cc=rec;
		mailSender.setReceive(rec);
		mailSender.setCcs(cc);
		OneToMany_sender.sendMailOneToMany(mailSender);
		OneToMany_sender.send_Cc(mailSender);
	}
	
	
	
	
}
