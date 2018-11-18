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
		if(coords != destinationCoords && coords.column == destinationCoords.column){
			if(Chessboard.chessboard.verticalVerif(true,coords.column,coords.row,destinationCoords.row)) {
				movs++;
				return true;
			}
		}else if(coords != destinationCoords && coords.row == destinationCoords.row) {
			if(Chessboard.chessboard.horizontalVerif(true,coords.row, coords.column, destinationCoords.column)) {
				movs++;
				return true;
			}
		}
		return false;
	}
	
	public boolean verificarComer(Coords destinationCoords) {
		if(coords != destinationCoords && coords.column == destinationCoords.column){
			if(Chessboard.chessboard.verticalVerif(false,coords.column,coords.row,destinationCoords.row)) {
				movs++;
				return true;
			}
		}else if(coords != destinationCoords && coords.row == destinationCoords.row) {
			if(Chessboard.chessboard.horizontalVerif(false,coords.row, coords.column, destinationCoords.column)) {
				movs++;
				return true;
			}
		}
		return false;
	}
	@Override
	public void amenazar() {
		int numSquare = 0;
		int i = 0;
		//Norte
		i = 1;
		numSquare = (coords.column-i)*8+coords.row;
		while(numSquare >= 0 && numSquare <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(numSquare)).sumarAmenaza(color);
			i++;
			numSquare = (coords.column-i)*8+coords.row;
		}
		//Sur
		i = 1;
		numSquare = (coords.column+i)*8+coords.row;
		while(numSquare >= 0 && numSquare <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(numSquare)).sumarAmenaza(color);
			i++;
			numSquare = (coords.column+i)*8+coords.row;
		}
		//Oeste
		i = 1;
		numSquare = coords.column*8+(coords.row-i);
		while(numSquare >= 0 && numSquare <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(numSquare)).sumarAmenaza(color);
			i++;
			numSquare = coords.column*8+(coords.row-i);
		}
		//Este
		i = 1;
		numSquare = coords.column*8+(coords.row+i);
		while(numSquare >= 0 && numSquare <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(numSquare)).sumarAmenaza(color);
			i++;
			numSquare = coords.column*8+(coords.row+i);
		}
	}
	@Override
	public void quitarAmenaza() {
		int numSquare = 0;
		int i = 0;
		//Norte
		i = 1;
		numSquare = (coords.column-i)*8+coords.row;
		while(numSquare >= 0 && numSquare <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(numSquare)).restarAmenaza(color); 
			i++;
			numSquare = (coords.column-i)*8+coords.row;
		}
		//Sur
		i = 1;
		numSquare = (coords.column+i)*8+coords.row;
		while(numSquare >= 0 && numSquare <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(numSquare)).restarAmenaza(color);
			i++;
			numSquare = (coords.column+i)*8+coords.row;
		}
		//Oeste
		i = 1;
		numSquare = coords.column*8+(coords.row-i);
		while(numSquare >= 0 && numSquare <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(numSquare)).restarAmenaza(color);
			i++;
			numSquare = coords.column*8+(coords.row-i);
		}
		//Este
		i = 1;
		numSquare = coords.column*8+(coords.row+i);
		while(numSquare >= 0 && numSquare <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(numSquare)).restarAmenaza(color);
			i++;
			numSquare = coords.column*8+(coords.row+i);
		}
	}
}
