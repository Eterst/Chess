package src.application;

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
