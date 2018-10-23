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
	public boolean verificarMov(Coords coords) { // TODO Agregar movimientos de comer
		if(GUI.selection.chessman.color == 2 && GUI.selection.chessman.coords.column == coords.column && ((coords.row == GUI.selection.chessman.coords.row-2 && movs == 0) || coords.row == GUI.selection.chessman.coords.row-1)) {
			if(coords.row == GUI.selection.chessman.coords.row-2 ) {
				twoMovsUsed = true;
			}
			movs++;
			return true;
		}
		else if(GUI.selection.chessman.color == 1 && GUI.selection.chessman.coords.column == coords.column && ((coords.row == GUI.selection.chessman.coords.row+2 && movs == 0) || coords.row == GUI.selection.chessman.coords.row+1)) {
			if(coords.row == GUI.selection.chessman.coords.row+2 ) {
				twoMovsUsed = true;
			}
			movs++;
			return true;
		}
		return false;
	}
}
