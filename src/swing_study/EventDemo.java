package swing_study;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EventDemo extends JFrame{
	private JTextField text1;    //第一个文本框
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
		text1=new JTextField();    //创建第一个文本框
		text1.addKeyListener(new TextKeyListerner());
		text1.setBounds(115, 12, 172, 22);
		getContentPane().add(text1);
		text2=new JTextField();
		text2.setBounds(115, 40, 172, 22);
		getContentPane().add(text2);
		final JLabel label=new JLabel();
		label.setText("第一个文本框");
		label.setBounds(10,12,99,18);
		getContentPane().add(label);
		final JLabel label2=new JLabel();
		label2.setText("第二个文本框");
		label2.setBounds(10, 40, 99, 18);
		getContentPane().add(label2);
	}
	
	
	private final class TextKeyListerner implements KeyListener{
		/**
		 * 键盘按下时，执行该方法
		 */
		public void keyPressed(KeyEvent e){
			
		}
		
		/**
		 * 键盘抬起时，执行该方法
		 */
		public void keyReleased(KeyEvent e){
			String text=text1.getText();
			text2.setText(text);
		}
		
		/**
		 * 键盘敲入字符时，执行该方法
		 */
		public void keyTyped(KeyEvent e){
			
		}
	}
}









