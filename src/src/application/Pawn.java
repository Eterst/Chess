package src.application;

public class Pawn extends Chessman{
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
	public boolean verificarMov(Coords coords) {
		return false;
	}
}
