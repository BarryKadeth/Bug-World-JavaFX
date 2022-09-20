package application;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Bug extends Circle{
	
	private String name; 
	private double energy;
//	Main m;
	
	
//	private World garden;
	
	public Bug (String name, double x, double y, double energy, Color c) {
		super(x, y, energy);
		this.setFill(c);
		this.name = name;
		this.energy = energy;
	}
	
	public void randomMove () {
		//reduces the energy levels of the bug
		energy = energy - 0.01;
		this.setRadius(energy);
		Random random = new Random();
		int r = random.nextInt(4);
		if (r == 0) { //North
			if (this.getCenterY() <= 0) {
				this.setCenterY(0);
			} else {
				this.setCenterY(this.getCenterY()-500/energy);
			}
		}
		if (r == 1) { //South
//			if (this.getCenterY() >= m.sceneHeight) {
//				this.setCenterY(m.sceneHeight);
//			} else {
				this.setCenterY(this.getCenterY()+500/energy);
//			}
		}
		if (r == 2) { //East
			if (this.getCenterX() <= 0) {
				this.setCenterX(0);
			} else {
				this.setCenterX(this.getCenterX()-500/energy);
			}
		}
		if (r == 3) { //West
//			if (this.getCenterX() >= m.sceneWidth) {
//				this.setCenterX(m.sceneWidth);
//			} else {
				this.setCenterX(this.getCenterX()+500/energy);
//			}
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


