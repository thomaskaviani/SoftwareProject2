/*
 * 
 * bron : https://stackoverflow.com/questions/14924770/simple-backup-and-restore-for-mysql-database-from-java
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
	

	@FXML
	protected void restoreDB(ActionEvent e) {
		public static void Restoredbfromsql(String s) {
	        try {
	            /*NOTE: String s is the mysql file name including the .sql in its name*/
	            /*NOTE: Getting path to the Jar file being executed*/
	            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
	            CodeSource codeSource = ExtrasController.class.getProtectionDomain().getCodeSource();
	            File jarFile = new File(codeSource.getLocation().toURI().getPath());
	            String jarDir = jarFile.getParentFile().getPath();

	            /*NOTE: Creating Database Constraints*/
	             String dbName = "SP2GR3_HRAPP";
	             String dbUser = "SP2GR3_HRAPP";
	             String dbPass = "CupRYb";

	            /*NOTE: Creating Path Constraints for restoring*/
	            String restorePath = jarDir + "\\backup" + "\\" + s;

	            /*NOTE: Used to create a cmd command*/
	            /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
	            String[] executeCmd = new String[]{"mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};

	            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
	            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
	            int processComplete = runtimeProcess.waitFor();

	            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
	            if (processComplete == 0) {
	                JOptionPane.showMessageDialog(null, "Successfully restored from SQL : " + s);
	            } else {
	                JOptionPane.showMessageDialog(null, "Error at restoring");
	            }


	        } catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
	            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql" + ex.getMessage());
	        }

	    }
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
