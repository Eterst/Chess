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
	
	public void clearChessman() {
		getChildren().remove(piece);
		piece = null;
	}
	
	public void addChessman(ChessmanGUI chess) {
		/*
		chess.chessman.coords.row = row;
		chess.chessman.coords.column = column;
		*/
		chess.chessman.coords = coords;
		chess.square = this;
		getChildren().remove(piece);
		piece = chess;
		getChildren().add(piece);
	}
	public void moveChessman(ChessmanGUI chess) {
		Chessman temp = Chessboard.chessboard.board[chess.chessman.coords.row][chess.chessman.coords.column];
		Chessboard.chessboard.board[chess.chessman.coords.row][chess.chessman.coords.column] = null;
		Chessboard.chessboard.board[coords.row][coords.column] = temp;
		
		System.out.println("Cambia");
		chess.square.piece = null;
		addChessman(chess);
		//chess.square.clear();
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
				if(GUI.selection != null) {
					if((piece == null && GUI.selection.chessman.verificarMov(coords)) || (piece != null && GUI.selection.chessman.verificarComer(coords))) {
						moveChessman(GUI.selection);
						GUI.selection = null;
						System.out.println("Antes: "+Chessboard.chessboard.turnWhite);
						if(Chessboard.chessboard.turnWhite) {
							Chessboard.chessboard.turnWhite = false;
						}else if(!Chessboard.chessboard.turnWhite) {
							Chessboard.chessboard.turnWhite = true;
						}
						System.out.println("Despues: "+Chessboard.chessboard.turnWhite);
						GUI.gui.updatePlayer();
					}
					System.out.println("Fil = "+coords.row+" Col: "+coords.column);
					System.out.println("Your clicked a square");
				}/*else {
					if(GUI.selection != null) {
						if(GUI.selection.chessman.verificarComer(coords)) {
							moveChessman(GUI.selection);
							GUI.selection = null;
							if(Chessboard.chessboard.turnWhite) {
								Chessboard.chessboard.turnWhite = false;
							}else if(!Chessboard.chessboard.turnWhite) {
								Chessboard.chessboard.turnWhite = true;
							}
							System.out.println("Despues: "+Chessboard.chessboard.turnWhite);
							GUI.gui.updatePlayer();
						}
					}
				}*/
				Chessboard.chessboard.printBoard();
			}
		};
		setOnMouseClicked(event);
		
		getChildren().clear();
		getChildren().add(square);
	}
}
