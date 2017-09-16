package swing_study;  
   
import java.awt.Color;  
import java.awt.Point;  
import java.awt.event.KeyAdapter;  
import java.awt.event.KeyEvent;  
   
import javax.swing.Icon;  
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
   
 enum KEY {  
     UP, RIGHT, DOWN, LEFT, RIGHT_UP, RIGHT_DOWN, LEFT_UP, LEFT_DOWN  
 }  
   
 enum HORIZION {  
     LEFT, RIGHT  
 }  
   
 enum VERTICAL {  
     UP, DOWN  
 }  
   
 public class MoveImage {  
     JFrame win;  
     Icon img;  
     JLabel lb;  
     static final int STEP = 2;  
     KEY key;  
     HORIZION hor;  
     VERTICAL ver;  
   
     public MoveImage() {  
         hor = null;  
         ver = null;  
   
         win = new JFrame("MoveImage");  
         win.setLayout(null);  
         // ����ͼƬ  
         img = new ImageIcon(getClass().getResource("img.gif"));  
         lb = new JLabel();  
         lb.setSize(img.getIconWidth(), img.getIconHeight());  
         // װ��ͼƬ  
         lb.setIcon(img);  
   
         win.setBounds(200, 0, 400, 300);  
         // ��Ӧ�����ϵļ������¼�  
         win.addKeyListener(new KeyAdapter() {  
             // ��ֵ��ʱ��  
             int k;  
   
             @Override 
             public void keyPressed(KeyEvent e) {  
                 k = e.getKeyCode();  
   
                 switch (k) {  
                 case KeyEvent.VK_UP:  
                     ver = VERTICAL.UP;  
                     break;  
                 case KeyEvent.VK_DOWN:  
                     ver = VERTICAL.DOWN;  
                     break;  
                 case KeyEvent.VK_RIGHT:  
                     hor = HORIZION.RIGHT;  
                     break;  
                 case KeyEvent.VK_LEFT:  
                     hor = HORIZION.LEFT;  
                     break;  
                 }  
                 if (ver == null) {  
                     if (hor == HORIZION.RIGHT) {  
                         key = KEY.RIGHT;  
                     } else {  
                         key = KEY.LEFT;  
                     }  
   
                 } else if (hor == null) {  
                     if (ver == VERTICAL.UP) {  
                         key = KEY.UP;  
                     } else {  
                         key = KEY.DOWN;  
                     }  
                 } else {  
                     if (hor == HORIZION.RIGHT) {  
                         if (ver == VERTICAL.UP) {  
                             key = KEY.RIGHT_UP;  
                         } else {  
                             key = KEY.RIGHT_DOWN;  
                         }  
                     } else {  
                         if (ver == VERTICAL.UP) {  
                             key = KEY.LEFT_UP;  
                         } else {  
                             key = KEY.LEFT_DOWN;  
                         }  
                     }  
                 }  
   
                 move(key);  
             }  
   
             @Override 
             public void keyReleased(KeyEvent e) {  
                 k = e.getKeyCode();  
                 switch (k) {  
                 case KeyEvent.VK_UP:  
                     ver = null;  
                     break;  
                 case KeyEvent.VK_DOWN:  
                     ver = null;  
                     break;  
                 case KeyEvent.VK_RIGHT:  
                     hor = null;  
                     break;  
                 case KeyEvent.VK_LEFT:  
                     hor = null;  
                     break;  
                 }  
             }  
         });  
   
         win.add(lb);  
         win.getContentPane().setBackground(Color.WHITE);  
         win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
         win.setVisible(true);  
         win.validate();  
     }  
   
     /**  
      * �ƶ�ͼƬ�� ֻ������������4��������������Ĳ�����  
      *   
      * @param keyCode  
      *            ���µļ����ϵļ��ļ�ֵ  
      */ 
     void move(KEY key) {  
         // ���µ�ǰ��λ��  
         Point pos = lb.getLocation();  
         switch (key) {  
         case UP:// �Ϸ���  
             pos.y -= STEP;  
             break;  
         case RIGHT:// �ҷ���  
             pos.x += STEP;  
             break;  
         case DOWN:// �·���  
             pos.y += STEP;  
             break;  
         case LEFT:// ����  
             pos.x -= STEP;  
             break;  
         case RIGHT_UP:// ���Ϸ���  
             pos.x += STEP;  
             pos.y -= STEP;  
             break;  
         case RIGHT_DOWN:// ���·���  
             pos.x += STEP;  
             pos.y += STEP;  
             break;  
         case LEFT_DOWN:// ���·���  
             pos.x -= STEP;  
             pos.y += STEP;  
             break;  
         case LEFT_UP:// ���Ϸ���  
             pos.x -= STEP;  
             pos.y -= STEP;  
             break;  
         }  
         // �Ƿ��ƶ����˱�Ե  
         if (pos.x >= win.getWidth() - lb.getWidth() || pos.x < 0 
                 || pos.y >= win.getHeight() - lb.getHeight() || pos.y < 0)  
             return;  
         // ������λ��  
         lb.setLocation(pos);  
         lb.validate();  
     }  
   
     public static void main(String[] args) {  
         MoveImage m = new MoveImage();  
     }  
 } 