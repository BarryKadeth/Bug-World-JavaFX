package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Spider extends Bug {

	private static Image spiderImage = new Image ("spider.png");
	
	public Spider(String name, double x, double y, double energy, Main m) {
		super(name, x, y, energy, m);
		this.setFill(new ImagePattern(spiderImage));
	}
	
	@Override
	public void randomMove () {
		detectFood();
		if (energy > 20) {
			//reduces the energy levels of the bug
			energy = energy - 0.01;
			this.setRadius(energy);
			
			Random random1 = new Random();
			int r1 = random1.nextInt(5);
			if (r1 == 0) {
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
			this.setFill(new ImagePattern(deadImage));
		}
		
	}

}
