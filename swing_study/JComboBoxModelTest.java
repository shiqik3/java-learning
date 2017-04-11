package swing_study;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

class MyComboBox extends AbstractListModel implements ComboBoxModel{
	String selecteditem=null;
	String[] test={"身份证","军人证","学生证","工作证"};
	public Object getElementAt(int index){
		return test[index];
	}
	public int getSize(){
		return test.length;
	}
	public void setSelectedItem(Object item){
		selecteditem=(String)item;
	}
	public Object getSelectedItem(){
		return selecteditem;
	}
	public int getIndex(){
		for(int i=0;i<test.length;i++){
			if(test[i].equals(getSelectedItem())){
				return i;
			}
			break;
		}
		return 0;
	}
}

public class JComboBoxModelTest extends JFrame{
	JComboBox jc=new JComboBox(new MyComboBox());
	JLabel jl=new JLabel("请选择证件：");
	public JComboBoxModelTest(){
		setSize(new Dimension(200,100));
		setVisible(true);
		setTitle("在窗口中设置下拉列表框");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(jl);
		cp.add(jc);
	}
	
	public static void main(String[]args){
		new JComboBoxModelTest();
	}
}




