package src.application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Clocks implements Runnable{
	
	public int p1remaining,p2remaining,p1timelimit,p2timelimit;
	
	public Pane pane;
	
	public Label p1label,p2label;
	
	public Button button;
	
	public boolean running;
	
	public Runnable runnable;
	
	public Thread thread;
	
	public Clocks() {
		runnable = this;
		p1timelimit = 1500;
		p2timelimit = 1500;
		p1remaining = p1timelimit;
		p2remaining = p2timelimit;
		
		pane = new Pane();
		pane.setMaxHeight(150);
		pane.setMaxHeight(300);
		
		pane.getChildren().add(new ImageView(new Image("Reloj.png")));
		p1label = new Label("25:00");
		p1label.setLayoutY(75);
		p1label.setLayoutX(75);
		p2label = new Label("25:00");
		p2label.setLayoutY(75);
		p2label.setLayoutX(225);
		
		button = new Button();
		
		pane.getChildren().add(p1label);
		pane.getChildren().add(p2label);
		
		EventHandler<Event> event = new EventHandler<Event>() {
			public void handle(Event e) {
				//running = running^true;
				if(!running) {
					running = true;
					thread.start();
				}else {
					running = false;
					thread.stop();
				}
		        
			}
		};
		
		button.setOnMouseClicked(event);
		
		button.setLayoutX(150);
		pane.getChildren().add(button);
		
		pane.setLayoutX(700);
		pane.setLayoutY(40);
		
		thread = new Thread(runnable);
	}
	public Clocks(boolean run) {}
	@Override
	public void run() {
		if(Chessboard.chessboard.turnWhite) {
			while(true) {
				System.out.print("");//unnecessary but necessary
				try 
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e){}
				p2remaining= p2remaining-60;
				
				float seconds = p1remaining/60;
				
				double seconds2 = Math.round((seconds * 100d) / 100d);
				
				p1label.setText(""+p1remaining/60+":");
			}
		}else {
			while(true) {
				try 
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e){}
				p2remaining= p2remaining-60;
				
				float seconds = p2remaining/60;
				
				int seconds2 = (int) (Math.round(seconds * 100d) / 100d);
				
				p2label.setText(p2remaining/60+":"+seconds2);
			}
		}
	}
	
}
