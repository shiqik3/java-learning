package educat_java;

class CopyStrByByte{
	//������
	private String str=null;    //�ַ���
	private int copyNum=0;    //Ҫ���Ƶ��ֽ���
	private String arrStr[];    //��Ž��ַ�����ֳɵ��ַ�����
	private int cutNum=0;    //�ѽ�ȡ���ֽ���
	private int cc=0;    //str�е������ַ���
	public CopyStrByByte(String str,int copyNum){
		//���캯��������ʼ��
		this.str=str;
		this.copyNum=copyNum;
	}
	public String CopyStr(){
		//�÷������ָ�����Ӵ�
		arrStr=str.split("");    //��������ַ������Ϊ�ַ�����
		str="";    //��գ����ڴ���ѽ�ȡ���ַ�
		for(int i=0;i<arrStr.length;i++)
		{
			if(arrStr[i].getBytes().length==1)
			{
				//�Ǻ���
				cutNum=cutNum+1;    //ͳ�Ƹ���
				str=str+arrStr[i];    //��÷Ǻ����Ӵ�
			}
			else if(arrStr[i].getBytes().length==2)
			{
				//����
				cc=cc+1;
				cutNum=cutNum+2;    //�����ֽ���Ϊ2����ͳ��
				str=str+arrStr[i];
			}
			//if����
			if(cutNum>=copyNum)
			{
				break;
			}
		}
		if(cutNum>copyNum)
		{
			str=str.substring(0, copyNum-cc);;    //�ѽ�ȡ���ַ�������Ҫ��ȡ���ַ���
		}
		return str;
	}
}

public class TextTruncate{
	//�����ַ������ȵ���
	public static void main(String[]args){
		CopyStrByByte cp=new CopyStrByByte("��ABC��DEF",7);    //�����ಢ��ʼ��
		System.out.println(cp.CopyStr());    //���÷�����ȡָ���Ӵ�
	}
}