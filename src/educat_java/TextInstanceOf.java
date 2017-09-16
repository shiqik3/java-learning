package educat_java;

public class TextInstanceOf{
	//����instanceof���������
	static class ObjectA{
		//��̬�ڲ���
		static String A="Object";
	}
	
	static class ObjectB extends ObjectA{
		//��̬�ڲ�����
		static void showInfo(){
			System.out.printf("����ľ�̬����%s��ֵ:%s%n","A","A");
		}
	}
	
	public static void main(String[]args){
		//java���������
		ObjectA a=new ObjectA();
		ObjectB b=new ObjectB();
		if(a.A instanceof Object){
			//��̬����A�Ƿ���Object����
			System.out.println("��̬����A��Object����");
		}
		else
		{
			System.out.println("��̬����A����Object����");
		}
		
		if(a.A instanceof String){
			//��̬����A�Ƿ���String����
			System.out.println("��̬����A��String����");
		}
		else
		{
			System.out.println("��̬����A����String����");
		}
		
		if(null instanceof Object)
		{
			//null�Ƿ���Object����
			System.out.println("null��Object����");
		}
		else
		{
			System.out.println("null����Object����");
		}
		
		if(a instanceof ObjectA)
		{
			//������a�Ƿ�ΪObjectA����
			System.out.println("����a��ObjectA����");
		}
		else
		{
			System.out.println("����a����ObjectA����");
		}
		
		if(b instanceof ObjectA)
		{
			System.out.println("����b��ObjectA����");
		}
		else
		{
			System.out.println("����b����ObjectA����");
		}
		
		if(a instanceof ObjectB)
		{
			System.out.println("����a��ObjectB����");
		}
		else
		{
			System.out.println("����a����ObjectB����");
		}
		
		if(b instanceof ObjectB)
		{
			System.out.println("����b��ObjectB����");
		}
		else
		{
			System.out.println("����b����ObjectB����");
		}
	}
}
















