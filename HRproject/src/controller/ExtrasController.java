package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.CacheData;
import application.Main;
import application.Navigator;
import dao.EmployeeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Employee;
import model.EmployeeDB;

public class ExtrasController implements Initializable {

	@FXML private Rectangle balk;
	
	@FXML private Label updateLabel;
	
	@FXML protected void toGeneral(ActionEvent e) {
		
		Navigator.loadVista(Navigator.GeneralSettingsView);
	}

	@FXML protected void updateManagers(ActionEvent e) {
		
		//MANAGERS VAN DE EMPLOYEES INSTELLEN
		CacheData.setEmployeesDB();
		
		for (Employee x : CacheData.employees) {
			
			int foo = Integer.parseInt(x.getEmployeeId());
			if (x.getReportsTo().equals("0") || x.getReportsTo().equals("-1")) {
				CacheData.employeesDB.get(foo).setManager(-1);
			} else {
				int foo2 = Integer.parseInt(x.getReportsTo());
				CacheData.employeesDB.get(foo).setManager(foo2);
			}
		}
		
		EmployeeDAO edao = new EmployeeDAO();
		for (EmployeeDB x : CacheData.employeesDB) {
			edao.update(x);
		}
		
		updateLabel.setText("Managers updated");
		updateLabel.setTextFill(Color.GREEN);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//balk
		balk.setFill(Color.valueOf(Main.color));
		updateLabel.setText("");
		
	}

}
