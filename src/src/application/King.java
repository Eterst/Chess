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
	
	public boolean verificarPeligro(Coords coords) {
		//Verificar si hay una amenaza
		//King
		for(int row = coords.row - 1; row - coords.row <= 1; ++row) {
			for(int column = coords.column - 1; column - coords.column <= 1; ++column) {
				if(row - coords.row != 0 || column - coords.column != 0) {
					if(row >= 0 && row <= 7 && column >=0 && column <= 7) {
						if(Chessboard.chessboard.board[row][column] != null) {
							if(Chessboard.chessboard.board[row][column].color != this.color) {
								if(Chessboard.chessboard.board[row][column].type.compareTo("K") == 0) {
									return true;
								}
							}	
						}
					}
				}
			}
		}
		//Pawn
		if(this.color == 2) {
			if(coords.row-1 >= 0 && coords.column-1 >= 0) {
				if(Chessboard.chessboard.board[coords.row-1][coords.column-1] != null) {
					if(Chessboard.chessboard.board[coords.row-1][coords.column-1].color != this.color) {
						if(Chessboard.chessboard.board[coords.row-1][coords.column-1].type.compareTo("P") == 0) {
							return true;
						}
					}
				}
			}
			if(coords.row-1 >= 0 && coords.column+1 <= 7) {
				if(Chessboard.chessboard.board[coords.row-1][coords.column+1] != null) {
					if(Chessboard.chessboard.board[coords.row-1][coords.column+1].color != this.color) {
						if(Chessboard.chessboard.board[coords.row-1][coords.column+1].type.compareTo("P") == 0) {
							return true;
						}
					}
				}
			}
		} else {
			if(coords.row+1 <= 7 && coords.column-1 >= 0) {
				if(Chessboard.chessboard.board[coords.row+1][coords.column-1] != null) {
					if(Chessboard.chessboard.board[coords.row+1][coords.column-1].color != this.color) {
						if(Chessboard.chessboard.board[coords.row+1][coords.column-1].type.compareTo("P") == 0) {
							return true;
						}
					}
				}
			}
			if(coords.row+1 <= 7 && coords.column+1 <= 7) {
				if(Chessboard.chessboard.board[coords.row+1][coords.column+1] != null) {
					if(Chessboard.chessboard.board[coords.row+1][coords.column+1].color != this.color) {
						if(Chessboard.chessboard.board[coords.row+1][coords.column+1].type.compareTo("P") == 0) {
							return true;
						}
					}
				}
			}
		}
		//Knight
		
		//Queen, Bishop, Rook
		int i = 0;
		Chessman temp = null;
		//Norte
		i = 1;
		while(coords.row - i >= 0) {
			temp = Chessboard.chessboard.board[coords.row-i][coords.column];
			if(temp != null && temp.type.compareTo("K") != 0) {
				if(temp.color != this.color) {
					if(temp.type.compareTo("Q") == 0 || temp.type.compareTo("R") == 0) {
						return true;
					}
				}
				break;
			}
			i++;
		}
		//Sur
		i = 1;
		while(coords.row + i <= 7) {
			temp = Chessboard.chessboard.board[coords.row+i][coords.column];
			if(temp != null && temp.type.compareTo("K") != 0) {
				if(temp.color != this.color) {
					if(temp.type.compareTo("Q") == 0 || temp.type.compareTo("R") == 0) {
						return true;
					}
				}
				break;
			}
			i++;
		}
		//Este
		i = 1;
		while(coords.column + i <= 7) {
			temp = Chessboard.chessboard.board[coords.row][coords.column+i];
			if(temp != null && temp.type.compareTo("K") != 0) {
				if(temp.color != this.color) {
					if(temp.type.compareTo("Q") == 0 || temp.type.compareTo("R") == 0) {
						return true;
					}
				}
				break;
			}
			i++;
		}
		//Oeste
		i = 1;
		while(coords.column - i >= 0) {
			temp = Chessboard.chessboard.board[coords.row][coords.column-i];
			if(temp != null && temp.type.compareTo("K") != 0) {
				if(temp.color != this.color) {
					if(temp.type.compareTo("Q") == 0 || temp.type.compareTo("R") == 0) {
						return true;
					}
				}
				break;
			}
			i++;
		}
		//Noreste
		i = 1;
		while(coords.row - i >= 0 && coords.column + i <= 7) {
			temp = Chessboard.chessboard.board[coords.row-i][coords.column+i];
			if(temp != null && temp.type.compareTo("K") != 0) {
				if(temp.color != this.color) {
					if(temp.type.compareTo("Q") == 0 || temp.type.compareTo("B") == 0) {
						return true;
					}
				}
				break;
			}
			i++;
		}
		//Sureste
		i = 1;
		while(coords.row + i <= 7 && coords.column + i <= 7) {
			temp = Chessboard.chessboard.board[coords.row+i][coords.column+i];
			if(temp != null && temp.type.compareTo("K") != 0) {
				if(temp.color != this.color) {
					if(temp.type.compareTo("Q") == 0 || temp.type.compareTo("B") == 0) {
						return true;
					}
				}
				break;
			}
			i++;
		}
		//Suroeste
		i = 1;
		while(coords.row + i <= 7 && coords.column - i >= 0) {
			temp = Chessboard.chessboard.board[coords.row+i][coords.column-i];
			if(temp != null && temp.type.compareTo("K") != 0) {
				if(temp.color != this.color) {
					if(temp.type.compareTo("Q") == 0 || temp.type.compareTo("B") == 0) {
						return true;
					}
				}
				break;
			}
			i++;
		}
		//Noroeste
		i = 1;
		while(coords.row - i >= 0 && coords.column - i >= 0) {
			temp = Chessboard.chessboard.board[coords.row-i][coords.column-i];
			if(temp != null && temp.type.compareTo("K") != 0) {
				if(temp.color != this.color) {
					if(temp.type.compareTo("Q") == 0 || temp.type.compareTo("B") == 0) {
						return true;
					}
				}
				break;
			}
			i++;
		}
		return false;
	}
	
	/**
	 *  @brief Revisa si el rey esta en peligro
	 *  @param Coords 
	 */
	public boolean reyEnPeligro(Coords coords) {
		if(coords != null) {
			if(color == 2) {
					return verificarPeligro(coords);
			}
			else if(color == 1) {
					return verificarPeligro(coords);
			}
		} 
		return false;
	}
	 
	@Override
	public boolean verificarMov(Coords coords) {
		if(this.coords !=coords &&(Math.abs(this.coords.row - coords.row) <= 1) & (Math.abs(this.coords.column - coords.column) <= 1)) {
			if(Chessboard.chessboard.board[coords.row][coords.column] == null) {
				if(!reyEnPeligro(coords)) {
					movs++;
					return true;
				}
			} else {
				return false;
			}
		}else if(movs == 0 && (this.coords.column == coords.column-2 || this.coords.column == coords.column+2) && !reyEnPeligro(coords)) {
			if(color == 1) {
				//Enroque largo
				if(coords.column < this.coords.column && Chessboard.chessboard.horizontalVerif(true, 0, 4, 1)) {
					if(Chessboard.chessboard.board[0][0] != null && Chessboard.chessboard.board[0][0].type == "R" && Chessboard.chessboard.board[0][0].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(24);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(0);
						cuadro.moveChessman(pieza.piece);
						movs++;
						return true;
					}
				//Enroque corto
				}else if(coords.column > this.coords.column && Chessboard.chessboard.horizontalVerif(true, 0, 4, 6)) {
					if(Chessboard.chessboard.board[0][7] != null && Chessboard.chessboard.board[0][7].type == "R" && Chessboard.chessboard.board[0][7].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(40);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(56);
						cuadro.moveChessman(pieza.piece);
						movs++;
						return true;
					}
				}
			}else if(color == 2) {
				//Enroque largo
				if(coords.column < this.coords.column && Chessboard.chessboard.horizontalVerif(true, 7, 4, 1)) {
					if(Chessboard.chessboard.board[7][0] != null && Chessboard.chessboard.board[7][0].type == "R" && Chessboard.chessboard.board[7][0].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(31);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(7);
						cuadro.moveChessman(pieza.piece);
						movs++;
						return true;
					}
				//Enroque corto
				}else if(coords.column > this.coords.column && Chessboard.chessboard.horizontalVerif(true, 7, 4, 6)) {
					if(Chessboard.chessboard.board[7][7] != null && Chessboard.chessboard.board[7][7].type == "R" && Chessboard.chessboard.board[7][7].movs == 0) {
						Square cuadro = (Square) GUI.gui.getGrid().getChildren().get(47);
						Square pieza = (Square) GUI.gui.getGrid().getChildren().get(63);
						cuadro.moveChessman(pieza.piece);
						movs++;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean verificarComer(Coords coords) {
		if(this.coords !=coords &&(Math.abs(this.coords.row - coords.row) <= 1) & (Math.abs(this.coords.column - coords.column) <= 1)) {
			if(!reyEnPeligro(coords)) {
				movs++;
				return true;
			}
		}
		return false;
	}
	
	/*@Override
	public void amenazar() {
		//Norte
		if((coords.column-1)+8*coords.row >= 0 && (coords.column-1)+8*coords.row <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*coords.row)).sumarAmenaza(color);
		}
		//Sur
		if((coords.column+1)+8*coords.row >= 0 && (coords.column+1)+8*coords.row <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*coords.row)).sumarAmenaza(color); 
		}
		//Oeste
		if(coords.column+8*(coords.row-1) >= 0 && coords.column+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*(coords.row-1))).sumarAmenaza(color);
		}
		//Este
		if(coords.column+8*(coords.row+1) >= 0 && coords.column+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*(coords.row+1))).sumarAmenaza(color);
		}
		//Noreste
		if((coords.column-1)+8*(coords.row+1) >= 0 && (coords.column-1)+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*(coords.row+1))).sumarAmenaza(color);
		}
		//Sureste
		if((coords.column+1)+8*(coords.row+1) >= 0 && (coords.column+1)+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*(coords.row+1))).sumarAmenaza(color);
		}
		//Suroeste
		if((coords.column+1)+8*(coords.row-1) >= 0 && (coords.column+1)+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*(coords.row-1))).sumarAmenaza(color);
		}
		//Noroeste
		if((coords.column-1)+8*(coords.row-1) >= 0 && (coords.column-1)+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*(coords.row-1))).sumarAmenaza(color);
		}
	}
	@Override
	public void quitarAmenaza() {
		//Norte
		if((coords.column-1)+8*coords.row >= 0 && (coords.column-1)+8*coords.row <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*coords.row)).restarAmenaza(color);
		}
		//Sur
		if((coords.column+1)+8*coords.row >= 0 && (coords.column+1)+8*coords.row <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*coords.row)).restarAmenaza(color); 
		}
		//Oeste
		if(coords.column+8*(coords.row-1) >= 0 && coords.column+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*(coords.row-1))).restarAmenaza(color);
		}
		//Este
		if(coords.column+8*(coords.row+1) >= 0 && coords.column+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get(coords.column+8*(coords.row+1))).restarAmenaza(color);
		}
		//Noreste
		if((coords.column-1)+8*(coords.row+1) >= 0 && (coords.column-1)+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*(coords.row+1))).restarAmenaza(color);
		}
		//Sureste
		if((coords.column+1)+8*(coords.row+1) >= 0 && (coords.column+1)+8*(coords.row+1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*(coords.row+1))).restarAmenaza(color);
		}
		//Suroeste
		if((coords.column+1)+8*(coords.row-1) >= 0 && (coords.column+1)+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column+1)+8*(coords.row-1))).restarAmenaza(color);
		}
		//Noroeste
		if((coords.column-1)+8*(coords.row-1) >= 0 && (coords.column-1)+8*(coords.row-1) <= 63) {
			((Square) GUI.gui.getGrid().getChildren().get((coords.column-1)+8*(coords.row-1))).restarAmenaza(color);
		}
	}
	*/
}
