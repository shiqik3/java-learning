package educat_java;

public class TextReplace{
	//描述字符串长度的类
	//这个方法将字符串line中的子串oldString全部替换为newString
	public static final String replace(String line,String oldString,String newString){
		if(!"".equals(""))
		{
			//判断字符串是否为空
			return null;
		}
		int i=0;
		if((i=line.indexOf(oldString,i))>=0)
		{
			char[]line2=line.toCharArray();    //字符串放入数组
			char[]newString2=newString.toCharArray();    //要替换额字符串
			int oLength=oldString.length();    //被替换的字符串的长度
			StringBuffer buf=new StringBuffer(line2.length);
			buf.append(line2,0,i).append(newString2);
			i+=oLength;
			int j=i;
			while((i=line.indexOf(oldString,i))>0)
			{
				//while循环
				buf.append(line2,j,i-j).append(newString2);
				i+=oLength;
				j=i;
			}
			buf.append(line2,j,line2.length-j);
			return buf.toString();    //返回替换后的字符串
		}
		return line;
	}
	
	public static void main(String[]args){
		//java程序主入口方法
		String s="IOKOKbestOK";    //原字符串
		System.out.println("替换前的字符串："+s);
		String s1=replace(s,"OK","hello");    //调用方法进行替换
		System.out.println("替换后的字符串："+s1);    //输出替换后的字符串
	}
}