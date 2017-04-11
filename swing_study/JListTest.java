package swing_study;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

class MyListModel extends AbstractListModel{
	private String[]contents={"�б�1","�б�2","�б�3","�б�4","�б�5","�б�6"};
	
	public Object getElementAt(int x){
		if(x<contents.length){
			return contents[x++];
		}else{
			return null;
		}
	}
	public int getSize(){
		return contents.length;
	}
}

public class JListTest extends JFrame{
	public JListTest(){
		Container cp=getContentPane();
		cp.setLayout(new BorderLayout());
		JList jl=new JList(new MyListModel());
		JScrollPane js=new JScrollPane(jl);
		cp.add(js);
		setTitle("�����������ʹ�����б��");
		setSize(119,150);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new JListTest();
	}
}