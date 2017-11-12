package odata;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Employee;

public class XMLReader {

	//deze functie maakt verbinding met de northwind database
	public static Document getConnection() throws IOException, ParserConfigurationException, SAXException {

		String url = "http://services.odata.org/V3/Northwind/Northwind.svc/Employees";
		URL myurl = new URL(url);
		HttpURLConnection con = (HttpURLConnection)myurl.openConnection();

		con.setDoOutput(true);
		con.setDoInput(true);


		con.setRequestProperty("Content-Type", "application/xml; charset=utf-8");
		con.setRequestProperty("Accept", "application/atom+xml,application/xml");
		con.setRequestProperty("Method", "GET");

		InputStream xml = con.getInputStream();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);

		doc.getDocumentElement().normalize();

		return doc;

	}
	
	
	public static Employee fillEmp(Element eElement, Node nNode) throws ParseException {
		Employee emp = new Employee();
		
		String id = eElement.getElementsByTagName("d:EmployeeID").item(0).getTextContent();
		emp.setEmployeeId(Integer.parseInt(id));
		emp.setLastName(eElement.getElementsByTagName("d:LastName").item(0).getTextContent());
		emp.setFirstName(eElement.getElementsByTagName("d:FirstName").item(0).getTextContent());
		emp.setTitle(eElement.getElementsByTagName("d:Title").item(0).getTextContent());
		emp.setTitleOfCourtesy(eElement.getElementsByTagName("d:Title").item(0).getTextContent());
		String date = eElement.getElementsByTagName("d:BirthDate").item(0).getTextContent();
		Date dat;
		DateFormat df = new SimpleDateFormat("d-M-Y");
		dat = df.parse(date);
		emp.setBirthDate(dat);
		date = eElement.getElementsByTagName("d:HireDate").item(0).getTextContent();
		dat = df.parse(date);
		emp.setHireDate(dat);
		emp.setAddress(eElement.getElementsByTagName("d:Address").item(0).getTextContent());
		emp.setCity(eElement.getElementsByTagName("d:City").item(0).getTextContent());
		emp.setRegion(eElement.getElementsByTagName("d:Region").item(0).getTextContent());
		emp.setPostalCode(eElement.getElementsByTagName("d:PostalCode").item(0).getTextContent());
		emp.setCountry(eElement.getElementsByTagName("d:Country").item(0).getTextContent());
		emp.setHomePhone(eElement.getElementsByTagName("d:HomePhone").item(0).getTextContent());
		emp.setExtension(eElement.getElementsByTagName("d:Extension").item(0).getTextContent());
		emp.setPhoto(eElement.getElementsByTagName("d:Photo").item(0).getTextContent());
		emp.setNotes(eElement.getElementsByTagName("d:Notes").item(0).getTextContent());
		String repto = eElement.getElementsByTagName("d:ReportsTo").item(0).getTextContent();
		if (repto != "") {
			emp.setReportsTo(Integer.parseInt(repto));
		}
		else {
			emp.setReportsTo(-1);
		}
		emp.setPhotoPath(eElement.getElementsByTagName("d:PhotoPath").item(0).getTextContent());
		return emp;
	}
	//print ALLE emps
	public static ArrayList<Employee> getAllEmps(Document doc) throws ParseException {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		NodeList nList = doc.getElementsByTagName("entry");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				emps.add(fillEmp(eElement, nNode));
				
			}
		}
		return emps;
	}

	//gaat over de IDs (haalt ze pas binnen als de param id overeenkomt met een bestaande emp
	public static Employee getEmpById(Document doc, int id) throws ParseException {
		NodeList nList = doc.getElementsByTagName("entry");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				String empId = eElement.getElementsByTagName("d:EmployeeID").item(0).getTextContent();
				
				if (Integer.parseInt(empId) == id) {
					return fillEmp(eElement, nNode);
					
				}
			}
		}
		Employee e = new Employee();
		return e;
	}

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException {
		Document doc;
		doc = getConnection();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps = getAllEmps(doc);
		for (int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i).toString()+'\n');
		}
		//Employee e = getEmpById(doc, 1);
		//System.out.println(e.toString());
		
	}
}


