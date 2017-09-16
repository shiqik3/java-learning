package educat_java;

interface Tour{
	//������
	public void visit();    //���η���
}

interface Visit{
	//�������η���
	public Tour visitStyle();
}

class GoAbroad implements Tour{
	//��������
	public void visit(){
		//ʵ�ֽӿڵķ���
		System.out.println("����ȥ�������ΰɣ�");
	}
}

class Hangzhou implements Tour{
	//��������
	public void visit(){
		System.out.println("���ݷ羰��������ȥ�����");
	}
}

class Home implements Tour{
	//�ڼ�
	public void visit(){
		System.out.println("����û��Ǯ����Ҳȥ���ˣ�");
	}
}

class GoAbroadVisit implements Visit{
	//���س������ζ���
	public Tour visitStyle(){
		return new GoAbroad();
	}
}

class HangzhouVisit implements Visit{
	//���غ������ζ���
	public Tour visitStyle(){
		return new Hangzhou();
	}
}

class HomeVisit implements Visit{
	//�����ڼҶ���
	public Tour visitStyle(){
		return new Home();
	}
}

public class TextMethodFactory{
	//������������ģʽ����
	public static void main(String[]args){
		//java���������
		try{
			Visit visit=new HangzhouVisit();    //�ӿڱ�������ʵ�������
			Tour tour=visit.visitStyle();    //���÷�����������ʵ��
			System.out.println("��������ȥ��������ѽ��");
			tour.visit();    //���÷���������η�ʽ
		}
		catch(Exception e)
		{
			//�����쳣
			System.out.println("�������μƻ�ȡ����");
		}
		finally
		{
			//�����ܱ�ִ��
			System.out.println("......");
		}
	}
}




















