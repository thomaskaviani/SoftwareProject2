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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Survey;
import application.Main;
import application.Navigator;

import dao.SurveyDAO;

public class SearchSurveyController implements Initializable{

	public static Survey survey;
	
	@FXML private Rectangle balk;
	
	@FXML
	private TableView<Survey> surveyTable;
	
	@FXML
	private TableColumn<Survey, String> surveyNameCol;
	
	@FXML
	protected void toSurveyDetail(ActionEvent e) {
		
		Survey s = surveyTable.getSelectionModel().getSelectedItem();
		SurveyDetailController.survey=s;
		Navigator.loadVista(Navigator.SurveyDetailView);
				
				
	}	
@FXML
	protected void toHome(ActionEvent e) {
	
	
	Navigator.loadVista(Navigator.HomeView);
			
	
}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		balk.setFill(Color.valueOf(Main.color));
		
		SurveyDAO sdao = new SurveyDAO();
		
		if (sdao.getAll() != null) {
			
			ObservableList<Survey> surveys = FXCollections.observableArrayList(sdao.getAll());
			
			surveyTable.setItems(surveys);
			surveyNameCol.setCellValueFactory(new PropertyValueFactory<Survey, String>("surveyName"));
		
		}
	}
}
