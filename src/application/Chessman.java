package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Chessman extends Pane{
	
	public int row;
	
	public int column;
	
	public Square square;
	
	public ImageView chessman;
	/* 
	1 king.#1
	1 queen.#2
	2 rooks.#3
	2 bishops.#4
	2 knights.#5
	8 pawns.#6
	
	1 rey
	1 dama o reina
	2 torres
	2 alfiles
	2 caballos
	8 peones
	*/
	public void select() {
		GUI.selection = this;
	}
	public Chessman(String color, String piece, Square sq) {
		if(color.length() > 1 || piece.length() > 1) {
			System.out.println("Value not appropieded");
			return;
		}
		sq.piece = this;
		chessman = new ImageView(""+(color.toLowerCase())+(piece.toUpperCase())+".png");
		chessman.setFitHeight(80);
		chessman.setFitWidth(80);
		
		EventHandler<Event> event = new EventHandler<Event>() {
			@Override
			public void handle(Event e) {
				if(GUI.selection == null) {
					System.out.println("Selected!");
					select();
				}else if(GUI.selection != null) {
					GUI.selection = null;
					System.out.println("Selected!");
					select();
				}
				
				System.out.println("Fil = "+row+" Col: "+column);
				System.out.println("Your clicked a Piece");
			}
		};
		setOnMouseClicked(event);
		
		getChildren().clear();
		getChildren().add(chessman);
	}
}
