package swing_study;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaDemo extends JFrame{
	private JTextArea textArea;
	
	public JTextAreaDemo(){
		super();
		final BorderLayout borderLaout=new BorderLayout();
		getContentPane().setLayout(borderLaout);
		this.setBounds(100,100,231,190);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JLabel label=new JLabel("请输入你的喜好：");
		getContentPane().add(label,BorderLayout.NORTH);
		final JScrollPane scrollPane=new JScrollPane();
		textArea=new JTextArea("\nlalalalla\n");
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		final JPanel panel=new JPanel();
		final FlowLayout flowLayout=new FlowLayout(FlowLayout.CENTER,20,2);
		panel.setLayout(flowLayout);
		getContentPane().add(panel,BorderLayout.SOUTH);
		panel.add(new JButton("提交"));
		panel.add(new JButton("关闭"));
		this.setVisible(true);
	}
	
	public static void main(String[]args){
		new JTextAreaDemo();
	}
}








