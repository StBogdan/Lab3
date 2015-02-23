import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectDrag {

    public static void main(String[] s){
	MDFrame mdf = new MDFrame("Rectangle Dragging");
	mdf.init();
    }

}


class MDFrame extends JFrame {

    MDFrame(String s){ super(s); }

    public void init(){

	MDPanel p = new MDPanel();
	p.init();
	this.setContentPane(p);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	
	this.setSize(300,300);
	this.setVisible(true);
    }

}

class MDPanel extends JPanel {
   
    int x, y; 
    boolean dragging;
    int offsetX, offsetY; 
                       
    final int initx = 50;
    final int inity = 50;
    final int size = 30;
   
   public void init() {

      x = initx;
      y = inity;

      this.setBackground(Color.white);
      RectDragListener l = new RectDragListener();
      this.addMouseListener(l);
      this.addMouseMotionListener(l);      
   }
                   

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.red);
      g.fillRect(x, y, size, size);
   }
   
   class RectDragListener implements MouseListener, MouseMotionListener {

      public void mousePressed(MouseEvent evt) { 
   
       if (!dragging) {
         
        int nx = evt.getX(); 
        int ny = evt.getY();
      
        if (nx >= x && nx < x+size && ny >= y && ny < y+size) {
          dragging = true;
          offsetX = nx - x; 
          offsetY = ny - y;
        }
      }
   }

   public void mouseReleased(MouseEvent evt) { 

       dragging = false;
       if (x + size < 5 || x > getSize().width - 5  || y + size < 5 || y > getSize().height - 5) {
              x = initx;
              y = inity;
       }
       repaint();
   }


   public void mouseDragged(MouseEvent evt) { 

      if (dragging) {
        int nx = evt.getX();
        int ny = evt.getY();
          x = nx - offsetX;
          y = ny - offsetY;
      }
      repaint();
   }


   public void mouseMoved(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

   }
}