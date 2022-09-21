package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


public class Bug extends Circle{
	
	private String name; 
	protected double energy;
	protected Main m;
	private static Image image = new Image ("bug.png");
	protected static Image deadImage = new Image ("tombstone.png");
	protected static Image ghostImage = new Image ("ghost.png");
	protected static Image rockImage = new Image ("rock.png");
	boolean alive = true;
	
	public Bug (String name, double x, double y, double energy, Main m) {
		super(x, y, energy);
		this.m = m;
		this.name = name;
		this.energy = energy;
		this.setFill(new ImagePattern(image));
	}
	
	//Bug moves randomly in one of four directions and is aware of the world's dimensions
	public void randomMove () {
		if (alive) {
			detectFood();
			if (energy > 15) {
				//reduces the energy levels of the bug
				energy = energy - 0.2;
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
			} else {
				alive = false;
				energy = 4;
				this.setRadius(15);
				this.setFill(new ImagePattern(deadImage));
			}
		}
		
	}
	
	public void detectFood() {
		for (Plant p : m.getPlants()) {
			if (p instanceof FlyTrap) {
				if (this.getCenterX() > p.getCenterX() - (p.getRadius()/2) &&
						this.getCenterX() < p.getCenterX() + (p.getRadius()/2) &&
						this.getCenterY() > p.getCenterY() - (p.getRadius()/2) &&
						this.getCenterY() < p.getCenterY() + (p.getRadius()/2)) {
					this.energy = 4;
					this.setRadius(15);
				}
			} 
			else if (this.getCenterX() > p.getCenterX() - (p.getRadius()/2) &&
					this.getCenterX() < p.getCenterX() + (p.getRadius()/2) &&
					this.getCenterY() > p.getCenterY() - (p.getRadius()/2) &&
					this.getCenterY() < p.getCenterY() + (p.getRadius()/2) &&
					p instanceof Beehive
					) {
				this.energy = 30;
				this.setRadius(energy);
				p.setSize(p.getSize()-0.1);
				p.setRadius(p.getSize());
			} 
			else if (this.getCenterX() > p.getCenterX() - (p.getRadius()/2) &&
					this.getCenterX() < p.getCenterX() + (p.getRadius()/2) &&
					this.getCenterY() > p.getCenterY() - (p.getRadius()/2) &&
					this.getCenterY() < p.getCenterY() + (p.getRadius()/2) &&
					p instanceof SpiderWeb
					) {
				this.energy = 40;
				this.setRadius(energy);
				p.setSize(p.getSize()-0.1);
				p.setRadius(p.getSize());
			} 
			else if (this.getCenterX() > p.getCenterX() - (p.getRadius()/2) &&
					this.getCenterX() < p.getCenterX() + (p.getRadius()/2) &&
					this.getCenterY() > p.getCenterY() - (p.getRadius()/2) &&
					this.getCenterY() < p.getCenterY() + (p.getRadius()/2)
					) {
				this.energy = 40;
				this.setRadius(energy);
				p.setSize(p.getSize()-10);
				p.setRadius(p.getSize());
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


