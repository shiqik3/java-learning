package java_Mail;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;

import org.omg.CORBA.portable.InputStream;

public class Receive_Mail {
	private Store store;    //���ʼ����������Ӻ�õ�������
	private R_MailInfo R_Info;    //���ʼ��Ĳ�������
	private Folder folder;    //�ռ���
	private Message[]mess;    //�ռ����е��ʼ���Ϣ
	private Message C_Message;    //��ǰ���ڴ�����ʼ���Ϣ
	private String C_FleName;    //��ǰ���ڴ�����ļ�����
	private Session session;    //�������ʼ��������ĻỰ
	String file_path="";    //���屣�����ı��ļ��ĵ�ַ
	public Receive_Mail(R_MailInfo R_Info){
		this.R_Info=R_Info;
	}
	
	public void M_receiveMail()throws Exception{
		if(this.R_Info==null){
			throw new Exception("����������ʼ��Ĳ�����");
		}
		if(this.connectToServer()){
			//���ӵ�������
			if(this.openInBoxFolder()){
				//���ռ���
				this.getAllMail();    //��ȡ�����ʼ�
				this.closeConnection();
			}else{
				throw new Exception("***�����ռ���ʧ��!***");
			}
		}else{
			throw new Exception("***�ʼ�����������ʧ��!***");
		}
	}
	//��½�ʼ�������
	private boolean connectToServer(){
		MailAttorney authenticator=null;
		if(this.R_Info.isIsvalidate()){
			//�ж��Ƿ���Ҫ�����֤
			//�����Ҫ�����֤���򴴽�һ��������֤��
			authenticator=new MailAttorney(this.R_Info.getUserName(),this.R_Info.getPassword());
		}
		session=Session.getInstance(this.R_Info.getProperties(),authenticator);
		try{
			this.store=session.getStore(this.R_Info.getProtocal());    //����store
		}catch(NoSuchProviderException e){
			System.out.println("���ӷ�����ʧ��!");
			return false;
		}
		System.out.println("�������ӷ����������Ժ�......");
		try{
			this.store.connect();    //��������
		}catch(MessagingException e){
			System.out.println("���ӷ�����ʧ��!");
			return false;
		}
		System.out.println("���ӷ������ɹ�");
		return true;
	}
	
	//���ռ���
	private boolean openInBoxFolder(){
		try{
			this.folder=store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);    //�����ļ��е�״̬Ϊ�ɶ�д
			Message[]massge=folder.getMessages();    //��ô��ļ����е�������Ϣ
			for(int i=0;i<massge.length;i++){
				massge[i].setFlag(Flags.Flag.DELETED, true);
				//��Ǵ��ʼ���flag��־�����deletedλΪtrue�������ٶ����ʼ���ֱ��ɾ�����ʼ�
				try{
					handle_Multipart(massge[i]);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("***********************************************");
			}
			return true;
		}catch(MessagingException e){
			System.err.println("�ռ�����Ϣ��ȡʧ�ܣ�");
		}
		return false;
	}
	
	private void handle_Multipart(Message massge){
		try{
			handle(massge);
			String disposition;
			BodyPart part;
			Multipart mp=(Multipart)massge.getContent();
			int mpCount=mp.getCount();
			//��ô��ʼ��и����ĸ���
			for(int m=0;m<mpCount;m++){
				part=mp.getBodyPart(m);
				disposition=part.getDisposition();
				if(disposition!=null&&disposition.equals(Part.ATTACHMENT)){
					M_saveAnnex(part);
				}else{
					System.out.println(part.getContent());
				}
			}
		}catch(Exception e){
			
		}
	}
	
	private void M_saveAnnex(BodyPart part){
		//���渽��
		String fileName;
		try{
			fileName=getFileName(part);    //��ø���������
			System.out.println("�и�����"+fileName);
			InputStream in=part.getInputStream();
			FileOutputStream writer=new FileOutputStream(
					new File(".\\attachments\\"+fileName);    //�����ļ������
					System.out.println("����·��Ϊ��"+".\\attchments\\"+fileName);
			byte[]b=new byte[255];
			int length=0;
			while((length=in.read(b))!=-1){
				writer.write(b);    //����д��ָ�����ļ�
			}
			writer.close();
			in.close();
		}catch(Exception e){
			
		}
	}
	
	private void handle(Message massge)throws Exception{
		System.out.println("�ʼ����⣺"+massge.getSubject());
		System.out.println("��������:"+massge.getSentDate());
		System.out.println("���͵�ַ��"+massge.getFrom()[0]);
	}
	
	//�Ͽ����ʼ�������������
	private boolean closeConnection(){
		try{
			if(this.folder.isOpen()){
				this.folder.close(true);
			}
			this.store.close();
			System.out.println("�ɹ��ر����ʼ������������ӣ�");
			return true;
		}catch(Exception e){
			System.out.println("�رպ��ʼ�������֮�������ʱ����");
		}
		return false;
	}
	
	//��ȡmess�е������ʼ�
	private void getAllMail()throws MessageingException{
		//���ʼ��ļ��л�ȡ�ʼ���Ϣ
		this.mess=this.folder.getMessage();
		System.out.println("�ܵ��ʼ���Ŀ��"+mess.length);
		System.out.println("���ʼ���Ŀ"+this.getNewMessageCount());
		System.out.println("ά���ʼ���Ŀ��"+this.getUnreadMessageCount());
		//��Ҫ���ص��ʼ�������
		int mailArrayLength=this.getMessageCount();
		System.out.println("һ�����ʼ�"+mailArrayLength+"��");
		int successCounter=0;
		int errorCount=0;
		for(int index=0;index<mailArrayLength;index++){
			try{
				this.C_Message=(mess[index]);    //������Ϣ��Ż�ȡ��Ϣ
				System.out.println("���ڻ�ȡ��"+(index+1)+"���ʼ�....");
				M_showMail(this.C_Message);    //��ʾ����Ϣ�Ļ�����Ϣ
				getMail();    //��ȡ��ǰmessage
				System.out.println("�ɹ���ȡ��"+(index+1)+"���ʼ�");
				successCounter++;
			}catch(Throwable e){
				errorCounter++;
				System.err.println("���ص�"+(index+1)+"���ʼ�ʱ����");
				
			}
		}
		System.out.println("---------------------------------------");
		System.out.println("�ɹ�������"+successCounter+"���ʼ�");
		System.out.println("ʧ��������"+errorCounter+"���ʼ�");
		System.out.println("---------------------------------------");
	}
	
	//��ʾ�ʼ��Ļ�����Ϣ
	private void M_showMail(Message message)throws Exception{
		System.out.println("������"+this.getFrom());
		System.out.println("�ռ��ˣ�"+this.getTOAddress());
		System.out.println("�����ˣ�"+this.getCCAddress());
		System.out.println("���⣺"+this.getSubject);
		System.out.println("���ڣ�"+this.getSendDate());
		System.out.print("�����ʼ���");
		System.out.println(this.isNew()?"��":"����");
		System.out.print("Ҫ���ִ��");
		System.out.println(this.getReplySign()?"��":"����");
		System.out.print("����������");
		System.out.println(this.isContainAttach()?"����":"������");
		System.out.println("---------------------------------------");
	}
	
	//����ʼ����ռ��ˡ����ͺ����͵ĵ�ַ�����������������ݵĲ����Ĳ�ͬ��"to"��ʾ�ռ��ˣ�"cc"��ʾ�����ˣ�"bcc"��ʾ�����˵�ַ
	private String getToAddress()throws Exception{
		return getMailAddress("TO",this.C_Message);
	}
	private String getCCAddress()throws Exception{
		return getMailAddress("CC",this.C_Message);
	}
	private String getBCCAddress()throws Exception{
		return getMailAddress("BCC",this.C_Message);
	}
	
	//����ʼ���ַ��type��ʾ���ͣ����ռ��ˡ������ˡ������ˣ�mimeMessage��ʾ�ʼ���Ϣ
	private String getMailAddress(String type,Message mimeMessage)throws Exception{
		String mailaddr="";
		String addtype=type.toUpperCase();
		InternetAddress[]address=null;
		if(addtype.equals("TO")||addtype.equals("CC")||addtype.equals("BCC")){
			if(addtype.equals("TO")){
				address=(InternetAddress[])mimeMessage.getRecipients(Message.RecipientType.TO);
			}else if(addtype.equals("CC")){
				address=(InternetAddress[])mimeMessage.getRecipients(Message.RecipientType.CC);
			}else{
				address=(InternetAddress[])mimeMessage.getRecipients(Message.RecipientType.BCC);
			}
			if(address!=null){
				for(int i=0;i<address.length;i++){
					//�Ȼ�ȡ�ʼ���ַ
					String email=address[i].getAddress();
					if(email==null){
						email="";
					}else{
						email=MimeUtility.decodeText(email);
					}
					//��ȡ�ø���������Ϣ
					String personal=address[i].getPersonal();
					if(personal==null){
						personal="";
					}else{
						personal=MimeUtility.decodeText(personal);
					}
					//������������Ϣ���ʼ���ַ������
					String compositeto=personal+"<"+email+">";
					//�����ַʱ���ö��÷ֿ�
					mailaddr+=","+compositeto;
				}
				mailaddr=mailaddr.substring(1);
			}
		}else{
			throw new Exception("����ĵ�ַ���ͣ���");
		}
		return mailaddr;
	}
	
	//��÷����˵ĵ�ַ������
	private String getFrom()throws Exception{
		return getFrom(this.C_Message);
	}
	
	private String getFrom(Message mimeMessage)throws Exception{
		InternetAddress[]address=(InternetAddress[])mimeMessage.getFrom();
		//��÷����˵�����
		String from=address[0].getAddress();
		if(from==null){
			from="";
		}
		//��ȡ�����˵�������Ϣ
		String personal=address[0].getPersonal();
		if(personal==null){
			personal="";
		}
		//ƽ�ɷ�����������Ϣ
		String fromaddr=personal+"<"+from+">";
		return fromaddr;
	}
	
	//��ȡmess��message����
	private int getMessageCount(){
		return this.mess.length;
	}
	
	//����ռ��������ʼ�������
	private int getNewMessageCount()throws MessagingException{
		return this.folder.getNewMessageCount();
	}
	
	private int getUnreadMessageCount()throws MessagingException{
		return this.folder.getUnreadMessageCount();
	}
	
	//����ʼ�����
	private String getSubject()throws MessagingException{
		return getSubject(this.C_Message);
	}
	
	private String getSubject(Message mimeMessage)throws MessagingException{
		String subject="";
		try{
			//���ʼ��������
			subject=MimeUtility.decodeText(mimeMessage.getSubject());
			if(subject==null){
				subject="";
			}
		}catch(Exception exce){
			
		}
		return subject;
	}
	
	//����ʼ���������
	private Date getSentDate()throws Exception{
		return getSentDate(this.C_Message);
	}
	
	private Date getSentDate(Message mimeMessage)throws Exception{
		return mimeMessage.getSentDate();
	}
	
	//�жϴ��ʼ��Ƿ���Ҫ��ִ�������Ҫ��ִ����true,���򷵻�false
	private boolean getReplySign()throws MessagingException{
		return getReplySign(this.C_Message);
	}
	
	private boolean getReplySign(Message mimeMessage)throws MessagingException{
		boolean replysign=false;
		String needreply[]=mimeMessage.getHeader("Disposition-Notification-To");
		if(needreply!=null){
			replysign=true;
		}
		return replysign;
	}
	
	//�жϴ��ʼ��Ƿ�һ�ȣ�����ά�ȷ���false,��֮����true;
	private boolean isNew()throws MessagingException{
		return isNew(this.C_Message);
	}
	
	private boolean isNew(Message mimeMessage)throws MessagingException{
		boolean isnew=false;
		Flags flags=mimeMessage.getFlags();
		Flags.Flag[]flag=flags.getSystemFlags();
		for(int i=0;i<flag.length;i++){
			if(flag[i]==Flags.Flag.SEEN){
				isnew=true;
				break;
			}
		}
		return isnew;
	}
	
	//�жϴ��ʼ��Ƿ��������
	private boolean isContainAttach()throws Exception{
		return isContainAttach(this.C_Message);
	}
	
	private boolean isContainAttach(Part part)throws Exception{
		boolean attachflag=false;
		if(part.isMimeType("multipart/*")){
			//����ʼ�������ಿ��
			Multipart mp=(Multipart)part.getContent();
			//����ÿ����
			for(int i=0;i<mp.getCount();i++){
				//���ÿ���ֵ�����
				BodyPart bodyPart=mp.getBodyPart(i);
				String disposition=bodyPart.getDisposition();
				if(disposition!=null&&(disposition.equals(Part.ATTACHMENT)||
						disposition.equals(Part.INLINE))){
					attachflag=true;
				}else if(bodyPart.isMimeType("multipart/*")){
					attachflag=isContainAttach((Part)bodyPart);
				}else{
					String contype=bodyPart.getContentType();
					if(contype.toLowerCase().indexOf("application")!=-1){
						attachflag=true;
					}
					if(contype.toLowerCase().indexOf("name")!=-1){
						attachflag=true;
					}
				}
			}
		}else if(part.isMimeType("message/rfc822")){
			attachflag=isContainAttach((Part)part.getContent());
		}
		return attachflag;
	}
}
