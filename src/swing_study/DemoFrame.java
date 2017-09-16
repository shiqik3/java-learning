package swing_study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoFrame extends JFrame{
	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable(){
			//���¼������д�������
			public void run(){
				try{
					DemoFrame frame=new DemoFrame();    //�����������
					frame.setVisible(true);    //���ô���ɼ�
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			//
		});
	}
	/**
	 * ���췽�����÷����ж����˽���ĳ�ʼ��
	 */
	public DemoFrame(){
		super();
		setBounds(200,200,400,200);    //���ô����С��λ��
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);     //���ô���Ĭ�Ϲرշ���
		final JLabel label=new JLabel();    //����JLablel��ǩ���
		label.setText("һ��JFrame����ʵ��");    //���ñ�ǩ�ı�
		getContentPane().add(label, BorderLayout.CENTER);    //��ӱ�ǩ�������������
	}
}