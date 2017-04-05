package educat_java;

interface Shape{
	//������״�ӿ�
	public void setPosition(int position);    //����λ��
	public int getPosition();    //���λ��
	public void move();    //�ƶ�λ��
	public void display();    //չʾ��״
}

class Oblong implements Shape{
	//����һ��������״
	int position;
	public void setPosition(int position){
		this.position=position;
	}
	public int getPosition(){
		return this.position;
	}
	public void move(){
		System.out.println("����ͼ���Ѿ��ƶ�����"+3*position);
	}
	public void display(){
		System.out.println("����ͼ�ε�λ�ã�"+position);
	}
}

class Circular{
	//����һ��Բ����״��û��ʵ��Shape�ӿ�
	int position;
	public int getPosition(){
		return position;
	}
	public void setPosition(int position){
		this.position=position;
	}
	public void display(){
		System.out.println("Բ��ͼ�ε�λ�ã�"+position);
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
		//ΪCircle��չmove()����
		System.out.println("Բ��ͼ���Ѿ��ƶ�����"+3*getPosition());
	}
	public void setPosition(int position){
		circular.setPosition(position);
	}
}

public class TextAdapter{
	//����������ģʽ����
	public static void main(String[]args){
		//java���������
		Oblong oblong=new Oblong();    //ʵ��������
		oblong.setPosition(100);    //����λ��
		oblong.move();    //�ƶ�λ��
		CircularAdapter circular=new CircularAdapter();     //ʵ����������
		circular.setPosition(200);    //����λ��
		circular.display();    //��ʾλ��
		circular.move();    //�ƶ�λ��
	}
}
























