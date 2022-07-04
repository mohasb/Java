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
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FormularioCSS extends Application {
	@Override
	public void start(Stage escenari) {
		try {
			//Titulo del form
			escenari.setTitle("Forulari d´entrada");
			
						
			//Crear y ajustar Gridpane
			GridPane arrel = new GridPane();
			arrel.setAlignment(Pos.CENTER);
			arrel.setHgap(10);
			arrel.setVgap(10);
			arrel.setPadding(new Insets(10, 10, 10, 10));
			
			//Crear elementos del form
			Label lusuari = new Label("Usuari");
			Label lcontrasenya = new Label("Contraseña");
			TextField usuari = new TextField();
			PasswordField contrasenya = new PasswordField();
			
			Text identificacio = new Text("Identificació");
			identificacio.setId("Titulo");
			//Establecer dos columnes para el título
			GridPane.setColumnSpan(identificacio, 2);

			Text resultat = new Text();
			//Color del texto en verde
			resultat.setId("Resultat");

			//Botón y se accion
			Button entrar = new Button("Entrar");
			entrar.setOnAction(e -> {
				resultat.setText("Botó presionat");
				entrar.setStyle("-fx-background-color: red;");
			});
			
			//Añadir elementos al gripPane en sus respectivas columnas
			arrel.add(identificacio, 0, 0);
			arrel.add(lusuari, 0, 1);
			arrel.add(usuari, 1, 1);
			arrel.add(lcontrasenya, 0, 2);
			arrel.add(contrasenya, 1, 2);
			arrel.add(entrar, 1, 3);
			arrel.add(resultat, 1, 4);


			//Creación de la escena, su contenido y dimensiones
			Scene escena = new Scene(arrel, 300, 300);
			//Enlazar form con CSS
			escena.getStylesheets().add(FormularioCSS.class.getResource("Estilo.css").toExternalForm());
			
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
