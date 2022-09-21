package application;
//Baz
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Plant extends Circle {
	private String name;
	protected double size; //size is the character used. 
	private static Image image = new Image ("sunflower.png");
	private double x;
	private double y;
	
	public Plant(String name, double x, double y, double size) {
		super (x,y,size);
		this.name = name;
		this.size = size;
		this.setFill(new ImagePattern(image));
	}
	
	/**chance of growth of plant*/
	public void growthSize () {
		Random random = new Random();
		int r = random.nextInt(5);
			if (r ==1 && size < 40) {
				this.size = size + 1;
				this.setRadius(size);
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

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}

}
