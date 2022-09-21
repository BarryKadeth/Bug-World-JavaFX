package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Spider extends Bug {

	private static Image spiderImage = new Image ("spider.png");
	
	public Spider(String name, double x, double y, double energy, Main m) {
		super(name, x, y, energy, m);
		this.setFill(new ImagePattern(spiderImage));
		// TODO Auto-generated constructor stub
	}

}
