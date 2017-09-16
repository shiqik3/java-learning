package swing_study;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

class MyListModel extends AbstractListModel{
	private String[]contents={"列表1","列表2","列表3","列表4","列表5","列表6"};
	
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
		setTitle("在这个窗体中使用了列表框");
		setSize(119,150);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new JListTest();
	}
}