package educat_java;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Test2{
	public static void main(String[]args){
		InputStreamReader rin=new InputStreamReader(System.in);
		try{
			char[]cs=new char[50];
			rin.read(cs);
			String str=new String(cs);
			System.out.println(str.trim());
			rin.close();
		}catch(IOException e){
			e.printStackTrace();
			System.out.println("error");
		}
	}
}