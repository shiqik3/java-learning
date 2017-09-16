package java_Mail;

import java.util.Properties;

public class Mail_SendProper {
	private String Host;
	private String Port="25";
	private String SendAddress;    //�ʼ������ߵĵ�ַ
	private String ReceiveAddress;    //�ʼ������ߵĵ�ַ
	//��½�ʼ����ͷ��������û���������
	private String userName;
	private String password;
	private boolean isvalidate=true;    //�Ƿ���Ҫ�����֤
	private String subject;    //�ʼ�����
	private String content;    //�ʼ����ı�����
	private String[]attachFileNames;    //�ʼ��������ļ���
	
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
