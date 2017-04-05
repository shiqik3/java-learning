package swing_study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorDemo extends JFrame implements ActionListener{
	//���붯�������ӿ�
	JTextField text_Show;    //�������еĵ�λ
	JPanel pnl,pnl_1,pnl_2,pnl_3;
	JMenuBar menu;
	JTextField text;
	JLabel label;    //label��������ߣ�����������״
	JButton btn_Bk,btn_CE,btn_C;
	JButton btn[];
	JButton btn_MC,btn_MR,btn_MS,btn_MAdd;
	JButton btn_Dot,btn_AddAndSub,btn_Add,btn_Sub,btn_Mul,btn_Div,btn_Mod;
	JButton btn_Sqrt,btn_Dao,btn_Equal;
	DecimalFormat df;    //���������������
	boolean click_Flag;    //���Ƶ�ǰ�ܷ񰴼�
	double memory_data;   //ʵ���ڴ��д洢������
	int memory_int;    //int���ʹ洢����ֻҪ��Int�͵����ݾʹ����
	double middle,result;    //��������double�����ݵ��м�ֵ(middle)�������(result)
	short key=-1,prekey=-1;    //key�������浱ǰ���к������㣬prekey��������ǰ�ν��к�������
	
	public CalculatorDemo(){
		//���캯��
		super("���ʼ�����");
		click_Flag=true;
		result=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image image=getToolkit().getImage("D:/workspace/New/chp07/2.jpg");
		setIconImage(image);
		df=new DecimalFormat("0.##############");    //��������������ȣ�����double��ֵ��
		text_Show=new JTextField(15);
		text_Show.setText(" ");
		text_Show.setHorizontalAlignment(JTextField.RIGHT);
		text_Show.setEditable(false);
		text_Show.setBackground(Color.white);
		pnl=new JPanel();
		this.getContentPane().add(pnl);
		pnl_1=new JPanel();
		pnl_2=new JPanel();
		pnl.setLayout(new BorderLayout());
		menu=new JMenuBar();    //����������
		//���pnlװ����ʾ������ı��������pnl_1
		//���pnl_1��BorderLayout�Ĳ��ַ�ʽװ�����pnl_2�����pnl_3
		pnl.add(menu, BorderLayout.NORTH);
		pnl.add(text_Show,BorderLayout.CENTER);
		pnl.add(pnl_1,BorderLayout.SOUTH);
		pnl_1.setLayout(new BorderLayout());
		text=new JTextField(5);
		text.setEditable(false);
		text.setBackground(new Color(220,220,220));
		label=new JLabel(" ");
		btn_Bk=new JButton("Backspace");
		btn_Bk.setForeground(Color.red);
		btn_CE=new JButton("CE");
		btn_CE.setForeground(Color.RED);
		btn_C=new JButton("C");
		btn_C.setForeground(Color.RED);
		btn_Bk.addActionListener(this);
		btn_CE.addActionListener(this);
		btn_C.addActionListener(this);
		pnl_1.add(pnl_2, BorderLayout.NORTH);
		//���pnl_2װ����ʾ�ڴ����ݵ��ı�����Backspace��CE��C������ť
		pnl_2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnl_2.add(text);
		pnl_2.add(label);
		pnl_2.add(btn_Bk);
		pnl_2.add(btn_CE);
		pnl_2.add(btn_C);
		pnl_3=new JPanel();
		pnl_1.add(pnl_3,BorderLayout.CENTER);
		btn=new JButton[10];    //������ʾ0~9�����ְ�ť
		for(int i=0;i<btn.length;i++){
			btn[i]=new JButton(Integer.toString(i));
			btn[i].setForeground(Color.BLUE);    //��ť�ϵ�������ɫΪ��ɫ
		}
		btn_MC=new JButton("MC");
		btn_MC.setForeground(Color.red);
		btn_MR=new JButton("MR");
		btn_MR.setForeground(Color.RED);
		btn_MS=new JButton("MS");
		btn_MS.setForeground(Color.RED);
		btn_MAdd=new JButton("M+");
		btn_MAdd.setForeground(Color.RED);
		btn_Dot=new JButton(".");
		btn_Dot.setForeground(Color.blue);
		btn_AddAndSub=new JButton("+/-");
		btn_AddAndSub.setForeground(Color.blue);
		btn_Add=new JButton("+");
		btn_Add.setForeground(Color.RED);
		btn_Sub=new JButton("-");
		btn_Sub.setForeground(Color.RED);
		btn_Mul=new JButton("*");
		btn_Mul.setForeground(Color.RED);
		btn_Div=new JButton("/");
		btn_Div.setForeground(Color.RED);
		btn_Mod=new JButton("%");
		btn_Mod.setForeground(Color.RED);
		btn_Sqrt=new JButton("sqrt");
		btn_Sqrt.setForeground(Color.RED);
		btn_Dao=new JButton("1/x");
		btn_Dao.setForeground(Color.RED);
		btn_Equal=new JButton("=");
		btn_Equal.setForeground(Color.RED);
		//���pnl_3װ������İ�ť
		pnl_3.setLayout(new GridLayout(4,6));    //����һ��4��6�е�GridLayout���ַ�ʽ
		//����Ӧ��button��������ַ�ʽ���ص����pnl_3��
		//�����е�button���ע��ʵ������
		pnl_3.add(btn_MC);
		btn_MC.addActionListener(this);
		pnl_3.add(btn[7]);
		btn[7].addActionListener(this);
		pnl_3.add(btn[8]);
		btn[8].addActionListener(this);
		pnl_3.add(btn[9]);
		btn[9].addActionListener(this);
		pnl_3.add(btn_Div);
		btn_Div.addActionListener(this);
		pnl_3.add(btn_Sqrt);
		btn_Sqrt.addActionListener(this);
		pnl_3.add(btn_MR);
		btn_MR.addActionListener(this);
		pnl_3.add(btn[4]);
		btn[4].addActionListener(this);
		pnl_3.add(btn[5]);
		btn[5].addActionListener(this);
		pnl_3.add(btn[6]);
		btn[6].addActionListener(this);
		pnl_3.add(btn_Mul);
		btn_Mul.addActionListener(this);
		pnl_3.add(btn_Mod);
		btn_Mod.addActionListener(this);
		pnl_3.add(btn_MS);
		btn_MS.addActionListener(this);
		pnl_3.add(btn[1]);
		btn[1].addActionListener(this);
		pnl_3.add(btn[2]);
		btn[2].addActionListener(this);
		pnl_3.add(btn[3]);
		btn[3].addActionListener(this);
		pnl_3.add(btn_Sub);
		btn_Sub.addActionListener(this);
		pnl_3.add(btn_Dao);
		btn_Dao.addActionListener(this);
		pnl_3.add(btn_MAdd);
		btn_MAdd.addActionListener(this);
		pnl_3.add(btn[0]);
		btn[0].addActionListener(this);
		pnl_3.add(btn_AddAndSub);
		btn_AddAndSub.addActionListener(this);
		pnl_3.add(btn_Dot);
		btn_Dot.addActionListener(this);
		pnl_3.add(btn_Add);
		btn_Add.addActionListener(this);
		pnl_3.add(btn_Equal);
		btn_Equal.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();    //�Զ��������ڵĴ�С���ʺ�������������������Ĳ���
		setVisible(true);
	}
	
	public static void main(String[]args){
		new CalculatorDemo();
	}

	public void actionPerformed(ActionEvent event) {
		boolean sign=false;    //�ж��Ƿ���double�����������㣬��Ϊtrue������Ϊfalse
		Object temp=event.getSource();
		try{
			//����������ݰ�ť�������µİ�ť���������׷�ӵ���ǰ�ı����ַ���֮��
			for(int i=0;i<=9;i++){
				if(temp==btn[i]&&click_Flag==true){
					text_Show.setText(text_Show.getText()+Integer.toString(i));
					//����"."��ťʱ���жϵ�ǰ�ı������ַ����ں�����".",����Ѿ����У��������ٲ���"."
				}
			}
			//forѭ������
			if(temp==btn_Dot&&click_Flag==true){
				boolean isInclude=false;
				
				if(text_Show.getText().length()==0){
					isInclude=false;
					//if�жϽ���
				}
				
				for(int i=0;i<text_Show.getText().length();i++){
					if('.'==text_Show.getText().charAt(i)){
						isInclude=true;
						break;
					}
					//forѭ������
				}
				
				if(isInclude==false){
					text_Show.setText(text_Show.getText()+".");
				}
				
			}
			//if����
			if((temp==btn_Add||temp==btn_Sub||temp==btn_Mul||temp==btn_Div)&&click_Flag==true){
				//"+"����
				if(temp==btn_Add){
					switch(prekey){
					case 0:
						result+=Double.parseDouble(text_Show.getText());
						break;
					case 1:
						result-=Double.parseDouble(text_Show.getText());
						break;
					case 2:
						result*=Double.parseDouble(text_Show.getText());
						break;
					case 3:
						if(Double.parseDouble(text_Show.getText())==0){
							//text_Show="aa";
							text_Show.setText("��������Ϊ��");
							click_Flag=false;
						}else{
							result/=Double.parseDouble(text_Show.getText());
							break;
						}
					default:
						result=Double.parseDouble(text_Show.getText());
					}
					//switch����
					text_Show.setText(" ");
					prekey=key=0;
				}
				//"-"����
				if(temp==btn_Sub){
					switch(prekey){
					case 0:
						result+=Double.parseDouble(text_Show.getText());
						break;
					case 1:
						result-=Double.parseDouble(text_Show.getText());
						break;
					case 2:
						result*=Double.parseDouble(text_Show.getText());
						break;
					case 3:
						if(Double.parseDouble(text_Show.getText())==0){
							text_Show.setText("��������Ϊ��");
							click_Flag=false;
						}else{
							result/=Double.parseDouble(text_Show.getText());
							break;
						}
					default:
						result=Double.parseDouble(text_Show.getText());
					}
					}
				}
			}
		}
		
	}
	
	
	
}






















