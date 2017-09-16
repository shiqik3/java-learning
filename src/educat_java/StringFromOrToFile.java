package educat_java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

public class StringFromOrToFile{
	public static int DEFAULT_BUFFER_SIZE=1000;
	//讲字符串写入指定文件（当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！）
	
	
	public static boolean StringToFile(String res,String filePath){
		boolean flag=true;
		BufferedReader bufferedReader=null;
		BufferedWriter bufferedWriter=null;
		try
		{
			File distFile=new File(filePath);    //创建文件
			if(!distFile.getParentFile().exists())
			{
				//判断父路径的文件夹是否存在
				distFile.getParentFile().mkdirs();    //可以在不存在的目录中创建文件夹
			}
			bufferedReader=new BufferedReader(new StringReader(res));    //将原字符串读入缓冲
			bufferedWriter=new BufferedWriter(new FileWriter(distFile));    //将文件写入缓冲
			char buf[]=new char[1024];    //字符缓冲区
			int len;
			while((len=bufferedReader.read(buf))!=-1)
			{
				//while循环
				bufferedWriter.write(buf,0,len);    //将字符串写入文件
				
			}
			bufferedWriter.flush();    //刷新写入流的缓冲
			bufferedReader.close();    //关闭读出流
			bufferedWriter.close();    //关闭写入流	
		}
		catch(IOException e)
		{
			//捕获异常
			e.printStackTrace();
			flag=false;
			return flag;
		}
		finally
		{
			//finally方法总被执行
			if(bufferedReader!=null)
			{
				//判断读出流是否为空
				try{
					bufferedReader.close();    //确保读出流关闭
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return flag;    //返回布尔类型
	}
	//文本文件转换为指定编码的字符串
	
	
	public static String fileToString(String filePath,String encoding){
		InputStreamReader reader=null;
		StringWriter writer=new StringWriter();
		try
		{
			if(encoding==null||"".equals(encoding.trim()))
			{
				//判断编码类型是否为空
				reader=new InputStreamReader(new FileInputStream(new File(filePath)),encoding);
				//设置编码方式
			}
			else
			{
				reader=new InputStreamReader(new FileInputStream(new File(filePath)));
				//文件进入输入流
			}
			char[]buf=new char[DEFAULT_BUFFER_SIZE];
			int len=0;
			while(-1!=(len=reader.read(buf)))
			{
				writer.write(buf,0,len);    //将输入流写入输出流
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(reader!=null)
			{
				try
				{
					reader.close();    //确保输入流关闭
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return writer.toString();    //返回转换结果
	}
	
	
	public static void main(String[]args){
		//java程序主入口
		String res="字符串写入指定文件文本文件换为指定编码的字符串";
		String filePath="E:/1.txt";    //文件
		String encoding="GB2321";    //编码格式设置
		System.out.println("字符串写入指定文件是否成功："+StringToFile(res,filePath));
		//调用方法将字符串写入文件
		System.out.println("从"+filePath+"文件根据"+encoding+"编码格式读入到的内容:\r\n"+fileToString(filePath,encoding));
	}
}
















