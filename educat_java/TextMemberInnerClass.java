package educat_java;


class OuterClass{
	String outer="outerclass";
	private int number=1;
	private static int count=10;
	
	public OuterClass(){}//Ĭ�Ϲ��췽��
	public OuterClass(int number,int count){
		//�������Ĺ��췽��
				this.number=number;
				this.count=count;
				System.out.println("��������ֱ�Ϊ��"+this.number+"��"+this.count);
	}
	private void outer_1(){
		//�ⲿ�Ǿ�̬����
		System.out.println("�����ⲿ��ķǾ�̬����");
		//InnerClass inner=this.new InnerClass();
	}
	private static void outer_2(){
		//�ⲿ��ľ�̬����
		System.out.println("�����ⲿ��ľ�̬����");
		//InnerClass inner=this.new InnerClass();
	}
	
	class InnerClass{
		//�����Ա�ڲ���
		String outer="innerclass";
		public InnerClass(){
			//Ĭ�Ϲ��췽��
			System.out.println("��Ա�ڲ���Ĺ��췽��");
		}
		protected void communicate(){
			//�����ķ���
			System.out.println("�ⲿ����ַ�����"+OuterClass.this.outer);
			System.out.println("�ڲ�����ַ�����"+this.outer);
		}
		protected void inner_1(){
			//��Ա�ڲ���ķǾ�̬����
			System.out.println("�����ⲿ���˽�з���");
			outer_1();
			outer_2();
		}
	}
}



public class TextMemberInnerClass{
	//������Ա�ڲ������
	public static void main(String[]args){
		//java���������
		OuterClass outer=new OuterClass(10,20);    //ʵ��������
		OuterClass.InnerClass inner=outer.new InnerClass();    //ʵ������Ա�ڲ���
		System.out.println("OuterClass="+outer.outer);
		System.out.println("InnerClass="+inner.outer);
		inner.communicate();    //���÷���
		inner.inner_1();
	}
}


























