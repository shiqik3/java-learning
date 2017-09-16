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
		progressBar=new JProgressBar();    //创建进度条
		progressBar.setStringPainted(true);    //显示进度文本
		getContentPane().add(progressBar, BorderLayout.CENTER);
		setBounds(100,100,300,110);
		final JLabel label=new JLabel();
		getContentPane().add(label, BorderLayout.NORTH);
		getContentPane().add(text, BorderLayout.SOUTH);
		label.setText("产品正在升级");
		setVisible(true);
	}
	
	public static void main(String[]args){
		Progress adx=new Progress();    //创建窗体
		//progressBar.setIndeterminate(true);    //设置进度条为不确定样式
		int sum=0;
		for(int i=0;i<=101;i++){
			try{
				Thread.sleep(100);    //令当前进程休眠0.1秒
				sum+=i;
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			adx.text.setText(String.valueOf(sum));
			progressBar.setValue(i);    //设置进度条数值	
		}
		
		progressBar.setIndeterminate(false);    //设置采用确定进度条
		progressBar.setString("升级完成！");    //设置提示信息
	}
}