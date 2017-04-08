package swing_study;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class buttonTest1 extends JFrame{
	public buttonTest1(){
		super();
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		setBounds(100,100,200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JRadioButton c1=new JRadioButton("yes");
		JRadioButton c2=new JRadioButton("no");
		JRadioButton c3=new JRadioButton("cancel");
		this.add(c1);
		this.add(c2);
		this.add("kk", c3);
		setVisible(true);
	}
	public static void main(String[]args){
		new buttonTest1();
	}
}