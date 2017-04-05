package educat_java;

import java.math.BigDecimal;

public class Math_Round{
	public static long getTraRoundMath(double du){
		//Math.round方法采用首先将dou加上0.5，然后取下整数
		//dou=4.6,首先dou加0.5成5.1,其下整数为5，四舍五入的结果就是5
		return Math.round(du);
	}
	
	public static long getIntRound(double dou,int mode){
		//左后取得BigDecimal对象转换成int并返回
		return Math_Round.getIntRound(dou, mode);
	}
	/**
	 * 要求返回舍入后结果为BigDecimal类型的数据；其中，du为舍入的数字
	 * scale表示返回的BigDecimal对象的标度(scale),mode表示舍入模式，
	 * return 表示返回舍入后的结果
	 */
	

	public static BigDecimal getRound(double du,int scale,int mode){
		/**
		 * 创建一个新的BigDecimal对象paramNumber,该对象的值和dou大小一样
		 */
		BigDecimal paramNumber=new BigDecimal(du);
		/**
		 * 然后调用paramNumber的setScale方法，该方法返回一个BigDecimal对象temp
		 * 返回值的标度为第一个参数指定的值，标度为大小表示小数部分的位数
		 * 第二个参数指定了paramNumber对象到temp对象的舍入模式
		 */
		return paramNumber.setScale(scale,mode);
	}
}