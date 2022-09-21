package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class FlyTrap extends Plant {
	
	private static Image trapImage = new Image ("trap.png");

	public FlyTrap(String name, double x, double y, double size) {
		super(name, x, y, size);
		this.setFill(new ImagePattern(trapImage));
	}

}
