package swing_study;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class JoinTest extends JFrame{
	private Thread threadA;
	private Thread threadB;
	final JProgressBar progressBar=new JProgressBar();
	final JProgressBar progressBar2=new JProgressBar();
	int count=0;
	public static void main(String[]args){
		init(new JoinTest(),100,100);
	}
	public JoinTest(){
		super();
		getContentPane().add(progressBar,BorderLayout.NORTH);
		getContentPane().add(progressBar2, BorderLayout.SOUTH);
		progressBar.setStringPainted(true);
		progressBar2.setStringPainted(true);
		threadA=new Thread(new Runnable(){
			int conunt=0;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					progressBar.setValue(++count);
					try{
						threadA.sleep(1000);
						threadB.join();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		threadA.start();
		threadB=new Thread(new Runnable(){
			int conunt=0;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					progressBar2.setValue(++count);
					try{
						threadB.sleep(100);
					}catch(Exception e){
						e.printStackTrace();
					}
					if(count==100){
						break;
					}
				}
			}
		});
		threadB.start();
	}
	
	
	public static void init(JFrame frame,int width,int height){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
	}
}