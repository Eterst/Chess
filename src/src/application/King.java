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
	
	public boolean reyEnPeligro(Coords coords) {
		return false;
	}
	 
	@Override
	public boolean verificarMov(Coords coords) {// TODO Agregar restricciones de movimiento incluyendo los movimientos de comer
		if((Math.abs(this.coords.row - coords.row) <= 1) & (Math.abs(this.coords.column - coords.column) <= 1)) {
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
						cuadro.moveChessman(pieza.piece);
						movs++;
						return true;
					}
				//Enroque corto
				}else if(coords.column > this.coords.column && Chessboard.chessboard.horizontalVerif(true, 0, 4, 6)) {
					if(Chessboard.chessboard.board[0][7] != null && Chessboard.chessboard.board[0][7].type == "R" && Chessboard.chessboard.board[0][7].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(40);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(56);
						cuadro.moveChessman(pieza.piece);
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
						cuadro.moveChessman(pieza.piece);
						movs++;
						return true;
					}
				//Enroque corto
				}else if(coords.column > this.coords.column && Chessboard.chessboard.horizontalVerif(true, 7, 4, 6)) {
					if(Chessboard.chessboard.board[7][7] != null && Chessboard.chessboard.board[7][7].type == "R" && Chessboard.chessboard.board[7][7].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(47);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(63);
						cuadro.moveChessman(pieza.piece);
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
}
