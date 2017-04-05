package educat_java;

class Plant{
	//植物
	String name;    //植物名称
	public Plant(String name){
		//带参数的构造方法
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
}

abstract class Garden{
	//花园类
	public abstract Plant getShade();    //花台上的植物
	public abstract Plant getCenter();    //中间的植物
	public abstract Plant getBorder();    //边上的植物
}

class Elegant extends Garden{
	//典雅型
	public Plant getBorder(){
		return new Plant("兰草");
	}
	public Plant getCenter(){
		return new Plant("榕树");
	}
	public Plant getShade(){
		return new Plant("郁金香");
	}
}

class Practical extends Garden{
	//实用型
	public Plant getShade(){
		return new Plant("葡萄");
	}
	public Plant getCenter(){
		return new Plant("石榴");
	}
	public Plant getBorder(){
		return new Plant("丝瓜");
	}
}

class Lazy extends Garden{
	//懒人型
	public Plant getShade(){
		return new Plant("月季");
	}
	public Plant getCenter(){
		return new Plant("茶花");
	}
	public Plant getBorder(){
		return new Plant("竹");
	}
}

class GardenMaker{
	//抽象工厂类
	private static Garden garden;
	public static Garden getGarden(String type) {
		garden =new Elegant();    //默认情况
		if(type.equals("实用型"))
		{
			garden=new Practical();
		}
		if(type.equals("懒人型"))
		{
			garden=new Lazy();
		}
		return garden;
	}
}

public class TextAbstractFactory{
	//操作抽象工厂模式的类
	public static void main(String[]args) {
		//java程序主入口
		Garden garden=GardenMaker.getGarden("实用型");    //传入参数调用方法获得实例
		Plant shade=garden.getShade();    //获取花园植物
		Plant center=garden.getCenter();
		Plant border=garden.getBorder();
		System.out.println("花台上的植物："+shade.getName());
		System.out.println("中间的植物："+center.getName());
		System.out.println("边上的的植物："+border.getName());
	}
}






















