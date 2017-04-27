package swing_study;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JoptionFrame extends JFrame{
	JTextField nameTextField=new JTextField(5);
	public JoptionFrame(){
		this.setBounds(100, 100, 250, 120);
		this.setTitle("test");
		this.setLayout(new BorderLayout());
		this.add(nameTextField,BorderLayout.CENTER);
		nameTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String	name=nameTextField.getText();
				if(name.equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "û�����������Ϣ",
							"��Ϣ��ʾ��",JOptionPane.CANCEL_OPTION);
				}else{
					int n=JOptionPane.showConfirmDialog(getContentPane(), "ȷ����ȷ��",
							"ȷ�϶Ի���",JOptionPane.YES_NO_CANCEL_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nameTextField.setText("��ȷ");
					}
				}
			}
			
		});
		this.setVisible(true);
	}
	
	public static void main(String[]args){
		new JoptionFrame();
	}
}