import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


@SuppressWarnings("serial")
class CircleSelect extends JFrame{
	int numberCirc =1;
	ArrayList<Circle> circles= new ArrayList<Circle>();
	
	public static void main(String args[]){
		CircleSelect aCircle = new CircleSelect();
		aCircle.init();
	}
	
	public void init(){
		Container panel = this.getContentPane();
		panel.setLayout(new BorderLayout());
		randomCircles(numberCirc);
		
		//Listen for clicks
		panel.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				for(Circle checkCircles : circles)
					{
					if(checkCircles.contains(arg0.getX(), arg0.getY())) 
						{Random RandColor = new Random();
						checkCircles.setColor(new Color(RandColor.nextInt(256),RandColor.nextInt(256),RandColor.nextInt(256)));
						}
					System.out.println(" Ding " + arg0.getX() +" " + arg0.getY());
					repaint();
					}
			}

			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		//Bottom buttons
		JButton inc = new JButton("Increase");
		JButton dec = new JButton("Decrease");
		JButton reset = new JButton("Reset");
		
		inc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				numberCirc +=1;
				randomCircles(numberCirc);
				repaint();
			}
		});
		dec.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				numberCirc -=1;
				randomCircles(numberCirc);
				repaint();
			}
		});
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				randomCircles(numberCirc);
				repaint();
			}
		});
		
		//Add the buttons
		Container buttons = new Container();
		panel.add(buttons,BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout());
		
		buttons.add(dec);
		buttons.add(inc);
		buttons.add(reset);
		
		//Setup the window
		setSize(1000, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Draws the actual circles
	//Uses the array
	public void makeRounds(ArrayList<Circle> circles){
		Graphics g = this.getGraphics();
		for(Circle drawThis : circles){
			//Color and coordonates are obtained using getters
			g.setColor(drawThis.getColor());
			g.fillOval(drawThis.getX(), drawThis.getY(), drawThis.getDiam(), drawThis.getDiam());
		}
	}
	
	
	/**
	 * Creates the specified number of circles placed at random positions within the window
	 * @param number
	 */
	public void randomCircles(int number){
		circles.clear();
		Random RandCoord = new Random();
		for(int i=0;i<number;i++)
			{circles.add(new Circle(RandCoord.nextInt(1000),RandCoord.nextInt(400)));}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		//Paint the circles in the ArrayList
		makeRounds(circles);
		}
	
	
}
