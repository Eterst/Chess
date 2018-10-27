package src.application;
/*//////////////////////////
/* Historial de personas: formato (fecha)-(Persona) ejemplo
/* 27/10/2018-Jonder
/* 
/*
/* Trabajando Ahora: None
/* Fecha inicio: 
/* Fecha terminado: 
//////////////////////////*/
public class Bishop extends Chessman{
	public Bishop(String color) {
		if(color == "b") {
			this.color = 1;
		}else if(color == "w") {
			this.color = 2;
		}
		type = "B";
		coords = new Coords();
	}
	@Override
	public boolean verificarMov(Coords coords) {// TODO Agregar restricciones de movimiento incluyendo los movimientos de comer
		if(Math.abs(coords.column-this.coords.column) == Math.abs(coords.row-this.coords.row)) {
			if(Chessboard.chessboard.diagonalVerif(true, this.coords, coords)) {
				return true;
			}
		}
		return false;
	}
	public boolean verificarComer(Coords coords) {
		
		if(Math.abs(coords.column-this.coords.column) == Math.abs(coords.row-this.coords.row)) {
			if(Chessboard.chessboard.diagonalVerif(false, this.coords, coords)) {
				if(Chessboard.chessboard.board[coords.row][coords.column] != null && Chessboard.chessboard.board[coords.row][coords.column].color != this.color) {
					return true;
				}
			}
		}
		
		return false;
	}
}
