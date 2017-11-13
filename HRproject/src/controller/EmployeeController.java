package controller;

//import application.Navigator;
import model.Employee;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class EmployeeController implements Initializable {

	
	@FXML
	private TableView<Employee> tableView;
	
	@FXML 
	private TextField searchBar;
 
	

	@FXML
	protected void toDetailEmployee(ActionEvent e) {
		
		Navigator.loadVista(Navigator.EmployeeDetailView);
				
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}