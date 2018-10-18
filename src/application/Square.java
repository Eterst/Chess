package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Square extends Pane{
	
	public int row;
	
	public int column;
	
	public ImageView square;
	
	public Chessman piece;
	
	public EventHandler<Event> event;
	
	public void clear() {
		piece = null;
		getChildren().clear();
		getChildren().add(square);
	}
	
	public void addChessman(Chessman chess) {
		chess.row = row;
		chess.column = column;
		chess.square = this;
		piece = chess;
		getChildren().clear();
		getChildren().add(piece);
	}
	
	public Square(int color, int i, int j) {
		row = i;
		column = j;
		if(color % 2 == 1) {
			square = new ImageView(new Image("white.png"));
		}else if(color % 2 == 0) {
			square = new ImageView(new Image("green.png"));
		}
		square.setFitHeight(80);
		square.setFitWidth(80);

		event = new EventHandler<Event>() {
			@Override
			public void handle(Event e) {
				System.out.println((System.currentTimeMillis()-GUI.time)/60);
				if(piece == null) {
					if(GUI.selection != null) {
						System.out.println("Cambia");
						GUI.selection.square.piece = null;
						addChessman(GUI.selection);
						//GUI.selection.square.clear();
						GUI.selection = null;
					}
					System.out.println("Fil = "+row+" Col: "+column);
					System.out.println("Your clicked a square");
				}
			}
		};
		setOnMouseClicked(event);
		
		getChildren().clear();
		getChildren().add(square);
	}
}
