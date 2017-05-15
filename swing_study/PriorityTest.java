package swing_study;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class PriorityTest extends JFrame{
	private JProgressBar[] progressBar=new JProgressBar[4];
	private Thread thread[]=new Thread[4];
	PriorityTest(){
		this.setBounds(100, 100, 300, 200);
		this.setTitle("进程优先级测试");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		for(int i=0;i<4;i++){
			progressBar[i]=new JProgressBar();
			progressBar[i].setStringPainted(true);
			progressBar[i].setIndeterminate(false);
			this.add(progressBar[i]);
			thread[i]=new Thread(new MyThread(progressBar[i]));
			thread[i].setPriority(4-i);
			if(i>0){
				try {
					thread[i-1].sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			thread[i].start();
		}
		this.setVisible(true);
	}
	public static void setPriority1(String threadName,int priority,Thread t){
		t.setPriority(priority);
		t.setName(threadName);
		t.start();
	}
	private final class MyThread implements Runnable{
		private final JProgressBar bar;
		int count=0;
		MyThread(JProgressBar bar){
			this.bar=bar;
		}
		public void run(){
			while(true){
				bar.setValue(count+=10);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					System.out.println("当前线程被中断");
				}
			}
		}
	}
	public static void main(String[]args){
		new PriorityTest();
	}
}