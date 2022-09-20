package application;
//Baz
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Plant extends Rectangle {
	private String name;
	private double size; //size is the character used. 
	
	public Plant(String name, double x, double y, double size, Color c) {
		super (x,y,size,size);
		this.setFill(c);
		this.name = name;
		this.size = size;
	}
	
	/**chance of growth of plant*/
	public void growthSize () {
		Random random = new Random();
		int r = random.nextInt(5);
			if (r ==1 && size < 50) {
				this.size = size + 1;
				this.setWidth(size);
				this.setHeight(size);
			}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
}
