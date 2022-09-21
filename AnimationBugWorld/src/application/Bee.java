package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Bee extends Bug {

	private static Image beeImage = new Image ("bee.png");
	
	public Bee(String name, double x, double y, double energy, Main m) {
		super(name, x, y, energy, m);
		this.setFill(new ImagePattern(beeImage));
	}

}
