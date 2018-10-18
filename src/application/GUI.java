package application;
	
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;


public class GUI extends Application {
	
	public GridPane grid;
	
	public static Chessman selection;
	
	public static GUI gui;
	
	public static long time;
	
	public void fill() {
		//adding Squares
		int temporal = 1;
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
			Chessman chess= new Chessman("b", "P", temp);
			temp.addChessman(chess);
		}
		for(int i = 6;i<63;i+=8) {
			temp = (Square) grid.getChildren().get(i);
			Chessman chess= new Chessman("w", "P", temp);
			temp.addChessman(chess);
		}
		//adding pieces
		//Rooks ( towers) Black
		temp = (Square) grid.getChildren().get(0);
		Chessman rook1 = new Chessman("b","R",temp);
		temp.addChessman(rook1);
		
		temp = (Square) grid.getChildren().get(56);
		Chessman rook2 = new Chessman("b","R",temp);
		temp.addChessman(rook2);
		//Rooks ( towers) White
		temp = (Square) grid.getChildren().get(7);
		Chessman rook3 = new Chessman("w","R",temp);
		temp.addChessman(rook3);
		
		temp = (Square) grid.getChildren().get(63);
		Chessman rook4 = new Chessman("w","R",temp);
		temp.addChessman(rook4);
		
		//adding knights
		temp = (Square) grid.getChildren().get(8);
		Chessman knights1 = new Chessman("b","N",temp);
		temp.addChessman(knights1);
		
		temp = (Square) grid.getChildren().get(48);
		Chessman knights2 = new Chessman("b","N",temp);
		temp.addChessman(knights2);
		//White
		temp = (Square) grid.getChildren().get(15);
		Chessman knights3 = new Chessman("w","N",temp);
		temp.addChessman(knights3);
		
		temp = (Square) grid.getChildren().get(55);
		Chessman knights4 = new Chessman("w","N",temp);
		temp.addChessman(knights4);
		//adding bishops
		temp = (Square) grid.getChildren().get(16);
		Chessman bh1 = new Chessman("b","B",temp);
		temp.addChessman(bh1);
		
		temp = (Square) grid.getChildren().get(40);
		Chessman bh2 = new Chessman("b","B",temp);
		temp.addChessman(bh2);
		//White
		temp = (Square) grid.getChildren().get(23);
		Chessman bh3 = new Chessman("w","B",temp);
		temp.addChessman(bh3);
		
		temp = (Square) grid.getChildren().get(47);
		Chessman bh4 = new Chessman("w","B",temp);
		temp.addChessman(bh4);
		//adding kings
		temp = (Square) grid.getChildren().get(24);
		Chessman k1 = new Chessman("b","K",temp);
		temp.addChessman(k1);
		//White
		temp = (Square) grid.getChildren().get(31);
		Chessman k2 = new Chessman("w","K",temp);
		temp.addChessman(k2);
		//adding kings
		temp = (Square) grid.getChildren().get(32);
		Chessman q1 = new Chessman("b","Q",temp);
		temp.addChessman(q1);
		//White
		temp = (Square) grid.getChildren().get(39);
		Chessman q2 = new Chessman("w","Q",temp);
		temp.addChessman(q2);
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
		AnchorPane root = new AnchorPane();
		root.setId("pane");
		
		ImageView background = new ImageView(new Image("144.png"));

		background.setLayoutX(30);
		background.setLayoutY(30);
		background.setFitHeight(640);
		background.setFitWidth(640);
		root.getChildren().add(background);
		
		Scene scene = new Scene(root,Screen.getPrimary().getBounds().getMaxY(),Screen.getPrimary().getBounds().getMaxY());
		
		//Cosas xd
		grid = new GridPane();
		grid.setVgap(0);
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
		cuadroalerta.setContentText("¿Quiere usar pantalla completa");

		Optional<ButtonType> result = cuadroalerta.showAndWait();
		if(result.get() == ButtonType.OK){
			primaryStage.setFullScreen(true);
		}
		cuadroalerta.close();
		scene.setFill(Paint.valueOf("#312E2B"));
		// "@../../source/gray.png"
		time = System.currentTimeMillis();
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
