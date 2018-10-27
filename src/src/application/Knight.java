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
public class Knight extends Chessman{
	public Knight(String color) {
		if(color == "b") {
			this.color = 1;
		}else if(color == "w") {
			this.color = 2;
		}
		type = "N";
		coords = new Coords();
	}
	@Override
	public boolean verificarMov(Coords coords) {// TODO Agregar restricciones de movimiento incluyendo los movimientos de comer
		if((this.coords.row - coords.row)*(this.coords.row - coords.row) + (this.coords.column - coords.column)*(this.coords.column - coords.column) == 5) {
			return true;
		}
		return false;
	}
	@Override
	public boolean verificarComer(Coords coords) {
		return verificarMov(coords);
	}
}
