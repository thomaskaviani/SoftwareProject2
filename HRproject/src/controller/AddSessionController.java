package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddSessionController implements Initializable {

	@FXML private DatePicker date;
	@FXML private DatePicker dateEnd;
	
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
	
	@FXML
	protected void addSession(ActionEvent e) {
		
		Calendar startcal = Calendar.getInstance();
		startcal.set(Calendar.DAY_OF_MONTH, date.getValue().getDayOfMonth());
		startcal.set(Calendar.MONTH, date.getValue().getMonthValue()-1);
		startcal.set(Calendar.YEAR, date.getValue().getYear());
		startcal.set(Calendar.HOUR_OF_DAY, startUur.getValue());
		startcal.set(Calendar.MINUTE, startMinuten.getValue());
		startcal.set(Calendar.SECOND, 0);
		startcal.set(Calendar.MILLISECOND, 0);
		
		Calendar endcal = Calendar.getInstance();
		endcal.set(Calendar.DAY_OF_MONTH, dateEnd.getValue().getDayOfMonth());
		endcal.set(Calendar.MONTH, dateEnd.getValue().getMonthValue()-1);
		endcal.set(Calendar.YEAR, dateEnd.getValue().getYear());
		endcal.set(Calendar.HOUR_OF_DAY, endUur.getValue());
		endcal.set(Calendar.MINUTE, endMinuten.getValue());
		endcal.set(Calendar.SECOND, 0);
		endcal.set(Calendar.MILLISECOND, 0);
		
		Date startDate = startcal.getTime();
		Date endDate = endcal.getTime();
		
		
		//Navigator.loadVista(Navigator.TrainingDetailView);
				
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

	}

}
