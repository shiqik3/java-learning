package swing_study;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public  class MouseEventDemo extends JFrame{
	private JTextField textField;
	public MouseEventDemo(){
		super();
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				String str=textField.getText();
				textField.setText(str+",用户连续点击了鼠标"+arg0.getClickCount()+"次");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("鼠标进入窗体区域");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("鼠标离开了窗体区域");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("鼠标在窗体区域按下了按键");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("鼠标在窗体区域释放了按键"+arg0.getButton());
			}
		});
		setBounds(100,100,500,375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField=new JTextField();
		setVisible(true);
		getContentPane().add(textField, BorderLayout.SOUTH);
	}
	
	public static void main(String[]args){
		new MouseEventDemo();
	}
}