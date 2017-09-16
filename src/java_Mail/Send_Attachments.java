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
			//�ж��Ƿ���Ҫ�����֤
			authenticator=new MailAttorney(mailSender.getUserName(),
					mailSender.getPassword());    //�����Ҫ�����֤���򴴽�һ��������֤��
		}
		Session sendMailSession=Session.getInstance(mailSender.getProperties(),authenticator);
		//�����ʼ����͵����Ժ�������֤������һ�������ʼ���session
		try{
			Message mailMessage=new MimeMessage(sendMailSession);
			Address from=new InternetAddress(mailSender.getSendAddress());
			mailMessage.setFrom(from);    //�����ʼ���Ϣ�ķ����ߵ�ַ
			Address to=new InternetAddress(mailSender.getReceiveAddress());
			//�����ʼ��Ľ����ߵ�ַ
			mailMessage.setRecipient(Message.RecipientType.TO, to);    //�����ʼ���Ϣ�Ľ����ߵ�ַ
			mailMessage.setSubject(mailSender.getSubject());    //�����ʼ���Ϣ������
			mailMessage.setSentDate(new Date());    //�����ʼ���Ϣ���͵�ʱ��
			Multipart mainPart=new MimeMultipart();    //MimeMultipart����һ�������࣬����MimeBodyPart���͵Ķ���
			BodyPart html=new MimeBodyPart();    //����һ������html���ݵ�MimeBodyPart
			html.setContent(mailSender.getContent(),"text/html;charset=GBK");    //����html����
			mainPart.addBodyPart(html);
			String[]attachFileNames=mailSender.getAttachFileNames();    //Ϊ�ʼ���Ӹ���
			if(attachFileNames!=null&&attachFileNames.length>0){
				MimeBodyPart attachment=null;    //�ӷ��ʼ�������MimeBodyPart
				File file=null;
				for(int i=0;i<attachFileNames.length;i++){
					attachment=new MimeBodyPart();
					file=new File(attachFileNames[i]);    //���߸����ļ������ļ�����Դ
					FileDataSource fds=new FileDataSource(file);
					attachment.setDataHandler(new DataHandler(fds));
					attachment.setFileName(MimeUtility.encodeWord(file.getName(),"GBK",null));
					//Ϊ���������ļ���
					mainPart.addBodyPart(attachment);
				}
			}
			mailMessage.setContent(mainPart);    //��MimeMultipart��������Ϊ�ʼ�����
			Transport.send(mailMessage);    //�����ʼ�
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
		mailSender.setSubject("���������ʼ�����");
		mailSender.setContent("afsasf");
		String[]fileNames=new String[2];
		fileNames[0]="D:";
		fileNames[1]="";
		mailSender.setAttachFileNames(fileNames);
		Send_Attachments.Send_Mail(mailSender);
	}
}
