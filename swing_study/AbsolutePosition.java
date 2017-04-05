package swing_study;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class AbsolutePosition extends JFrame{
	public AbsolutePosition(){
		setTitle("本窗体使用绝对布局");    //设置该窗体的标题
		this.setLayout(null);    //使得该窗体取消布局管理器设置
		setBounds(0,0,200,200);    //绝对定位窗体的位置与大小
		JButton b1=new JButton("按钮1");    //创建按钮
		JButton b2=new JButton("按钮2");    //创建按钮
		b1.setBounds(10,30,80,30);    //设置按钮的位置与大小
		b2.setBounds(60,70,100,20);
		this.add(b1);    //将按钮添加到容器中
		this.add(b2);
		setVisible(true);    //使得窗体可见
		//设置窗体关闭方式
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new AbsolutePosition();
	}
}