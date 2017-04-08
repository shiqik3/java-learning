package swing_study;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCheckBoxDemo extends JFrame{
	public JCheckBoxDemo(){
		super();
		getContentPane().setLayout(null);
		setBounds(100,100,230,103);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JCheckBox cb0=new JCheckBox();
		cb0.setBounds(10,34,64,26);
		cb0.setText("ok");
		getContentPane().add(cb0);
		JCheckBox cb1=new JCheckBox("∆π≈“«Ú");
		cb1.setSelected(true);
		cb1.setBounds(84,34,64,26);
		getContentPane().add(cb1);
		JCheckBox cb2=new JCheckBox("”Œ”æ",true);
		cb2.setBounds(158,34,64,26);
		getContentPane().add(cb2);
		final JLabel label=new JLabel();
		label.setText("ƒ„œ≤ª∂µƒ‘À∂Ø£∫");
		label.setBounds(10,10,91,18);
		getContentPane().add(label);
		setVisible(true);
	}
	
	public static void main(String[]args){
		new JCheckBoxDemo();
	}
}