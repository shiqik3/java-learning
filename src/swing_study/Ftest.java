package swing_study;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Ftest extends JFrame{
	//创建类，继承JFrame类
	private static final long serialVersionUID=1L;
	private JPanel jContentPane=null;    //创建面板对象
	private JTextArea jTextArea=null;    //创建文本域对象
	private JPanel controlPanel=null;    //创建面板对象
	private JButton openButton=null;    //创建按钮对象
	private JButton closeButton=null;    //创建按钮对象
	public void Ftest(){
		this.layout();
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[]args){
		//java程序主方法
		Ftest thisClass=new Ftest();    //创建本类对象
		thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisClass.setVisible(true);    //设置该窗体为显示状态
	}
}