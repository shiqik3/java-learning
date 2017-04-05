package swing_study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoFrame extends JFrame{
	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable(){
			//在事件队列中创建窗体
			public void run(){
				try{
					DemoFrame frame=new DemoFrame();    //创建窗体对象
					frame.setVisible(true);    //设置窗体可见
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			//
		});
	}
	/**
	 * 构造方法，该方法中定义了界面的初始化
	 */
	public DemoFrame(){
		super();
		setBounds(200,200,400,200);    //设置窗体大小和位置
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);     //设置窗体默认关闭方法
		final JLabel label=new JLabel();    //创建JLablel标签组件
		label.setText("一个JFrame窗体实例");    //设置标签文本
		getContentPane().add(label, BorderLayout.CENTER);    //添加标签组件到窗体容器
	}
}