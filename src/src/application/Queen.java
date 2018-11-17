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
public class Queen extends Chessman{
	public Queen(String color) {
		if(color == "b") {
			this.color = 1;
		}else if(color == "w") {
			this.color = 2;
		}
		type = "Q";
		coords = new Coords();
	}
	@Override
	public boolean verificarMov(Coords coords) {
		if(this.coords.column == coords.column){
			if(Chessboard.chessboard.verticalVerif(true,this.coords.column,this.coords.row,coords.row)) {
				movs++;
				return true;
			}
		}else if(this.coords.row == coords.row) {
			if(Chessboard.chessboard.horizontalVerif(true,this.coords.row, this.coords.column, coords.column)) {
				movs++;
				return true;
			}
		}else if(Math.abs(coords.column-this.coords.column) == Math.abs(coords.row-this.coords.row)) {
			if(Chessboard.chessboard.diagonalVerif(true, this.coords, coords)) {
				movs++;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean verificarComer(Coords coords) {
		if(this.coords != coords && this.coords.column == coords.column){
			if(Chessboard.chessboard.verticalVerif(false,this.coords.column,this.coords.row,coords.row)) {
				movs++;
				return true;
			}
		}else if(this.coords != coords && this.coords.row == coords.row) {
			if(Chessboard.chessboard.horizontalVerif(false,this.coords.row, this.coords.column, coords.column)) {
				movs++;
				return true;
			}
		}else if(this.coords != coords && Math.abs(coords.column-this.coords.column) == Math.abs(coords.row-this.coords.row)) {
			if(Chessboard.chessboard.diagonalVerif(false, this.coords, coords)) {
				if(Chessboard.chessboard.board[coords.row][coords.column] != null && Chessboard.chessboard.board[coords.row][coords.column].color != this.color) {
					movs++;
					return true;
				}
			}
		}
		return false;
	}
}
