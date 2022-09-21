package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


public class Bug extends Circle{
	
	private String name; 
	private double energy;
	private Main m;
	private static Image image = new Image ("bug.png");
	
	
	
//	private World garden;
	
	public Bug (String name, double x, double y, double energy, Main m) {
		super(x, y, energy);
		this.m = m;
		this.name = name;
		this.energy = energy;
		this.setFill(new ImagePattern(image));
	}
	
	public void randomMove () {
		//reduces the energy levels of the bug
		energy = energy - 0.01;
		this.setRadius(energy);
		Random random = new Random();
		int r = random.nextInt(4);
		if (r == 0) { //North
			if (this.getCenterY() <= 20) {
				this.setCenterY(0 + 40);
			} else {
				this.setCenterY(this.getCenterY()-500/energy);
			}
		}
		if (r == 1) { //South
			if (this.getCenterY() >= m.primaryStage.getHeight() - 80) { //m.sceneHeight - 40
				this.setCenterY(m.primaryStage.getHeight() - 80);
			} else {
				this.setCenterY(this.getCenterY()+500/energy);
			}
		}
		if (r == 2) { //West
			if (this.getCenterX() <= 20) {
				this.setCenterX(0+ 40);
			} else {
				this.setCenterX(this.getCenterX()-500/energy);
			}
		}
		if (r == 3) { //East
			if (this.getCenterX() >= m.primaryStage.getWidth() - 40) {
				this.setCenterX(m.primaryStage.getWidth() - 40 );
			} else {
				this.setCenterX(this.getCenterX()+500/energy);
			}
		}
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double energy) {
		this.energy = energy;
	}
}


