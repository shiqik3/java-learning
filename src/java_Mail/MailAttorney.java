package java_Mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAttorney extends Authenticator{
	private String userName;
	private String password;
	public MailAttorney(String userName,String password){
		this.userName=userName;
		this.password=password;
	}
	
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName,password);
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
}
