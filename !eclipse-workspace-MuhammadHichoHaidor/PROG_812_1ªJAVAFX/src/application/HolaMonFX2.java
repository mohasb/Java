package application;
	
import javafx.application.*;

import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;





public class HolaMonFX2 extends Application {
		
		
	Label resposta;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage escenari) {
		
		escenari.setTitle("Hola M�n");
		FlowPane rootNode = new FlowPane(10, 10);
		rootNode.setAlignment(Pos.CENTER);
		
		//Crea una escena
		Scene escena1 = new Scene(rootNode, 300, 100);
		
		escenari.setScene(escena1);
		resposta = new Label("Clica en el Bot�");
		
		Button btnA = new Button("Hola");
		Button btnB = new Button("Adeu");

	
		btnA.setOnAction(new EventHandler<ActionEvent>()  {
			public void handle(ActionEvent arg0) {
				resposta.setText("Hola M�n!");				
			}
			
		});
		
		btnB.setOnAction(new EventHandler<ActionEvent>()  {
			public void handle(ActionEvent arg0) {
				resposta.setText("Adeu M�n!");				
			}
			
		});
		
		rootNode.getChildren().addAll(btnA, btnB, resposta);
		escenari.show();
	}
}
