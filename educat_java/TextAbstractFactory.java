package educat_java;

class Plant{
	//ֲ��
	String name;    //ֲ������
	public Plant(String name){
		//�������Ĺ��췽��
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
	//��԰��
	public abstract Plant getShade();    //��̨�ϵ�ֲ��
	public abstract Plant getCenter();    //�м��ֲ��
	public abstract Plant getBorder();    //���ϵ�ֲ��
}

class Elegant extends Garden{
	//������
	public Plant getBorder(){
		return new Plant("����");
	}
	public Plant getCenter(){
		return new Plant("����");
	}
	public Plant getShade(){
		return new Plant("������");
	}
}

class Practical extends Garden{
	//ʵ����
	public Plant getShade(){
		return new Plant("����");
	}
	public Plant getCenter(){
		return new Plant("ʯ��");
	}
	public Plant getBorder(){
		return new Plant("˿��");
	}
}

class Lazy extends Garden{
	//������
	public Plant getShade(){
		return new Plant("�¼�");
	}
	public Plant getCenter(){
		return new Plant("�軨");
	}
	public Plant getBorder(){
		return new Plant("��");
	}
}

class GardenMaker{
	//���󹤳���
	private static Garden garden;
	public static Garden getGarden(String type) {
		garden =new Elegant();    //Ĭ�����
		if(type.equals("ʵ����"))
		{
			garden=new Practical();
		}
		if(type.equals("������"))
		{
			garden=new Lazy();
		}
		return garden;
	}
}

public class TextAbstractFactory{
	//�������󹤳�ģʽ����
	public static void main(String[]args) {
		//java���������
		Garden garden=GardenMaker.getGarden("ʵ����");    //����������÷������ʵ��
		Plant shade=garden.getShade();    //��ȡ��԰ֲ��
		Plant center=garden.getCenter();
		Plant border=garden.getBorder();
		System.out.println("��̨�ϵ�ֲ�"+shade.getName());
		System.out.println("�м��ֲ�"+center.getName());
		System.out.println("���ϵĵ�ֲ�"+border.getName());
	}
}






















