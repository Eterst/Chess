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
public class Coords {
	public int row;
	
	public int column;
	
	public Coords() {
		row = 0;
		column = 0;
	}
	public Coords(int row, int column) {
		this.row = row;
		this.column = column;
	}
	public void setXY(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
