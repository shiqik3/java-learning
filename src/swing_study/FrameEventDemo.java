package swing_study;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FrameEventDemo extends JFrame{
	public static void main(String[]args){
		FrameEventDemo frame=new FrameEventDemo();    //创建窗体
		frame.setVisible(true);    //显示窗体
		
	}
	
	public FrameEventDemo(){
		super();
		addWindowListener(new WindowListener(){
			//添加窗体的时间监听器
			public void windowActivated(final WindowEvent e){
				System.out.println("活动状态");
			}
			public void windowClosed(WindowEvent e){
				System.out.println("已关闭");
				System.exit(0);
			}
			public void windowClosing(WindowEvent e){
				System.out.println("正在关闭");
			}
			public void windowDeactivated(WindowEvent e){
				System.out.println("非活动状态");
			}
			public void windowDeiconified(WindowEvent e){
				System.out.println("脱离最小化");
			}
			public void windowIconified(WindowEvent e){
				System.out.println("最小化");
			}
			public void windowOpened(WindowEvent e){
				System.out.println("打开状态");
			}
		});
		
		setBounds(100,100,500,375);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
	
}











