package educat_java;


class OuterClass{
	String outer="outerclass";
	private int number=1;
	private static int count=10;
	
	public OuterClass(){}//默认构造方法
	public OuterClass(int number,int count){
		//带参数的构造方法
				this.number=number;
				this.count=count;
				System.out.println("传入的数分别为："+this.number+"与"+this.count);
	}
	private void outer_1(){
		//外部非静态方法
		System.out.println("调用外部类的非静态方法");
		//InnerClass inner=this.new InnerClass();
	}
	private static void outer_2(){
		//外部类的静态方法
		System.out.println("调用外部类的静态方法");
		//InnerClass inner=this.new InnerClass();
	}
	
	class InnerClass{
		//定义成员内部类
		String outer="innerclass";
		public InnerClass(){
			//默认构造方法
			System.out.println("成员内部类的构造方法");
		}
		protected void communicate(){
			//交流的方法
			System.out.println("外部类的字符串："+OuterClass.this.outer);
			System.out.println("内部类的字符串："+this.outer);
		}
		protected void inner_1(){
			//成员内部类的非静态方法
			System.out.println("调用外部类的私有方法");
			outer_1();
			outer_2();
		}
	}
}



public class TextMemberInnerClass{
	//操作成员内部类的类
	public static void main(String[]args){
		//java程序主入口
		OuterClass outer=new OuterClass(10,20);    //实例化对象
		OuterClass.InnerClass inner=outer.new InnerClass();    //实例化成员内部类
		System.out.println("OuterClass="+outer.outer);
		System.out.println("InnerClass="+inner.outer);
		inner.communicate();    //调用方法
		inner.inner_1();
	}
}


























