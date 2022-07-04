package application;
	

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


public class Formulario extends Application {
	@Override
	public void start(Stage escenari) {
		try {
			//Titulo del form
			escenari.setTitle("Forulari d�entrada");
			
						
			//Crear y ajustar Gridpane
			GridPane arrel = new GridPane();
			arrel.setAlignment(Pos.CENTER);
			arrel.setHgap(10);
			arrel.setVgap(10);
			arrel.setPadding(new Insets(10, 10, 10, 10));
			
			//Crear elementos del form
			Label lusuari = new Label("Usuari");
			Label lcontrasenya = new Label("Contrase�a");
			TextField usuari = new TextField();
			PasswordField contrasenya = new PasswordField();
			
			Text identificacio = new Text("Identificaci�");
			//Tama�o del texto a 30
			identificacio.setFont(new Font(30));
			//Esblecer dos columnes para el t�tulo
			GridPane.setColumnSpan(identificacio, 2);

			Text resultat = new Text("Resultado");
			//Color del texto en verde
			resultat.setFill(Color.GREEN);

			//Bot�n y se accion
			Button entrar = new Button("Entrar");
			entrar.setOnAction(e -> resultat.setText("Bot� presionat"));
			
			//A�adir elementos al gripPane en sus respectivas columnas
			arrel.add(identificacio, 0, 0);
			arrel.add(lusuari, 0, 1);
			arrel.add(usuari, 1, 1);
			arrel.add(lcontrasenya, 0, 2);
			arrel.add(contrasenya, 1, 2);
			arrel.add(entrar, 1, 3);
			arrel.add(resultat, 1, 4);


			//Creaci�n de la escena, su contenido y dimensiones
			Scene escena = new Scene(arrel, 300, 300);
			escenari.setScene(escena);
			//mostrar form
			escenari.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
