/*
 * 
 * referentie : https://stackoverflow.com/questions/14924770/simple-backup-and-restore-for-mysql-database-from-java
 * 
 * 
 * 
 * */
package controller;




import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import java.io.File;

import application.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ExtrasController implements Initializable {

	@FXML
	protected void backupDB(ActionEvent e) {
	
//		    try
//		      {
//
//		        /*NOTE: Getting path to the Jar file being executed*/
//		        /*NOTE: YourImplementingClass-> replace with the class executing the code*/
//		        CodeSource codeSource = ExtrasController.class.getProtectionDomain().getCodeSource();
//		        File jarFile = new File(codeSource.getLocation().toURI().getPath());
//		        String jarDir = jarFile.getParentFile().getPath();
//
//
//		        /*NOTE: Creating Database Constraints*/
//		        String dbName = "SP2GR3_HRAPP";
//		        String dbUser = "SP2GR3_HRAPP";
//		        String dbPass = "CupRYb";
//
//		        /*NOTE: Creating Path Constraints for folder saving*/
//		        /*NOTE: Here the backup folder is created for saving inside it*/
//		        String folderPath = jarDir + "\\backup";
//
//		        /*NOTE: Creating Folder if it does not exist*/
//		        File f1 = new File(folderPath);
//		        f1.mkdir();
//
//		        /*NOTE: Creating Path Constraints for backup saving*/
//		        /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
//		         String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
//
//		        /*NOTE: Used to create a cmd command*/
//		        String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " --database " + dbName + " -r " + savePath;
//
//		        /*NOTE: Executing the command here*/
//		        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
//		        int processComplete = runtimeProcess.waitFor();
//
//		        /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
//		        if (processComplete == 0) {
//		            System.out.println("Backup Complete");
//		        } else {
//		            System.out.println("Backup Failure");
//		        }
//
//		    } catch (URISyntaxException | IOException | InterruptedException ex) {
//		        JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
//		    }
		}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
