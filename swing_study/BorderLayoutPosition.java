package swing_study;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BorderLayoutPosition extends JFrame{
	public BorderLayoutPosition(){
		setTitle("�������ʹ�ñ߽粼�ֹ�����");    //���ô������
		getContentPane().setLayout(new BorderLayout());    //��������Ϊ�߽粼�ֹ�����
		final JButton button=new JButton();
		button.setText("center button");
		getContentPane().add(button, BorderLayout.CENTER);    //���λ���м�λ�õİ�ť
		final JButton button_1=new JButton();
		button_1.setText("west button");
		getContentPane().add(button_1, BorderLayout.WEST);    //���
		final JButton button_2=new JButton();
		button_2.setText("west button");
		getContentPane().add(button_2, BorderLayout.EAST);    //�ұ�
		final JButton button_3=new JButton();
		button_3.setText("west button");
		getContentPane().add(button_3, BorderLayout.NORTH);    //�ϱ�
		final JButton button_4=new JButton();
		button_4.setText("west button");
		getContentPane().add(button_4, BorderLayout.SOUTH);    //�±�
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new BorderLayoutPosition();
	}
}