package educat_java;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Test3{
	public static void main(String[]args){
		Writer out=new PrintWriter(System.out);
		try{
			char[]cs="��ʵ��ʹ��OutputSteam��������ڿ���̨����ַ���".toCharArray();
			out.write(cs);
			cs="������ݣ�".toCharArray();
			out.write(cs);
			out.flush();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}