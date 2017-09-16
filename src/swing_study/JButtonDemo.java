package swing_study;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonDemo extends JFrame{
	public static void main(String[]args){
		JButtonDemo frame=new JButtonDemo();
		frame.setVisible(true);
	}
	
	public JButtonDemo(){
		setTitle("JButton��ťʵ��");
		//�����༭ͼ�����
		ImageIcon editIcon=new ImageIcon(getClass().getResource("modify.gif"));
		ImageIcon delIcon=new ImageIcon(getClass().getResource("del.gif"));    //����ɾ��ͼ�����
		getContentPane().setLayout(new FlowLayout());
		setBounds(100,100,215,74);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JButton okButton=new JButton("�༭",editIcon);
		getContentPane().add(okButton);    //��Ӱ�ť������
		final JButton delButton=new JButton();
		delButton.setIcon(delIcon);
		delButton.setText("ɾ��");    //���ð�ť�ı�
		getContentPane().add(delButton);
		
	}
}