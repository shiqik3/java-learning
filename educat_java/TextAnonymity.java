package educat_java;

interface AnonymityInter{
	//����һ���ӿ�
	public void method();
}

abstract class AnonymityAbstract{
	//����һ��������
	int count;
	abstract void method();
}

class AnonymityClass{
	//����һ����
	public void method(){
		System.out.println("����һ����ͨ����");
	}
}

public class TextAnonymity{
	//���������ڲ������
	public static void main(String[]args){
		//java���������
		AnonymityInter inter=new AnonymityInter(){
			//ʵ�ֽӿ��е������ڲ���
			public void method(){
				//ʵ�ֽӿ��еķ���
				System.out.println("�������ڲ�����ʵ�ֽӿڵķ���");
			}
		};
		inter.method();    //���÷���
		AnonymityAbstract a=new AnonymityAbstract(){
			//ʵ�ֳ�����������ڲ���
			{
			count=(int)((10*Math.random())+1);    //����������
			}
			void method(){
				//��д����
				System.out.println("��������������"+count);
			}
		};
		a.method();    //���÷���
		AnonymityClass ac=new AnonymityClass(){
			//ʵ����ͨ��������ڲ���
			public void method(){
				//������ķ���
				System.out.println("������ķ���");
			}
		};
		ac.method();    //���÷���
	}
}
