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
	
	public boolean horizontalVerif(int fil,int col1, int col2) {
		if(col1 < col2) {
			for(int i = col1+1;i<=col2;i++) {
				if(board[fil][i] != null) {return false;}
			}
			return true;
		}else if(col1 > col2){
			for(int i = col2;i<col1;i++) {
				if(board[fil][i] != null) {return false;}
			}
			return true;
		}
		return true;
	}
	public boolean verticalVerif(int col,int fil1,int fil2) {
		if(fil1 < fil2) {
			for(int i = fil1+1;i<=fil2;i++) {
				if(board[i][col] != null) {
					/* BETA
					if(turnWhite && board[i][col].color == 1) {
						return true;
					}
					if(!turnWhite && board[i][col].color == 2) {
						return true;
					}
					*/
					System.out.println("1:Fallo en fila "+i+" y en col "+col);
					return false;
				}
			}
			return true;
		}else if(fil1 > fil2) {
			for(int i = fil2;i<fil1;i++) {
				if(board[i][col] != null) {
					/* BETA
					if(turnWhite && board[i][col].color == 1) {
						return true;
					}
					if(!turnWhite && board[i][col].color == 2) {
						return true;
					}
					*/
					System.out.println("2:Fallo en fila "+i+" y en col "+col);
					return false;
				}
			}
			return true;
		}
		return true;
	}
	public boolean diagonalVerif(Coords coords1, Coords coords2) {
		for(int i = coords1.row+1,j = coords1.column+1;(i<=coords2.row && j<=coords2.column);i++,j++) {
			if(board[i][j] != null) {return false;}
		}
		return true;
	}
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
