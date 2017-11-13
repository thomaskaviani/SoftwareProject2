package controller;

//import application.Navigator;
import model.Employee;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class EmployeeController {
	
	@FXML
	private TableView<Employee> tableView;
	@FXML 
	private TextField firstNameField;
    @FXML 
    private TextField lastNameField;
    @FXML 
    private TextField emailField;
    
    
    
}