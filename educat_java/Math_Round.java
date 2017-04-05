package educat_java;

import java.math.BigDecimal;

public class Math_Round{
	public static long getTraRoundMath(double du){
		//Math.round�����������Ƚ�dou����0.5��Ȼ��ȡ������
		//dou=4.6,����dou��0.5��5.1,��������Ϊ5����������Ľ������5
		return Math.round(du);
	}
	
	public static long getIntRound(double dou,int mode){
		//���ȡ��BigDecimal����ת����int������
		return Math_Round.getIntRound(dou, mode);
	}
	/**
	 * Ҫ�󷵻��������ΪBigDecimal���͵����ݣ����У�duΪ���������
	 * scale��ʾ���ص�BigDecimal����ı��(scale),mode��ʾ����ģʽ��
	 * return ��ʾ���������Ľ��
	 */
	

	public static BigDecimal getRound(double du,int scale,int mode){
		/**
		 * ����һ���µ�BigDecimal����paramNumber,�ö����ֵ��dou��Сһ��
		 */
		BigDecimal paramNumber=new BigDecimal(du);
		/**
		 * Ȼ�����paramNumber��setScale�������÷�������һ��BigDecimal����temp
		 * ����ֵ�ı��Ϊ��һ������ָ����ֵ�����Ϊ��С��ʾС�����ֵ�λ��
		 * �ڶ�������ָ����paramNumber����temp���������ģʽ
		 */
		return paramNumber.setScale(scale,mode);
	}
}