package swing_study;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

public class Progress extends JFrame{
	private static JProgressBar progressBar;
	public Progress(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		progressBar=new JProgressBar();    //����������
		progressBar.setStringPainted(true);    //��ʾ�����ı�
		getContentPane().add(progressBar, BorderLayout.CENTER);
		setBounds(100,100,300,78);
		final JLabel label=new JLabel();
		getContentPane().add(label, BorderLayout.NORTH);
		label.setText("��Ʒ��������");
		setVisible(true);
	}
	
	public static void main(String[]args){
		new Progress();    //��������
	}
}