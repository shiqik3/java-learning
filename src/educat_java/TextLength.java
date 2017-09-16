package educat_java;

public class TextLength{
	//�����ַ������ȵ���
	public static boolean isChineseChar(char c)throws Exception{
		//�ж��Ƿ���һ������
		return String.valueOf(c).getBytes("GBK").length>1;    //���ֵ��ֽ�������1
	}
	public static int getChineseCount(String s)throws Exception{
		//��ú��ֵĳ���
		char c;
		int chineseCount=0;
		if(!s.equals("")){
			//�ж��Ƿ�Ϊ��
			 s=new String(s.getBytes(),"GBK");    //����ͳһ����
		}
		for(int i=0;i<s.length();i++)
		{
			//forѭ��
			c=s.charAt(i);    //����ַ����е�ÿ���ַ�
			if(isChineseChar(c)){
				//���÷��������ж��Ƿ�Ϊ����
				chineseCount++;    //��ͬ��chineseCount=chineseCount+1;
			}
		}
		return chineseCount;    //���غ��ָ���
	}
	public static String getStringInfo(String s){
		//�����ĸ�����֡��ո�ĸ���
		char ch;
		int character=0,
				blank=0,
				number=0;
		for(int i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			if(ch>='a'&&ch<='z'||(ch>='A'&&ch<='Z'))
			{
				//ͳ����ĸ
				character++;
			}
			else if(ch==' ')
			{
				//ͳ�ƿո�
				blank++;
			}
			else if(ch>'0'&&ch<='9')
			{
				//ͳ������
				number++;
			}
			else
			{
				continue;
			}
		}
		return "�ַ����й���"+character+"����ĸ��"+blank+"���ո�"+number+"������";
	}
	
	
	
	public static void main(String[]args) throws Exception{
		//java���������
		String s="hello,world �� �� �� �ã���123";
		System.out.println("�ַ������ܳ��ȣ�"+s.length());    //��ʾ�ַ�������
		System.out.println("�ַ����к��ֳ��ȣ�"+getChineseCount(s));    //���÷�����ʾ���ֳ���
		System.out.println(getStringInfo(s));    //���÷�����ʾ�������͵ĳ���
	}
}