package swing_study;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JScrollPaneTest extends JFrame{
	public JScrollPaneTest(){
		Container c=getContentPane();    //��������
		JTextArea ta=new JTextArea(20,50);    //�����ı��������
		JScrollPane sp=new JScrollPane(ta);    //����JScrollPanemain�����
		c.add(sp);
		setTitle("�����������ַ�����");
		this.setLocation(500, 300);
		setSize(200,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new JScrollPaneTest();
	}
}