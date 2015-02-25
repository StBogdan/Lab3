import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class Shape {
		int x,y;
		Color color;
		
		//Gets the position
		//And a random colour
		public Shape(int x,int y){
			this.x=x;
			this.y=y;
			Random RandColor = new Random();
			this.color = new Color(RandColor.nextInt(256),RandColor.nextInt(256),RandColor.nextInt(256));
		}
		
		//Checks if a point in within the circle
		public abstract boolean contains(int x,int y);
		
		//Getters 
		public int getX(){return this.x;}
		public int getY(){return this.y;}
		
		public Color getColor(){return this.color;}
		public void setColor(Color color) {this.color = color;}
	}
