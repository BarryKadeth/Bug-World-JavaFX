package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Bee extends Bug {

	private static Image beeImage = new Image ("bee.png");
	
	public Bee(String name, double x, double y, double energy, Main m) {
		super(name, x, y, energy, m);
		this.setFill(new ImagePattern(beeImage));
	}
	
	@Override
	public void randomMove () {
		detectFood();
		if (energy > 20) {
			//reduces the energy levels of the bug
			energy = energy - 0.1;
			this.setRadius(energy);
			//Bee will move top left between 1700 and 1900 
			if (m.clockTime > 1700 && m.clockTime < 1900) {
				if (this.getCenterY() <= 20) {
					this.setCenterY(0 + 40);
				} else {
					this.setCenterY(this.getCenterY()-500/energy);
				}
				if (this.getCenterX() <= 20) {
					this.setCenterX(0+ 40);
				} else {
					this.setCenterX(this.getCenterX()-500/energy);
				}
			//Bee will move down right between 500 and 600
			} else if  (m.clockTime > 500 && m.clockTime < 650) {
				if (this.getCenterY() >= m.primaryStage.getHeight() - 80) { //m.sceneHeight - 40
					this.setCenterY(m.primaryStage.getHeight() - 80);
				} else {
					this.setCenterY(this.getCenterY()+500/energy);
				}
				if (this.getCenterX() >= m.primaryStage.getWidth() - 40) {
					this.setCenterX(m.primaryStage.getWidth() - 40 );
				} else {
					this.setCenterX(this.getCenterX()+500/energy);
				}
			} else {
			
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
		} else {
			energy = 4;
			this.setRadius(15);
			this.setFill(new ImagePattern(deadImage));
		}
		
	}
	

}
