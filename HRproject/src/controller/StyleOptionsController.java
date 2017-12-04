/*
 * Bronnen:
 * 
 * XMLModifier voor het aanpassen van kleuren door mkyong: https://www.mkyong.com/java/how-to-modify-xml-file-in-java-dom-parser/
 * 
 * 
 * */

package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXColorPicker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Theme;
import application.Main;
import application.Navigator;
import dao.UserDAO;

public class StyleOptionsController implements Initializable{
	
	@FXML private Rectangle balk;
	
	@FXML private Label errorLabel;
	
	@FXML private JFXColorPicker colorPicker;
	
	@FXML private ComboBox<Theme> colorComboBox = new ComboBox<Theme>();

	@FXML
	protected void toGeneralSettings(ActionEvent e) {

		Navigator.loadVista(Navigator.GeneralSettingsView);

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		
		ArrayList<Theme> colors = new ArrayList<Theme>();
		Theme original = new Theme("ORIGINAL","f5d6a6");
		Theme red = new Theme("RED", "f1d8d1");
		Theme blue = new Theme("BLUE", "81d8d0");
		Theme grey = new Theme("GREY", "b3b7a9");
		Theme green = new Theme("GREEN","A3B86C");

		colors.add(original);
		colors.add(red);
		colors.add(blue);
		colors.add(grey);
		colors.add(green);

		ObservableList<Theme> obslist = FXCollections.observableArrayList(colors);
		colorComboBox.getItems().addAll(obslist);
	}
	
	@FXML protected void SaveTheme() {
		
		if (colorComboBox.getValue() == null) {
			
			if (colorPicker.getValue() != null) {
				
				String hex = Integer.toHexString(colorPicker.getValue().hashCode()).substring(0, 6);
				Main.color = hex;
				LoginController.userLogged.setColor(Main.color);
				
				UserDAO udao = new UserDAO();
				udao.update(LoginController.userLogged);
				
				Navigator.loadVista(Navigator.StyleOptionsView);
				Navigator.loadUserVista(Navigator.UserBoxView);
				
			} else {
				errorLabel.setText("No color selected");
				errorLabel.setTextFill(Color.FIREBRICK);
			}
			
		} else {
			
			//ChangeColor.changeColor(colorComboBox.getValue().getCode());
		
			Main.color = colorComboBox.getValue().getCode();
			LoginController.userLogged.setColor(Main.color);
			
			UserDAO udao = new UserDAO();
			udao.update(LoginController.userLogged);
			
			Navigator.loadVista(Navigator.StyleOptionsView);
			Navigator.loadUserVista(Navigator.UserBoxView);
			
			System.out.println("color changed to "+ colorComboBox.getValue().getCode());
			
			
		}
	}

}
