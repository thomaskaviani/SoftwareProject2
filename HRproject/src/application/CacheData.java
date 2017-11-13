package application;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import model.Employee;
import odata.XMLReader;

public class CacheData {

	public static ArrayList<Employee> employees;
	
	
	
	public static void setEmployees() throws IOException, ParserConfigurationException, SAXException, ParseException {
		
		Document doc;
		doc = XMLReader.getConnection();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps = XMLReader.getAllEmps(doc);
		
		CacheData.employees = emps;
		
	}
	
	
}
