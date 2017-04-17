package swing_study;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.WindowPeer;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ShakeFrame extends JFrame{
	private JButton btn=new JButton("click me");
	public ShakeFrame(){
		super("´°ÌåÕð¶¯");
		this.setBounds(100, 100, 200, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		btn.setBounds(60, 20, 70, 30);
		this.add(btn);
		btn.addActionListener(new shakeAction());
		this.setVisible(true);
	}
	
	public class shakeAction implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int x=ShakeFrame.this.getX();
			int y=ShakeFrame.this.getY();
			for(int i=0;i<20;i++){
				if(i%2==0){
					x+=5;
					y+=5;
				}else{
					x-=5;
					y-=5;
				}
				ShakeFrame.this.setLocation(x, y);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public static void main(String[]args){
		new ShakeFrame();
	}
}