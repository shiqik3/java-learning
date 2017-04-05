package educat_java;

interface Car{
	//车的父类
	public void driver();    //开车
}

class Benz implements Car{
	//奔驰车
	public void driver(){
		System.out.println("今天咱开奔驰！");
	}
}

class Bike implements Car{
	public void driver(){
		System.out.println("唉，现在经济危机，只能起自行车了呀！");
	}
}

class Bmw implements Car{
	//宝马
	public void driver(){
		System.out.println("今天开宝马吧!");
	}
}

class Driver{
	//车的工厂
	public static Car driverCar(String s)throws Exception{
		if(s.equalsIgnoreCase("Benz"))
		{
			//判断窜入参数返回不同的实现类
			return new Benz();
		}
		else if(s.equalsIgnoreCase("Bmw"))
		{
			return new Bmw();
		}
		else if(s.equalsIgnoreCase("Bike"))
		{
			return new Bike();
		}
		else
		{
			throw new Exception();    //跑出异常
		}
	}
}

public class TextSimpleFactory{
	//操作简单工厂模式的类
	public static void main(String[]args){
		//java程序入口处
		try{
			Car car=Driver.driverCar("Bike");    //调用方法返回车的实例
			System.out.println("经理，今天开什么车呀！");
			car.driver();    //调用方法开车
		}
		catch(Exception e)
		{
			//捕获异常
			System.out.println("开车出现问题......");
		}
		finally{
			//代码总被执行
			System.out.println(".......");
		}
	}
}


























