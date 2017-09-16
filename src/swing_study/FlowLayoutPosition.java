package swing_study;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FlowLayoutPosition extends JFrame{
	public FlowLayoutPosition(){
		setTitle("������ʵ�������ֹ�����");   //���ô������
		setSize(300,300);    //���ô����С
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container c=getContentPane();
		//���ô�����ʽ���֣��������룬���֮��ˮƽ����봹ֱ���
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		for(int i=0;i<10;i++){
			//��������ѭ�����10����ť
			c.add(new JButton("button"+i));
		}
		setVisible(true);    //��ʾ����
	}
	
	public static void main(String[]args){
		new FlowLayoutPosition();
	}
}













