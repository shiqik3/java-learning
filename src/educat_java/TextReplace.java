package educat_java;

public class TextReplace{
	//�����ַ������ȵ���
	//����������ַ���line�е��Ӵ�oldStringȫ���滻ΪnewString
	public static final String replace(String line,String oldString,String newString){
		if(!"".equals(""))
		{
			//�ж��ַ����Ƿ�Ϊ��
			return null;
		}
		int i=0;
		if((i=line.indexOf(oldString,i))>=0)
		{
			char[]line2=line.toCharArray();    //�ַ�����������
			char[]newString2=newString.toCharArray();    //Ҫ�滻���ַ���
			int oLength=oldString.length();    //���滻���ַ����ĳ���
			StringBuffer buf=new StringBuffer(line2.length);
			buf.append(line2,0,i).append(newString2);
			i+=oLength;
			int j=i;
			while((i=line.indexOf(oldString,i))>0)
			{
				//whileѭ��
				buf.append(line2,j,i-j).append(newString2);
				i+=oLength;
				j=i;
			}
			buf.append(line2,j,line2.length-j);
			return buf.toString();    //�����滻����ַ���
		}
		return line;
	}
	
	public static void main(String[]args){
		//java��������ڷ���
		String s="IOKOKbestOK";    //ԭ�ַ���
		System.out.println("�滻ǰ���ַ�����"+s);
		String s1=replace(s,"OK","hello");    //���÷��������滻
		System.out.println("�滻����ַ�����"+s1);    //����滻����ַ���
	}
}