package educat_java;

public class TextCompare{
	public static void main(String[]args){
		//java���������
		String str1="HelloWorld!";
		String str2="HelloWorld!";
		String str3=new String("HelloWorld!");
		String str4=new String("HelloWorld!");
		//�Ƚ������ַ�����hashcodeĬ�����ڴ��ַ
		System.out.println("str1��str2�Ĺ�ϣ���Ƿ���ͬ��"+(str1.hashCode()==str2.hashCode()));
		System.out.println("str1��str2��ֵ�Ƿ���ȣ�"+(str1.equals(str2)));
		System.out.println("str1��str2�Ƿ���ͬһ���ڴ��ַ��"+(str1==str2));
		
		System.out.println("str1��str3�Ĺ�ϣ���Ƿ���ͬ��"+(str1.hashCode()==str3.hashCode()));
		System.out.println("str1��str3��ֵ�Ƿ���ȣ�"+(str1.equals(str3)));
		System.out.println("str1��str3�Ƿ���ͬһ���ڴ��ַ��"+(str1==str3));
		
		int isSame=str1.compareTo(str2);
		
		str1=str3;    //������str3��������strr1
		System.out.println("str1��str3�Ĺ�ϣ���Ƿ���ͬ��"+(str1.hashCode()==str3.hashCode()));
		System.out.println("str1��str3��ֵ�Ƿ���ȣ�"+(str1.equals(str3)));
		System.out.println("str1��str3�Ƿ���ͬһ���ڴ��ַ��"+(str1==str3));
		System.out.println("str4��str3�Ƿ���ͬһ���ڴ��ַ��"+(str4==str3));
		int isSame1=str4.compareTo(str3);
		
		if(isSame==0)
		{
			System.out.println("����compareTo�����Ƚ�str1��str2���");
		}
		if(isSame1==0)
		{
			System.out.println("����compareTo�����Ƚ�str4��str3���");
		}
	}
}