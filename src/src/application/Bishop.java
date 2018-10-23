package src.application;

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
		return true;
	}
}
