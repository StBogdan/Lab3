import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


@SuppressWarnings("serial")
public class ShapeSelect extends JFrame{
	int numberCirc =1;
	ArrayList<Shape> shapes= new ArrayList<Shape>();
	
	public static void main(String args[]){
		ShapeSelect aShape = new ShapeSelect();
		aShape.init();
	}
	
	public void init(){
		Container panel = this.getContentPane();
		panel.setLayout(new BorderLayout());
		randomShapes(numberCirc);
		
		//Listen for clicks
		panel.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				for(Shape checkShapes : shapes)
					{
					if(checkShapes.contains(arg0.getX(), arg0.getY())) 
						{Random RandColor = new Random();
						checkShapes.setColor(new Color(RandColor.nextInt(256),RandColor.nextInt(256),RandColor.nextInt(256)));
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
		
		//Make the buttons do stuff
		inc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				numberCirc +=1;
				randomShapes(numberCirc);
				repaint();
			}
		});
		dec.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				numberCirc -=1;
				randomShapes(numberCirc);
				repaint();
			}
		});
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				randomShapes(numberCirc);
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
	
	//Draws the actual shapes
	//Uses the array
	public void makeRounds(ArrayList<Shape> shapes){
		Graphics g = this.getGraphics();
		for(Shape drawThis : shapes){
			//Colour and coordinates are obtained using getters
			g.setColor(drawThis.getColor());
			
			//Check if it's a circle
			if (drawThis instanceof Circle) g.fillOval(drawThis.getX(), drawThis.getY(), ((Circle) drawThis).getDiam(), ((Circle) drawThis).getDiam());
			else g.fillRect(drawThis.getX(), drawThis.getY(), ((Square) drawThis).getSize(), ((Square) drawThis).getSize());
		}
	}
	
	
	/**
	 * Creates the specified number of shapes placed at random positions within the window
	 * @param number
	 */
	public void randomShapes(int number){
		shapes.clear();
		
		//Creates an equal amount of Squares and Circles
		Random RandCoord = new Random();
		for(int i=0;i<number;i++)
			{
			if ( i % 2 == 0) shapes.add(new Circle(RandCoord.nextInt(1000),RandCoord.nextInt(400)));
			else shapes.add(new Square(RandCoord.nextInt(1000),RandCoord.nextInt(400)));
			}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		//Paint the shapes in the ArrayList
		makeRounds(shapes);
		}
	
	
}
