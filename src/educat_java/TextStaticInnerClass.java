package educat_java;

public class TextStaticInnerClass{
	//操作静态内部类
	private static int num=1;
	private int count=10;
	
	public static void outer(){
		System.out.println("这是外部类的静态方法");
		System.out.println();
		System.out.println("***************************************");
		System.out.println();
	}
	public static void outer_1(){
		System.out.println("这是外部类的静态方法");
		System.out.println("访问内部类的静态方法");
		System.out.println("--------------------");
		System.out.println("内部类的静态变量："+Inner.inner_num);
		Inner.inner_outer();
	}
	public void outer_2(){
		System.out.println("这是外部类的非静态方法");
		System.out.println("访问内部类的静态方法");
		System.out.println("--------------------");
		System.out.println("内部类的静态变量："+Inner.inner_num);
		Inner.inner_outer();
	}
	static class Inner{
		static int inner_num=100;
		int inner_count=200;
		
		static void inner_outer(){
			System.out.println("这是内部类的静态方法");
			System.out.println();
			System.out.println("******************************************");
			System.out.println();
		}
		static void inner_outer_1(){
			System.out.println("这是内部类的静态方法");
			System.out.println("访问外部类的静态方法");
			System.out.println("--------------------");
			System.out.println("外部类的静态变量："+num);
			outer();    //访问外部类的静态方法
		}
		void inner_outer_2(){
			System.out.println("这是静态内部类的非静态方法");
			System.out.println("访问外部类的静态方法");
			System.out.println("--------------------");
			System.out.println("外部类的静态变量："+num);
			outer();    //访问外部类的静态方法
		}
	}
	
	public static void main(String[]args){
		//java程序主入口
		TextStaticInnerClass inner=new TextStaticInnerClass();
		inner.outer_1();    //调用方法
		inner.outer_2();
		TextStaticInnerClass.Inner inn=new TextStaticInnerClass.Inner();
		inn.inner_outer_1();
		inn.inner_outer_2();
		

	}
}