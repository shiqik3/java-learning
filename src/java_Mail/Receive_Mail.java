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
	private Store store;    //与邮件服务器连接后得到的邮箱
	private R_MailInfo R_Info;    //收邮件的参数配置
	private Folder folder;    //收件箱
	private Message[]mess;    //收件箱中的邮件消息
	private Message C_Message;    //当前正在处理的邮件消息
	private String C_FleName;    //当前正在处理的文件名称
	private Session session;    //创建与邮件服务器的会话
	String file_path="";    //定义保存后的文本文件的地址
	public Receive_Mail(R_MailInfo R_Info){
		this.R_Info=R_Info;
	}
	
	public void M_receiveMail()throws Exception{
		if(this.R_Info==null){
			throw new Exception("请载入接收邮件的参数！");
		}
		if(this.connectToServer()){
			//连接到服务器
			if(this.openInBoxFolder()){
				//打开收件箱
				this.getAllMail();    //获取所有邮件
				this.closeConnection();
			}else{
				throw new Exception("***进入收件夹失败!***");
			}
		}else{
			throw new Exception("***邮件服务器连接失败!***");
		}
	}
	//登陆邮件服务器
	private boolean connectToServer(){
		MailAttorney authenticator=null;
		if(this.R_Info.isIsvalidate()){
			//判断是否需要身份认证
			//如果需要身份认证，则创建一个密码验证器
			authenticator=new MailAttorney(this.R_Info.getUserName(),this.R_Info.getPassword());
		}
		session=Session.getInstance(this.R_Info.getProperties(),authenticator);
		try{
			this.store=session.getStore(this.R_Info.getProtocal());    //创建store
		}catch(NoSuchProviderException e){
			System.out.println("连接服务器失败!");
			return false;
		}
		System.out.println("正在连接服务器，请稍候......");
		try{
			this.store.connect();    //建立连接
		}catch(MessagingException e){
			System.out.println("连接服务器失败!");
			return false;
		}
		System.out.println("连接服务器成功");
		return true;
	}
	
	//打开收件夹
	private boolean openInBoxFolder(){
		try{
			this.folder=store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);    //设置文件夹的状态为可读写
			Message[]massge=folder.getMessages();    //获得此文件夹中的所有信息
			for(int i=0;i<massge.length;i++){
				massge[i].setFlag(Flags.Flag.DELETED, true);
				//标记此邮件的flag标志对象的deleted位为true，可以再读完邮件后直接删除该邮件
				try{
					handle_Multipart(massge[i]);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("***********************************************");
			}
			return true;
		}catch(MessagingException e){
			System.err.println("收件夹信息获取失败！");
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
			//获得此邮件中附件的个数
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
		//报存附件
		String fileName;
		try{
			fileName=getFileName(part);    //获得附件的名称
			System.out.println("有附件："+fileName);
			InputStream in=part.getInputStream();
			FileOutputStream writer=new FileOutputStream(
					new File(".\\attachments\\"+fileName);    //创建文件输出流
					System.out.println("保存路径为："+".\\attchments\\"+fileName);
			byte[]b=new byte[255];
			int length=0;
			while((length=in.read(b))!=-1){
				writer.write(b);    //将流写入指定的文件
			}
			writer.close();
			in.close();
		}catch(Exception e){
			
		}
	}
	
	private void handle(Message massge)throws Exception{
		System.out.println("邮件主题："+massge.getSubject());
		System.out.println("发送日期:"+massge.getSentDate());
		System.out.println("发送地址："+massge.getFrom()[0]);
	}
	
	//断开与邮件服务器的连接
	private boolean closeConnection(){
		try{
			if(this.folder.isOpen()){
				this.folder.close(true);
			}
			this.store.close();
			System.out.println("成功关闭与邮件服务器的连接！");
			return true;
		}catch(Exception e){
			System.out.println("关闭和邮件服务器之间的连接时出错！");
		}
		return false;
	}
	
	//获取mess中的所有邮件
	private void getAllMail()throws MessageingException{
		//从邮件文件夹获取邮件信息
		this.mess=this.folder.getMessage();
		System.out.println("总的邮件数目："+mess.length);
		System.out.println("新邮件数目"+this.getNewMessageCount());
		System.out.println("维度邮件数目："+this.getUnreadMessageCount());
		//将要下载的邮件的数量
		int mailArrayLength=this.getMessageCount();
		System.out.println("一共有邮件"+mailArrayLength+"封");
		int successCounter=0;
		int errorCount=0;
		for(int index=0;index<mailArrayLength;index++){
			try{
				this.C_Message=(mess[index]);    //根据消息编号获取消息
				System.out.println("正在获取第"+(index+1)+"封邮件....");
				M_showMail(this.C_Message);    //显示该消息的基本信息
				getMail();    //获取当前message
				System.out.println("成功获取第"+(index+1)+"封邮件");
				successCounter++;
			}catch(Throwable e){
				errorCounter++;
				System.err.println("下载第"+(index+1)+"封邮件时出错");
				
			}
		}
		System.out.println("---------------------------------------");
		System.out.println("成功下载了"+successCounter+"封邮件");
		System.out.println("失败下载了"+errorCounter+"封邮件");
		System.out.println("---------------------------------------");
	}
	
	//显示邮件的基本信息
	private void M_showMail(Message message)throws Exception{
		System.out.println("发件人"+this.getFrom());
		System.out.println("收件人："+this.getTOAddress());
		System.out.println("抄送人："+this.getCCAddress());
		System.out.println("主题："+this.getSubject);
		System.out.println("日期："+this.getSendDate());
		System.out.print("是新邮件？");
		System.out.println(this.isNew()?"是":"不是");
		System.out.print("要求回执？");
		System.out.println(this.getReplySign()?"是":"不是");
		System.out.print("包含附件？");
		System.out.println(this.isContainAttach()?"包含":"不包含");
		System.out.println("---------------------------------------");
	}
	
	//获得邮件的收件人、抄送和密送的地址和姓名，根据所传递的参数的不同，"to"表示收件人，"cc"表示抄送人，"bcc"表示密送人地址
	private String getToAddress()throws Exception{
		return getMailAddress("TO",this.C_Message);
	}
	private String getCCAddress()throws Exception{
		return getMailAddress("CC",this.C_Message);
	}
	private String getBCCAddress()throws Exception{
		return getMailAddress("BCC",this.C_Message);
	}
	
	//获得邮件地址，type表示类型，如收件人、抄送人、密送人，mimeMessage表示邮件信息
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
					//先获取邮件地址
					String email=address[i].getAddress();
					if(email==null){
						email="";
					}else{
						email=MimeUtility.decodeText(email);
					}
					//再取得个人描述信息
					String personal=address[i].getPersonal();
					if(personal==null){
						personal="";
					}else{
						personal=MimeUtility.decodeText(personal);
					}
					//将个人描述信息与邮件地址连起来
					String compositeto=personal+"<"+email+">";
					//多个地址时，用都好分开
					mailaddr+=","+compositeto;
				}
				mailaddr=mailaddr.substring(1);
			}
		}else{
			throw new Exception("错误的地址类型！！");
		}
		return mailaddr;
	}
	
	//获得发件人的地址和姓名
	private String getFrom()throws Exception{
		return getFrom(this.C_Message);
	}
	
	private String getFrom(Message mimeMessage)throws Exception{
		InternetAddress[]address=(InternetAddress[])mimeMessage.getFrom();
		//获得发件人的邮箱
		String from=address[0].getAddress();
		if(from==null){
			from="";
		}
		//获取发件人的描述信息
		String personal=address[0].getPersonal();
		if(personal==null){
			personal="";
		}
		//平成发件人完整信息
		String fromaddr=personal+"<"+from+">";
		return fromaddr;
	}
	
	//获取mess中message数量
	private int getMessageCount(){
		return this.mess.length;
	}
	
	//获得收件箱中新邮件的数量
	private int getNewMessageCount()throws MessagingException{
		return this.folder.getNewMessageCount();
	}
	
	private int getUnreadMessageCount()throws MessagingException{
		return this.folder.getUnreadMessageCount();
	}
	
	//获得邮件主题
	private String getSubject()throws MessagingException{
		return getSubject(this.C_Message);
	}
	
	private String getSubject(Message mimeMessage)throws MessagingException{
		String subject="";
		try{
			//将邮件主题解码
			subject=MimeUtility.decodeText(mimeMessage.getSubject());
			if(subject==null){
				subject="";
			}
		}catch(Exception exce){
			
		}
		return subject;
	}
	
	//获得邮件发送日期
	private Date getSentDate()throws Exception{
		return getSentDate(this.C_Message);
	}
	
	private Date getSentDate(Message mimeMessage)throws Exception{
		return mimeMessage.getSentDate();
	}
	
	//判断此邮件是否需要回执，如果需要回执返回true,否则返回false
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
	
	//判断此邮件是否一度，富国维度返回false,反之返回true;
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
	
	//判断此邮件是否包含附件
	private boolean isContainAttach()throws Exception{
		return isContainAttach(this.C_Message);
	}
	
	private boolean isContainAttach(Part part)throws Exception{
		boolean attachflag=false;
		if(part.isMimeType("multipart/*")){
			//如果邮件体包含多部分
			Multipart mp=(Multipart)part.getContent();
			//遍历每部分
			for(int i=0;i<mp.getCount();i++){
				//获得每部分的主体
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
