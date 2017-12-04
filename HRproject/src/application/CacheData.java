package application;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import dao.AddressDAO;
import dao.ParticipationDAO;
import dao.SessionsDAO;
import dao.TeacherDAO;
import dao.TrainingDAO;
import model.Address;
import model.Employee;
import model.Participation;
import model.Sessions;
import model.Teacher;
import model.Training;
import odata.XMLReader;

public class CacheData {
	
	public static boolean loggedIn = false;

	public static ArrayList<Employee> employees;
	
	public static List<Participation> participations;
	
	public static List<Training> trainings;
	
	public static List<Teacher> teachers;
	
	public static List<Address> addresses;
	
	public static List<Sessions> sessions;
	
	public static void setEmployees() throws IOException, ParserConfigurationException, SAXException, ParseException {
		
		Document doc;
		doc = XMLReader.getConnection();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps = XMLReader.getAllEmps(doc);
		
		CacheData.employees = emps;
		
	}
	
	public static void setSessions() {
		SessionsDAO sdao = new SessionsDAO();
		sessions = sdao.getAll();
	}
	
	public static void setAddresses() {
		AddressDAO adao = new AddressDAO();
		addresses = adao.getAll();
	}
	
	
	public static void setTeachers() {
		TeacherDAO tdao = new TeacherDAO();
		teachers = tdao.getAll();
	}
	
	public static void setTrainings() {
		TrainingDAO tdao = new TrainingDAO();
		trainings = tdao.getAll();
	}
	
	public static void setParticipations() {
		ParticipationDAO pdao = new ParticipationDAO();
		participations = pdao.getAll();
	}
	
}
