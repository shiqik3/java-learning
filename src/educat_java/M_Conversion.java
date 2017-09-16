package educat_java;

public class M_Conversion{
	public static void main(String[]args){
		int O_data=0766;    //八进制数字的声明，在前面加上0
		int T_data=123456;    //十进制的声明
		int H_data=0xA57B;    //十六进制数字的声明，在前面加上0x，x不区分大小写
		System.out.println("八进制"+O_data+"转换成二进制：");    //八进制转换成二进制
		System.out.println(Integer.toString(O_data,2)+";");
		System.out.println(Integer.toBinaryString(O_data));
		
		System.out.println("八进制"+O_data+"转换成十进制：");    //八进制转换成十进制
		System.out.println(Integer.toString(O_data,10)+";");
		System.out.println(Integer.toString(O_data));
		
		System.out.println("八进制"+O_data+"转换成十六进制：");    //八进制转换成十六进制
		System.out.println(Integer.toString(O_data,16)+";");
		System.out.println(Integer.toHexString(O_data));
	}
}