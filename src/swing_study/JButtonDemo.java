package swing_study;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonDemo extends JFrame{
	public static void main(String[]args){
		JButtonDemo frame=new JButtonDemo();
		frame.setVisible(true);
	}
	
	public JButtonDemo(){
		setTitle("JButton按钮实例");
		//创建编辑图标对象
		ImageIcon editIcon=new ImageIcon(getClass().getResource("modify.gif"));
		ImageIcon delIcon=new ImageIcon(getClass().getResource("del.gif"));    //创建删除图标对象
		getContentPane().setLayout(new FlowLayout());
		setBounds(100,100,215,74);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JButton okButton=new JButton("编辑",editIcon);
		getContentPane().add(okButton);    //添加按钮到窗体
		final JButton delButton=new JButton();
		delButton.setIcon(delIcon);
		delButton.setText("删除");    //设置按钮文本
		getContentPane().add(delButton);
		
	}
}