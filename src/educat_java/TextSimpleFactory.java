package educat_java;

interface Car{
	//���ĸ���
	public void driver();    //����
}

class Benz implements Car{
	//���۳�
	public void driver(){
		System.out.println("�����ۿ����ۣ�");
	}
}

class Bike implements Car{
	public void driver(){
		System.out.println("�������ھ���Σ����ֻ�������г���ѽ��");
	}
}

class Bmw implements Car{
	//����
	public void driver(){
		System.out.println("���쿪�����!");
	}
}

class Driver{
	//���Ĺ���
	public static Car driverCar(String s)throws Exception{
		if(s.equalsIgnoreCase("Benz"))
		{
			//�жϴ���������ز�ͬ��ʵ����
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
			throw new Exception();    //�ܳ��쳣
		}
	}
}

public class TextSimpleFactory{
	//�����򵥹���ģʽ����
	public static void main(String[]args){
		//java������ڴ�
		try{
			Car car=Driver.driverCar("Bike");    //���÷������س���ʵ��
			System.out.println("�������쿪ʲô��ѽ��");
			car.driver();    //���÷�������
		}
		catch(Exception e)
		{
			//�����쳣
			System.out.println("������������......");
		}
		finally{
			//�����ܱ�ִ��
			System.out.println(".......");
		}
	}
}


























