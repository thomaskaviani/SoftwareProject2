package application;
	

import java.io.IOException;

import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import controller.MainController;

public class Main extends Application {
	
	public static Stage mainStage;
	
	@Override
	public void start(Stage stage) throws Exception {
		 
		mainStage = stage;
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
	
	
	
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException, TransformerException {
		
		
		CacheData.setEmployees();
		CacheData.setTrainings();
		CacheData.setParticipations();
		
		
	
		
		
		launch(args);
		
		/*
		
		//adden van image aan database
		CertificateDAO cdao = new CertificateDAO();

		File file = new File("C:\\Users\\bavia\\Downloads\\Klassediagram_groep3.pdf");
		byte[] certData = new byte[(int) file.length()];

		try {
	            FileInputStream fileInputStream = new FileInputStream(file);
	            fileInputStream.read(certData);
	            fileInputStream.close();
	    } catch (Exception e) {
	            e.printStackTrace();
	    }


		Certificate cert = new Certificate("2","Certnaam", certData);

		cdao.insert(cert);
	     
		*/

	}
}
