package controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import application.CacheData;
import application.Main;
import application.Navigator;
import dao.CertificateDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import model.Certificate;
import model.Employee;
import model.Training;

public class AddCertificateController implements Initializable {

	public static Employee employee;
	private File certificateFile;
	private final FileChooser fileChooser = new FileChooser();
	
	
	@FXML private Label fileLabel;
	
	@FXML private Label errorLabel;
	
	@FXML private TextField trainName;
	
	@FXML private ComboBox<Training> trainingComboBox;
	
	
	@FXML private Label titleLabel;
	
	@FXML protected void openFile(ActionEvent e) {
		
		configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(Main.mainStage);
        if (file != null) {
        	
        	certificateFile = file;
        	fileLabel.setText("File selected");
        	
        	//FILE GEBRUIKEN
        	System.out.println(certificateFile);
        }
        
        errorLabel.setText("");
	}
	
	@FXML protected void saveCertificate(ActionEvent e) {
		
		
		if (certificateFile == null || (trainName.getText().trim().isEmpty() && trainingComboBox.getValue() == null)) {
			
			if (trainingComboBox.getValue() == null || trainName.getText().trim().isEmpty()) {
				errorLabel.setText("You must select a training or enter a trainingname!");
			} else if (certificateFile == null){
				errorLabel.setText("You must select a file!");
			} else {
				errorLabel.setText("Unknown Error");
			}
			
		} else {
			
			//CERTIFICATE IN DB STEKEN
			CertificateDAO cdao = new CertificateDAO();
			
			byte[] certData = new byte[(int) certificateFile.length()];
			
			//extensie verkrijgen
			String filename = certificateFile.getName();
			String extension = "";
			int i = filename.lastIndexOf('.');
			if (i > 0) {
			    extension = filename.substring(i);
			}
			System.out.println(extension);
			
			//fileinputstream
			try {
	            FileInputStream fileInputStream = new FileInputStream(certificateFile);
	            fileInputStream.read(certData);
	            fileInputStream.close();
		    } catch (Exception x) {
		            x.printStackTrace();
		    }
			

			//certificaat toevoegen
			Certificate cert = new Certificate(employee.getEmployeeId(), trainName.getText().trim() , certData, extension);
			
			if (trainingComboBox.getValue() != null) {
				cert.setTrainingName(trainingComboBox.getValue().getName());
			}
			
			cdao.insert(cert);
			
			//terug naar employees gaan
			resetVars();
			Navigator.loadVista(Navigator.EmployeeView);
			
		}
	}
	
	@FXML
	protected void toEmployee(ActionEvent e) {
		resetVars();
		Navigator.loadVista(Navigator.EmployeeView);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//titeltekst vullen
		titleLabel.setText("Add Certificate - " + employee.getFullName());
		
		//inputfile op nul zetten
		certificateFile = null;
		errorLabel.setText("");
		
		//combobox voor trainingen vullen
		ObservableList<Training> trainings = FXCollections.observableArrayList(CacheData.trainings);
		trainingComboBox.getItems().addAll(trainings);
		

	}

	
	private static void configureFileChooser(final FileChooser fileChooser) {      
	            fileChooser.setTitle("View Files");
	            
	            fileChooser.setInitialDirectory(
	                new File(System.getProperty("user.home"))
	            );          
	            
	            fileChooser.getExtensionFilters().addAll(
	                new FileChooser.ExtensionFilter("All files", "*.*"),
	                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	                new FileChooser.ExtensionFilter("PNG", "*.png")
	            );
	}
	
	public void resetVars() {
		employee = null;
		certificateFile = null;
	}
}
