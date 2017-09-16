package swing_study;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MouseEventDemo2 extends JFrame{
	private JTextField textField;
	public MouseEventDemo2(){
		super();
		getContentPane().setLayout(null);
		addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mouseMoved(arg0);
				textField.setLocation(arg0.getPoint());
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				MouseEventDemo2.this.setTitle(arg0.getPoint().toString());
			}
		});
		setBounds(100,100,330,175);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField=new JTextField();
		textField.setBounds(90, 100, 137, 30);
		getContentPane().add(textField);
		setVisible(true);
	}
	
	public static void main(String[]args){
		new MouseEventDemo2();
	}
}