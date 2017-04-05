package educat_java;

class OneSingleton{
	//��һ�ַ�ʽʵ�ֵ���ģʽ
	private static int number=0;    //˽������
	private static OneSingleton instance=new OneSingleton();    //OneSingleton��Ψһʵ��
	
	private OneSingleton(){
		//���캯��˽�з���繹��OneSingletonʵ��
	}
	public static OneSingleton getInstance(){
		//��ȡOneSingleton��ʵ��
		return instance;
	}
	public synchronized int getNumber(){
		//synchronized�ؼ��ֱ�ʾ�������߳�ͬ��
		return number;    //��һʱ�����ֻ����һ���߳̽���÷���
	}
	public synchronized void nextNumber(){
		//��number��1
		number++;
	}
}


class TwoSingleton{
	private static int number=0;    //˽������
	private static TwoSingleton instance=null;    //TwoSingleton��Ψһʵ��
	private TwoSingleton(){
		//���캯��˽�з���繹��TwoSingletonʵ��
	}
	//synchronized�ؼ��ֱ�ʾ�������߳�ͬ��
	public static synchronized TwoSingleton genInstance(){
		//��һʱ�����ֻ����һ���߳̽���÷���
		if(instance==null)
		{
			//�ж��Ƿ�instanceΪ�գ�Ϊ���򴴽�
			instance=new TwoSingleton();
		}
		return instance;
	}
	public synchronized int getNumber(){
		return number;
	}
	public synchronized void nextNumber(){
		number++;
	}
}


public class TextSingleton{
	//��������ģʽ����
	public static void main(String[]args){
		//java���������
		OneSingleton one1=OneSingleton.getInstance();    //���÷������ʵ��
		OneSingleton one2=OneSingleton.getInstance();    //���÷������ʵ����=
		System.out.println("��OneSingletonʵ�ֵ���ģʽ��");
		System.out.println("����nextNumber����ǰ��");
		System.out.println("one1.number="+one1.getNumber());
		System.out.println("one2.number="+one2.getNumber());
		one1.nextNumber();    //���÷���
		System.out.println("����nextnumber������");
		System.out.println("one1.number="+one1.getNumber());
		System.out.println("one2.number="+one2.getNumber());
		
		TwoSingleton two1=TwoSingleton.genInstance();    //���÷������ʵ��
		TwoSingleton two2=TwoSingleton.genInstance();    //���÷������ʵ��
		System.out.println("��TwoSingletonʵ�ֵ���ģʽ��");
		System.out.println("����nextNumber����ǰ��");
		System.out.println("two1.number="+two1.getNumber());
		System.out.println("two2.number="+two2.getNumber());
		two1.nextNumber();    //���÷���
		System.out.println("����nextnumber������");
		System.out.println("two1.number="+two1.getNumber());
		System.out.println("two2.number="+two2.getNumber());
	}
}






