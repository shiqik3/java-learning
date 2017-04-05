package educat_java;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Test3{
	public static void main(String[]args){
		Writer out=new PrintWriter(System.out);
		try{
			char[]cs="本实力使用OutputSteam输出流，在控制台输出字符串".toCharArray();
			out.write(cs);
			cs="输出内容：".toCharArray();
			out.write(cs);
			out.flush();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}