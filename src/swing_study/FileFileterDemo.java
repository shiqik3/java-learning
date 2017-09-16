package swing_study;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileFileterDemo extends JFrame{
	public FileFileterDemo(){
		this.setBounds(100, 100, 200, 150);
		this.setTitle("测试");
		this.setLayout(new FlowLayout());
		JLabel label=new JLabel("长");
		JTextField lengthText=new JTextField(12);
		JPanel panel=new JPanel();
		panel.add(label);
		panel.add(lengthText);
		JButton button=new JButton("提交");
		this.add(panel);
		this.add(button);
		this.setVisible(true);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String length=lengthText.getText();
				boolean bool=true;
				char[]len=length.toCharArray();
				for(int i=0;i<len.length;i++){
					if(!(Character.isDigit(len[i]))){
						bool=false;
					}
				}
				if(bool==false){
					JOptionPane.showMessageDialog(getContentPane(),
							"输入了非法字符!","warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	
	public static void main(String[]args){
		new FileFileterDemo();
	}
}