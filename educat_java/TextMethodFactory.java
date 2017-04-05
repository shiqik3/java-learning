package educat_java;

interface Tour{
	//旅游类
	public void visit();    //旅游方法
}

interface Visit{
	//具体旅游方法
	public Tour visitStyle();
}

class GoAbroad implements Tour{
	//出国旅游
	public void visit(){
		//实现接口的方法
		System.out.println("咱们去国外旅游吧！");
	}
}

class Hangzhou implements Tour{
	//杭州旅游
	public void visit(){
		System.out.println("杭州风景优美，咱去那里吧");
	}
}

class Home implements Tour{
	//在家
	public void visit(){
		System.out.println("唉，没有钱哪里也去不了！");
	}
}

class GoAbroadVisit implements Visit{
	//返回出国旅游对象
	public Tour visitStyle(){
		return new GoAbroad();
	}
}

class HangzhouVisit implements Visit{
	//返回杭州旅游对象
	public Tour visitStyle(){
		return new Hangzhou();
	}
}

class HomeVisit implements Visit{
	//返回在家对象
	public Tour visitStyle(){
		return new Home();
	}
}

public class TextMethodFactory{
	//操作工厂方法模式的类
	public static void main(String[]args){
		//java程序主入口
		try{
			Visit visit=new HangzhouVisit();    //接口变了引用实现类对象
			Tour tour=visit.visitStyle();    //调用方法返回旅游实例
			System.out.println("今年咱们去哪里旅游呀！");
			tour.visit();    //调用方法获得旅游方式
		}
		catch(Exception e)
		{
			//捕获异常
			System.out.println("今年旅游计划取消？");
		}
		finally
		{
			//代码总被执行
			System.out.println("......");
		}
	}
}




















