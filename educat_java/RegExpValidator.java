package educat_java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegExpValidator{
	//描述java正则表达式验证的类
	/**
	 * @param待验证的字符串
	 * @return如果是符合邮箱格式的字符串返回<b>true</b>,否则为<b>false</b>
	 */
	public static boolean isEmail(String str){
		String regex="[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-Z0-9]-*){1,}\\.){1,3}[a-zA-Z\\-}{1.}";
		return match(regex,str);
	}
	/**
	 * @param待验证的字符串
	 * @return如果是符合网址格式的字符串，返回<b>true</b>,否则为<b>false</b>
	 */
	public static boolean isHomepage(String str){
		String regex="http://(([a-zA-Z0-9]|-){1,}\\.){1,}[a-zA-Z0-9]{1,}-*";
		return match(regex,str);
	}
	/**
	 * @param regex正则表达式字符串
	 * @param str要匹配的字符串
	 * @return 如果str符合regex的正则表达式格式返回true否则返回false;
	 */
	private static boolean match(String regex,String str){
		Pattern pattern=Pattern.compile(regex);    //将传入的正则表达式编译到模式中
		Matcher matcher=pattern.matcher(str);    //模式进行匹配字符串
		return matcher.matches();    //返回匹配结果
	}
	public static void main(String[]args){
		//java程序的主入口方法
		String mail="aasina@.com";
		String homePage="http://www.sina.com.cn";
		System.out.println(mail+"邮箱是否有效："+isEmail(mail));    //调用方法验证邮箱
		System.out.println(homePage+"网址格式是否有效："+isHomepage(homePage));    //调用方法验证网址格式
	}
}