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
public class Chessboard {
	public Chessman[][] board;
	
	public boolean turnWhite = true;
	
	public boolean playable;
	/* TODO Ver si es necesario
	public String player1Name;
	
	public String player2Name;
	*/
	
	public static Chessboard chessboard;
	
	public boolean horizontalVerif(boolean included,int fil,int col1, int col2) {
		if(included) {
			horizontalVerif1(fil, col1, col2);
		}
		return horizontalVerif2(fil, col1, col2);
	}
	
	public boolean horizontalVerif1(int fil,int col1, int col2) {
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
	
	public boolean horizontalVerif2(int fil,int col1, int col2) {
		if(col1 < col2) {
			for(int i = col1+1;i<col2;i++) {
				if(board[fil][i] != null) {return false;}
			}
			return true;
		}else if(col1 > col2){
			for(int i = col2+1;i<col1;i++) {
				if(board[fil][i] != null) {return false;}
			}
			return true;
		}
		return true;
	}
	public boolean verticalVerif(boolean included,int col,int fil1,int fil2) {
		if(included) {
			return verticalVerif1(col, fil1, fil2);
		}
		return verticalVerif2(col, fil1, fil2);
	}
	public boolean verticalVerif1(int col,int fil1,int fil2) {
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
					System.out.println("2:Fallo en fila "+i+" y en col "+col);
					return false;
				}
			}
			return true;
		}
		return true;
	}
	
	public boolean verticalVerif2(int col,int fil1,int fil2) {
		if(fil1 < fil2) {
			for(int i = fil1+1;i<fil2;i++) {
				if(board[i][col] != null) {
					System.out.println("1:Fallo en fila "+i+" y en col "+col);
					return false;
				}
			}
			return true;
		}else if(fil1 > fil2) {
			for(int i = fil2+1;i<fil1;i++) {
				if(board[i][col] != null) {
					System.out.println("2:Fallo en fila "+i+" y en col "+col);
					return false;
				}
			}
			return true;
		}
		return true;
	}
	
	public boolean diagonalVerif(boolean included, Coords coords1, Coords coords2) {
		if(included) {
			return diagonalVerif1(coords1,coords2);
		}
		return diagonalVerif2(coords1,coords2);
	}
	public boolean diagonalVerif1(Coords coords1, Coords coords2) {
		if(coords1.row<coords2.row && coords1.column<coords2.column) {
			for(int i = coords1.row+1,j = coords1.column+1;(i<=coords2.row && j<=coords2.column);i++,j++) {
				if(board[i][j] != null) {return false;}
			}
		}else if(coords1.row<coords2.row && coords1.column > coords2.column) {
			for(int i = coords1.row+1,j = coords1.column-1;(i<=coords2.row && j>= coords2.column);i++,j--) {
				if(board[i][j] != null) {return false;}
			}
		}else if(coords1.row>coords2.row  && coords1.column>coords2.column) {
			for(int i = coords1.row-1,j = coords1.column-1;(i>=coords2.row && j>= coords2.column);i--,j--) {
				if(board[i][j] != null) {return false;}
			}
		}else if(coords1.row>coords2.row  && coords1.column<coords2.column) {
			for(int i = coords1.row-1,j = coords1.column+1;(i>=coords2.row && j<= coords2.column);i--,j++) {
				if(board[i][j] != null) {return false;}
			}
		}
		return true;
	}
	
	public boolean diagonalVerif2(Coords coords1, Coords coords2) {
		if(coords1.row<coords2.row && coords1.column<coords2.column) {
			for(int i = coords1.row+1,j = coords1.column+1;(i<coords2.row && j<coords2.column);i++,j++) {
				if(board[i][j] != null) {return false;}
			}
		}else if(coords1.row<coords2.row && coords1.column > coords2.column) {
			for(int i = coords1.row+1,j = coords1.column-1;(i<coords2.row && j> coords2.column);i++,j--) {
				if(board[i][j] != null) {return false;}
			}
		}else if(coords1.row>coords2.row  && coords1.column>coords2.column) {
			for(int i = coords1.row-1,j = coords1.column-1;(i>coords2.row && j> coords2.column);i--,j--) {
				if(board[i][j] != null) {return false;}
			}
		}else if(coords1.row>coords2.row  && coords1.column<coords2.column) {
			for(int i = coords1.row-1,j = coords1.column+1;(i>coords2.row && j< coords2.column);i--,j++) {
				if(board[i][j] != null) {return false;}
			}
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
