package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import application.CacheData;
import application.Main;
import application.Navigator;
import dao.ParticipationDAO;
import dao.SessionsDAO;
import dao.TrainingDAO;
import dao.TrainingRequestDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Participation;
import model.Sessions;
import model.Training;
import model.TrainingRequest;

public class AssignRequestController implements Initializable {

	public static TrainingRequest trainingRequest;
	
	@FXML private Rectangle balk;
	
	@FXML private Label errorLabel;
	@FXML private Label newLabel;
	@FXML private Label trainingLabel;
	@FXML private Label employeeLabel;
	@FXML private Label sessionLabel;
	
	@FXML private Button createButton;
	@FXML private Button assignButton;
	
	@FXML private TableView<Sessions> sessionTable;
	@FXML private TableColumn<Sessions, Date> sessionTableCol;
	
	@FXML protected void toRequest(ActionEvent e) {
		Navigator.loadVista(Navigator.TrainingRequestView);
	}
	
	@FXML protected void assign(ActionEvent e) {
		
		Sessions s = sessionTable.getSelectionModel().getSelectedItem();
		
		if (s != null) {
			
			String x = String.valueOf(trainingRequest.getRealEmpId());
			Participation p2 = new Participation(trainingRequest.getTrainingId(), x, 0, 0, s.getSessionId());
			ParticipationDAO pdao2 = new ParticipationDAO();
			pdao2.insert(p2);
			CacheData.setParticipations();
			
			TrainingRequestDAO tdao = new TrainingRequestDAO();
			tdao.delete(trainingRequest);
			
			Navigator.loadVista(Navigator.TrainingRequestView);
		} else {
			errorLabel.setTextFill(Color.FIREBRICK);
			errorLabel.setText("Select a session");
		}
		
	}
	
	@FXML protected void createTraining(ActionEvent e) {
		
		TrainingDAO tdao = new TrainingDAO();
		Training temp = new Training(trainingRequest.getName(),trainingRequest.getGoal());
		
		tdao.insert(temp);
		Training t = tdao.getByName(trainingRequest.getName());
		System.out.println(t.getTrainingId());
		CacheData.setTrainings();
		
		trainingRequest.setTrainingId(t.getTrainingId());
		TrainingRequestDAO trdao = new TrainingRequestDAO();
		trdao.update(trainingRequest);
		
		AddSessionController.training = t;
		AddSessionController.normal = false;
		Navigator.loadVista(Navigator.AddSessionView);
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//balk & errorlabel
		balk.setFill(Color.valueOf(Main.color));
		errorLabel.setText("");
		
		createButton.setVisible(false);
		
		trainingLabel.setText(trainingRequest.getName());
		employeeLabel.setText(trainingRequest.getEmpId());
		
		if (trainingRequest.getTrainingId() < 0) {
			
			newLabel.setText("Non existing training");
			newLabel.setTextFill(Color.FIREBRICK);
			
			sessionTable.setVisible(false);
			sessionLabel.setVisible(false);
			
			assignButton.setVisible(false);
			
			createButton.setVisible(true);
			
			
		} else {
			newLabel.setText("Existing training");
			newLabel.setTextFill(Color.GREEN);
			
			SessionsDAO sdao = new SessionsDAO();

			if (sdao.getByTraining(trainingRequest.getTrainingId()) != null) {

				ObservableList<Sessions> sessions = FXCollections.observableArrayList(sdao.getByTraining(trainingRequest.getTrainingId()));

				for (Sessions s : sessions) {
					s.setStartTimeString();
				}

				sessionTableCol.setCellValueFactory(new PropertyValueFactory<Sessions, Date>("startTimeString"));

				
				sessionTable.setItems(sessions);
			}
		}
		
	}

}
