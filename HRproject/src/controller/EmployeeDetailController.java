package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import application.CacheData;
import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Employee;

public class EmployeeDetailController implements Initializable{

	public static Employee employee;
	public int managerId = Integer.parseInt(employee.getReportsTo()) - 1;
	public String managerName = CacheData.employees.get(managerId).getFirstName() + " " +CacheData.employees.get(managerId).getLastName();
	
	@FXML private Label employeeName;
	
	@FXML private Label empId;
	@FXML private Label empName;
	@FXML private Label empTitle;
	@FXML private Label empTitleCourtesy;
	@FXML private Label empManager;
	@FXML private Label empBirthdate;
	@FXML private Label empHiredate;
	@FXML private Label empPhone;
	@FXML private Label empExtension;
	
	@FXML private Label empAddress;
	@FXML private Label empCity;
	@FXML private Label empRegion;
	@FXML private Label empPostalcode;
	@FXML private Label empCountry;


	@FXML private Label empNotes;
	
	
	
	@FXML
	protected void toEmployees(ActionEvent e) {
		
		Navigator.loadVista(Navigator.EmployeeView);
				
	}/*
	@FXML
	protected void goBack(ActionEvent e) {
		
		Navigator.loadVista(Navigator.EmployeeView);
				
	}
	
	*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = employee.getBirthDate();
		Date hireDate = employee.getHireDate();
		
		
		
		employeeName.setText(employee.getFirstName() + " " + employee.getLastName());
		
		empId.setText(employee.getEmployeeId());
		empName.setText(employee.getFirstName() + " " + employee.getLastName());
		empTitle.setText(employee.getTitle());
		empTitleCourtesy.setText(employee.getTitleOfCourtesy());
		empManager.setText(managerName);
		empBirthdate.setText(dateFormat.format(birthDate));
		empHiredate.setText(dateFormat.format(hireDate));
		empPhone.setText(employee.getHomePhone());
		empExtension.setText(employee.getExtension());
		
		empAddress.setText(employee.getAddress());
		empRegion.setText(employee.getRegion());
		empCountry.setText(employee.getCountry());
		empCity.setText(employee.getCity());
		empPostalcode.setText(employee.getPostalCode());
		
		empNotes.setText(employee.getNotes());
	}
	
}
