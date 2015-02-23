import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circle extends Shape {
		int rad=30;
		
		//Constructor that uses default radius of 30
		//Also sets a random color
		public Circle(int x,int y){
			super(x,y);
		}
		
		//Radius-specificating constructor
		public Circle(int x,int y,int radius){
			super(x, y);
			this.rad= radius;
		}
		
		//Checks if a point in within the circle
		public boolean contains(int x,int y){
			return Math.sqrt((this.x+ this.rad -x)*(this.x+ this.rad -x) + (this.y+ this.rad-y)*(this.y+ this.rad-y)) < this.rad;
		}
		
		//Getters 
		public int getDiam(){return this.rad*2;}
		
	}
