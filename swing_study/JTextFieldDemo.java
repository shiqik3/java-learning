package swing_study;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JTextFieldDemo extends JFrame{
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;
	Panel panel=new Panel();
	Panel panel_1=new Panel();
	Panel panel_2=new Panel();
	Panel panel_3=new Panel();
	public JTextFieldDemo(){
		super();
		final FlowLayout flowLayout_4=new FlowLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		getContentPane().setLayout(new GridLayout(4,1));
		setTitle("文本框演示程序");
		setBounds(100,100,412,166);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(new JLabel("姓名："));
		textField=new JTextField();
		panel.add(textField);
		panel.setLayout(flowLayout_4);
		panel_1.add(new JLabel("性别:"));
		textField_1=new JTextField(4);
		panel_1.add(textField_1);
		panel_2.add(new JLabel("年龄"));
		textField_2=new JTextField("哈哈");
		panel_2.add(textField_2);
		panel_3.add(new JLabel("地址："));
		textField_3=new JTextField("长",12);
		panel_3.add(textField_3);
		this.add(panel);
		this.add(panel_1);
		this.add(panel_2);
		this.add(panel_3);
		setVisible(true);
	}
	
	public static void main(String[]args){
		new JTextFieldDemo();
	}
}









