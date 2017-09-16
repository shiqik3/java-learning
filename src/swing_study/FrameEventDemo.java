package swing_study;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FrameEventDemo extends JFrame{
	public static void main(String[]args){
		FrameEventDemo frame=new FrameEventDemo();    //��������
		frame.setVisible(true);    //��ʾ����
		
	}
	
	public FrameEventDemo(){
		super();
		addWindowListener(new WindowListener(){
			//��Ӵ����ʱ�������
			public void windowActivated(final WindowEvent e){
				System.out.println("�״̬");
			}
			public void windowClosed(WindowEvent e){
				System.out.println("�ѹر�");
				System.exit(0);
			}
			public void windowClosing(WindowEvent e){
				System.out.println("���ڹر�");
			}
			public void windowDeactivated(WindowEvent e){
				System.out.println("�ǻ״̬");
			}
			public void windowDeiconified(WindowEvent e){
				System.out.println("������С��");
			}
			public void windowIconified(WindowEvent e){
				System.out.println("��С��");
			}
			public void windowOpened(WindowEvent e){
				System.out.println("��״̬");
			}
		});
		
		setBounds(100,100,500,375);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	
}











