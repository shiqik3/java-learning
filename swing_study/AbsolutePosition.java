package swing_study;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class AbsolutePosition extends JFrame{
	public AbsolutePosition(){
		setTitle("������ʹ�þ��Բ���");    //���øô���ı���
		this.setLayout(null);    //ʹ�øô���ȡ�����ֹ���������
		setBounds(0,0,200,200);    //���Զ�λ�����λ�����С
		JButton b1=new JButton("��ť1");    //������ť
		JButton b2=new JButton("��ť2");    //������ť
		b1.setBounds(10,30,80,30);    //���ð�ť��λ�����С
		b2.setBounds(60,70,100,20);
		this.add(b1);    //����ť��ӵ�������
		this.add(b2);
		setVisible(true);    //ʹ�ô���ɼ�
		//���ô���رշ�ʽ
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args){
		new AbsolutePosition();
	}
}