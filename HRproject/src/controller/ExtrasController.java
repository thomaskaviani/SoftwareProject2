/*
 * 
 * bronnen: https://www.youtube.com/watch?v=fq1alQY9iLk&index=5&list=LLAEkIkIY1AWlm-_N7rl1S7A, 
 * http://java-buddy.blogspot.be/2012/05/save-file-with-javafx-filechooser.html
 * https://uwudamith.wordpress.com/2010/12/24/get-backup-and-restore-on-mysql-in-java/
 * */
package controller;


import java.io.File;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;




public class ExtrasController implements Initializable{

	String path = null;
	String filename;
	

	@FXML
	private TextField textField;
	//private Label errorLabel;
	@FXML
	protected void backupDB(ActionEvent e) throws IOException{
		Process p = null;
		if (textField ==null) {
			System.out.println("Please select path !!");
		} else {

			try {
				Runtime runtime = Runtime.getRuntime(); 
				p = runtime.exec("C://Program Files//MySQL//MySQL Server 5.7//bin//mysqldump.exe -P 3306 -h 172.20.0.27 -u SP2GR3_HRAPP -pCupRYb --add-drop-database -B SP2GR3_HRAPP -r "+ path);
			
			int processComplete = p.waitFor();
			if (processComplete==0) {
				System.out.println("Backup complete");
			}
			else {
				System.out.println("Backup Failed");
			}
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
		System.out.println("test");
	}
	
//voor backup
	@FXML
	protected void browseFile(ActionEvent e) {
		FileChooser fc = new FileChooser();
		
		FileChooser.ExtensionFilter ex = new FileChooser.ExtensionFilter("SQL Files", "*.sql");
		fc.getExtensionFilters().add(ex);
				
		try {
			File f = fc.showSaveDialog(null);
			path = f.getAbsolutePath();
			//path = path;
			textField.setText(path);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		System.out.println("test");
        }
     //voor restore   
	@FXML
	protected void browse(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		
	FileChooser.ExtensionFilter ex = new FileChooser.ExtensionFilter("SQL Files", "*.sql");
	fileChooser.getExtensionFilters().add(ex);
		
	try {
		File f = fileChooser.showOpenDialog(null);
		path = f.getAbsolutePath();
		path = path.replace("\\", "/");
		textField.setText(path);
	} catch (Exception e2) {
		e2.printStackTrace();
	}
			System.out.println("test");
	}
	
	
	@FXML
	protected void restoreDB(ActionEvent e) {
		/*String dbUserName ="SP2GR3_HRAPP";
		String dbPassword ="CupRYb";
		String dbName="SP2GR3_HRAPP";*/
	String[] restoreCmd = new String[] {"C://Program Files//MySQL//MySQL Server 5.7//bin//mysql.exe -u SP2GR3_HRAPP -pCupRYb SP2GR3_HRAPP -P 3306 -h 172.20.0.27  < " + path};
	Process runtimeProcess;	
	try {
		runtimeProcess = Runtime.getRuntime().exec(restoreCmd); 
		int processComplete = runtimeProcess.waitFor();
	if (processComplete==0) {
		System.out.println("Restore succes");
	} else {
System.out.println("Restore failed");
	}
		
	} catch (Exception e2) {
		e2.printStackTrace();
	}
			System.out.println("test");
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}









