package educat_java;

class OneSingleton{
	//第一种方式实现单例模式
	private static int number=0;    //私有属性
	private static OneSingleton instance=new OneSingleton();    //OneSingleton的唯一实例
	
	private OneSingleton(){
		//构造函数私有防外界构造OneSingleton实例
	}
	public static OneSingleton getInstance(){
		//获取OneSingleton的实例
		return instance;
	}
	public synchronized int getNumber(){
		//synchronized关键字表示方法是线程同步
		return number;    //任一时刻最多只能有一个线程进入该方法
	}
	public synchronized void nextNumber(){
		//将number加1
		number++;
	}
}


class TwoSingleton{
	private static int number=0;    //私有属性
	private static TwoSingleton instance=null;    //TwoSingleton的唯一实例
	private TwoSingleton(){
		//构造函数私有防外界构造TwoSingleton实例
	}
	//synchronized关键字表示方法是线程同步
	public static synchronized TwoSingleton genInstance(){
		//任一时刻最多只能有一个线程进入该方法
		if(instance==null)
		{
			//判断是否instance为空，为空则创建
			instance=new TwoSingleton();
		}
		return instance;
	}
	public synchronized int getNumber(){
		return number;
	}
	public synchronized void nextNumber(){
		number++;
	}
}


public class TextSingleton{
	//操作单例模式的类
	public static void main(String[]args){
		//java程序主入口
		OneSingleton one1=OneSingleton.getInstance();    //调用方法获得实例
		OneSingleton one2=OneSingleton.getInstance();    //调用方法获得实例化=
		System.out.println("用OneSingleton实现单例模式：");
		System.out.println("调用nextNumber方法前：");
		System.out.println("one1.number="+one1.getNumber());
		System.out.println("one2.number="+one2.getNumber());
		one1.nextNumber();    //调用方法
		System.out.println("调用nextnumber方法后：");
		System.out.println("one1.number="+one1.getNumber());
		System.out.println("one2.number="+one2.getNumber());
		
		TwoSingleton two1=TwoSingleton.genInstance();    //调用方法获得实例
		TwoSingleton two2=TwoSingleton.genInstance();    //调用方法获得实例
		System.out.println("用TwoSingleton实现单例模式：");
		System.out.println("调用nextNumber方法前：");
		System.out.println("two1.number="+two1.getNumber());
		System.out.println("two2.number="+two2.getNumber());
		two1.nextNumber();    //调用方法
		System.out.println("调用nextnumber方法后：");
		System.out.println("two1.number="+two1.getNumber());
		System.out.println("two2.number="+two2.getNumber());
	}
}






