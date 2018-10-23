package src.application;

public class Rook extends Chessman{
	public Rook(String color) {
		if(color == "b") {
			this.color = 1;
		}else if(color == "w") {
			this.color = 2;
		}
		type = "R";
		coords = new Coords();
	}
	@Override
	public boolean verificarMov(Coords coords) {// TODO Agregar restricciones de movimiento incluyendo los movimientos de comer
		if(GUI.selection.chessman.type == "R" && (GUI.selection.chessman.coords.column == coords.column || GUI.selection.chessman.coords.row == coords.row)){
			return true;
		}else if(GUI.selection.chessman.type != "R" && GUI.selection.chessman.type != "P"){
			return true;
		}
		return false;
	}
}
