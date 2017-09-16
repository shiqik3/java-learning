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
					JOptionPane.showMessageDialog(getContentPane(), "没有添加姓名信息",
							"信息提示框",JOptionPane.CANCEL_OPTION);
				}else{
					int n=JOptionPane.showConfirmDialog(getContentPane(), "确认正确吗？",
							"确认对话框",JOptionPane.YES_NO_CANCEL_OPTION);
					if(n==JOptionPane.YES_OPTION){
						nameTextField.setText("正确");
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