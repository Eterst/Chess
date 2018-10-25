package src.application;

public class Chessboard {
	public Chessman[][] board;
	
	public boolean turnWhite = true;
	
	public boolean playable;
	/* TODO Ver si es necesario
	public String player1Name;
	
	public String player2Name;
	*/
	
	public static Chessboard chessboard;
	
	public void printFil(int i) {
		for(int j = 0;j<8;j++) {
			if(board[i][j] != null) {
				if(board[i][j].color == 1) {
					System.out.print("|\033[3m"+board[i][j].type+"\033[0m"); //[34;43m
				}else {
					System.out.print("|"+board[i][j].type);
				}

			}else {
				System.out.print("| ");
			}
		}
		System.out.println("|");
		//printLine();
	}
	
	public void printBoard() {
		for(int i = 0;i<8;i++) {
			printFil(i);
			
		}
	}
	public Chessboard() { //TODO Complementar con metodo "Fill" de GUI.java
		chessboard = this;
		playable = true;
		board = new Chessman[8][8];
	}
}
