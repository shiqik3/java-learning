package swing_study;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JButton clear=new JButton("复位");
	private int btnnum=5;
	private int count[]=new int[4];
	
	public TickCount(){
		super("投票计数器");
		this.setBounds(450, 250, 400, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setResizable(true);
		panel.setName("选择你最喜欢的运动");
		btn[0]=new JRadioButton("乒乓球:");
		btn[1]=new JRadioButton("足球:    ");
		btn[2]=new JRadioButton("篮球:    ");
		btn[3]=new JRadioButton("网球:    ");
		for(int i=0;i<4;i++){
			count[i]=0;
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
		submit.addActionListener(new Btn2Listener());
		clear.addActionListener(new Btn2Listener());
		panel2.add(submit);
		panel2.add(clear);
		panel.setLayout(new GridLayout(4,1));
		panel2.setLayout(new FlowLayout());
		this.add(panel);
		this.add(panel2);
		this.setVisible(true);
	}
	private void clear(){
		for(int i=0;i<4;i++){
			pro[i].setValue(0);
			label[i].setText("  0票");
			count[i]=0;
		}
	}
	private void doProgressBar(int i){
		count[i]++;
		pro[i].setValue(count[i]*10);
		label[i].setText("  "+count[i]+"票");
	}
	
	private class BtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn[0]){
				btnnum=0;
			}else if(e.getSource()==btn[1]){
				btnnum=1;
			}else if(e.getSource()==btn[2]){
				btnnum=2;
			}else if(e.getSource()==btn[3]){
				btnnum=3;
			}else{
				return;
			}
			
		}
	}
	private class Btn2Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==submit){
				if(btnnum>=0&&btnnum<4){
					doProgressBar(btnnum);
				}else{
					JOptionPane.showMessageDialog(null,
							"未选择项目!", "系统信息", JOptionPane.WARNING_MESSAGE);
				}
				
			}else if(e.getSource()==clear){
				clear();
			}
		}
	}
	public static void main(String[]args){
		new TickCount();
	}
}