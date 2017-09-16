package swing_study;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserDemo extends JFrame{
	private JTextField text;
	private JLabel label;
	private JButton button;
	public JFileChooserDemo(){
		this.setBounds(100, 100, 300, 200);
		this.setTitle("文件对话框测试器");
		this.setLayout(new FlowLayout());
		JTextField text=new JTextField(20);
		JLabel label=new JLabel("文件路径:");
		JButton button=new JButton("选择文件");
		this.add(label);
		this.add(text);
		this.add(button);
		this.setVisible(true);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser chooser=new JFileChooser();
				FileFilter filter=new FileNameExtensionFilter
						("图像文件(*bmp;*.gif;*.jpg;*.jpeg)","bmp","gif","jpg","jpeg");
				chooser.setFileFilter(filter);
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setMultiSelectionEnabled(false);    //禁用多重选择
				int result=chooser.showOpenDialog(chooser);
				if(result==JFileChooser.APPROVE_OPTION){
					File file=chooser.getSelectedFile();
					text.setText(file.getPath());
				}
			}
		});
	}
	
	public static void main(String[]args){
		new JFileChooserDemo();
	}
}