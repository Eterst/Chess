package src.application;

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
	public boolean verificarMov(Coords coords) {// TODO Agregar restricciones de movimiento incluyendo los movimientos de comer
		return true;
	}
}
