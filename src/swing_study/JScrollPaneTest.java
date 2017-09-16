package swing_study;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JScrollPaneTest extends JFrame{
	public JScrollPaneTest(){
		Container c=getContentPane();    //创建容器
		JTextArea ta=new JTextArea(20,50);    //创建文本区域组件
		JScrollPane sp=new JScrollPane(ta);    //创建JScrollPanemain版对象
		c.add(sp);
		setTitle("滚动条的文字翻译器");
		this.setLocation(500, 300);
		setSize(200,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new JScrollPaneTest();
	}
}