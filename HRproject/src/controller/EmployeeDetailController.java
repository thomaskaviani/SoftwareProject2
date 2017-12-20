package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import application.CacheData;
import application.Main;
import application.Navigator;
import model.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EmployeeDetailController implements Initializable{

	public static Employee employee;
	public int managerId;
	public String managerName = null;
	
	@FXML private Rectangle balk;
	
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

	@FXML private ImageView empImage;

	@FXML private Label empNotes;
	
	
	//backbutton
	@FXML protected void toEmployees(ActionEvent e) {
		resetVars();
		Navigator.loadVista(Navigator.EmployeeView);
				
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		balk.setFill(Color.valueOf(Main.color));
		managerId = Integer.parseInt(employee.getReportsTo()) - 1;
		
		if(managerId>0) {
			managerName = CacheData.employees.get(managerId).getFirstName() + " " +CacheData.employees.get(managerId).getLastName();
		}
		
		if (employee.getTitleOfCourtesy().equals("Ms.") || employee.getTitleOfCourtesy().equals("Mrs.")) {
			empImage.setImage(new Image("/images/FemalePP.png"));
		}
		else {
			empImage.setImage(new Image("/images/MalePP.png"));
		}
		
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
	
	public void resetVars() {
		employee = null;
		managerId = 0;
		managerName = null;
	}
	
}
