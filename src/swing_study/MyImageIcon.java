package swing_study;

import java.awt.Container;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class MyImageIcon extends JFrame{
	public MyImageIcon(){
		Container container=getContentPane();
		JLabel jl=new JLabel("��ͼ��ı�ǩ���",JLabel.CENTER);
		URL url=MyImageIcon.class.getResource("icon.jpg");
		Icon icon=new ImageIcon(url);    //ʵ����Icon����
		jl.setIcon(icon);    //Ϊ��ǩ����
		jl.setHorizontalAlignment(SwingConstants.CENTER);    //�������ַ�ֹ�ڱ�ǩ�м�
		jl.setOpaque(true);    //���ñ�ǩΪ��͸��״̬
		container.add(jl);    //����Ǩ��ӵ�ͬ����
		setVisible(true);    //�Ǵ���ɼ�
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //���ô���ر�ģʽ
		setSize(286,168);
	}
	
	public static void main(String[]args){
		new MyImageIcon();
	}
}