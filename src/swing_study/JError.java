package swing_study;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JError extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JError(){
		final GridLayout gridLayout=new GridLayout(0,3,2,2);
		getContentPane().setLayout(gridLayout);    //���ò��ֹ�����
		setTitle("����һ��ʹ�����񲼾ֹ������Ĵ���");    //���ô������
		final JButton button_1=new JButton();
		button_1.setText("��ť1");
		getContentPane().add(button_1);
		final JButton button_2=new JButton();
		button_2.setText("��ť2");
		getContentPane().add(button_2);
		final JButton button_3=new JButton();
		button_3.setText("��ť3");
		getContentPane().add(button_3);
		final JButton button_4=new JButton();
		button_4.setText("��ť4");
		getContentPane().add(button_4);
		final JButton button_5=new JButton();
		button_5.setText("��ť5");
		getContentPane().add(button_5);
		final JButton button_6=new JButton();
		button_6.setText("��ť6");
		getContentPane().add(button_6);
		final JButton button_7=new JButton();
		button_7.setText("��ť7");
		getContentPane().add(button_7);
		
		this.setBounds(100, 100, 300, 150);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new JError();
	}
}