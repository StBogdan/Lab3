import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;


class Die extends JFrame{
	private int value =1;
	int[][] dotValues;
	
	public static void main(String args[]){
		Die aDie = new Die("Dice");
		aDie.init();
	}
	
	public Die(String title){
		super(title);
		this.dotValues = placeDots();
	}
	public void init(){
		Container panel = this.getContentPane();
		panel.setLayout(new BorderLayout());
		
		//Bottom buttons
		JButton inc = new JButton("Increase");
		JButton dec = new JButton("Decrease");
		
		//Make the buttons do increment the value displayed
		//And repaint the frame
		inc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Random RNG = new Random();
				value =1+ RNG.nextInt(6);
				repaint();
			}
		});
		dec.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(value > 1) value-=1;
				repaint();
			}
		});
		
		//Add the buttons
		Container buttons = new Container();
		panel.add(buttons,BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout());
		
		buttons.add(dec);
		buttons.add(inc);
		
		//Setup the window
		setSize(900, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Draws the actual shapes
	public void updateVal(int i){
		Graphics g = this.getGraphics();
		// For odd die result n , the dots stored at indexes 0,1 .... n-1 are drawn 
		// For even ones, dots stored at indexes 1,....,n are drawn
		int j = (this.value %2 != 0) ? 0 :1 ;
		
		while(j < i + ((this.value %2 != 0) ? 0 :1)){
			g.fillOval(dotValues[j][0]-25, dotValues[j][1]-25, 50, 50);
			j+=1;
		}
	}
	
	public void paint(Graphics g){
		//Draws the background then the dots
		g.setColor(Color.white);
		g.fillRect(300, 50, 300, 300);
		updateVal(value);
	}
	
	private int[][] placeDots(){
		//Arbitrary positions for the dots
		//Visual of the index of the dot and the drawn location
		// 1 5 4
		//   0
		// 3 6 2
		int[][] dotArray = new int[7][2];
		dotArray[0][0]=450; dotArray[0][1]=200;
		dotArray[1][0]=350; dotArray[1][1]=100;
		dotArray[2][0]=550; dotArray[2][1]=300;
		dotArray[3][0]=350; dotArray[3][1]=300;
		dotArray[4][0]=550; dotArray[4][1]=100;
		dotArray[5][0]=450; dotArray[5][1]=100;
		dotArray[6][0]=450; dotArray[6][1]=300;
		return dotArray;
	}
	
	
}
