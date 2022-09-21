package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Beehive extends Plant {

	private static Image beehiveImage = new Image ("bee-hive.png");
	
	public Beehive(String name, double x, double y, double size) {
		super(name, x, y, size);
		this.setFill(new ImagePattern(beehiveImage));
	}
	
	@Override
	public void growthSize () {
		Random random = new Random();
		int r = random.nextInt(30);
			if (r ==1 && size < 100) {
				this.size = size + 1;
				this.setRadius(size);
			}
	}

}
