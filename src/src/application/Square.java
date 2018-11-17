package src.application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
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
public class Square extends Pane{
	/* Reemplazado con Coods
	public int row;
	
	public int column;
	*/
	public Coords coords;
	
	public ImageView square;
	
	public ImageView isquare;
	
	public boolean iluminated = false;
	
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
		if(!getChildren().contains(piece)) {
			getChildren().add(piece);
		}
	}
	public void moveChessman(ChessmanGUI chess) {
		GUI.gui.Desiluminate();
		Chessman temp = Chessboard.chessboard.board[chess.chessman.coords.row][chess.chessman.coords.column];
		Chessboard.chessboard.board[chess.chessman.coords.row][chess.chessman.coords.column] = null;
		Chessboard.chessboard.board[coords.row][coords.column] = temp;
		
		System.out.println("Cambia");
		chess.square.piece = null;
		addChessman(chess);
		//chess.square.clear();
		chess = null;
	}
	public void Coronar2(String equipo, int tipoPieza) {
		clearChessman();
		ChessmanGUI pieza;
		Chessboard.chessboard.board[coords.row][coords.column] = null;
		//int tipoPieza = GUI.gui.elegirPieza(equipo);
		if(tipoPieza == 1) {
			pieza = new ChessmanGUI(equipo, "Q", this);
		} else if(tipoPieza == 2) {
			pieza = new ChessmanGUI(equipo, "N", this);
		} else if(tipoPieza == 3) {
			pieza = new ChessmanGUI(equipo, "R", this);
		} else {
			pieza = new ChessmanGUI(equipo, "B", this);
		}
		addChessman(pieza);
		Chessboard.chessboard.board[coords.row][coords.column] = pieza.chessman;
		Chessboard.chessboard.inCoronation = null;
		//Agregar quitar coronacion de interfaz
	}
	public void Coronar(String equipo) {
		Chessboard.chessboard.inCoronation = this;
		GUI.gui.elegirPieza(equipo);
	}
	public void Iluminar() {
		if(!iluminated) {
			getChildren().remove(square);
			getChildren().add(isquare);
			iluminated = true;
		}
	}
	public void Desiluminar() {
		if(iluminated) {
			getChildren().remove(isquare);
			getChildren().add(square);
			iluminated = false;
		}
	}
	public void textMove() {
		if(GUI.selection != null && Chessboard.chessboard.playable) {
			if((piece == null && GUI.selection.chessman.verificarMov(coords)) || (piece != null && GUI.selection.chessman.verificarComer(coords))) {
				moveChessman(GUI.selection);
				if(GUI.selection.chessman.type.compareTo("P") == 0) {
					if(GUI.selection.chessman.coords.row == 7) {//TODO En fase de pruebas 
						Coronar("b");
					}
					else if(GUI.selection.chessman.coords.row == 0) {
						Coronar("w");
					}
				}
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
		}
	}
	
	public Square(int color, int i, int j) {
		/*
		row = i;
		column = j;
		*/
		coords = new Coords(i,j);
		if(color % 2 == 1) {
			square = new ImageView(new Image("white.png"));
			isquare = new ImageView(new Image("iwhite.png"));
		}else if(color % 2 == 0) {
			square = new ImageView(new Image("green.png"));
			isquare = new ImageView(new Image("igreen.png"));
		}
		square.setFitHeight(80);
		square.setFitWidth(80);

		event = new EventHandler<Event>() {
			@Override
			public void handle(Event e) {
				if(GUI.selection != null && Chessboard.chessboard.playable) {
					if((piece == null && GUI.selection.chessman.verificarMov(coords)) || (piece != null && GUI.selection.chessman.verificarComer(coords))) {
						moveChessman(GUI.selection);
						if(GUI.selection.chessman.type.compareTo("P") == 0) {
							if(GUI.selection.chessman.coords.row == 7) {//TODO En fase de pruebas 
								Coronar("b");
							}
							else if(GUI.selection.chessman.coords.row == 0) {
								Coronar("w");
							}
						}
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
