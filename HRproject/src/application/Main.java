package application;
	

import java.io.IOException;
//import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import controller.MainController;
import dao.TrainingDAO;

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
	
	
	
	
	public static void main(String[] args) {

		
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
		
		TrainingDAO tdao = new TrainingDAO();
		System.out.println(tdao.getAll());
	}
}
