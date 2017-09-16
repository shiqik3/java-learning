package swing_study;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Progress extends JFrame{
	private static JProgressBar progressBar;
	JTextField text=new JTextField();
	public Progress(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		progressBar=new JProgressBar();    //����������
		progressBar.setStringPainted(true);    //��ʾ�����ı�
		getContentPane().add(progressBar, BorderLayout.CENTER);
		setBounds(100,100,300,110);
		final JLabel label=new JLabel();
		getContentPane().add(label, BorderLayout.NORTH);
		getContentPane().add(text, BorderLayout.SOUTH);
		label.setText("��Ʒ��������");
		setVisible(true);
	}
	
	public static void main(String[]args){
		Progress adx=new Progress();    //��������
		//progressBar.setIndeterminate(true);    //���ý�����Ϊ��ȷ����ʽ
		int sum=0;
		for(int i=0;i<=101;i++){
			try{
				Thread.sleep(100);    //�ǰ��������0.1��
				sum+=i;
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			adx.text.setText(String.valueOf(sum));
			progressBar.setValue(i);    //���ý�������ֵ	
		}
		
		progressBar.setIndeterminate(false);    //���ò���ȷ��������
		progressBar.setString("������ɣ�");    //������ʾ��Ϣ
	}
}