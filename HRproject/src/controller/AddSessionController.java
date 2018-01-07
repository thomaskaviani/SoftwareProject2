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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Address;
import model.Sessions;
import model.Teacher;
import model.Training;
import application.Main;
import application.Navigator;
import dao.AddressDAO;
import dao.SessionsDAO;
import dao.TeacherDAO;

public class AddSessionController implements Initializable {
	
	@FXML private Rectangle balk;
	@FXML private Button returnButton;
	
	public static Training training;
	public static boolean normal = true;
	
	@FXML private TextField sessionName;
	@FXML private Label errorLabel;
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
	
	@FXML protected void addSession(ActionEvent e) {
		
		Teacher teacher = null;
		Address address = null;
		Date startDate = null;
		Date endDate = null;
		
		boolean addSession = true;
		
		//Sessienaam
		if (sessionName.getText().isEmpty()) {
			addSession = false;
			errorLabel.setText("Session name is required");
			errorLabel.setTextFill(Color.FIREBRICK);
		} else {
			
			if (date.getValue() == null || dateEnd.getValue() == null || startUur == null || startMinuten == null || endUur == null || endMinuten == null) {
				if (addSession) {
					errorLabel.setText("All date and time fields are required!");
					errorLabel.setTextFill(Color.FIREBRICK);
				}
				addSession = false;
			} else if (addSession){
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
						
				endDate = endcal.getTime();
				startDate = startcal.getTime();	
				
				
				//Teacher aanmaken / selecteren
				if (teacherComboBox.getValue() == null && addSession == true) {
					
					//Teacher van texfields
					if ((teacherName.getText().isEmpty() || teacherCompany.getText().isEmpty() || teacherCompany.getText().isEmpty()) && addSession == true) {
						errorLabel.setText("Teacher's name, company and email are required");
						errorLabel.setTextFill(Color.FIREBRICK);
						addSession = false;
					} else if (addSession) {
						Teacher teachTemp = new Teacher(teacherName.getText(), teacherEmail.getText(), teacherCompany.getText());
						TeacherDAO teachdao = new TeacherDAO();
						teachdao.insert(teachTemp);					
						teacher = teachdao.getByName(teacherName.getText());
					}
				} else if (addSession){
					//teacher van de combobox
					teacher = teacherComboBox.getValue();
				}
				
				
			}
			
		}
		
		
		
		
		//Adres aanmaken / selecteren
		if (addressComboBox.getValue() == null && addSession == true) {
			
			if (street.getText().isEmpty() || number.getText().isEmpty() || zipcode.getText().isEmpty() || city.getText().isEmpty() || country.getText().isEmpty()) {
				addSession = false;
				errorLabel.setText("All addressfields are required (except 'Bus')");
				errorLabel.setTextFill(Color.FIREBRICK);
			} else if (addSession) {
					Address adresTemp = new Address(street.getText(), number.getText(), bus.getText(), zipcode.getText(), city.getText(), country.getText());
					AddressDAO adao = new AddressDAO();
					adao.insert(adresTemp);
					address = adao.getByStreetAndNumber(street.getText(), number.getText());
			}
			
		} else if (addSession) {
			//address van de combobox
			address = addressComboBox.getValue();
		}
		
		
		if (addSession) {
			
			Sessions sesh = new Sessions(training.getTrainingId(), sessionName.getText(),  address.getAddressId(), teacher.getTeacherId(), startDate, endDate);
			SessionsDAO sdao = new SessionsDAO();
			sdao.insert(sesh);
		
			//terugkeren
			resetVars();
			
			if (normal) {
				Navigator.loadVista(Navigator.TrainingDetailView);
			} else {
				//TrainingRequestDAO tdao = new TrainingRequestDAO();
				//AssignRequestController.trainingRequest.setTrainingId(training.getTrainingId());
				//System.out.println(training);
				//tdao.update(AssignRequestController.trainingRequest);
				Navigator.loadVista(Navigator.AssignRequestView);
			}
		}
		
				
		
	}
	
	//backbutton
	@FXML protected void toTrainingDetail(ActionEvent e) {
		
		resetVars();
		if (TrainingDetailController.training != null) {
			Navigator.loadVista(Navigator.TrainingDetailView);
		} else {
			Navigator.loadVista(Navigator.SearchTrainingView);
		}
				
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		if (!normal) {
			returnButton.setVisible(false);
		}
		
		//teacherlijst vullen
		TeacherDAO tdao = new TeacherDAO();
		ObservableList<Teacher> teachers = FXCollections.observableArrayList(tdao.getAll());
		teachers.add(0, null);
		
		//adreslijst vullen
		AddressDAO adao = new AddressDAO();
		ObservableList<Address> addresses = FXCollections.observableArrayList(adao.getAll());
		addresses.add(0, null);
		
		//comboboxen met lijsten vullen
		teacherComboBox.getItems().addAll(teachers);
		addressComboBox.getItems().addAll(addresses);
		
		
	}

	
	public void resetVars() {
		training = null;
	}
}
