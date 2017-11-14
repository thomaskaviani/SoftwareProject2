package controller;

//import application.Navigator;
import model.Employee;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import application.CacheData;
import application.Navigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class EmployeeController implements Initializable {

	
	@FXML
	private TableView<Employee> tableView;
	
	@FXML 
	private TextField searchBar;
	
	@FXML private TableColumn<Employee, String> empIdCol;
	@FXML private TableColumn<Employee, String> empFirstNameCol;
	@FXML private TableColumn<Employee, String> empLastNameCol;
	@FXML private TableColumn<Employee, String> empFunctionCol;
	@FXML private TableColumn<Employee, String> empEmailCol;
	
	
	
	@FXML
	protected void toDetailEmployee(ActionEvent e) {
		
		Employee emp = tableView.getSelectionModel().getSelectedItem();
		EmployeeDetailController.employee = emp;  
		Navigator.loadVista(Navigator.EmployeeDetailView);
				
		
	}
	@FXML
	protected void toHome(ActionEvent e) {
		
		Navigator.loadVista(Navigator.HomeView);
				
	}
	//toHome
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		ObservableList<Employee> emps = FXCollections.observableArrayList(CacheData.employees);
		tableView.setItems(emps);
		
		empIdCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeId"));
		empFirstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		empLastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		empFunctionCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("title"));
		empEmailCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
		
	}
    
    
}