package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Home extends FlyTrap {

	private static Image houseImage = new Image ("home.png");
	
	public Home(String name, double x, double y, double size) {
		super(name, x, y, size);
		this.setFill(new ImagePattern(houseImage));
		
	}

}
