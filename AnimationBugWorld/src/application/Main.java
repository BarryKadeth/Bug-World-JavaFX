package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	public double sceneWidth;
	public double sceneHeight;
	public int clockTime = 1200;
	public Stage primaryStage;
	public Text textTime = new Text (520,17,"Time: " + clockTime);
	Pane root = new Pane ();
	public BackgroundImage backgroundImage;
	Image grassImage = new Image("greenGrass.jpg");
	Image eveningGrassImage = new Image("EveningGrass.jpg");
	Image nightGrassImage = new Image("NightGrass.jpg");
	Background background;
	
	public Pane getRoot() {
		return root;
	}
	public Stage getPrimaryStage() {
		return primaryStage;
	}

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
			this.primaryStage = primaryStage;
			BorderPane mainRoot = new BorderPane();
			
			//Root pane will have the world
			root.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			mainRoot.setCenter(root);
			
			//Grass image
			backgroundImage = new BackgroundImage (grassImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
			background = new Background(backgroundImage);
			root.setBackground(background);
			
			//Creating top pane: 
			Pane top = new Pane();
			top.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
			Button playButton = new Button("Play World");
			playButton.setPrefSize(100, 20);
			
			top.getChildren().add(playButton);
			
			Button pauseButton = new Button("Pause World");
			pauseButton.setPrefSize(100, 20);
			pauseButton.setLayoutX(100);
			top.getChildren().add(pauseButton);
			
			Button addButton = new Button("Add Bug");
			addButton.setPrefSize(100, 20);
			addButton.setLayoutX(200);
			top.getChildren().add(addButton);
			mainRoot.setTop(top);
			
			Button exitButton = new Button("Exit World");
			exitButton.setPrefSize(100, 20);
			exitButton.setLayoutX(300);
			top.getChildren().add(exitButton);
			
			Slider slider = new Slider(0,5,1);
			slider.setLayoutX(400);
			slider.setLayoutY(12);
			slider.setPrefSize(100, 0);
			top.getChildren().add(slider);
			
			
			final Text textSpeed = new Text (415,10,"World Speed");
			textSpeed.setFill(Color.BLACK);
			top.getChildren().add(textSpeed);
			mainRoot.setTop(top);
			
			//Add time aspect to world

			textTime.setFill(Color.BLACK);
			top.getChildren().add(textTime);
			mainRoot.setTop(top);
			
			//List of plants / objects
			plants.add(new Home ("AA",900,300,250));
			plants.add(new FlyTrap ("AA",650,100,50));
			plants.add(new FlyTrap ("AA",650,300,50));
			plants.add(new FlyTrap ("AA",650,500,50));
			
			plants.add(new Plant ("AA",50,300,25));
			plants.add(new Plant ("AA",150,300,25));
			plants.add(new Plant ("AA",250,300,25));
			plants.add(new Plant ("AA",350,300,35));
			plants.add(new FlyTrap ("AA",450,300,40));
			plants.add(new Plant ("AA",550,300,25));
			
			
			plants.add(new Plant ("AA",50,500,25));
			plants.add(new Plant ("AA",150,500,25));
			plants.add(new Plant ("AA",250,500,25));
			plants.add(new Plant ("AA",350,500,25));
			plants.add(new Plant ("AA",450,500,25));
			plants.add(new Plant ("AA",550,500,25));
			
			
			
			
			plants.add(new Beehive ("AA",100,100,90));
			plants.add(new SpiderWeb ("AA",400,100,90));
			
			for (Plant p : plants) {
				root.getChildren().add(p);
			}
			
			//List of bugs
			bugs.add(new Spider ("A",400,100,25,this));
			bugs.add(new Spider ("B",400,200,25,this));
			bugs.add(new Spider ("A",500,100,25,this));
			bugs.add(new Spider ("B",100,500,25,this));
			bugs.add(new Spider ("A",400,150,25,this));
			bugs.add(new Spider ("B",400,100,25,this));
			
			bugs.add(new Butterfly ("C",300,300,25,this));
			bugs.add(new Butterfly ("C",300,300,25,this));
			bugs.add(new Butterfly ("C",100,300,25,this));
			bugs.add(new Butterfly ("C",100,500,25,this));
			bugs.add(new Butterfly ("C",500,500,25,this));
			bugs.add(new Butterfly ("C",600,500,25,this));
			
			bugs.add(new Bee ("D",400,400,25,this));
			bugs.add(new Bee ("D",400,400,25,this));
			bugs.add(new Bee ("D",500,400,25,this));
			bugs.add(new Bee ("D",500,400,25,this));
			bugs.add(new Bee ("D",200,200,25,this));
			bugs.add(new Bee ("D",200,200,25,this));
			bugs.add(new Bee ("D",800,20,25,this));
			bugs.add(new Bee ("D",800,50,25,this));
			
			for (Bug b : bugs) {
				root.getChildren().add(b);
			}
			
			MyEventHandler v = new MyEventHandler(this);
			KeyFrame frame = new KeyFrame(Duration.millis(100), v);
			Timeline timeline = new Timeline();
			timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
			timeline.getKeyFrames().add(frame);
			timeline.play();
			
			Scene scene = new Scene (mainRoot,900,600,Color.LIGHTGREEN);

			//pause controls:
			pauseButton.setOnAction(new EventHandler<ActionEvent>(){
				
				@Override
				public void handle (ActionEvent Arg0) {
					timeline.pause();
				}
			});
			//play controls:
			playButton.setOnAction(new EventHandler<ActionEvent>(){
				
				@Override
				public void handle (ActionEvent Arg0) {
					timeline.play();
				}
			});
			
			exitButton.setOnAction(v);			
			addButton.setOnAction(v);

//			//Slider set up:
	        slider.valueProperty().addListener(
	                new ChangeListener<Number>() {
	    
	               public void changed(ObservableValue <? extends Number >
	                         observable, Number oldValue, Number newValue) {
//	            	   System.out.println(newValue);
	                   timeline.setRate((double) newValue);
	               }
	           });
			
			
		//	primaryStage.setFullScreen(true);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Baramey's Geographic Bug World");
			//spider image for icon
			Image spiderImage = new Image("spider.png",50,50,false,false);
			primaryStage.getIcons().add(spiderImage);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		
		if(event.getSource() instanceof KeyFrame) {
			
			if (m.clockTime < 2400 ) {
				m.clockTime = m.clockTime + 10;
				m.textTime.setText("Time: " + m.clockTime);
				if (m.clockTime > 1700 && m.clockTime < 1900 || 
						m.clockTime > 500 && m.clockTime < 800) {
					m.backgroundImage = new BackgroundImage (m.eveningGrassImage,
							BackgroundRepeat.NO_REPEAT,
		                    BackgroundRepeat.NO_REPEAT,
		                    BackgroundPosition.DEFAULT,
		                    BackgroundSize.DEFAULT);	
				m.background = new Background (m.backgroundImage);
				m.root.setBackground(m.background);
				} else if (m.clockTime > 1900) {
					m.backgroundImage = new BackgroundImage (m.nightGrassImage,
							BackgroundRepeat.NO_REPEAT,
		                    BackgroundRepeat.NO_REPEAT,
		                    BackgroundPosition.DEFAULT,
		                    BackgroundSize.DEFAULT);	
				m.background = new Background (m.backgroundImage);
				m.root.setBackground(m.background);
				} else if (m.clockTime >=800 && m.clockTime <=1700) {
					m.backgroundImage = new BackgroundImage (m.grassImage,
							BackgroundRepeat.NO_REPEAT,
		                    BackgroundRepeat.NO_REPEAT,
		                    BackgroundPosition.DEFAULT,
		                    BackgroundSize.DEFAULT);	
				m.background = new Background (m.backgroundImage);
				m.root.setBackground(m.background);
				}
			} else if (m.clockTime >= 2400) {
				m.clockTime = 0;
				m.textTime.setText("Time: " + m.clockTime);
			}
			
			for(Bug b : m.getBugs()) {
				b.randomMove();
			}
			for(Plant p : m.getPlants()) {
				p.growthSize();
			}
		}
		else if(event.getSource() instanceof Button) {
			Button b = (Button)event.getSource();
			if(b.getText().equals("Exit World")) {
				Platform.exit();
			} else if (b.getText().equals("Add Bug")) {
				Random random = new Random();
				int r = random.nextInt(3);
				
				if (r == 0) {
					Spider s = new Spider ("AAA",450,50,25,m);
					m.getBugs().add(s);
					m.getRoot().getChildren().add(s);
				} else if (r == 1) {
					Butterfly s = new Butterfly ("AAA",300,300,25,m);
					m.getBugs().add(s);
					m.getRoot().getChildren().add(s);
				} else if (r == 2) {
					Bee s = new Bee ("AAA",500,500,25,m);
					m.getBugs().add(s);
					m.getRoot().getChildren().add(s);
				}	
				
				
				
				
			}
		}
    }
}


	