package controller;

//import application.Navigator;
import model.Employee;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    
    
    @FXML
    protected void addEmployee(ActionEvent e) {
    	ObservableList<Employee> data = tableView.getItems();
    	data.add(new Employee(firstNameField.getText(),lastNameField.getText(), emailField.getText()));
    	
    	firstNameField.setText("");
    	lastNameField.setText("");
    	emailField.setText("");
    
    }
    
}