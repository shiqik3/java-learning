package educat_java;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class CartesianCurve extends Applet{
	int width,height;    //����int���ͱ���
	Image image;    //����ͼ�����
	Graphics draw_Curve;    //����ͼ�λ��Ʊ���
	public void init(){
		//Applect�����ʼ��
		setBackground(Color.BLACK);
		this.setSize(350,310);
		width=getSize().width;
		height=getSize().height;
		image=createImage(width,height);
		draw_Curve=image.getGraphics();
	}
	
	public void paint(Graphics g){
		//����Graphics�������
		draw_Curve.clearRect(0, 0, width, height);
		draw_Curve.setColor(Color.red);    //�ú�ɫ��������ָ���ľ���
		int i,j;
		double x,y,r;
		for(i=0;i<=90;i++){
			//�ѿ�����ѧ��ʽ��(x*x+y*u-2a*a(x*x+y*y)
			for(j=0;j<=90;j++){
				r=Math.PI/45*i*(1-Math.sin(Math.PI/45*j))*18;
				x=r*Math.cos(Math.PI/45*j)*Math.sin(Math.PI/45*i)+width/2;
				y=-r*Math.sin(Math.PI/45*j)+height/4;
				draw_Curve.fillOval((int)x, (int)y, 2, 2);
			}
		}
		g.drawImage(image, 0, 0, this);
	}
}