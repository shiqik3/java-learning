package educat_java;

public class M_Conversion{
	public static void main(String[]args){
		int O_data=0766;    //�˽������ֵ���������ǰ�����0
		int T_data=123456;    //ʮ���Ƶ�����
		int H_data=0xA57B;    //ʮ���������ֵ���������ǰ�����0x��x�����ִ�Сд
		System.out.println("�˽���"+O_data+"ת���ɶ����ƣ�");    //�˽���ת���ɶ�����
		System.out.println(Integer.toString(O_data,2)+";");
		System.out.println(Integer.toBinaryString(O_data));
		
		System.out.println("�˽���"+O_data+"ת����ʮ���ƣ�");    //�˽���ת����ʮ����
		System.out.println(Integer.toString(O_data,10)+";");
		System.out.println(Integer.toString(O_data));
		
		System.out.println("�˽���"+O_data+"ת����ʮ�����ƣ�");    //�˽���ת����ʮ������
		System.out.println(Integer.toString(O_data,16)+";");
		System.out.println(Integer.toHexString(O_data));
	}
}