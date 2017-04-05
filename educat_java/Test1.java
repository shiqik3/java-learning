package educat_java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test1{
	public static void main(String[]args){
		String a = null;
		for(int i=0;i<10;i++)
		{
			a="D://"+i+".txt";
		
		Path path=Paths.get(a);
		try {
			Path file=Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件已经被创建");
		}
		}
		/*try {
			Files.delete(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}