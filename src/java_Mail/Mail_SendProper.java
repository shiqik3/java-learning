package java_Mail;

import java.util.Properties;

public class Mail_SendProper {
	private String Host;
	private String Port="25";
	private String SendAddress;    //邮件发送者的地址
	private String ReceiveAddress;    //邮件接收者的地址
	//登陆邮件发送服务器的用户名和密码
	private String userName;
	private String password;
	private boolean isvalidate=true;    //是否需要身份验证
	private String subject;    //邮件主题
	private String content;    //邮件的文本内容
	private String[]attachFileNames;    //邮件附件的文件名
	
	public Properties getProperties(){
		Properties p=new Properties();
		p.put("mail.smtp.host",this.Host);
		p.put("mail.smtp.port", this.Port);
		p.put("mail.smtp.auth", isvalidate?"true":"false");
		return p;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public String getHost(){
		return Host;
	}
	
	public void setHost(String host){
		Host=host;
	}
	
	public boolean isIsvalidate(){
		return isvalidate;
	}
	
	public void setIsvalidate(boolean isvalidate){
		this.isvalidate=isvalidate;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPort(){
		return Port;
	}
	
	public void setPort(String port){
		Port=port;
	}
	
	public String getReceiveAddress(){
		return ReceiveAddress;
	}
	
	public void setReceiveAddress(String receiveAddress){
		ReceiveAddress=receiveAddress;
	}
	
	public String getSendAddress(){
		return SendAddress;
	}
	
	public void setSendAddress(String sendAddress){
		SendAddress=sendAddress;
	}
	
	public String getSubject(){
		return subject;
	}
	
	public void setSubject(String subject){
		this.subject=subject;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String[] getAttachFileNames(){
		return attachFileNames;
	}
	
	public void setAttachFileNames(String[]attachFileNames){
		this.attachFileNames=attachFileNames;
	}
}
