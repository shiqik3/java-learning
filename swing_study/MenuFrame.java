package swing_study;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuFrame extends JFrame{
	public static void main(String[]args){
		MenuFrame menuFrame=new MenuFrame();
		menuFrame.setVisible(true);
	}
	public MenuFrame(){
		super();
		setTitle("创建菜单");
		setBounds(100,100,240,160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar=new JMenuBar();
		JMenu mn_file=new JMenu("文件");
		JMenu mn_edit=new JMenu("编辑");
		JMenuItem mi_new=new JMenuItem("新建");
		JMenuItem mi_open=new JMenuItem("打开");
		JMenuItem mi_save=new JMenuItem("保存");
		JMenuItem mi_exit=new JMenuItem("退出");
		URL url=MenuFrame.class.getResource("exit.png");
		Icon icon=new ImageIcon(url);
		mi_exit.setIcon(icon);
		mi_exit.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent arg0){
				System.exit(0);
			}
		});
		JMenuItem mi_copy=new JMenuItem("复制");
		JMenuItem mi_paste=new JMenuItem("粘贴");
		mn_file.add(mi_new);
		mn_file.add(mi_open);
		mn_file.add(mi_save);
		mn_file.addSeparator();    //在“保存”和“退出”菜单项间加分隔符
		mn_file.add(mi_exit);
		mn_edit.add(mi_copy);
		mn_edit.add(mi_paste);
		menuBar.add(mn_file);
		menuBar.add(mn_edit);
		this.setJMenuBar(menuBar);
	}
}