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
	
	@Override
	public boolean verificarMov(Coords coords) {
		return false;
	}
}
