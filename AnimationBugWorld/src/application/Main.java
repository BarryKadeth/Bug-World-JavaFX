package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	public double sceneWidth;
	public double sceneHeight;
	
	private static ArrayList<Bug> bugs = new ArrayList<Bug> ();
	private static ArrayList<Plant> plants = new ArrayList<Plant> ();
	public ArrayList<Bug> getBugs() {
		return bugs;
	}
	public ArrayList<Plant> getPlants() {
		return plants;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Pane root = new Pane ();
			Image icon = new Image("spider.png");
			
			root.getChildren().add(icon);
			
			//List of plants 
			plants.add(new Plant ("AA",40,40,25,Color.YELLOW));
			plants.add(new Plant ("BB",200,200,25,Color.GREEN));
			for (Plant p : plants) {
				root.getChildren().add(p);
			}
			//List of bugs
			bugs.add(new Bug ("A",100,100,25,Color.BLACK));
			bugs.add(new Bug ("B",200,200,25,Color.ORANGE));
			bugs.add(new Bug ("C",300,300,25,Color.YELLOW));
			bugs.add(new Bug ("D",400,400,25,Color.GREEN));
			for (Bug b : bugs) {
				root.getChildren().add(b);
			}

			
			
			
			
			MyEventHandler v = new MyEventHandler(this);
			KeyFrame frame = new KeyFrame(Duration.millis(100), v);
			Timeline timeline = new Timeline();
			timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
			timeline.getKeyFrames().add(frame);
			timeline.play();
			
			Scene scene = new Scene (root,400,400);
			//update sceneWidth and height for the Bug class to know
			sceneWidth = scene.getWidth();
			sceneHeight = scene.getHeight();
			
		//	primaryStage.setFullScreen(true);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Bug World");
			primaryStage.getIcons().add(icon);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}


		
//		KeyFrame frame = new KeyFrame(Duration.millis(160), new EventHandler<ActionEvent>() {
//			
//			
//			@Override
//			public void handle(ActionEvent t) {
//
//			
//			}
//			
//		});
//		
//		Timeline timeline = new Timeline();
//		timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
//		timeline.getKeyFrames().add(frame);
//		timeline.play();
//		
//		primaryStage.setTitle("Hello Animation");
//		primaryStage.setScene(scene);
//		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}



}

class MyEventHandler implements EventHandler <ActionEvent>
{

	Main m;
	
	public MyEventHandler(Main m)
	{
		this.m = m;
	}
	
	@Override
	public void handle(ActionEvent event) {
		for(Bug b : m.getBugs())
		{
//			System.out.println("Running...."+b.getName());
			b.randomMove();
		}
		for(Plant p : m.getPlants())
		{
			p.growthSize();
		}
		
    }

}


	