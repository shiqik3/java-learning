package educat_java;

interface Shape{
	//定义形状接口
	public void setPosition(int position);    //设置位置
	public int getPosition();    //获得位置
	public void move();    //移动位置
	public void display();    //展示形状
}

class Oblong implements Shape{
	//定义一个矩形形状
	int position;
	public void setPosition(int position){
		this.position=position;
	}
	public int getPosition(){
		return this.position;
	}
	public void move(){
		System.out.println("矩形图形已经移动到："+3*position);
	}
	public void display(){
		System.out.println("矩形图形的位置："+position);
	}
}

class Circular{
	//定义一个圆形形状，没有实现Shape接口
	int position;
	public int getPosition(){
		return position;
	}
	public void setPosition(int position){
		this.position=position;
	}
	public void display(){
		System.out.println("圆形图形的位置："+position);
	}
}

class CircularAdapter implements Shape{
	private Circular circular;
	public CircularAdapter(){
		circular=new Circular();
	}
	public void display(){
		circular.display();
	}
	public int getPosition(){
		return circular.getPosition();
	}
	public void move(){
		//为Circle扩展move()方法
		System.out.println("圆形图形已经移动到："+3*getPosition());
	}
	public void setPosition(int position){
		circular.setPosition(position);
	}
}

public class TextAdapter{
	//操作适配器模式的类
	public static void main(String[]args){
		//java程序主入口
		Oblong oblong=new Oblong();    //实例化对象
		oblong.setPosition(100);    //设置位置
		oblong.move();    //移动位置
		CircularAdapter circular=new CircularAdapter();     //实例化适配器
		circular.setPosition(200);    //设置位置
		circular.display();    //显示位置
		circular.move();    //移动位置
	}
}
























