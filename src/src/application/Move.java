package src.application;

public class Move {
	private Coords initial;
	
	private Coords destination;
	
	private int counter;
	
	public Move(Coords init,Coords dest) {
		initial = init;
		destination = dest;
		counter = 0;
	}
	public boolean equals(Move move) {
		if((initial.row == move.initial.row && initial.column == move.initial.column) && (destination.row == move.destination.row && destination.column == move.destination.column) ) {
			return true;
		}
		return false;
	}
	public void incCounter() {
		counter++;
	}
}
