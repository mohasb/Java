package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FormulariController {
    @FXML
    private Text resultado;
    @FXML
    private Button entrar;

    public void Accion(ActionEvent actionEvent) {

        resultado.setText("Botón presionado");
        entrar.setStyle("-fx-background-color: red;");
    }
}