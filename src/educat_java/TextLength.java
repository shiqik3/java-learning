package educat_java;

public class TextLength{
	//描述字符串长度的类
	public static boolean isChineseChar(char c)throws Exception{
		//判断是否是一个汉字
		return String.valueOf(c).getBytes("GBK").length>1;    //汉字的字节数大于1
	}
	public static int getChineseCount(String s)throws Exception{
		//获得汉字的长度
		char c;
		int chineseCount=0;
		if(!s.equals("")){
			//判断是否为空
			 s=new String(s.getBytes(),"GBK");    //进行统一编码
		}
		for(int i=0;i<s.length();i++)
		{
			//for循环
			c=s.charAt(i);    //获得字符串中的每个字符
			if(isChineseChar(c)){
				//调用方法进行判断是否为汉字
				chineseCount++;    //等同于chineseCount=chineseCount+1;
			}
		}
		return chineseCount;    //返回汉字个数
	}
	public static String getStringInfo(String s){
		//获得字母、数字、空格的个数
		char ch;
		int character=0,
				blank=0,
				number=0;
		for(int i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			if(ch>='a'&&ch<='z'||(ch>='A'&&ch<='Z'))
			{
				//统计字母
				character++;
			}
			else if(ch==' ')
			{
				//统计空格
				blank++;
			}
			else if(ch>'0'&&ch<='9')
			{
				//统计数字
				number++;
			}
			else
			{
				continue;
			}
		}
		return "字符串中共有"+character+"个字母，"+blank+"个空格，"+number+"个数字";
	}
	
	
	
	public static void main(String[]args) throws Exception{
		//java程序主入口
		String s="hello,world 世 界 你 好！！123";
		System.out.println("字符串的总长度："+s.length());    //显示字符串长度
		System.out.println("字符串中汉字长度："+getChineseCount(s));    //调用方法显示汉字长度
		System.out.println(getStringInfo(s));    //调用方法显示其他类型的长度
	}
}