package src.application;

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
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean verificarComer(Coords coords) {
		return verificarMov(coords);
	}
}
