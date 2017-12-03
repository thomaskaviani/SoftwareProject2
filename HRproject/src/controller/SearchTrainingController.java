package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Survey;
import model.Training;
import application.CacheData;
import application.Navigator;
import dao.SurveyDAO;

public class SearchTrainingController implements Initializable {
	
	
	@FXML
	private TableView<Training> tableView;
	
	@FXML
	private TableColumn<Training, String> trainingNameCol;
	
	@FXML
	private TableColumn<Training, String> trainingDescCol;

	@FXML
	protected void toTrainingDetail(ActionEvent e) {
		
		Training t = tableView.getSelectionModel().getSelectedItem();
		TrainingDetailController.training = t;  
		Navigator.loadVista(Navigator.TrainingDetailView);
				
		
	}

	@FXML
	protected void toTraining(ActionEvent e) {
		
		
		Navigator.loadVista(Navigator.TrainingView);
				
		
	}
	
	@FXML
	protected void toSurvey(ActionEvent e) {
		SurveyDAO sdao = new SurveyDAO();
		Training t = tableView.getSelectionModel().getSelectedItem();
		
		
		
		if(sdao.getByTraining(t.getTrainingId())!=null)
		{
			//bestaat het reeds
			System.out.println("De survey van training: "+t.getTrainingId() + " bestaat al");
			
		}
		else
		{
			String surveyNaam = t.getName() + " Survey";
			Survey s = new Survey(t.getTrainingId(),surveyNaam);
			s.setSurveyId(1);
			
			 sdao.insert(s);
			 s=sdao.getByTraining(t.getTrainingId());
			 AddQuestionSurveyController.training = t;  
			 AddQuestionSurveyController.survey=s;
				System.out.println("nieuwe vraag");
			 
			Navigator.loadVista(Navigator.AddQuestionSurveyView);
		}
		
		
		
		
		
				
		
	}

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		ObservableList<Training> trainingen = FXCollections.observableArrayList(CacheData.trainings);
		
		tableView.setItems(trainingen);
		
		trainingNameCol.setCellValueFactory(new PropertyValueFactory<Training, String>("name"));
		trainingDescCol.setCellValueFactory(new PropertyValueFactory<Training, String>("goal"));
		
		
	}

}


