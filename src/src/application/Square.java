package src.application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Square extends Pane{
	/* Reemplazado con Coods
	public int row;
	
	public int column;
	*/
	public Coords coords;
	
	public ImageView square;
	
	public ChessmanGUI piece;
	
	public EventHandler<Event> event;
	
	public void clear() {
		piece = null;
		getChildren().clear();
		getChildren().add(square);
	}
	
	public void addChessman(ChessmanGUI chess) {
		/*
		chess.chessman.coords.row = row;
		chess.chessman.coords.column = column;
		*/
		chess.chessman.coords = coords;
		chess.square = this;
		piece = chess;
		getChildren().clear();
		getChildren().add(piece);
	}
	public void moveChessman(ChessmanGUI chess) {
		Chessman temp = Chessboard.chessboard.board[chess.chessman.coords.row][chess.chessman.coords.column];
		Chessboard.chessboard.board[chess.chessman.coords.row][chess.chessman.coords.column] = null;
		Chessboard.chessboard.board[coords.row][coords.column] = temp;
		
		System.out.println("Cambia");
		chess.square.piece = null;
		addChessman(chess);
		//GUI.selection.square.clear();
		chess = null;
	}
	public Square(int color, int i, int j) {
		/*
		row = i;
		column = j;
		*/
		coords = new Coords(i,j);
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
				if(piece == null) {
					if(GUI.selection != null) {
						if(GUI.selection.chessman.verificarMov(coords)) {
							moveChessman(GUI.selection);
						}
						/*
						if(GUI.selection.chessman.type == "P" ) { // TODO **Eliminado por cambio**
							if(GUI.selection.chessman.verificarMov(coords)) {
								moveChessman(GUI.selection);
							}
						}else if(GUI.selection.chessman.type == "R" && (GUI.selection.chessman.coords.column == coords.column || GUI.selection.chessman.coords.row == coords.row)){
							moveChessman(GUI.selection);
						}else if(GUI.selection.chessman.type != "R" && GUI.selection.chessman.type != "P"){
							moveChessman(GUI.selection);
						}
						*/
					}
					System.out.println("Fil = "+coords.row+" Col: "+coords.column);
					System.out.println("Your clicked a square");
					
				}
				Chessboard.chessboard.printBoard();
			}
		};
		setOnMouseClicked(event);
		
		getChildren().clear();
		getChildren().add(square);
	}
}
