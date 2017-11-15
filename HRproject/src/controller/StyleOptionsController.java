package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.xml.transform.TransformerException;

import application.ChangeColor;
import application.Main;
import application.Navigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import model.Theme;

public class StyleOptionsController implements Initializable{
	@FXML private ComboBox<Theme> colorComboBox = new ComboBox<Theme>();



	@FXML
	protected void toGeneralSettings(ActionEvent e) {

		Navigator.loadVista(Navigator.GeneralSettingsView);

	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Theme> colors = new ArrayList<Theme>();
		Theme original = new Theme("ORIGINAL","f5d6a6");
		Theme red = new Theme("RED", "f1d8d1");
		Theme dark = new Theme("DARK", "ff3d08");

		colors.add(original);
		colors.add(red);
		colors.add(dark);

		ObservableList<Theme> obslist = FXCollections.observableArrayList(colors);
		colorComboBox.getItems().addAll(obslist);
	}
	@FXML
	protected void SaveTheme() throws TransformerException {
		if (colorComboBox.getValue() == null) {
			//foutboodschap
		} else {
			ChangeColor.changeColor(colorComboBox.getValue().getCode());
		
			System.out.println("color changed to "+ colorComboBox.getValue().getCode());
		}
	}

}
