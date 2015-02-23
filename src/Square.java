import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Square extends Shape {
		int size =75;
		
		//Constructor that uses default radius of 30
		//Also sets a random color
		public Square(int x,int y){
			super(x,y);
		}
		
		//Size-specificating constructor
		public Square(int x,int y,int size){
			super(x, y);
			this.size= size;
		}
		
		//Checks if a point in within the circle
		public boolean contains(int x,int y){
			return x>=this.x && x<=this.x+this.size && y>=this.y && y<=this.y+this.size; 
		}
		
		//Getters 
		public int getSize() {return this.size;}
		
	}

