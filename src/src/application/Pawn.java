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
	// TODO
	@Override
	public boolean verificarMov(Coords coords) { // TODO Agregar metodo de comer y peon al paso
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
		else if(color == 2 && (this.coords.column - coords.column == 1 || this.coords.column - coords.column == -1) && coords.row == this.coords.row - 1) {
			if(Chessboard.chessboard.board[coords.row][coords.column].color == 1) {
			/* comer(coords);
			 * return true;
			 *} else {
			 */
			return false;
			}
		}
		else if(color == 1 && (this.coords.column - coords.column == 1 || this.coords.column - coords.column == -1) && coords.row == this.coords.row + 1) {
			if(Chessboard.chessboard.board[coords.row][coords.column].color == 1) {
			/* comer(coords);
			 * return true;
			 *} else {
			 */
			return false;
			}
		}
		return false;
	}
}
