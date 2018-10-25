package src.application;

public class Pawn extends Chessman{
	
	public int movs;
	
	public boolean twoMovsUsed = false;
	
	public Pawn(String color) {
		if(color == "b") {
			this.color = 1;
		}else if(color == "w") {
			this.color = 2;
		}
		type = "P";
		coords = new Coords();
	}
	// TODO Agregar metodo de peon al paso
	@Override
	public boolean verificarMov(Coords coords) { 
		if(color == 2 && this.coords.column == coords.column && ((coords.row == this.coords.row - 2 && movs == 0) || coords.row == this.coords.row - 1)) {
			if(coords.row == this.coords.row - 2 ) {
				twoMovsUsed = true;
			}
			movs++;
			return true;
		}
		else if(color == 1 && this.coords.column == coords.column && ((coords.row == this.coords.row + 2 && movs == 0) || coords.row == this.coords.row + 1)) {
			if(coords.row == this.coords.row + 2 ) {
				twoMovsUsed = true;
			}
			movs++;
			return true;
		}
		return false;
	}
	@Override
	public boolean verificarComer(Coords coords) {
		if(color == 2 && (this.coords.column - coords.column == 1 || this.coords.column - coords.column == -1) && coords.row == this.coords.row - 1) {
			if(Chessboard.chessboard.board[coords.row][coords.column] != null) {
				if(Chessboard.chessboard.board[coords.row][coords.column].color == 1) {
					return true;
				} else {
					return false;
				}
			}
		}
		else if(color == 1 && (this.coords.column - coords.column == 1 || this.coords.column - coords.column == -1) && coords.row == this.coords.row + 1) {
			if(Chessboard.chessboard.board[coords.row][coords.column] != null) {
				if(Chessboard.chessboard.board[coords.row][coords.column].color == 2) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
