package swing_study;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Ftest extends JFrame{
	//�����࣬�̳�JFrame��
	private static final long serialVersionUID=1L;
	private JPanel jContentPane=null;    //����������
	private JTextArea jTextArea=null;    //�����ı������
	private JPanel controlPanel=null;    //����������
	private JButton openButton=null;    //������ť����
	private JButton closeButton=null;    //������ť����
	public void Ftest(){
		this.layout();
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[]args){
		//java����������
		Ftest thisClass=new Ftest();    //�����������
		thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisClass.setVisible(true);    //���øô���Ϊ��ʾ״̬
	}
}