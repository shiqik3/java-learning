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
		setTitle("�����˵�");
		setBounds(100,100,240,160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar=new JMenuBar();
		JMenu mn_file=new JMenu("�ļ�");
		JMenu mn_edit=new JMenu("�༭");
		JMenuItem mi_new=new JMenuItem("�½�");
		JMenuItem mi_open=new JMenuItem("��");
		JMenuItem mi_save=new JMenuItem("����");
		JMenuItem mi_exit=new JMenuItem("�˳�");
		URL url=MenuFrame.class.getResource("exit.png");
		Icon icon=new ImageIcon(url);
		mi_exit.setIcon(icon);
		mi_exit.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent arg0){
				System.exit(0);
			}
		});
		JMenuItem mi_copy=new JMenuItem("����");
		JMenuItem mi_paste=new JMenuItem("ճ��");
		mn_file.add(mi_new);
		mn_file.add(mi_open);
		mn_file.add(mi_save);
		mn_file.addSeparator();    //�ڡ����桱�͡��˳����˵����ӷָ���
		mn_file.add(mi_exit);
		mn_edit.add(mi_copy);
		mn_edit.add(mi_paste);
		menuBar.add(mn_file);
		menuBar.add(mn_edit);
		this.setJMenuBar(menuBar);
	}
}