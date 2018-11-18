package src.application;
/*//////////////////////////
/* Historial de personas: formato (fecha)-(Persona) ejemplo
/* 27/10/2018-Jonder
/* 
/*
/* Trabajando Ahora: None
/* Fecha inicio: None
/* Fecha terminado: None
//////////////////////////*/
public class King extends Chessman{
	public King(String color) {
		if(color == "b") {
			this.color = 1;
		}else if(color == "w") {
			this.color = 2;
		}
		type = "K";
		coords = new Coords();
	}
	
	/**
	 *  @brief Si el rey esta en una casilla amenazada revisa si es una amenaza real o "por rayos x" si es una amenaza real retorna true y false si no lo amenazan directamente o si no esta en una casilla amenazada 
	 *  @param Coords
	 */
	public boolean reyEnPeligro(Coords coords) {
		if(coords != null) {
			if(color == 2) {
				if(((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*coords.row)).amenazaNegra > 0) {
					return true;
				}
			}
			else if(color == 1) {
				if(((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*coords.row)).amenazaBlanca > 0) {
					return true;
				}
			}
		}
		return false;
	}
	 
	@Override
	public boolean verificarMov(Coords coords) {// TODO Agregar restricciones de movimiento incluyendo los movimientos de comer
		if(this.coords !=coords &&(Math.abs(this.coords.row - coords.row) <= 1) & (Math.abs(this.coords.column - coords.column) <= 1)) {
			if(!reyEnPeligro(coords)) {
				movs++;
				return true;
			}
		}else if(movs == 0 && (this.coords.column == coords.column-2 || this.coords.column == coords.column+2) && !reyEnPeligro(coords)) {
			if(color == 1) {
				//Enroque largo
				if(coords.column < this.coords.column && Chessboard.chessboard.horizontalVerif(true, 0, 4, 1)) {
					if(Chessboard.chessboard.board[0][0] != null && Chessboard.chessboard.board[0][0].type == "R" && Chessboard.chessboard.board[0][0].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(24);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(0);
						pieza.piece.chessman.quitarAmenaza();//Quita la amenaza de la torre
						cuadro.moveChessman(pieza.piece);
						cuadro.piece.chessman.amenazar();//Pone la amenaza de la torre
						movs++;
						return true;
					}
				//Enroque corto
				}else if(coords.column > this.coords.column && Chessboard.chessboard.horizontalVerif(true, 0, 4, 6)) {
					if(Chessboard.chessboard.board[0][7] != null && Chessboard.chessboard.board[0][7].type == "R" && Chessboard.chessboard.board[0][7].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(40);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(56);
						pieza.piece.chessman.quitarAmenaza();//Quita la amenaza de la torre
						cuadro.moveChessman(pieza.piece);
						cuadro.piece.chessman.amenazar();//Pone la amenaza de la torre
						movs++;
						return true;
					}
				}
			}else if(color == 2) {
				//Enroque largo
				if(coords.column < this.coords.column && Chessboard.chessboard.horizontalVerif(true, 7, 4, 1)) {
					if(Chessboard.chessboard.board[7][0] != null && Chessboard.chessboard.board[7][0].type == "R" && Chessboard.chessboard.board[7][0].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(31);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(7);
						pieza.piece.chessman.quitarAmenaza();//Quita la amenaza de la torre
						cuadro.moveChessman(pieza.piece);
						cuadro.piece.chessman.amenazar();//Pone la amenaza de la torre
						movs++;
						return true;
					}
				//Enroque corto
				}else if(coords.column > this.coords.column && Chessboard.chessboard.horizontalVerif(true, 7, 4, 6)) {
					if(Chessboard.chessboard.board[7][7] != null && Chessboard.chessboard.board[7][7].type == "R" && Chessboard.chessboard.board[7][7].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(47);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(63);
						pieza.piece.chessman.quitarAmenaza();//Quita la amenaza de la torre
						cuadro.moveChessman(pieza.piece);
						cuadro.piece.chessman.amenazar();//Pone la amenaza de la torre
						movs++;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean verificarComer(Coords coords) {
		return verificarMov(coords);
	}
	
	@Override
	public void amenazar() {
		//Norte
		if((coords.column-1)+8*coords.row >= 0 && (coords.column-1)+8*coords.row <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*coords.row)).sumarAmenaza(color);
		}
		//Sur
		if((coords.column+1)+8*coords.row >= 0 && (coords.column+1)+8*coords.row <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*coords.row)).sumarAmenaza(color); 
		}
		//Oeste
		if(coords.column+8*(coords.row-1) >= 0 && coords.column+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*(coords.row-1))).sumarAmenaza(color);
		}
		//Este
		if(coords.column+8*(coords.row+1) >= 0 && coords.column+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*(coords.row+1))).sumarAmenaza(color);
		}
		//Noreste
		if((coords.column-1)+8*(coords.row+1) >= 0 && (coords.column-1)+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*(coords.row+1))).sumarAmenaza(color);
		}
		//Sureste
		if((coords.column+1)+8*(coords.row+1) >= 0 && (coords.column+1)+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*(coords.row+1))).sumarAmenaza(color);
		}
		//Suroeste
		if((coords.column+1)+8*(coords.row-1) >= 0 && (coords.column+1)+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*(coords.row-1))).sumarAmenaza(color);
		}
		//Noroeste
		if((coords.column-1)+8*(coords.row-1) >= 0 && (coords.column-1)+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*(coords.row-1))).sumarAmenaza(color);
		}
	}
	@Override
	public void quitarAmenaza() {
		//Norte
		if((coords.column-1)+8*coords.row >= 0 && (coords.column-1)+8*coords.row <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*coords.row)).restarAmenaza(color);
		}
		//Sur
		if((coords.column+1)+8*coords.row >= 0 && (coords.column+1)+8*coords.row <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*coords.row)).restarAmenaza(color); 
		}
		//Oeste
		if(coords.column+8*(coords.row-1) >= 0 && coords.column+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*(coords.row-1))).restarAmenaza(color);
		}
		//Este
		if(coords.column+8*(coords.row+1) >= 0 && coords.column+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*(coords.row+1))).restarAmenaza(color);
		}
		//Noreste
		if((coords.column-1)+8*(coords.row+1) >= 0 && (coords.column-1)+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*(coords.row+1))).restarAmenaza(color);
		}
		//Sureste
		if((coords.column+1)+8*(coords.row+1) >= 0 && (coords.column+1)+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*(coords.row+1))).restarAmenaza(color);
		}
		//Suroeste
		if((coords.column+1)+8*(coords.row-1) >= 0 && (coords.column+1)+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*(coords.row-1))).restarAmenaza(color);
		}
		//Noroeste
		if((coords.column-1)+8*(coords.row-1) >= 0 && (coords.column-1)+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*(coords.row-1))).restarAmenaza(color);
		}
	}
	
}
