package application;
	

import java.io.IOException;
import java.text.ParseException;
//import java.util.List;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Employee;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import controller.MainController;


import odata.XMLReader;

//import dao.TrainingDAO;
//import dao.AddressDAO;
//import dao.UserDAO;
//import model.Address;
//import model.User;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		 
		stage.setTitle("HR - Application");
		
        stage.setScene(createScene(loadMainPane()));
        stage.setMaximized(true);
        stage.show();
        
		
	}
	
	
	private Pane loadMainPane() throws IOException {
        
		FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(Navigator.MainView));

        MainController mainController = loader.getController();

        Navigator.setMainController(mainController);

        Navigator.loadVista(Navigator.LoginView);



        return mainPane;
    }
	
	
	private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        
        return scene;
    }
	
	
	
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException {

		
		launch(args);
		
		/* TEST VAN ADDRESSSEN
		AddressDAO adresDao = new AddressDAO();
		List<Address> lijst = adresMgr.getAll();
		
		System.out.println(lijst);
		
		Address a = adresDao.getById(10);
		a.setNumber(420);
		adresDao.update(a);
		
		
		AddressDAO adresDao = new AddressDAO();
		Address adres1 = new Address("Nijverheidskaai", 100, "Bus2" , "1050", "Anderlecht", "Belgi�");
		System.out.println(adres1);
		adresDao.insert(adres1);
		*/
		
		/* TEST VAN USER, WAARDE IN CONSTRUCTOR WIJZIGEN
		UserDAO UserDao = new UserDAO();
		
		User y = new User("Piet", "wachtwoord", "kok");
		UserDao.insert(y);
		*/
		
		XMLReader reader = new XMLReader();
		
		Document doc;
		doc = reader.getConnection();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps = reader.getAllEmps(doc);
		for (int i = 0; i < emps.size(); i++) {
			System.out.println(emps.get(i).toString()+'\n');
		}
		//Employee e = getEmpById(doc, 1);
		//System.out.println(e.toString());

	}
}
