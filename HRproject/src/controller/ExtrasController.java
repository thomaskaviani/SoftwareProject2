/*
 * 
 * https://stackoverflow.com/questions/14924770/simple-backup-and-restore-for-mysql-database-from-java
 * */
package controller;




import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import org.hibernate.Session;

import java.io.FileOutputStream;

import dao.HibernateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ExtrasController implements Initializable {

	@SuppressWarnings({ "unchecked", "resource" })
	@FXML
	protected void backupDB(ActionEvent e) throws IOException{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		// for every table, have the bean implement Serializable and use the next 4 lines
		
		@SuppressWarnings("deprecation")
		List <model.Employee> tblCollectionEmployee = session.createCriteria(model.Employee.class).list();
		FileOutputStream backupEmployees = new FileOutputStream("backupOf"+model.Employee.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Address> tblCollectionAddress = session.createCriteria(model.Address.class).list();
		FileOutputStream backupAddress = new FileOutputStream("backupOf"+model.Address.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Book> tblCollectionBook = session.createCriteria(model.Book.class).list();
		FileOutputStream backupBook = new FileOutputStream("backupOf"+model.Book.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Certificate> tblCollectionCertificate = session.createCriteria(model.Certificate.class).list();
		FileOutputStream backupCertificate = new FileOutputStream("backupOf"+model.Certificate.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Participation> tblCollectionParticipation = session.createCriteria(model.Participation.class).list();
		FileOutputStream backupParticipation = new FileOutputStream("backupOf"+model.Participation.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Sessions> tblCollectionSession = session.createCriteria(model.Sessions.class).list();
		FileOutputStream backupSessions = new FileOutputStream("backupOf"+model.Sessions.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Survey_a> tblCollectionSurvey_a = session.createCriteria(model.Survey_a.class).list();
		FileOutputStream backupSurvey_a = new FileOutputStream("backupOf"+model.Survey_a.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Survey_q> tblCollectionSurvey_q = session.createCriteria(model.Survey_q.class).list();
		FileOutputStream backupSurvey_q = new FileOutputStream("backupOf"+model.Survey_q.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Survey> tblCollectionSurvey = session.createCriteria(model.Survey.class).list();
		FileOutputStream backupSurvey = new FileOutputStream("backupOf"+model.Survey.class+".sql");
		
		@SuppressWarnings("deprecation")
		List <model.Teacher> tblCollectionTeacher = session.createCriteria(model.Teacher.class).list();
		FileOutputStream backupTeacher = new FileOutputStream("backupOf"+model.Teacher.class+".sql");
		
		
		
		ObjectOutputStream backupWriterEmployee = new ObjectOutputStream(backupEmployees);
		ObjectOutputStream backupWriterAddress = new ObjectOutputStream(backupAddress);
		ObjectOutputStream backupWriterBook = new ObjectOutputStream(backupBook);
		ObjectOutputStream backupWriterCertificate = new ObjectOutputStream(backupCertificate);
		ObjectOutputStream backupWriterParticipation = new ObjectOutputStream(backupParticipation);
		ObjectOutputStream backupWriterSessions = new ObjectOutputStream(backupSessions);
		ObjectOutputStream backupWriterSurvey_a = new ObjectOutputStream(backupSurvey_a);
		ObjectOutputStream backupWriterSurvey_q = new ObjectOutputStream(backupSurvey_q);
		ObjectOutputStream backupWriterSurvey = new ObjectOutputStream(backupSurvey);
		ObjectOutputStream backupWriterTeacher = new ObjectOutputStream(backupTeacher);

		
		
		
		backupWriterEmployee.writeObject(tblCollectionEmployee);
		backupWriterAddress.writeObject(tblCollectionAddress);
		backupWriterBook.writeObject(tblCollectionBook);
		backupWriterCertificate.writeObject(tblCollectionCertificate);
		backupWriterParticipation.writeObject(tblCollectionParticipation);
		backupWriterSessions.writeObject(tblCollectionSession);
		backupWriterSurvey_a.writeObject(tblCollectionSurvey_a);
		backupWriterSurvey_q.writeObject(tblCollectionSurvey_q);
		backupWriterSurvey.writeObject(tblCollectionSurvey);
		backupWriterTeacher.writeObject(tblCollectionTeacher);

	
	}
	

	@FXML
	protected void restoreDB(ActionEvent e) {
		
		/*
		 * 
		 * 
		 * analyse: werken met file chooser en die files laten runnen
		 * 
		 * */
		
		
	    
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}









