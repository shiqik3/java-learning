package swing_study;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FlowLayoutPosition extends JFrame{
	public FlowLayoutPosition(){
		setTitle("本窗体实用流布局管理器");   //设置窗体标题
		setSize(300,300);    //设置窗体大小
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container c=getContentPane();
		//设置窗体流式布局，组件左对齐，组件之间水平间隔与垂直间隔
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		for(int i=0;i<10;i++){
			//在容器中循环添加10个按钮
			c.add(new JButton("button"+i));
		}
		setVisible(true);    //显示窗体
	}
	
	public static void main(String[]args){
		new FlowLayoutPosition();
	}
}













