package educat_java;

import java.security.MessageDigest;

public class TextMD5{
	//������������м��ܺ���֤����
	private final static String[]hexDigits={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	//ʮ���������ֵ��ַ���ӳ������
	public static String createPassword(String inputString){
		//��inputString����
		return encodeByMD5(inputString);
	}
	//��֤����������Ƿ���ȷ��password:����������
	public static boolean authenticatePassword(String password,String inputString){
		if(password.equals(encodeByMD5(inputString))){
			return true;
		}else{
			return false;
		}
	}
	
	private static String encodeByMD5(String originString){
		//���ַ�������MD5����
		if(originString!=null){
			try{
				//��������ָ���㷨���Ƶ���ϢժҪ
				MessageDigest md=MessageDigest.getInstance("MD5");
				//ָ�����ֽ������ժҪ���������£����ժҪ����
				byte[]results=md.digest(originString.getBytes());
				String resultString=byteArrayToHexString(results);    //�õ����ֽ��������ַ�������
				return resultString.toUpperCase();    //���ؼ��ܺ���ַ���
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private static String byteArrayToHexString(byte[]b){
		//ת���ֽ�����Ϊʮ�������ַ���
		StringBuffer resultSb=new StringBuffer();
		for(int i=0;i<b.length;i++){
			resultSb.append(byteToHexString(b[i]));    //���÷������ֽ�����תΪʮ�������ַ���
		}
		return resultSb.toString();    //����ʮ�������ַ���
	}
	
	//��һ���ֽ�ת����ʮ��������ʽ���ַ�
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
		//java���������
		String password=TextMD5.createPassword("888888");    //���÷������ַ������м���
		System.out.println("��888888��MD5���ܺ���ַ�����\n"+encodeByMD5("888888"));    //���ܺ���ַ���
		String inputString="8888";
		System.out.println("��8888��MD5���ܺ���ַ�����\n"+encodeByMD5("8888"));    //���ܺ���ַ���
		System.out.println("8888������ƥ�䣿"+String.valueOf(TextMD5.authenticatePassword(password, inputString)));    //��֤���ܺ���ַ���
		inputString="888888";
		System.out.println("888888������ƥ�䣿"+TextMD5.authenticatePassword(password, inputString));
	}
}










