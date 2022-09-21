package application;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class SpiderWeb extends Plant {

	private static Image spiderWebImage = new Image ("spider-web.png");
	
	public SpiderWeb(String name, double x, double y, double size) {
		super(name, x, y, size);
		this.setFill(new ImagePattern(spiderWebImage));
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
