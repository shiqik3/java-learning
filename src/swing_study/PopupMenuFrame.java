package swing_study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopupMenuFrame extends JFrame{
	public static void main(String[]args){
		PopupMenuFrame popupMenuFrame=new PopupMenuFrame();
		popupMenuFrame.setVisible(true);
	}
	public PopupMenuFrame(){
		super();
		this.setTitle("创造弹出菜单");
		this.setBounds(100, 100, 240, 160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem mi_new=new JMenuItem("新建");
		JMenuItem mi_open=new JMenuItem("打开");
		JMenuItem mi_exit=new JMenuItem("退出");
		popupMenu.add(mi_new);
		popupMenu.add(mi_open);
		popupMenu.addSeparator();
		popupMenu.add(mi_exit);
		final JLabel label=new JLabel("ahfj");
		label.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.isPopupTrigger())
				popupMenu.show(arg0.getComponent(), arg0.getX(), arg0.getY());
			}
		});
		label.setOpaque(true);    //设置标签为不透明
		label.setBackground(Color.PINK);
		getContentPane().add(label);
	}
}