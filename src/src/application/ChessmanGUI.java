package src.application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
/*//////////////////////////
/* Historial de personas: formato (fecha)-(Persona) ejemplo
/* 27/10/2018-Jonder
/* 
/*
/* Trabajando Ahora: None
/* Fecha inicio: None
/* Fecha terminado: None
//////////////////////////*/
public class ChessmanGUI extends Pane{
	
	/* Desactivado para hacer herencia con Chessman
	public int row;
	
	public int column;
	
	public Coords coords;
	
	// 1 if is black, 2 if is white
	public int color;
	
	public String type;
	*/
	public Square square;
	
	public Chessman chessman;
	
	private ImageView chessmanIMG;
	/* 
	1 king.#1
	1 queen.#2
	2 rooks.#3
	2 bishops.#4
	2 knights.#5  "N"
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
	public boolean confirmSelect() {
		if(chessman.color == 2 && Chessboard.chessboard.turnWhite) {
			return true;
		}else if(chessman.color == 1 && !(Chessboard.chessboard.turnWhite)) {
			return true;
		}
		return false;
	}
	public Chessman selectPiece(String color, String piece) { // TODO crear constructores de las clases
		Chessman chessman;
		if(piece == "P") {
			chessman = new Pawn(color);
		}else if(piece == "K") {
			chessman = new King(color);
		}else if(piece == "N") {
			chessman = new Knight(color);
		}else if(piece == "Q") {
			chessman = new Queen(color);
		}else if(piece == "R") {
			chessman = new Rook(color);
		}else {
			chessman = new Bishop(color);
		}
		return chessman;
	}
	public ChessmanGUI(String color, String piece, Square sq) {
		chessman = selectPiece(color,piece);
		if(color.length() > 1 || piece.length() > 1 || !(color == "b" || color == "w")) {
			System.out.println("Values not appropieded");
			return;
		}
		sq.piece = this;
		chessmanIMG = new ImageView(""+(color.toLowerCase())+(piece.toUpperCase())+".png");
		chessmanIMG.setFitHeight(80);
		chessmanIMG.setFitWidth(80);
		
		EventHandler<Event> event = new EventHandler<Event>() {
			@Override
			public void handle(Event e) {
				/*
				if(GUI.selection == null) {
					if(confirmSelect()) {
						System.out.println("Selected!");
						select();
					}
				}else if(GUI.selection != null) {
					if(confirmSelect()) {
						System.out.println("Selected!");
						select();
					}
				}*/
				if(confirmSelect() && Chessboard.chessboard.playable) {
					System.out.println("Selected!");
					select();
					GUI.gui.Desiluminate();
					if(chessman.type == "B") {
						GUI.gui.diagonalIluminate(chessman.coords);
					}
				}
				System.out.println("Fil = "+chessman.coords.row+" Col: "+chessman.coords.column);
				System.out.println("Your clicked a Piece");
			}
		};
		setOnMouseClicked(event);
		
		getChildren().clear();
		getChildren().add(chessmanIMG);
	}
}
