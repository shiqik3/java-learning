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
		progressBar=new JProgressBar();    //创建进度条
		progressBar.setStringPainted(true);    //显示进度文本
		getContentPane().add(progressBar, BorderLayout.CENTER);
		setBounds(100,100,300,78);
		final JLabel label=new JLabel();
		getContentPane().add(label, BorderLayout.NORTH);
		label.setText("产品正在升级");
		setVisible(true);
	}
	
	public static void main(String[]args){
		new Progress();    //创建窗体
	}
}