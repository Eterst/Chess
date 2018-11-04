package src.application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
/*//////////////////////////
/* Historial de personas: formato (fecha)-(Persona) ejemplo
/* 27/10/2018-Jonder
/* 
/*
/* Trabajando Ahora: None
/* Fecha inicio: None
/* Fecha terminado: None
//////////////////////////*/
public class GUI extends Application {
	
	private GridPane grid;
	
	public GridPane getGrid() {
		return grid;
	}

	public Label getActualPlayer() {
		return actualPlayer;
	}

	public Pane getCoronationPanel() {
		return coronationPanel;
	}

	public static ChessmanGUI selection;
	
	public static GUI gui;
	
	private Label actualPlayer;
	
	private Pane coronationPanel;
	
	public ImageView coronationBackground = new ImageView(new Image("bbackground.png"));
	
	private AnchorPane root;
	
	public void updatePlayer(){
		if(Chessboard.chessboard.turnWhite) {
			actualPlayer.setText("Turn of White's");
		}else {
			actualPlayer.setText("Turn of Black's");
		}
	}
	
	public Label CreateLabel(double x,double y) {
		Label label = new Label();
		label.setLayoutX(x);
		label.setLayoutY(y);
		label.setTextFill(Color.WHITE);
		label.setFont(Font.font(28));
		return label;
	}
	public void electionInit(String equipo) {
		if(coronationPanel != null) {
			coronationPanel.getChildren().clear();
			coronationPanel = null;
		}
		coronationPanel = new Pane();
		int color;
		if(equipo == "b") {
			color = 1;
		}else if(equipo == "w") {
			color = 2;
		}else {
			color = -1;
		}
		GridPane gridp = new GridPane();
		Square sq1 = new Square(color,0,0);
		Square sq2 = new Square(color,0,1);
		Square sq3 = new Square(color,1,0);
		Square sq4 = new Square(color,1,1);
		
		sq1.addChessman(new ChessmanGUI(equipo,"Q",sq1));
		sq2.addChessman(new ChessmanGUI(equipo,"N",sq1));
		sq3.addChessman(new ChessmanGUI(equipo,"R",sq1));
		sq4.addChessman(new ChessmanGUI(equipo,"B",sq1));
		
		gridp.addRow(0, sq1);
		gridp.addRow(0, sq2);
		gridp.addRow(1, sq3);
		gridp.addRow(1, sq4);
		
		sq1.piece.setOnMouseClicked(null);
		sq2.piece.setOnMouseClicked(null);
		sq3.piece.setOnMouseClicked(null);
		sq4.piece.setOnMouseClicked(null);
		
		EventHandler<Event> event = new EventHandler<Event>() {
			@Override
			public void handle(Event e) {
				Square sq = (Square) e.getSource();
				if(sq.coords.row == 0) {
					if(sq.coords.column == 0) {
						if(Chessboard.chessboard.inCoronation != null) {
							Chessboard.chessboard.inCoronation.Coronar2(equipo, 1);
							clearCoronation();
						}
					}else {
						if(Chessboard.chessboard.inCoronation != null) {
							Chessboard.chessboard.inCoronation.Coronar2(equipo, 2);
							clearCoronation();
						}
					}
				}else {
					if(sq.coords.column == 0) {
						if(Chessboard.chessboard.inCoronation != null) {
							Chessboard.chessboard.inCoronation.Coronar2(equipo, 3);
							clearCoronation();
						}
					}else {
						if(Chessboard.chessboard.inCoronation != null) {
							Chessboard.chessboard.inCoronation.Coronar2(equipo, 4);
							clearCoronation();
						}
					}
				}
			}
		};
		
		sq1.setOnMouseClicked(event);
		sq2.setOnMouseClicked(event);
		sq3.setOnMouseClicked(event);
		sq4.setOnMouseClicked(event);
		
		coronationPanel.getChildren().add(gridp);
		coronationPanel.setLayoutX(270);
		coronationPanel.setLayoutY(270);
	}
	public void elegirPieza(String equipo) {
		coronationBackground.setOpacity(0.4);
		coronationBackground.setFitHeight(640);
		coronationBackground.setFitWidth(640);
		coronationBackground.setLayoutX(30);
		coronationBackground.setLayoutY(30);
		root.getChildren().add(coronationBackground);
		
		Chessboard.chessboard.playable = false;
		
		electionInit(equipo);
		
		root.getChildren().add(coronationPanel);
		
	}
	public void clearCoronation() {
		root.getChildren().remove(coronationBackground);
		root.getChildren().remove(coronationPanel);
		
		Chessboard.chessboard.playable = true;
	}
	public void fill() {
		Chessboard.chessboard = new Chessboard();
		//adding Squares
		int temporal = 1;
		int temp_row = 0;
		int temp_column = 0;
		for(int i = 0;i<8;i++) {
			for(int j = 0; j<8;j++) {
				Square temp = new Square(temporal,j,i);
				grid.addColumn(i, temp);
				temporal++;
			}
			temporal++;
		}
		//adding peons
		Square temp;
		for(int i = 1;i<58;i+=8) {
			temp = (Square) grid.getChildren().get(i);
			ChessmanGUI chess= new ChessmanGUI("b", "P", temp);
			temp.addChessman(chess);
			Chessboard.chessboard.board[1][temp_column] = chess.chessman;
			temp_column++;
		}
		temp_column = 0;
		for(int i = 6;i<63;i+=8) {
			temp = (Square) grid.getChildren().get(i);
			ChessmanGUI chess= new ChessmanGUI("w", "P", temp);
			temp.addChessman(chess);
			Chessboard.chessboard.board[6][temp_column] = chess.chessman;
			temp_column++;
		}
		//Chessboard.chessboard.printBoard();
		//adding pieces
		//Rooks ( towers) Black
		temp = (Square) grid.getChildren().get(0);
		ChessmanGUI rook1 = new ChessmanGUI("b","R",temp);
		temp.addChessman(rook1);
		Chessboard.chessboard.board[0][0] = rook1.chessman;
		
		temp = (Square) grid.getChildren().get(56);
		ChessmanGUI rook2 = new ChessmanGUI("b","R",temp);
		temp.addChessman(rook2);
		Chessboard.chessboard.board[0][7] = rook2.chessman;
		//Rooks ( towers) White
		temp = (Square) grid.getChildren().get(7);
		ChessmanGUI rook3 = new ChessmanGUI("w","R",temp);
		temp.addChessman(rook3);
		Chessboard.chessboard.board[7][0] = rook3.chessman;
		
		temp = (Square) grid.getChildren().get(63);
		ChessmanGUI rook4 = new ChessmanGUI("w","R",temp);
		temp.addChessman(rook4);
		Chessboard.chessboard.board[7][7] = rook3.chessman;
		
		//adding knights
		temp = (Square) grid.getChildren().get(8);
		ChessmanGUI knights1 = new ChessmanGUI("b","N",temp);
		temp.addChessman(knights1);
		Chessboard.chessboard.board[0][1] = knights1.chessman;
		
		temp = (Square) grid.getChildren().get(48);
		ChessmanGUI knights2 = new ChessmanGUI("b","N",temp);
		temp.addChessman(knights2);
		Chessboard.chessboard.board[0][6] = knights2.chessman;
		//White
		temp = (Square) grid.getChildren().get(15);
		ChessmanGUI knights3 = new ChessmanGUI("w","N",temp);
		temp.addChessman(knights3);
		Chessboard.chessboard.board[7][1] = knights3.chessman;
		
		temp = (Square) grid.getChildren().get(55);
		ChessmanGUI knights4 = new ChessmanGUI("w","N",temp);
		temp.addChessman(knights4);
		Chessboard.chessboard.board[7][6] = knights4.chessman;
		//adding bishops
		temp = (Square) grid.getChildren().get(16);
		ChessmanGUI bh1 = new ChessmanGUI("b","B",temp);
		temp.addChessman(bh1);
		Chessboard.chessboard.board[0][2] = bh1.chessman;
		
		temp = (Square) grid.getChildren().get(40);
		ChessmanGUI bh2 = new ChessmanGUI("b","B",temp);
		temp.addChessman(bh2);
		Chessboard.chessboard.board[0][5] = bh2.chessman;
		//White
		temp = (Square) grid.getChildren().get(23);
		ChessmanGUI bh3 = new ChessmanGUI("w","B",temp);
		temp.addChessman(bh3);
		Chessboard.chessboard.board[7][2] = bh3.chessman;
		
		temp = (Square) grid.getChildren().get(47);
		ChessmanGUI bh4 = new ChessmanGUI("w","B",temp);
		temp.addChessman(bh4);
		Chessboard.chessboard.board[7][5] = bh4.chessman;
		//adding kings
		temp = (Square) grid.getChildren().get(24);
		ChessmanGUI k1 = new ChessmanGUI("b","K",temp);
		temp.addChessman(k1);
		Chessboard.chessboard.board[0][3] = k1.chessman;
		//White
		temp = (Square) grid.getChildren().get(31);
		ChessmanGUI k2 = new ChessmanGUI("w","K",temp);
		temp.addChessman(k2);
		Chessboard.chessboard.board[7][3] = k2.chessman;
		//adding queens
		temp = (Square) grid.getChildren().get(32);
		ChessmanGUI q1 = new ChessmanGUI("b","Q",temp);
		temp.addChessman(q1);
		Chessboard.chessboard.board[0][4] = q1.chessman;
		//White
		temp = (Square) grid.getChildren().get(39);
		ChessmanGUI q2 = new ChessmanGUI("w","Q",temp);
		temp.addChessman(q2);
		Chessboard.chessboard.board[7][4] = q2.chessman;
	}
	
	@Override
	public void start(Stage primaryStage) {
		gui = this;
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());
		root = new AnchorPane();
		root.setId("pane");
		
		ImageView background = new ImageView(new Image("144.png"));

		
		
		background.setLayoutX(30);
		background.setLayoutY(30);
		background.setFitHeight(640);
		background.setFitWidth(640);
		root.getChildren().add(background);
		
		actualPlayer = CreateLabel(30,-10);
		actualPlayer.setText("Turn of White's");
		root.getChildren().add(actualPlayer);
		
		Scene scene = new Scene(root,Screen.getPrimary().getBounds().getMaxY(),Screen.getPrimary().getBounds().getMaxY());
		
		//Cosas xd
		grid = new GridPane();
		grid.setVgap(0);
		grid.setHgap(0);
		root.getChildren().add(grid);
		grid.setLayoutX(30);
		grid.setLayoutY(30);
		grid.setMaxSize(640, 640);
		fill();
		/*
		Square xd = (Square) grid.getChildren().get(0);
		Chessman chess1 = new Chessman("w","B",xd);
		xd.addChessman(chess1);
		*/
		root.setLayoutX((Screen.getPrimary().getBounds().getMaxX()/2)-370);
		root.setLayoutY((Screen.getPrimary().getBounds().getMaxY()/2)-370);
		
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		
		Alert cuadroalerta = new Alert(AlertType.CONFIRMATION);
	   	cuadroalerta.setTitle("Pantalla completa");
		cuadroalerta.setHeaderText(null);
		cuadroalerta.initStyle(StageStyle.UTILITY);
		cuadroalerta.setContentText("¿Quiere usar pantalla completa?");

		Optional<ButtonType> result = cuadroalerta.showAndWait();
		if(result.get() == ButtonType.OK){
			primaryStage.setFullScreen(true);
		}
		cuadroalerta.close();
		
		scene.setFill(Paint.valueOf("#312E2B"));
		// "@../../source/gray.png"
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
