package controller;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import model.Address;
import model.Sessions;
import model.Teacher;
import model.Training;
import application.Navigator;
import dao.AddressDAO;
import dao.SessionsDAO;
import dao.TeacherDAO;

public class AddSessionController implements Initializable {
	
	public static Training training;
	
	
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
	
	
	@FXML private ComboBox<Teacher> teacherComboBox;
	@FXML private ComboBox<Address> addressComboBox;
	
	@FXML
	protected void addSession(ActionEvent e) {
		
		Teacher teacher = null;
		Address address = null;
		
		if (teacherComboBox.getValue() == null) {
			
			Teacher teachTemp = new Teacher(teacherName.getText(), teacherEmail.getText(), teacherCompany.getText());
			TeacherDAO teachdao = new TeacherDAO();
			teachdao.insert(teachTemp);
			teacher = teachdao.getByName(teacherName.getText());
		} else {
			teacher = teacherComboBox.getValue();
		}
		
		if (addressComboBox.getValue() == null) {
			Address adresTemp = new Address(street.getText(), number.getText(), bus.getText(), zipcode.getText(), city.getText(), country.getText());
			AddressDAO adao = new AddressDAO();
			adao.insert(adresTemp);
			address = adao.getByStreetAndNumber(street.getText(), number.getText());
		} else {
			address = addressComboBox.getValue();
		}
		
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
		
		
		Sessions sesh = new Sessions(training.getTrainingId(), address.getAddressId(), teacher.getTeacherId(), startDate, endDate);
		
		SessionsDAO sdao = new SessionsDAO();
		sdao.insert(sesh);
		
		
		Navigator.loadVista(Navigator.TrainingDetailView);
				
		
	}
	@FXML
	protected void toTrainingDetail(ActionEvent e) {
		
		Navigator.loadVista(Navigator.TrainingDetailView);
				
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		TeacherDAO tdao = new TeacherDAO();
		ObservableList<Teacher> teachers = FXCollections.observableArrayList(tdao.getAll());
		
		teacherComboBox.getItems().addAll(teachers);
		
		AddressDAO adao = new AddressDAO();
		ObservableList<Address> addresses = FXCollections.observableArrayList(adao.getAll());
		
		addressComboBox.getItems().addAll(addresses);
		
		

	}

}
