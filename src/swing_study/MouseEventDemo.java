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
				textField.setText(str+",�û�������������"+arg0.getClickCount()+"��");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("�����봰������");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("����뿪�˴�������");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("����ڴ����������˰���");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				textField.setText("����ڴ��������ͷ��˰���"+arg0.getButton());
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