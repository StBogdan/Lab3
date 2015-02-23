import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Square extends Shape {
		int size =75;
		
		//Also sets a random color
		public Square(int x,int y){
			super(x,y);
		}
		
		//Size-specifying constructor
		public Square(int x,int y,int size){
			super(x, y);
			this.size= size;
		}
		
		//Checks if a point in within the square
		public boolean contains(int x,int y){
			//The x,y of the drawing is different between Linux and Windows
			//Tested on windows
			return x>=(this.x)  && x<=(this.x + size) && y>=(this.y - size/2) && y<=(this.y +size/2);
			
			//This works on Linux
			// return x>=this.x && x<=this.x+this.size && y>=this.y && y<=this.y+this.size; 
		}
		
		//Getters 
		public int getSize() {return this.size;}
		
	}

