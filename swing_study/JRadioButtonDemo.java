package swing_study;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JRadioButtonDemo extends JFrame{
	public JRadioButtonDemo(){
		super();
		ButtonGroup group=new ButtonGroup();
		getContentPane().setLayout(new GridLayout(1,0));
		setBounds(100,100,230,87);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JRadioButton radioButton=new JRadioButton();    //创建普通单选按钮
		radioButton.setText("NICE");
		getContentPane().add(radioButton);
		JRadioButton radioButton_1=new JRadioButton("YES");
		group.add(radioButton_1);
		getContentPane().add(radioButton_1);
		JRadioButton radioButton_2=new JRadioButton("NO",true);
		group.add(radioButton_2);
		getContentPane().add(radioButton_2);
		setVisible(true);
	}
	
	public static void main(String[]args){
		JRadioButtonDemo frame=new JRadioButtonDemo();
		frame.setVisible(true);
	}
}