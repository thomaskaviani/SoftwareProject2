/*
 * 
 * bronnen: https://www.youtube.com/watch?v=fq1alQY9iLk&index=5&list=LLAEkIkIY1AWlm-_N7rl1S7A, 
 * http://java-buddy.blogspot.be/2012/05/save-file-with-javafx-filechooser.html
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
				p = runtime.exec("C://Program Files//MySQL//MySQL Server 5.7//bin//mysqldump.exe -P3306 -h 172.20.0.27 -uSP2GR3_HRAPP -pCupRYb --add-drop-database SP2GR3_HRAPP -r "+ path);
			
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
	

	@FXML
	protected void browseFile(ActionEvent e) {
		FileChooser fc = new FileChooser();
		
		FileChooser.ExtensionFilter ex = new FileChooser.ExtensionFilter("SQL Files", "*.sql");
		fc.getExtensionFilters().add(ex);
		
		
		
		
		//String date = new SimpleDateFormat("yyyy-mm-dd").format(new Date(0));
		
		try {
			File f = fc.showSaveDialog(null);
			path = f.getAbsolutePath();
			path = path.replace('\\', '/');
			//path = path;
			textField.setText(path);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
		System.out.println("test");
        }
        
		
	
		
		
	/*private static void configureFileChooser(final FileChooser fileChooser) {      
        fileChooser.setTitle("Select Files");
        
        fileChooser.setInitialDirectory(
            new File(System.getProperty("user.home"))
        );          
        
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("SQL", "(*.sql)")
        );
}*/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}









