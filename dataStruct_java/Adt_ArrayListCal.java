package dataStruct_java;

import java.util.Scanner;

public class Adt_ArrayListCal{
	private Adt_ArrayList2 list1;    //���ڴ�Ų�����
	private Adt_ArrayList2 list2;    //���ڴ�Ų���ָ��
	
	public Adt_ArrayListCal(){
		list1=new Adt_ArrayList2();
		list2=new Adt_ArrayList2();
	}
	private String[] CalInput(){
		//��׺���ʽ���뺯����ÿ����ֵ�����֮����" "���ո����
		String[] str;
		Scanner scan=new Scanner(System.in);
		String input=scan.nextLine();
		str=input.split(" ");
		return str;
	}
	private void CalCulate(String[] str){
		//��׺���ʽ���㺯��
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" ");
			if(i%2==0){
				list1.push(str[i]);
			}else if(i>1){
				//��������
				CharOperate co1=equal((String) list2.pop());
				while(equal(str[i]).smaller(co1)){
					String b=(String) list1.pop();
					String a=(String) list1.pop();
					String c=co1.theOperate;
					list1.push(Operate(a,b,c));    //��������
					if(list2.size()>0)
					{
						co1=equal((String) list2.pop());
					}else{
						co1=null;
						break;
					}
				}
				if(co1!=null){
					list2.push(co1.theOperate);
				}
				list2.push(str[i]);
			}else{
				list2.push(str[i]);
			}
		}
		list1.display();
	}
	private void CalOperate(String[] str){
		//��׺���׺���沨�����ʽ
		for(int i=0;i<str.length;i++){
			System.out.print(str[i]+" ");
			if(i%2==0){
				list1.push(str[i]);
			}else if(i>1){
				//��������
				CharOperate co1=equal((String) list2.pop());
				while(equal(str[i]).smaller(co1)){
					String b=(String) list1.pop();
					String a=(String) list1.pop();
					String c=co1.theOperate;
					list1.push(Operate2(a,b,c));
					if(list2.size()>0)
					{
						co1=equal((String) list2.pop());
					}else{
						co1=null;
						break;
					}
				}
				if(co1!=null){
					list2.push(co1.theOperate);
				}
				list2.push(str[i]);
			}else{
				list2.push(str[i]);
			}
		}
		list1.display();
	}
	private CharOperate equal(String x){
		//������ʶ����
		switch(x){
		case "+":
			return new CharOperate("+",1);
		case "-":
			return new CharOperate("-",1);
		case "*":
			return new CharOperate("*",2);
		case "/":
			return new CharOperate("/",2);
		default:
			return new CharOperate("=",0);
		}
	}
	private String Operate(String a,String b,String c){
		//���㺯��
		int ac,bc;
		try{
			ac=Integer.parseInt(a);
			bc=Integer.parseInt(b);
		}catch(Exception e){
			ac=0;
			bc=0;
			System.out.println("�ַ���ת��ʧ��");
		}
		switch(c){
		case "+":
			return new Integer(ac+bc).toString();
		case "-":
			return new Integer(ac-bc).toString();
		case "*":
			return new Integer(ac*bc).toString();
		case "/":
			return new Integer(ac/bc).toString();
		default:
			return new Integer(0).toString();
		}
	}
	private String Operate2(String a,String b,String c){
		//�ϳ��沨�����ʽ����
		return new String(a+b+c);
	}
	class CharOperate{
		//����ָ����������
		private String theOperate;    //�������ķ�������
		private int theWeight;    //��������Ȩ��
		
		public CharOperate(){
			doDefault();
		}
		public CharOperate(String o,int w){
			doDefault(o,w);
		}
		private void doDefault(){
			//Ĭ��Ϊ�ӷ�
			theOperate="+";
			theWeight=1;
		}
		private void doDefault(String o,int w){
			theOperate=o;
			theWeight=w;
		}
		private boolean smaller(CharOperate c){
			if(this.theWeight<=c.theWeight){
				return true;
			}else{
				return false;
			}
		}
	}
	
	class Adt_ArrayList2<AnyType>{
		//����������Ҫ��Adtջ��
		private static final int DEFAULT_CAPACITY=10;
		private int theSize;
		private int aPointer;
		private AnyType[]theItems;
		
		public Adt_ArrayList2(){
			doClear();
		}
		public void clear(){
			doClear();
		}
		private void doClear(){
			theSize=0;
			aPointer=-1;
			ensureCapacity(DEFAULT_CAPACITY);
		}
		public int size(){
			return theSize;
		}
		public boolean isEmpty(){
			return size()==0;
		}
		public void trimToSize(){
			ensureCapacity(size());
		}
		public AnyType get(int idx){
			if(idx<0||idx>=size()){
				throw new ArrayIndexOutOfBoundsException();
			}
			return theItems[idx];
		}
		private void ensureCapacity(int newCapacity){
			if(newCapacity<theSize){
				return;
			}
			AnyType[]old=theItems;
			theItems=(AnyType[])new Object[newCapacity];
			for(int i=0;i<size();i++){
				theItems[i]=old[i];
			}
		}
		public boolean push(AnyType x){
			push(size(),x);
			return true;
		}
		private void push(int idx,AnyType x){
			if(theItems.length==size()){
				ensureCapacity(size()*2+1);
			}
			for(int i=theSize;i>idx;i--){
				theItems[i]=theItems[i-1];
			}
			theItems[idx]=x;
			theSize++;
			aPointer++;
		}
		public AnyType pop(){
			return pop(size()-1);
		}
		private AnyType pop(int idx){
			AnyType removedItem=theItems[idx];
			for(int i=idx;i<size();i++){
				theItems[i]=theItems[i+1];
			}
			theSize--;
			aPointer--;
			return removedItem;
		}
		public void display(){
			for(int i=0;i<size();i++){
				System.out.print(theItems[i]+" ");
				if((i+1)%10==0){
					System.out.println();
				}
			}
		}

	}
	
	
	public static void main(String[]args){
		//java���������
		Adt_ArrayListCal list=new Adt_ArrayListCal();
		//list.CalCulate(list.CalInput());
		//System.out.println();
		list.CalOperate(list.CalInput());
	}
}