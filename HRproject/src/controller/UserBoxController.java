package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class UserBoxController implements Initializable {

	@FXML
	private ImageView imgView;
	
	@FXML
	private Label username;
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        
		File file = new File("src/images/default.png");
        Image image = new Image(file.toURI().toString());
        imgView.setImage(image);
        
    }
}
