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
		this.setTitle("���쵯���˵�");
		this.setBounds(100, 100, 240, 160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem mi_new=new JMenuItem("�½�");
		JMenuItem mi_open=new JMenuItem("��");
		JMenuItem mi_exit=new JMenuItem("�˳�");
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
		label.setOpaque(true);    //���ñ�ǩΪ��͸��
		label.setBackground(Color.PINK);
		getContentPane().add(label);
	}
}