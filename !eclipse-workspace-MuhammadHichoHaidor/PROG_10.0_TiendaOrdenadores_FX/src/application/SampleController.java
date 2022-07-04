package application;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class SampleController {
	@FXML
    private ImageView salir;

	
	
	
	void haz() {
	    salir.setOnMouseClicked(mouseEvent -> System.exit(0));

	}
	
}
