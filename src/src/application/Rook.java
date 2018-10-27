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
	public boolean verificarMov(Coords destinationCoords) {// TODO Agregar restricciones de movimiento incluyendo los movimientos de comer
		if(coords.column == destinationCoords.column){
			if(Chessboard.chessboard.verticalVerif(coords.column,coords.row,destinationCoords.row)) {
				return true;
			}
		}else if(coords.row == destinationCoords.row) {
			if(Chessboard.chessboard.horizontalVerif(coords.row, coords.column, destinationCoords.column)) {
				return true;
			}
		}
		return false;
	}
}
