package src.application;

public class Chessman {

	public String type;
	
	public Coords coords;
	
	public int color;
	
	/*
	public Chessman(String color, String piece) { // TODO Posible eliminacion completamente *Conflicto con herencia*
		int clor;
		if(color == "b") {
			this.color = 1;
		}else if(color == "w") {
			this.color = 2;
		}
		if(piece == "P") {
			
		}
	}
	*/
	
	public boolean verificarMov(Coords coords){return false;}; // Metodo que va a ser Sobreescrito en las clases hijo
	
	public boolean verificarComer(Coords coords) {return true;}
}
