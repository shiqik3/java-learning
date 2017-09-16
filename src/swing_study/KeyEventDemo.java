package swing_study;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class KeyEventDemo extends JFrame{
	private JTextField result;
	private int n1=0,n2=0;
	private JLabel num1,num2,message;    //message��ʾ��������Ϣ�ı�ǩ���
	
	public KeyEventDemo(){
		super();
		setTitle("�����¼���ʾ����");
		setBounds(100,100,270,99);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		num1=new JLabel("10");
		num1.setHorizontalAlignment(SwingConstants.RIGHT);
		num1.setBounds(28, 35, 66, 18);
		getContentPane().add(num1);
		final JLabel label_1=new JLabel("+");
		label_1.setBounds(101, 35, 25, 18);
		getContentPane().add(label_1);
		num2=new JLabel("10");
		num2.setBounds(113, 35, 25, 18);
		getContentPane().add(num2);
		final JLabel label_3=new JLabel();
		label_3.setText("=");
		label_3.setBounds(142, 35, 7, 18);
		getContentPane().add(label_3);
		result=new JTextField();    //�������������ı���
		result.addKeyListener(new KeyAdapter(){
			public void keyPressed(final KeyEvent arg0){
				do_result_keyPressed(arg0);
			}
		});
		result.setBounds(152, 33, 56, 22);
		getContentPane().add(result);
		message=new JLabel();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(28, 0, 180, 29);
		getContentPane().add(message);
		this.setVisible(true);
		randomNumber();
	}
	
	protected void do_result_keyPressed(final KeyEvent arg0){
		if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
			String resultStr=result.getText();
			int resultNum=0;
			try{
				resultNum=Integer.parseInt(resultStr);
			}catch(NumberFormatException e1){
				message.setText("���ֻ�����������������롣");
				result.selectAll();    //ȫѡ�ı����ı�
				return;
			}
			if(resultNum==n1+n2){
				message.setText("�ش���ȷ");
				randomNumber();
				result.selectAll();
			}else{
				message.setText("�ش�������´���");
				result.selectAll();
			}
		}
	}
	
	private void randomNumber(){
		n1=(int)(Math.random()*100+1);
		n2=(int)(Math.random()*100+1);
		num1.setText(n1+"");
		num2.setText(n2+"");
	}
	
	public static void main(String[]args){
		new KeyEventDemo();
	}
}


