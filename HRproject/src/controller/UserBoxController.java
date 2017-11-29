package controller;

import java.io.FileOutputStream;
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
	
	public static String user;
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        
		byte[] imagedata = LoginController.userLogged.getImagefile();
		
		String filepath = "src/images/userimage_" + LoginController.userLogged.getUsername() + ".jpg";
		String filepath2 = "/images/userimage_" + LoginController.userLogged.getUsername() + ".jpg";
		
		try {
			FileOutputStream fos = new FileOutputStream(filepath);
			fos.write(imagedata);
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
        Image image = new Image(filepath2);
        imgView.setImage(image);
        
        String str = user;
        String strUppercase = str.substring(0, 1).toUpperCase() + str.substring(1);
        username.setText(strUppercase);
        
    }
	
	
}
