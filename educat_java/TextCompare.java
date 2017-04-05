package educat_java;

public class TextCompare{
	public static void main(String[]args){
		//java程序主入口
		String str1="HelloWorld!";
		String str2="HelloWorld!";
		String str3=new String("HelloWorld!");
		String str4=new String("HelloWorld!");
		//比较两个字符串的hashcode默认是内存地址
		System.out.println("str1与str2的哈希码是否相同："+(str1.hashCode()==str2.hashCode()));
		System.out.println("str1与str2的值是否相等："+(str1.equals(str2)));
		System.out.println("str1与str2是否是同一个内存地址："+(str1==str2));
		
		System.out.println("str1与str3的哈希码是否相同："+(str1.hashCode()==str3.hashCode()));
		System.out.println("str1与str3的值是否相等："+(str1.equals(str3)));
		System.out.println("str1与str3是否是同一个内存地址："+(str1==str3));
		
		int isSame=str1.compareTo(str2);
		
		str1=str3;    //讲对象str3赋给对象strr1
		System.out.println("str1与str3的哈希码是否相同："+(str1.hashCode()==str3.hashCode()));
		System.out.println("str1与str3的值是否相等："+(str1.equals(str3)));
		System.out.println("str1与str3是否是同一个内存地址："+(str1==str3));
		System.out.println("str4与str3是否是同一个内存地址："+(str4==str3));
		int isSame1=str4.compareTo(str3);
		
		if(isSame==0)
		{
			System.out.println("运用compareTo方法比较str1与str2相等");
		}
		if(isSame1==0)
		{
			System.out.println("运用compareTo方法比较str4与str3相等");
		}
	}
}