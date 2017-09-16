package swing_study;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class SleepMethodTest extends JFrame{
	private Thread t;
	private static Color[]color={Color.BLACK,Color.BLUE,Color.CYAN,Color.RED,
			Color.PINK,Color.LIGHT_GRAY};
	private static final Random rand=new Random();
	private static Color getC(){
		return color[rand.nextInt(color.length)];
	}
	public SleepMethodTest(){
		t=new Thread(new Runnable(){
			int x=30;
			int y=50;
			public void run(){
				while(true){
					try{
						t.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					Graphics graphics=getGraphics();
					graphics.setColor(getC());
					graphics.drawLine(x, y, 100, y++);
					if(y>=80){
						y=50;
					}
				}
			}
		});
		t.start();
	}
	public static void main(String[]args){
		init(new SleepMethodTest(),100,100);
	}
	public static void init(JFrame frame,int width,int height){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setBounds(100, 100, 300, 200);
		frame.setVisible(true);
	}
}