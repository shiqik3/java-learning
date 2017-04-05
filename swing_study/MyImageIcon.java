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
		JLabel jl=new JLabel("带图标的标签组件",JLabel.CENTER);
		URL url=MyImageIcon.class.getResource("icon.jpg");
		Icon icon=new ImageIcon(url);    //实例化Icon对象
		jl.setIcon(icon);    //为标签设置
		jl.setHorizontalAlignment(SwingConstants.CENTER);    //设置文字防止在标签中间
		jl.setOpaque(true);    //设置标签为不透明状态
		container.add(jl);    //将变迁添加到同期中
		setVisible(true);    //是窗体可见
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);    //设置窗体关闭模式
		setSize(286,168);
	}
	
	public static void main(String[]args){
		new MyImageIcon();
	}
}