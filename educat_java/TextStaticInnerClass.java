package educat_java;

public class TextStaticInnerClass{
	//������̬�ڲ���
	private static int num=1;
	private int count=10;
	
	public static void outer(){
		System.out.println("�����ⲿ��ľ�̬����");
		System.out.println();
		System.out.println("***************************************");
		System.out.println();
	}
	public static void outer_1(){
		System.out.println("�����ⲿ��ľ�̬����");
		System.out.println("�����ڲ���ľ�̬����");
		System.out.println("--------------------");
		System.out.println("�ڲ���ľ�̬������"+Inner.inner_num);
		Inner.inner_outer();
	}
	public void outer_2(){
		System.out.println("�����ⲿ��ķǾ�̬����");
		System.out.println("�����ڲ���ľ�̬����");
		System.out.println("--------------------");
		System.out.println("�ڲ���ľ�̬������"+Inner.inner_num);
		Inner.inner_outer();
	}
	static class Inner{
		static int inner_num=100;
		int inner_count=200;
		
		static void inner_outer(){
			System.out.println("�����ڲ���ľ�̬����");
			System.out.println();
			System.out.println("******************************************");
			System.out.println();
		}
		static void inner_outer_1(){
			System.out.println("�����ڲ���ľ�̬����");
			System.out.println("�����ⲿ��ľ�̬����");
			System.out.println("--------------------");
			System.out.println("�ⲿ��ľ�̬������"+num);
			outer();    //�����ⲿ��ľ�̬����
		}
		void inner_outer_2(){
			System.out.println("���Ǿ�̬�ڲ���ķǾ�̬����");
			System.out.println("�����ⲿ��ľ�̬����");
			System.out.println("--------------------");
			System.out.println("�ⲿ��ľ�̬������"+num);
			outer();    //�����ⲿ��ľ�̬����
		}
	}
	
	public static void main(String[]args){
		//java���������
		TextStaticInnerClass inner=new TextStaticInnerClass();
		inner.outer_1();    //���÷���
		inner.outer_2();
		TextStaticInnerClass.Inner inn=new TextStaticInnerClass.Inner();
		inn.inner_outer_1();
		inn.inner_outer_2();
		

	}
}