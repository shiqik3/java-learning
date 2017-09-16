package educat_java;

import java.security.MessageDigest;

public class TextMD5{
	//描述对密码进行加密和验证的类
	private final static String[]hexDigits={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	//十六进制数字到字符的映射数组
	public static String createPassword(String inputString){
		//把inputString加密
		return encodeByMD5(inputString);
	}
	//验证输入的密码是否正确，password:真正的密码
	public static boolean authenticatePassword(String password,String inputString){
		if(password.equals(encodeByMD5(inputString))){
			return true;
		}else{
			return false;
		}
	}
	
	private static String encodeByMD5(String originString){
		//对字符串进行MD5加密
		if(originString!=null){
			try{
				//创建具有指定算法名称的信息摘要
				MessageDigest md=MessageDigest.getInstance("MD5");
				//指定的字节数组对摘要进行最后更新，完成摘要计算
				byte[]results=md.digest(originString.getBytes());
				String resultString=byteArrayToHexString(results);    //得到的字节数组变成字符串返回
				return resultString.toUpperCase();    //返回加密后的字符串
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private static String byteArrayToHexString(byte[]b){
		//转换字节数组为十六进制字符串
		StringBuffer resultSb=new StringBuffer();
		for(int i=0;i<b.length;i++){
			resultSb.append(byteToHexString(b[i]));    //调用方法将字节数组转为十六进制字符串
		}
		return resultSb.toString();    //返回十六进制字符串
	}
	
	//将一个字节转化成十六进制形式的字符
	private static String byteToHexString(byte b){
		int n=b;
		if(n<0){
			n=256+n;
		}
		int d1=n/16;
		int d2=n%16;
		return hexDigits[d1]+hexDigits[d2];
	}
	
	public static void main(String[]args){
		//java主程序入口
		String password=TextMD5.createPassword("888888");    //调用方法对字符串进行加密
		System.out.println("对888888用MD5加密后的字符串：\n"+encodeByMD5("888888"));    //加密后的字符串
		String inputString="8888";
		System.out.println("对8888用MD5加密后的字符串：\n"+encodeByMD5("8888"));    //加密后的字符串
		System.out.println("8888与密码匹配？"+String.valueOf(TextMD5.authenticatePassword(password, inputString)));    //验证加密后的字符串
		inputString="888888";
		System.out.println("888888与密码匹配？"+TextMD5.authenticatePassword(password, inputString));
	}
}










