package swing_study;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JpanelTest extends JFrame{
	public JpanelTest(){
		Container c=getContentPane();
		c.setLayout(new GridLayout(2,2,10,10));    //设置两行一列的网格布局
		//初始化面板，设置网格布局
		JPanel p1=new JPanel(new GridLayout(1,3,10,10));
		JPanel p2=new JPanel(new GridLayout(1,2,10,10));
		JPanel p3=new JPanel(new GridLayout(1,2,10,10));
		JPanel p4=new JPanel(new GridLayout(2,1,10,10));
		p1.add(new JButton("1"));
		p1.add(new JButton("2"));
		p1.add(new JButton("3"));
		p2.add(new JButton("1"));
		p2.add(new JButton("2"));
		p3.add(new JButton("1"));
		p3.add(new JButton("2"));
		p4.add(new JButton("1"));
		p4.add(new JButton("2"));
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	public static void main(String[]args){
		new JpanelTest();
	}
}