/*
 * Bronnen:
 * 
 * 
 * JavaFX Tables doorzoeken door "code.makery": http://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
 * 
 * */
package controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import application.CacheData;
import application.Navigator;
import model.Employee;


public class EmployeeController implements Initializable {

	
	@FXML private TableView<Employee> tableView;
	
	@FXML private TextField searchBar;
	
	@FXML private TableColumn<Employee, String> empIdCol;
	@FXML private TableColumn<Employee, String> empFirstNameCol;
	@FXML private TableColumn<Employee, String> empLastNameCol;
	@FXML private TableColumn<Employee, String> empFunctionCol;
	@FXML private TableColumn<Employee, String> empEmailCol;
	
	
	@FXML protected void toDetailEmployee(ActionEvent e) {
		
		Employee emp = tableView.getSelectionModel().getSelectedItem();
		if (emp != null) {
			EmployeeDetailController.employee = emp;
			Navigator.loadVista(Navigator.EmployeeDetailView);
		} else {
			//ERROR: SELECT EMPLOYEE
		}
				
		
	}

	//backbutton
	@FXML protected void toHome(ActionEvent e) {
		Navigator.loadVista(Navigator.HomeView);
				
	}

	@FXML protected void toAddCert(ActionEvent e) {
		
		Employee emp = tableView.getSelectionModel().getSelectedItem();
		if (emp != null) {
			AddCertificateController.employee = emp;
			Navigator.loadVista(Navigator.AddCertificateView);
		}
		
	}
	
	@FXML protected void toShowCert(ActionEvent e) {
		
		Employee emp = tableView.getSelectionModel().getSelectedItem();
		if (emp != null) {
			ShowCertificateController.employee = emp;
			Navigator.loadVista(Navigator.ShowCertificateView);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		ObservableList<Employee> emps = FXCollections.observableArrayList(CacheData.employees);
		
		empIdCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeId"));
		empFirstNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
		empLastNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
		empFunctionCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("title"));
		empEmailCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
		
		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Employee> filteredEmps = new FilteredList<>(emps, p -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredEmps.setPredicate(employee -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every employee with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (employee.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (employee.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Employee> sortedEmps = new SortedList<>(filteredEmps);
				
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedEmps.comparatorProperty().bind(tableView.comparatorProperty());
				
		// 5. Add sorted (and filtered) data to the table.
		tableView.setItems(sortedEmps);
		
	}
    
    
}