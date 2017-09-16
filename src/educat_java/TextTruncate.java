package educat_java;

class CopyStrByByte{
	//调用类
	private String str=null;    //字符串
	private int copyNum=0;    //要复制的字节数
	private String arrStr[];    //存放将字符串拆分成的字符数组
	private int cutNum=0;    //已截取的字节数
	private int cc=0;    //str中的中文字符数
	public CopyStrByByte(String str,int copyNum){
		//构造函数变量初始化
		this.str=str;
		this.copyNum=copyNum;
	}
	public String CopyStr(){
		//该方法获得指定的子串
		arrStr=str.split("");    //将传入的字符串拆分为字符数组
		str="";    //清空，用于存放已截取的字符
		for(int i=0;i<arrStr.length;i++)
		{
			if(arrStr[i].getBytes().length==1)
			{
				//非汉字
				cutNum=cutNum+1;    //统计个数
				str=str+arrStr[i];    //获得非汉字子串
			}
			else if(arrStr[i].getBytes().length==2)
			{
				//汉字
				cc=cc+1;
				cutNum=cutNum+2;    //汉字字节数为2进行统计
				str=str+arrStr[i];
			}
			//if结束
			if(cutNum>=copyNum)
			{
				break;
			}
		}
		if(cutNum>copyNum)
		{
			str=str.substring(0, copyNum-cc);;    //已截取的字符数大于要截取的字符数
		}
		return str;
	}
}

public class TextTruncate{
	//描述字符串长度的类
	public static void main(String[]args){
		CopyStrByByte cp=new CopyStrByByte("我ABC汉DEF",7);    //调用类并初始化
		System.out.println(cp.CopyStr());    //调用方法获取指定子串
	}
}