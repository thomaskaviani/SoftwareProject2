package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddSessionController implements Initializable {

	@FXML private DatePicker date;
	
	@FXML private ChoiceBox<Integer> startUur;
	@FXML private ChoiceBox<Integer> startMinuten;
	
	@FXML private ChoiceBox<Integer> endUur;
	@FXML private ChoiceBox<Integer> endMinuten;
	
	@FXML private TextField teacherName;
	@FXML private TextField teacherEmail;
	@FXML private TextField teacherCompany;
	
	@FXML private TextField street;
	@FXML private TextField number;
	@FXML private TextField bus;
	@FXML private TextField city;
	@FXML private TextField zipcode;
	@FXML private TextField country;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

	}

}
