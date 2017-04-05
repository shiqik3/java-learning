package swing_study;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BorderLayoutPosition extends JFrame{
	public BorderLayoutPosition(){
		setTitle("这个窗体使用边界布局管理器");    //设置窗体标题
		getContentPane().setLayout(new BorderLayout());    //设置容器为边界布局管理器
		final JButton button=new JButton();
		button.setText("center button");
		getContentPane().add(button, BorderLayout.CENTER);    //添加位于中间位置的按钮
		final JButton button_1=new JButton();
		button_1.setText("west button");
		getContentPane().add(button_1, BorderLayout.WEST);    //左边
		final JButton button_2=new JButton();
		button_2.setText("west button");
		getContentPane().add(button_2, BorderLayout.EAST);    //右边
		final JButton button_3=new JButton();
		button_3.setText("west button");
		getContentPane().add(button_3, BorderLayout.NORTH);    //上边
		final JButton button_4=new JButton();
		button_4.setText("west button");
		getContentPane().add(button_4, BorderLayout.SOUTH);    //下边
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new BorderLayoutPosition();
	}
}