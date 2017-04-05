package educat_java;

interface LocalInterface{
	//����һ���ӿ�
	public void local_1();    //������������
	public void local_2();
	public void local_3();
}

class Outer{
	//�ⲿ��
	private int a1=10;
	private void privateShow(){
		System.out.println("�ⲿ���˽�зǾ�̬����");
	}
	public void show(){
		System.out.println("�ⲿ��ķǾ�̬����");
	}
	public LocalInterface method(){
		//�������ؾֲ��ڲ���ʵ�ֵĽӿ�
		final int number=20;
		class Inner implements LocalInterface{
			//����ֲ��ڲ���ʵ�ֽӿ�
			public void local_1(){
				show();
			}
			public void local_2(){
				System.out.println("��ʾ�ֲ��ڲ���ĳ�Ա������"+number);
				System.out.println("�����ⲿ��ĳ�Ա������"+a1);
			}
			public void local_3(){
				privateShow();
			}
		}
		return new Inner();
	}
}


public class TextLocalInnerClass{
	//�����ֲ������
	public static void main(String[]args){
		//java��������ڴ�
		Outer out=new Outer();    //ʵ��������
		LocalInterface local=out.method();    //���÷������ؽӿ�
		local.local_1();
		local.local_2();
		local.local_3();
	}
}

























