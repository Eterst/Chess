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
	public boolean verificarMov(Coords coords) {
		return false;
	}
}
