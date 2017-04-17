package swing_study;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

public class TickCount extends JFrame{
	private JRadioButton btn[]=new JRadioButton[4];
	private JProgressBar pro[]=new JProgressBar[4];
	private JPanel panel=new JPanel();
	private JPanel panel2=new JPanel();
	private ButtonGroup group=new ButtonGroup();
	private JButton submit=new JButton("提交");
	private JButton update=new JButton("刷新");
	
	public TickCount(){
		super("投票计数器");
		this.setBounds(100, 100, 400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setResizable(true);
		panel.setName("选择你最喜欢的运动");
		btn[0]=new JRadioButton("乒乓球");
		btn[1]=new JRadioButton("足球");
		btn[2]=new JRadioButton("篮球");
		btn[3]=new JRadioButton("网球");
		for(int i=0;i<4;i++){
			pro[i]=new JProgressBar();
			pro[i].setStringPainted(true);
			pro[i].setIndeterminate(false);
			group.add(btn[i]);
		}
		panel.add(btn[0]);
		panel.add(pro[0]);
		panel.add(btn[1]);
		panel.add(pro[1]);
		panel.add(btn[2]);
		panel.add(pro[2]);
		panel.add(btn[3]);
		panel.add(pro[3]);
		panel.setLayout(new GridLayout(4,1));
		this.add(panel);
		this.setVisible(true);
	}
	
	public static void main(String[]args){
		new TickCount();
	}
}