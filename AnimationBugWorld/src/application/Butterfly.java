package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Butterfly extends Bug {
	
	private static Image butterflyImage = new Image ("butterfly.png");

	public Butterfly(String name, double x, double y, double energy, Main m) {
		super(name, x, y, energy, m);
		this.setFill(new ImagePattern(butterflyImage));
	}

}
