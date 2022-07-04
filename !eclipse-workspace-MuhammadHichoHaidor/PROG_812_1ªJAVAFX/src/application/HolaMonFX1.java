package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;





public class HolaMonFX1 extends Application {
		
	@Override
	public void start(Stage primaryStage) {
		
		Button boton = new Button();
		boton.setText("Saluda");
		boton.setOnAction(new EventHandler<ActionEvent>()  {
			public void handle(ActionEvent arg0) {
				System.out.println("Hola M�n!");
			}
			
		});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(boton);
		
		Scene escena = new Scene(layout, 300, 400);
		
		primaryStage.setTitle("Hola M�n");
		primaryStage.setScene(escena);
		primaryStage.show();
		

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
