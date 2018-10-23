package src.application;

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
	public boolean verificarMov(Coords coords) {
		return false;
	}
}
