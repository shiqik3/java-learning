//package swing_study;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.Frame;
//import java.awt.GridLayout;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.DecimalFormat;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenuBar;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//public class CalculatorDemo extends JFrame implements ActionListener{
//	//导入动作监听接口
//	JTextField text_Show;    //设计面板中的单位
//	JPanel pnl,pnl_1,pnl_2,pnl_3;
//	JMenuBar menu;
//	JTextField text;
//	JLabel label;    //label单纯左白蛇，控制面板的形状
//	JButton btn_Bk,btn_CE,btn_C;
//	JButton btn[];
//	JButton btn_MC,btn_MR,btn_MS,btn_MAdd;
//	JButton btn_Dot,btn_AddAndSub,btn_Add,btn_Sub,btn_Mul,btn_Div,btn_Mod;
//	JButton btn_Sqrt,btn_Dao,btn_Equal;
//	DecimalFormat df;    //设置数据输出精度
//	boolean click_Flag;    //控制当前能否按键
//	double memory_data;   //实用内存中存储的数字
//	int memory_int;    //int类型存储器，只要是Int型的数据就存进来
//	double middle,result;    //用来保存double型数据的中间值(middle)和最后结果(result)
//	short key=-1,prekey=-1;    //key用来保存当前进行何种运算，prekey用来保存前次进行何种运算
//	
//	public CalculatorDemo(){
//		//构造函数
//		super("资质计算器");
//		click_Flag=true;
//		result=0;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Image image=getToolkit().getImage("D:/workspace/New/chp07/2.jpg");
//		setIconImage(image);
//		df=new DecimalFormat("0.##############");    //设置数据输出精度（对于double型值）
//		text_Show=new JTextField(15);
//		text_Show.setText(" ");
//		text_Show.setHorizontalAlignment(JTextField.RIGHT);
//		text_Show.setEditable(false);
//		text_Show.setBackground(Color.white);
//		pnl=new JPanel();
//		this.getContentPane().add(pnl);
//		pnl_1=new JPanel();
//		pnl_2=new JPanel();
//		pnl.setLayout(new BorderLayout());
//		menu=new JMenuBar();    //设计整个面板
//		//面板pnl装在显示结果的文本区和面板pnl_1
//		//面板pnl_1按BorderLayout的布局方式装在面板pnl_2和面板pnl_3
//		pnl.add(menu, BorderLayout.NORTH);
//		pnl.add(text_Show,BorderLayout.CENTER);
//		pnl.add(pnl_1,BorderLayout.SOUTH);
//		pnl_1.setLayout(new BorderLayout());
//		text=new JTextField(5);
//		text.setEditable(false);
//		text.setBackground(new Color(220,220,220));
//		label=new JLabel(" ");
//		btn_Bk=new JButton("Backspace");
//		btn_Bk.setForeground(Color.red);
//		btn_CE=new JButton("CE");
//		btn_CE.setForeground(Color.RED);
//		btn_C=new JButton("C");
//		btn_C.setForeground(Color.RED);
//		btn_Bk.addActionListener(this);
//		btn_CE.addActionListener(this);
//		btn_C.addActionListener(this);
//		pnl_1.add(pnl_2, BorderLayout.NORTH);
//		//面板pnl_2装载显示内存数据的文本区和Backspace、CE、C三个按钮
//		pnl_2.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		pnl_2.add(text);
//		pnl_2.add(label);
//		pnl_2.add(btn_Bk);
//		pnl_2.add(btn_CE);
//		pnl_2.add(btn_C);
//		pnl_3=new JPanel();
//		pnl_1.add(pnl_3,BorderLayout.CENTER);
//		btn=new JButton[10];    //创建表示0~9的数字按钮
//		for(int i=0;i<btn.length;i++){
//			btn[i]=new JButton(Integer.toString(i));
//			btn[i].setForeground(Color.BLUE);    //按钮上的字体颜色为蓝色
//		}
//		btn_MC=new JButton("MC");
//		btn_MC.setForeground(Color.red);
//		btn_MR=new JButton("MR");
//		btn_MR.setForeground(Color.RED);
//		btn_MS=new JButton("MS");
//		btn_MS.setForeground(Color.RED);
//		btn_MAdd=new JButton("M+");
//		btn_MAdd.setForeground(Color.RED);
//		btn_Dot=new JButton(".");
//		btn_Dot.setForeground(Color.blue);
//		btn_AddAndSub=new JButton("+/-");
//		btn_AddAndSub.setForeground(Color.blue);
//		btn_Add=new JButton("+");
//		btn_Add.setForeground(Color.RED);
//		btn_Sub=new JButton("-");
//		btn_Sub.setForeground(Color.RED);
//		btn_Mul=new JButton("*");
//		btn_Mul.setForeground(Color.RED);
//		btn_Div=new JButton("/");
//		btn_Div.setForeground(Color.RED);
//		btn_Mod=new JButton("%");
//		btn_Mod.setForeground(Color.RED);
//		btn_Sqrt=new JButton("sqrt");
//		btn_Sqrt.setForeground(Color.RED);
//		btn_Dao=new JButton("1/x");
//		btn_Dao.setForeground(Color.RED);
//		btn_Equal=new JButton("=");
//		btn_Equal.setForeground(Color.RED);
//		//面板pnl_3装载其余的按钮
//		pnl_3.setLayout(new GridLayout(4,6));    //创建一个4行6列的GridLayout布局方式
//		//将相应的button组件按布局方式加载到面板pnl_3中
//		//将所有的button组件注册实践侦听
//		pnl_3.add(btn_MC);
//		btn_MC.addActionListener(this);
//		pnl_3.add(btn[7]);
//		btn[7].addActionListener(this);
//		pnl_3.add(btn[8]);
//		btn[8].addActionListener(this);
//		pnl_3.add(btn[9]);
//		btn[9].addActionListener(this);
//		pnl_3.add(btn_Div);
//		btn_Div.addActionListener(this);
//		pnl_3.add(btn_Sqrt);
//		btn_Sqrt.addActionListener(this);
//		pnl_3.add(btn_MR);
//		btn_MR.addActionListener(this);
//		pnl_3.add(btn[4]);
//		btn[4].addActionListener(this);
//		pnl_3.add(btn[5]);
//		btn[5].addActionListener(this);
//		pnl_3.add(btn[6]);
//		btn[6].addActionListener(this);
//		pnl_3.add(btn_Mul);
//		btn_Mul.addActionListener(this);
//		pnl_3.add(btn_Mod);
//		btn_Mod.addActionListener(this);
//		pnl_3.add(btn_MS);
//		btn_MS.addActionListener(this);
//		pnl_3.add(btn[1]);
//		btn[1].addActionListener(this);
//		pnl_3.add(btn[2]);
//		btn[2].addActionListener(this);
//		pnl_3.add(btn[3]);
//		btn[3].addActionListener(this);
//		pnl_3.add(btn_Sub);
//		btn_Sub.addActionListener(this);
//		pnl_3.add(btn_Dao);
//		btn_Dao.addActionListener(this);
//		pnl_3.add(btn_MAdd);
//		btn_MAdd.addActionListener(this);
//		pnl_3.add(btn[0]);
//		btn[0].addActionListener(this);
//		pnl_3.add(btn_AddAndSub);
//		btn_AddAndSub.addActionListener(this);
//		pnl_3.add(btn_Dot);
//		btn_Dot.addActionListener(this);
//		pnl_3.add(btn_Add);
//		btn_Add.addActionListener(this);
//		pnl_3.add(btn_Equal);
//		btn_Equal.addActionListener(this);
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();    //自动调整窗口的大小，适合她所包含的所有组件的布局
//		setVisible(true);
//	}
//	
//	public static void main(String[]args){
//		new CalculatorDemo();
//	}
//
//	public void actionPerformed(ActionEvent event) {
//		boolean sign=false;    //判断是否是double型数参与运算，是为true，不是为false
//		Object temp=event.getSource();
//		try{
//			//如果按下数据按钮，将按下的按钮代表的数据追加到当前文本框字符串之后
//			for(int i=0;i<=9;i++){
//				if(temp==btn[i]&&click_Flag==true){
//					text_Show.setText(text_Show.getText()+Integer.toString(i));
//					//按下"."按钮时，判断当前文本框内字符串内含不含".",如果已经含有，则不允许再插入"."
//				}
//			}
//			//for循环结束
//			if(temp==btn_Dot&&click_Flag==true){
//				boolean isInclude=false;
//				
//				if(text_Show.getText().length()==0){
//					isInclude=false;
//					//if判断结束
//				}
//				
//				for(int i=0;i<text_Show.getText().length();i++){
//					if('.'==text_Show.getText().charAt(i)){
//						isInclude=true;
//						break;
//					}
//					//for循环结束
//				}
//				
//				if(isInclude==false){
//					text_Show.setText(text_Show.getText()+".");
//				}
//				
//			}
//			//if结束
//			if((temp==btn_Add||temp==btn_Sub||temp==btn_Mul||temp==btn_Div)&&click_Flag==true){
//				//"+"操作
//				if(temp==btn_Add){
//					switch(prekey){
//					case 0:
//						result+=Double.parseDouble(text_Show.getText());
//						break;
//					case 1:
//						result-=Double.parseDouble(text_Show.getText());
//						break;
//					case 2:
//						result*=Double.parseDouble(text_Show.getText());
//						break;
//					case 3:
//						if(Double.parseDouble(text_Show.getText())==0){
//							//text_Show="aa";
//							text_Show.setText("除数不能为零");
//							click_Flag=false;
//						}else{
//							result/=Double.parseDouble(text_Show.getText());
//							break;
//						}
//					default:
//						result=Double.parseDouble(text_Show.getText());
//					}
//					//switch结束
//					text_Show.setText(" ");
//					prekey=key=0;
//				}
//				//"-"操作
//				if(temp==btn_Sub){
//					switch(prekey){
//					case 0:
//						result+=Double.parseDouble(text_Show.getText());
//						break;
//					case 1:
//						result-=Double.parseDouble(text_Show.getText());
//						break;
//					case 2:
//						result*=Double.parseDouble(text_Show.getText());
//						break;
//					case 3:
//						if(Double.parseDouble(text_Show.getText())==0){
//							text_Show.setText("除数不能为零");
//							click_Flag=false;
//						}else{
//							result/=Double.parseDouble(text_Show.getText());
//							break;
//						}
//					default:
//						result=Double.parseDouble(text_Show.getText());
//					}
//					}
//				}
//			}
//		}
//		
//	}
//	
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
