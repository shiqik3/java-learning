package swing_study;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

public class TickCount extends JFrame{
	private JLabel label[]=new JLabel[4];
	private JRadioButton btn[]=new JRadioButton[4];
	private JProgressBar pro[]=new JProgressBar[4];
	private JPanel panel=new JPanel();
	private JPanel panel2=new JPanel();
	private JPanel pan[]=new JPanel[4];
	private ButtonGroup group=new ButtonGroup();
	private JButton submit=new JButton("提交");
	private JButton update=new JButton("刷新");
	private String btnText=new String();
	
	public TickCount(){
		super("投票计数器");
		this.setBounds(100, 100, 400, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setResizable(true);
		panel.setName("选择你最喜欢的运动");
		btn[0]=new JRadioButton("乒乓球:");
		btn[1]=new JRadioButton("足球:    ");
		btn[2]=new JRadioButton("篮球:    ");
		btn[3]=new JRadioButton("网球:    ");
		for(int i=0;i<4;i++){
			pan[i]=new JPanel();
			pro[i]=new JProgressBar();
			pro[i].setStringPainted(true);
			pro[i].setIndeterminate(false);
			group.add(btn[i]);
			btn[i].addActionListener(new BtnListener());
			label[i]=new JLabel("  0票");
		}
		for(int i=0;i<4;i++){
			pan[i].add(btn[i]);
			pan[i].add(pro[i]);
			pan[i].add(label[i]);
			pan[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			panel.add(pan[i]);
		}
		panel2.add(submit);
		panel2.add(update);
		panel.setLayout(new GridLayout(4,1));
		panel2.setLayout(new FlowLayout());
		this.add(panel);
		this.add(panel2);
		this.setVisible(true);
	}
	
	private class BtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn[0]){
				btnText=btn[0].getText();
			}else if(e.getSource()==btn[1]){
				btnText=btn[1].getText();
			}else if(e.getSource()==btn[2]){
				btnText=btn[2].getText();
			}else if(e.getSource()==btn[3]){
				btnText=btn[3].getText();
			}else{
				return;
			}
			
		}
	}
	
	public static void main(String[]args){
		new TickCount();
	}
}