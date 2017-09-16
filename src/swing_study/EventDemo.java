package swing_study;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventDemo extends JFrame{
	private JTextField text1;    //��һ���ı���
	private JTextField text2;
	public static void main(String[]args){
		EventDemo frame=new EventDemo();
		frame.setVisible(true);
	}
	public EventDemo(){
		super();
		getContentPane().setLayout(null);
		setBounds(100,100,305,113);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text1=new JTextField();    //������һ���ı���
		text1.addKeyListener(new TextKeyListerner());
		text1.setBounds(115, 12, 172, 22);
		getContentPane().add(text1);
		text2=new JTextField();
		text2.setBounds(115, 40, 172, 22);
		getContentPane().add(text2);
		final JLabel label=new JLabel();
		label.setText("��һ���ı���");
		label.setBounds(10,12,99,18);
		getContentPane().add(label);
		final JLabel label2=new JLabel();
		label2.setText("�ڶ����ı���");
		label2.setBounds(10, 40, 99, 18);
		getContentPane().add(label2);
	}
	
	
	private final class TextKeyListerner implements KeyListener{
		/**
		 * ���̰���ʱ��ִ�и÷���
		 */
		public void keyPressed(KeyEvent e){
			
		}
		
		/**
		 * ����̧��ʱ��ִ�и÷���
		 */
		public void keyReleased(KeyEvent e){
			String text=text1.getText();
			text2.setText(text);
		}
		
		/**
		 * ���������ַ�ʱ��ִ�и÷���
		 */
		public void keyTyped(KeyEvent e){
			
		}
	}
}









