package educat_java;

public class TextInstanceOf{
	//操作instanceof运算符的类
	static class ObjectA{
		//静态内部类
		static String A="Object";
	}
	
	static class ObjectB extends ObjectA{
		//静态内部子类
		static void showInfo(){
			System.out.printf("超类的静态属性%s的值:%s%n","A","A");
		}
	}
	
	public static void main(String[]args){
		//java程序主入口
		ObjectA a=new ObjectA();
		ObjectB b=new ObjectB();
		if(a.A instanceof Object){
			//静态属性A是否是Object类型
			System.out.println("静态属性A是Object类型");
		}
		else
		{
			System.out.println("静态属性A不是Object类型");
		}
		
		if(a.A instanceof String){
			//静态属性A是否是String类型
			System.out.println("静态属性A是String类型");
		}
		else
		{
			System.out.println("静态属性A不是String类型");
		}
		
		if(null instanceof Object)
		{
			//null是否是Object类型
			System.out.println("null是Object类型");
		}
		else
		{
			System.out.println("null不是Object类型");
		}
		
		if(a instanceof ObjectA)
		{
			//检测对象a是否为ObjectA类型
			System.out.println("对象a是ObjectA类型");
		}
		else
		{
			System.out.println("对象a不是ObjectA类型");
		}
		
		if(b instanceof ObjectA)
		{
			System.out.println("对象b是ObjectA类型");
		}
		else
		{
			System.out.println("对象b不是ObjectA类型");
		}
		
		if(a instanceof ObjectB)
		{
			System.out.println("对象a是ObjectB类型");
		}
		else
		{
			System.out.println("对象a不是ObjectB类型");
		}
		
		if(b instanceof ObjectB)
		{
			System.out.println("对象b是ObjectB类型");
		}
		else
		{
			System.out.println("对象b不是ObjectB类型");
		}
	}
}
















