package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class UserBoxController implements Initializable {

	@FXML private VBox balk;
	
	@FXML
	private ImageView imgView;
	
	@FXML
	private Label username;
	
	public static String user;
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        
		balk.setStyle("-fx-background-color: #" + Main.color + ";");
		
		
		//userimage opvragen en tijdelijk opslaan "userimage_username.jpg"
		byte[] imagedata = LoginController.userLogged.getImagefile();
		
		String filepath = "src/images/userimage_" + LoginController.userLogged.getUsername() + ".jpg";
		
		File file = new File(filepath);
		file.getParentFile().mkdirs();
		try {
		file.createNewFile();

		
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(imagedata);
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
        Image image = new Image(file.toURI().toString());
        imgView.setImage(image);
        
        
        
        
        String str = user;
        String strUppercase = str.substring(0, 1).toUpperCase() + str.substring(1);
        username.setText(strUppercase);
        
    }
	
	
}
