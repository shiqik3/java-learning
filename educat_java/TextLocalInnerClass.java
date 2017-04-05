package educat_java;

interface LocalInterface{
	//定义一个接口
	public void local_1();    //定义三个方法
	public void local_2();
	public void local_3();
}

class Outer{
	//外部类
	private int a1=10;
	private void privateShow(){
		System.out.println("外部类的私有非静态变量");
	}
	public void show(){
		System.out.println("外部类的非静态方法");
	}
	public LocalInterface method(){
		//方法返回局部内部类实现的接口
		final int number=20;
		class Inner implements LocalInterface{
			//定义局部内部类实现接口
			public void local_1(){
				show();
			}
			public void local_2(){
				System.out.println("显示局部内部类的成员常量："+number);
				System.out.println("调用外部类的成员变量："+a1);
			}
			public void local_3(){
				privateShow();
			}
		}
		return new Inner();
	}
}


public class TextLocalInnerClass{
	//操作局部类的类
	public static void main(String[]args){
		//java程序主入口处
		Outer out=new Outer();    //实例化对象
		LocalInterface local=out.method();    //调用方法返回接口
		local.local_1();
		local.local_2();
		local.local_3();
	}
}

























