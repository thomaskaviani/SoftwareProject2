package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Main;
import application.Navigator;
import dao.CertificateDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Certificate;
import model.Employee;

public class ShowCertificateController implements Initializable {

	public static Employee employee;
	
	@FXML private Label empLabel;
	@FXML private Label errorLabel;
	@FXML private TableView<Certificate> tableView;
	@FXML private TableColumn<Certificate, String> certCol;
	
	@FXML protected void openCert(ActionEvent e) {
		
		Certificate cert = tableView.getSelectionModel().getSelectedItem();
		if (cert != null) {
			String extensie = cert.getExtension();
			String path = "src/images/test" + extensie;
			byte[] foo = cert.getFile();
			
			//Temp file opslaan
		    try{
		           FileOutputStream fos = new FileOutputStream(path);
		           fos.write(foo);
		           fos.close();
		    }catch(Exception x){
		    	   x.printStackTrace();
		    }
		    
		  //Temp file openen
		    File file = new File(path);
		    Desktop desktop = Desktop.getDesktop();

			try {
	            desktop.open(file);
	        } catch (IOException ex) {
	            Logger.getLogger(Main.class.getName()).log(
	                Level.SEVERE, null, ex
	            );
	        }	
		} else {
			errorLabel.setText("No certificate selected");
			errorLabel.setTextFill(Color.FIREBRICK);
		}
	}
	
	@FXML protected void clickCert(MouseEvent e) {
		errorLabel.setText("");
	}
	
	
	//backbutton
	@FXML protected void toEmployee(ActionEvent e) {
		resetVars();
		Navigator.loadVista(Navigator.EmployeeView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		empLabel.setText(employee.getFullName());
		
		CertificateDAO cdao = new CertificateDAO();
		
		ObservableList<Certificate> certs = FXCollections.observableArrayList(cdao.getByEmpId(employee.getEmployeeId()));
		tableView.setItems(certs);
		
		certCol.setCellValueFactory(new PropertyValueFactory<Certificate, String>("trainingName"));

	}

	
	public void resetVars() {
		employee = null;
	}
	
}
