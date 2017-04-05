package educat_java;

interface AnonymityInter{
	//定义一个接口
	public void method();
}

abstract class AnonymityAbstract{
	//定义一个抽象类
	int count;
	abstract void method();
}

class AnonymityClass{
	//定义一个类
	public void method(){
		System.out.println("这是一个普通的类");
	}
}

public class TextAnonymity{
	//操作匿名内部类的类
	public static void main(String[]args){
		//java程序主入口
		AnonymityInter inter=new AnonymityInter(){
			//实现接口中的匿名内部类
			public void method(){
				//实现接口中的方法
				System.out.println("在匿名内部类中实现接口的方法");
			}
		};
		inter.method();    //调用方法
		AnonymityAbstract a=new AnonymityAbstract(){
			//实现抽象类的匿名内部类
			{
			count=(int)((10*Math.random())+1);    //随机获得数字
			}
			void method(){
				//重写方法
				System.out.println("您的幸运数字是"+count);
			}
		};
		a.method();    //调用方法
		AnonymityClass ac=new AnonymityClass(){
			//实现普通类的匿名内部类
			public void method(){
				//覆盖类的方法
				System.out.println("覆盖类的方法");
			}
		};
		ac.method();    //调用方法
	}
}
