package educat_java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegExpValidator{
	//����java������ʽ��֤����
	/**
	 * @param����֤���ַ���
	 * @return����Ƿ��������ʽ���ַ�������<b>true</b>,����Ϊ<b>false</b>
	 */
	public static boolean isEmail(String str){
		String regex="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-Z0-9]-*){1,}\\.){1,3}[a-zA-Z\\-}{1.}";
		return match(regex,str);
	}
	/**
	 * @param����֤���ַ���
	 * @return����Ƿ�����ַ��ʽ���ַ���������<b>true</b>,����Ϊ<b>false</b>
	 */
	public static boolean isHomepage(String str){
		String regex="http://(([a-zA-Z0-9]|-){1,}\\.){1,}[a-zA-Z0-9]{1,}-*";
		return match(regex,str);
	}
	/**
	 * @param regex������ʽ�ַ���
	 * @param strҪƥ����ַ���
	 * @return ���str����regex��������ʽ��ʽ����true���򷵻�false;
	 */
	private static boolean match(String regex,String str){
		Pattern pattern=Pattern.compile(regex);    //�������������ʽ���뵽ģʽ��
		Matcher matcher=pattern.matcher(str);    //ģʽ����ƥ���ַ���
		return matcher.matches();    //����ƥ����
	}
	public static void main(String[]args){
		//java���������ڷ���
		String mail="aasina@.com";
		String homePage="http://www.sina.com.cn";
		System.out.println(mail+"�����Ƿ���Ч��"+isEmail(mail));    //���÷�����֤����
		System.out.println(homePage+"��ַ��ʽ�Ƿ���Ч��"+isHomepage(homePage));    //���÷�����֤��ַ��ʽ
	}
}