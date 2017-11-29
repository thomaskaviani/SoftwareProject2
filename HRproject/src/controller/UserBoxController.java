package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
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
		
		try {
			FileOutputStream fos = new FileOutputStream(filepath);
			fos.write(imagedata);
			fos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		File file = new File(filepath);
		
        Image image = new Image(file.toURI().toString());
        imgView.setImage(image);
        
        String str = user;
        String strUppercase = str.substring(0, 1).toUpperCase() + str.substring(1);
        username.setText(strUppercase);
        
    }
	
	
}
