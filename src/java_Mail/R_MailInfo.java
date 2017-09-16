package java_Mail;

import java.io.File;
import java.util.Properties;

public class R_MailInfo {
	//邮件服务器的IP、端口和协议
	private String Host;
	private String Port="110";
	private String protocal="pop3";
	//登陆邮件服务器的用户名和密码
	private String userName;
	private String password;
	//保存邮件的路径
	private String att_path="./temp/";
	private String mail_path="./temp";
	private String emailFileFormat=".eml";
	//是否需要身份验证
	private boolean Isvalidate=true;
	//获得邮件会话属性
	public Properties getProperties(){
		Properties p=new Properties();
		p.put("mail.pop3.host", this.Host);
		p.put("mail.pop3.port",this.Port);
		p.put("mail.pop3.auth", Isvalidate?"true":"false");
		return p;
	}
	
	public String getAtt_path(){
		return att_path;
	}
	
	public void setAtt_path(String att_path){
		if(!att_path.endsWith(File.separator)){
			att_path=att_path+File.separator;
		}
		this.att_path=att_path;
	}
	
	public String getEmailFileFormat(){
		return emailFileFormat;
	}
	
	public void setEmailFileFormat(String emailFileFormat){
		if(!emailFileFormat.startsWith(".")){
			emailFileFormat="."+emailFileFormat;
		}
		this.emailFileFormat=emailFileFormat;
	}
	
	public String getHost(){
		return Host;
	}
	
	public void setHost(String host){
		Host=host;
	}
	
	public boolean isIsvalidate(){
		return Isvalidate;
	}
	
	public void setIsvalidate(boolean isvalidate){
		Isvalidate=isvalidate;
	}
	
	public String getMail_path(){
		return mail_path;
	}
	
	public void setMail_path(String mail_path){
		if(!mail_path.endsWith(File.separator)){
			mail_path=mail_path+File.separator;
		}
		this.mail_path=mail_path;
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
	
	public String getProtocal(){
		return protocal;
	}
	
	public void setProtocal(String protocal){
		this.protocal=protocal;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
}
