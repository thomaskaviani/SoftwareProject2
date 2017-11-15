package application;

//basis gevonden op https://www.mkyong.com/java/how-to-modify-xml-file-in-java-dom-parser/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class ChangeColor {
	public static ArrayList<String> getViews(){
		ArrayList<String> views = new ArrayList<String>();
		//alle views MET GEKLEURDE BALK
		String AccountSettingsView = "src/view/AccountSettingsView.fxml";
		String AddEmployeeToSessionView= "src/view/AddEmployeeToSessionView.fxml";
		String AddSessionView = "src/view/AddSessionView.fxml";
		String AddTrainingView = "src/view/AddTrainingView.fxml";
		String EmployeeDetailView = "src/view/EmployeeDetailView.fxml";
		String EmployeeView = "src/view/EmployeeView.fxml";
		String ForgotPasswordView = "src/view/ForgotPasswordView.fxml";
		String GeneralSettingsView = "src/view/GeneralSettingsView.fxml";
		String HomeView = "src/view/HomeView.fxml";
		String LoginView = "src/view/LoginView.fxml";
		String SearchTrainingView = "src/view/SearchTrainingView.fxml";
		String StyleOptionsView = "src/view/StyleOptionsView.fxml";
		String TrainingDetailView = "src/view/TrainingDetailView.fxml";
		String TrainingResultView = "src/view/TrainingResultView.fxml";
		String TrainingView = "src/view/TrainingView.fxml";
		views.add(AccountSettingsView);
		views.add(AddEmployeeToSessionView);
		views.add(AddSessionView);
		views.add(EmployeeDetailView);
		views.add(EmployeeView);
		views.add(ForgotPasswordView);
		views.add(GeneralSettingsView);
		views.add(HomeView);
		views.add(LoginView);
		views.add(SearchTrainingView);
		views.add(StyleOptionsView);
		views.add(TrainingDetailView);
		views.add(TrainingResultView);
		views.add(TrainingView);
		views.add(AddTrainingView);

		return views;

	}

	public static void changeColor(String color) throws TransformerException {
		//1 keer het linkerbovenvierkant veranderen
		changeUserBox(color);
	
		ArrayList<String> views = getViews();
		for (int i = 0; i < views.size(); i++) {
			String filePath = views.get(i);
			File xmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(xmlFile);
				doc.getDocumentElement().normalize();

				// Get the  element by tag name directly
				Node rect = doc.getElementsByTagName("Rectangle").item(0);

				// update staff attribute
				NamedNodeMap attr = rect.getAttributes();
				Node nodeAttr = attr.getNamedItem("fill");
				nodeAttr.setTextContent(color);

				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(views.get(i)));
				transformer.transform(source, result);
				
				
			} catch (SAXException | ParserConfigurationException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static void changeUserBox (String color) throws TransformerException {
		String UserBoxView = "src/view/UserBoxView.fxml";
		String filePath = UserBoxView;
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			// Get the  element by tag name directly
			Node rect = doc.getElementsByTagName("VBox").item(0);

			// update staff attribute
			NamedNodeMap attr = rect.getAttributes();
			Node nodeAttr = attr.getNamedItem("style");
			nodeAttr.setTextContent("-fx-background-color: "+color);
	

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(UserBoxView));
			transformer.transform(source, result);
			
			
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}
	}


}
