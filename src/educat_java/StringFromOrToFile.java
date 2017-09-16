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
	//���ַ���д��ָ���ļ�����ָ���ĸ�·�����ļ��в�����ʱ��������޶�ȥ�������Ա�֤����ɹ�����
	
	
	public static boolean StringToFile(String res,String filePath){
		boolean flag=true;
		BufferedReader bufferedReader=null;
		BufferedWriter bufferedWriter=null;
		try
		{
			File distFile=new File(filePath);    //�����ļ�
			if(!distFile.getParentFile().exists())
			{
				//�жϸ�·�����ļ����Ƿ����
				distFile.getParentFile().mkdirs();    //�����ڲ����ڵ�Ŀ¼�д����ļ���
			}
			bufferedReader=new BufferedReader(new StringReader(res));    //��ԭ�ַ������뻺��
			bufferedWriter=new BufferedWriter(new FileWriter(distFile));    //���ļ�д�뻺��
			char buf[]=new char[1024];    //�ַ�������
			int len;
			while((len=bufferedReader.read(buf))!=-1)
			{
				//whileѭ��
				bufferedWriter.write(buf,0,len);    //���ַ���д���ļ�
				
			}
			bufferedWriter.flush();    //ˢ��д�����Ļ���
			bufferedReader.close();    //�رն�����
			bufferedWriter.close();    //�ر�д����	
		}
		catch(IOException e)
		{
			//�����쳣
			e.printStackTrace();
			flag=false;
			return flag;
		}
		finally
		{
			//finally�����ܱ�ִ��
			if(bufferedReader!=null)
			{
				//�ж϶������Ƿ�Ϊ��
				try{
					bufferedReader.close();    //ȷ���������ر�
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return flag;    //���ز�������
	}
	//�ı��ļ�ת��Ϊָ��������ַ���
	
	
	public static String fileToString(String filePath,String encoding){
		InputStreamReader reader=null;
		StringWriter writer=new StringWriter();
		try
		{
			if(encoding==null||"".equals(encoding.trim()))
			{
				//�жϱ��������Ƿ�Ϊ��
				reader=new InputStreamReader(new FileInputStream(new File(filePath)),encoding);
				//���ñ��뷽ʽ
			}
			else
			{
				reader=new InputStreamReader(new FileInputStream(new File(filePath)));
				//�ļ�����������
			}
			char[]buf=new char[DEFAULT_BUFFER_SIZE];
			int len=0;
			while(-1!=(len=reader.read(buf)))
			{
				writer.write(buf,0,len);    //��������д�������
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
					reader.close();    //ȷ���������ر�
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return writer.toString();    //����ת�����
	}
	
	
	public static void main(String[]args){
		//java���������
		String res="�ַ���д��ָ���ļ��ı��ļ���Ϊָ��������ַ���";
		String filePath="E:/1.txt";    //�ļ�
		String encoding="GB2321";    //�����ʽ����
		System.out.println("�ַ���д��ָ���ļ��Ƿ�ɹ���"+StringToFile(res,filePath));
		//���÷������ַ���д���ļ�
		System.out.println("��"+filePath+"�ļ�����"+encoding+"�����ʽ���뵽������:\r\n"+fileToString(filePath,encoding));
	}
}
















