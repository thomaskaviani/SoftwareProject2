package controller;

//import application.Navigator;
import model.Employee;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class EmployeeController implements Initializable{
	
	@FXML
	private TableView<Employee> tableView;
	
	@FXML 
	private TextField searchBar;
    
    
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}